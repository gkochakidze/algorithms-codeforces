import java.util.Scanner;

public class Rectangles {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numOfTestCases = scanner.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            int minimumArea = solve();
            System.out.println(minimumArea);
        }
    }

    private static int solve() {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        int numberOfRectangles = scanner.nextInt();

        int x, y;
        for (int i = 0; i < numberOfRectangles; i++) {
            for (int j = 0; j < 4; j++) {
                x = scanner.nextInt();
                if (x < minX) {
                    minX = x;
                }
                if (x > maxX) {
                    maxX = x;
                }

                y = scanner.nextInt();
                if (y < minY) {
                    minY = y;
                }
                if (y > maxY) {
                    maxY = y;
                }
            }
        }
        return (maxX - minX) * (maxY - minY);
    }
}
