package Spring_practice.Week1;

import java.io.*;

public class 冶炼金属 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 10010;
    static pair[] pairs = new pair[N];
    static int max = -(int)1e9;
    static int min = (int)1e9;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        for(int i = 0;i < N;i++){
            String[] str = br.readLine().split(" ");
            int o = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            pairs[i] = new pair(o,x);
            max = Math.max(max,(int)Math.ceil(o / x));
        }
        int l = 1,r = max;
        int mid;
        while (l < r){
            mid = (l + r) >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        min = l; r = max;
        while (l < r){
            mid = (l + r + 1) >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        max = l;
        pw.println(min + " " + max);
        pw.close();
    }
    static boolean check(int n){
        for (int i = 0; i < N; i++) {
            int o = pairs[i].o;
            int x = pairs[i].x;
            if (Math.ceil(o / n) != x) return false;
        }
        return true;
    }
}
class pair{
    int o;
    int x;

    public pair(int o, int x) {
        this.o = o;
        this.x = x;
    }
}
