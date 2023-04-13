package Spring_practice.Week1;

import java.io.*;

public class solution_冶炼金属 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 10010;
    static int min = 1,max = (int) 1e9;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            min = Math.max(min,get(a,b));
            max = Math.min(max,get(a,b - 1) - 1);
        }
        System.out.println(min + " " + max);
    }
    static int get(int a,int b){
        int l = 1,r = (int)1e9;
        while(l < r){
            int mid = (l + r) >> 1;
            if ((a / mid) <= b) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
