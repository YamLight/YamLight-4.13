package Spring_practice.Week1;

import java.io.*;
import java.util.Arrays;

public class 飞机降落 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int T,n;
    static int N = 20;
    static boolean[] st = new boolean[N];
    static plane[] planes = new plane[N];
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0){
            n = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                planes[i] = new plane(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]));
            }
            Arrays.fill(st,false);
            if (dfs(0,0)) pw.println("YES");
            else pw.println("NO");
        }
        pw.close();
    }
    static boolean dfs(int u,int last){
        if (u == n){
            return true;
        }
        for (int i = 0; i < n; i++) {
            int t = planes[i].t,d = planes[i].d,l = planes[i].l;
            if (!st[i] && t + d >= last){//还没有降落 而且燃料还足够盘旋
                st[i] = true;
                if (dfs(u + 1,Math.max(last,t) + l)) return true;
                st[i] = false;
            }
        }
        return false;
    }
}
class plane{
    int t;
    int d;
    int l;

    public plane(int t, int d, int l) {
        this.t = t;
        this.d = d;
        this.l = l;
    }
}
