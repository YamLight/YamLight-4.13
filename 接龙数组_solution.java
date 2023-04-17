package Spring_practice.Week1;

import java.io.*;

public class 接龙数组_solution {
    static int N = 100010;
    static int[] f = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int[] g = new int[10];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n ; i++) {
            l[i] = s[i - 1].charAt(0) - '0';
            r[i] = s[i - 1].charAt(s[i - 1].length() - 1) - '0';
        }
//        for (int i = 1; i <= n ; i++) {
//            System.out.println(l[i] + " " + r[i]);
//        }
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            f[i] = 1;
            for (int j = 1; j < i ; j++) {//错误
                if (r[j] == l[i]){
                    f[i] = Math.max(f[i],f[j] + 1);
                    res = Math.max(res,f[i]);
                }
            }
        }
        System.out.println(n - res);
    }
}
