import java.util.Scanner;

public class CountMixStrings {
    private static Scanner scanner;

    private static int prime = 1000000007;
    private static long[] factorials = new long[20001];

    public static void main(String[] args) {
        preCalculateAllFactorial();
//        scanner = new Scanner(System.in);
//        int numOfTestCases = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < numOfTestCases; i++) {
//            String[] strings = new String(scanner.nextLine()).split(" ");
//            int m = Integer.parseInt(strings[0]);
//            int n = Integer.parseInt(strings[1]);
//            System.out.println(solve(m, n));
//        }
    }

    private static long solve(int m, int n) {
        return 0;
    }

    //(fact(n+m) * inv(fact(n))) mod 10^9 + 7)

    private static void preCalculateAllFactorial() {
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
    }
}
