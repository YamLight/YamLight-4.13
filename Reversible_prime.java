package pat;

import java.util.Scanner;

public class Reversible_prime {
    static int N = 100010;
    static boolean[] st = new boolean[N];
    static int[] prime = new int[N];
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        get_prime();
        int a = scanner.nextInt();
        while (a > 0){
            int b = scanner.nextInt();
            int num = get(a,b);
//            System.out.println(num);
            if (check(num) && check(a)) System.out.println("Yes");
            else System.out.println("No");
            a = scanner.nextInt();
        }
    }
    static boolean check(int s){
        if (s <= 1) return false;
        for (int i = 2; i <= s / i; i++) {
            if (s % i == 0) return false;
        }
        return true;
    }
    static int get(int n,int radix){
        String tmp = "";
        while (n != 0){
            tmp = tmp + (n % radix);
            n /= radix;
        }
//        System.out.println(tmp);
        return Integer.parseInt(tmp,radix);
    }
//    static void get_prime(){
//        //枚举所有数
//        for (int i = 2; i < N ; i++) {
//            if (!st[i]) prime[cnt++] = i;
//            for (int j = 0; prime[j] <= N / i ; j++) {
//                if (prime[j] * i < N){
//                    st[prime[j] * i] = true;
//                    if (i % prime[j] == 0) break;
//                }
//            }
//        }
//    }
}
