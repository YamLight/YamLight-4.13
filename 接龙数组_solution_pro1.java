package Spring_practice.Week1;

import java.io.*;

public class 接龙数组_solution_pro1 {
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
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            f[i] = 1;
            f[i] = Math.max(f[i],g[l[i]] + 1);
            //找以l[i]为结尾的最长接龙数列 再加上自己
            //比如 11 12 第i个数的头是1 那就找尾巴是1的最长接龙数列
            g[r[i]] = Math.max(g[r[i]],f[i]);//为什么要这样更新g[r[i]]
            //比如说 11 121 111 23 33 现在i = 5 以3结尾的最长接龙数列有两个 但是放在整个序列来看 最长的接龙数列
            //长度是3 所以要取一个max来更新
            res = Math.max(res,f[i]);
        }
        System.out.println(n - res);
    }
}