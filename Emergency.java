package pat;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Emergency {
    static int N = 510;
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int[] w = new int[N];
    static int[] h = new int[N];
    static int[]num = new int[N];
    static int[] dist = new int[N];
    static int[] save = new int[N];
    static int[] cnt = new int[N];
    static int[] ans = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m,c1,c2,idx;
    static int max = 0x3f3f3f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(h,-1);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c1 = scanner.nextInt();
        c2 = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            save[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int l = scanner.nextInt();
            add(a,b,l);
            add(b,a,l);
        }
        Dijkstra();
        System.out.println(cnt[c2] + " " + ans[c2]);
    }
    static void Dijkstra(){
        PriorityQueue<pp> q = new PriorityQueue<>();
        Arrays.fill(dist,max);
        q.add(new pp(0,c1));
        dist[c1] = 0; cnt[c1] = 1;ans[c1] = save[c1];
        while (!q.isEmpty()){
            pp p = q.poll();
            int t = p.second;
            int distance = p.first;
            if (st[t]) continue;
            for (int i = h[t]; i != -1 ; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    q.add(new pp(dist[j],j));
                    cnt[j] = cnt[t];
                    ans[j] = ans[t] + save[j];
                }
                else if (dist[j] == distance + w[i]){
                    cnt[j] += cnt[t];
                    ans[j] = Math.max(ans[j],ans[t] + save[j]);
                }
            }
        }
    }
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
class pp implements Comparable<pp>{
    int first;//距离值
    int second;//点编号

    public pp(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(pp o) {
        return Integer.compare(first,o.first);
    }
}
