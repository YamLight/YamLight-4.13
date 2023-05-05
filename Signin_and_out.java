package pat;

import java.io.*;

public class Signin_and_out {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static String in = "",out = "";
    static char[] unlock = {'2','4',':','0','0',':','0','0'};
    static char[] lock = {'0','0',':','0','0',':','0','0'};

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0){
            String[] str = br.readLine().split(" ");
            char[] time1 = str[1].toCharArray();
            char[] time2 = str[2].toCharArray();
            for (int i = 0; i < 8; i++) {
                int a = time1[i] - '0';
                int b = unlock[i] - '0';
                if (a == b) continue;
                else if (a > b) break;
                else {
                    unlock = time1;
                    in = str[0];
                    break;
                }
            }
            for (int i = 0; i < 8; i++) {
                int a = time2[i] - '0';
                int b = lock[i] - '0';
                if (a == b) continue;
                else if (a < b) break;
                else {
                    lock = time2;
                    out = str[0];
                    break;
                }
            }
        }
        System.out.print(in + " " + out);
    }
}
