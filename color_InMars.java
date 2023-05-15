package pat;

import java.io.*;

public class color_InMars {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static String ans = "#";
    public static void main(String[] args) throws IOException {
        String[] rgb = br.readLine().split(" ");
        for (int i = 0; i < rgb.length; i++) {
            int tmp = Integer.parseInt(rgb[i]);
            String num = get(tmp);
            if (num.length() > 1) ans = ans + num;
            else ans = ans + "0" + num;
        }
        System.out.print(ans);
    }
    static String get(int num){
        String res = "";
        if (num == 0) return "0";
        while (num != 0){
            int tmp = num % 13;
            if (tmp == 10) {
                res = "A" + res;
            }
            else if (tmp == 11) {
                res = "B" + res;
            }
            else if (tmp == 12) {
                res = "C" + res;
            }
            else res = tmp + res;
            num /= 13;
        }
        return res;
    }
}
