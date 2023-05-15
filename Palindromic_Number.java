package pat;

import java.io.*;

public class Palindromic_Number {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static int k;
    static long n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Long.parseLong(s[0]);
        k = Integer.parseInt(s[1]);
        for (;cnt < k;) {
            if (check(n)) {
                pw.println(n);
                pw.print(cnt);
                pw.close();
                return;
            }
//            System.out.println(get(n) + " " + n);
            else {
                n += get(n);
                cnt++;
            }
        }
        pw.println(n);
        pw.print(cnt);
        pw.close();
    }
    static boolean check(long num){
        if (num == get(num)) return true;
        return false;
    }
    static long get(long num){//求反转数
        String ans = "";
        for (int i = 0; num != 0; i++) {
            ans = ans + (num % 10);
            num /= 10;
        }
        return Long.parseLong(ans);
    }
}
