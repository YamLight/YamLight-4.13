package pat;

import java.io.*;

public class maximum_sub {
    static int N = 10010;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int[] a = new int[N];
    static int[] s = new int[N];
    static int sum = 0,l,r;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n ; i++) {
            a[i] = Integer.parseInt(str[i - 1]);
        }
        boolean flag = false;
        for (int i = 1; i <= n ; i++) {
            if (a[i] >= 0) flag = true;
        }
        if (!flag) {
            pw.print(0 + " ");
            pw.print(a[1] + " " + a[n]);
            pw.close();
            return;
        }
        for (int i = 1; i <= n ; i++) {
            s[i] = s[i - 1] + a[i];
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                if (s[j] - s[i - 1] > sum){
                    sum = s[j] - s[i - 1];
                    l = i;
                    r = j;
                }
            }
        }
        pw.print(sum + " " + a[l] + " "  + a[r]);
        pw.close();
    }
}
