package Spring_practice.Week1;

import java.io.*;

public class 接龙数列_solution_pro2 {
    static int N = 100010;
    static int[] g = new int[10];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] s = br.readLine().split(" ");
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            int l = s[i - 1].charAt(0) - '0';
            int r = s[i - 1].charAt(s[i - 1].length() - 1) - '0';
            int f = Math.max(1,g[l] + 1);
            //因为我们每个f[i]只会用一次 所以直接定义一个f就可以
            //并且l和r也只会用一次 所以定义l和r就可以
            g[r] = Math.max(g[r],f);
            res = Math.max(res,f);
        }
        System.out.println(n - res);
    }
}
