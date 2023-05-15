package pat;

import java.io.*;
import java.util.Arrays;

public class Battle_OverCities02 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 1010;
    static int M = N * N;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];
    static int n,m,k,x;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        Arrays.fill(h,-1);
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        while (m-- > 0){
            String[] s1 = br.readLine().split(" ");
            int p = Integer.parseInt(s1[0]);
            int q = Integer.parseInt(s1[1]);
            add(p,q); add(q,p);
        }
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            Arrays.fill(st,false);
            x = Integer.parseInt(s3[i]);
            int res = 0;
            for (int j = 1; j <= n ; j++) {
                if (j == x) continue;
                if (!st[j]){
                    res++;
                    dfs(j);
                }
            }
            pw.println(res - 1);
        }
        pw.close();
    }
    static void dfs(int u){
        for (int i = h[u]; i != -1 ; i = ne[i]) {
            int j = e[i];
            if (j != x && !st[j]){
                st[j] = true;
                dfs(j);
            }
        }
    }
    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
