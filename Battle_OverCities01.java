package pat;

import java.io.*;

public class Battle_OverCities01 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 1010;
    static int M = N * N;
    static int[] p = new int[N];
    static edge[] edges = new edge[M];
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int p = Integer.parseInt(s1[0]);
            int q = Integer.parseInt(s1[1]);
            edges[i] = new edge(p, q);
        }
        String[] s3 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(s3[i]);
            int cnt = n - 1;
            for (int j = 1; j <= n ; j++) {
                p[j] = j;
            }
            for (int j = 0; j < m; j++) {
                int a = edges[j].a,b = edges[j].b;
                if (a != x && b != x){
                    int fa = find(a);
                    int fb = find(b);
                    if (fa != fb){
                        p[fb] = fa;
                        cnt--;
                    }
                }
            }
            pw.println(cnt - 1);
        }
        pw.close();
    }
    static int find(int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
class edge{
    int a;
    int b;

    public edge(int a, int b) {
        this.a = a;
        this.b = b;
    }
}