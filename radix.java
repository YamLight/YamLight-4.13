package pat;

import java.io.*;

public class radix {
    static int tag,radix;
    static String N1,N2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] str = br.readLine().split(" ");
        N1 = str[0];
        N2 = str[1];
        tag = Integer.parseInt(str[2]);
        radix = Integer.parseInt(str[3]);
        if (tag == 2) swap();
//        System.out.println(N1);
//        System.out.println(N2);
        long target = cal(N1,radix);
//        System.out.println(target);
        long l = 0,r = target + 1;
        for (char c:N2.toCharArray()
             ) {
            l = Math.max(l,(long)get(c) + 1);
        }
//        System.out.println("l " + l);
        while (l < r){
            long mid = l + r >> 1;
            if (cal(N2,mid) >= target) r = mid;
            else l = mid + 1;
        }
        if (cal(N2,l) == target) System.out.println(l);
        else System.out.println("impossible");
    }
    static long cal(String s,long r){
        long sum = 0;
        for (char c:s.toCharArray()
             ) {
            if ((double) sum * r + get(c) > 1e16) return (long)1e18;
            sum = sum * r + get(c);
        }
        return sum;
    }
    static int get(char c){
        if (c >= '0' && c <= '9') return c - '0';
        else return c - 'a' + 10;
    }
    static void swap(){
        String tmp = N1;
        N1 = N2;
        N2 = tmp;
    }
}
