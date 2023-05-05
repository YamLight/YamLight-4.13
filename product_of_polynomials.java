package pat;

import java.io.*;
import java.util.*;

public class product_of_polynomials{
    static int N = 1010;
    static double[] n = new double[N];
    static int size = 0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            int p = scanner.nextInt();
            double q = scanner.nextDouble();
            n[p] += q;
        }
        int b = scanner.nextInt();
        for (int i = 0; i < b; i++) {
            int p = scanner.nextInt();
            double q = scanner.nextDouble();
            n[p] += q;
        }
        for (int i = N - 1; i >= 0; i--) {
            if (n[i] != 0) size++;
        }
        System.out.print(size);
        int j = 0;
        for (int i = N - 1; i >= 0 ; i--) {
            if (n[i] != 0) {
                System.out.printf(" %d %.1f",i,n[i]);
                j = i - 1;
            }
        }
        for (int i = j; i >= 0 ; i--) {
            if (n[i] != 0) System.out.printf(" %d %.1f",i,n[i]);
        }
    }
}