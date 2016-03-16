import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrintMixStrings {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfTestCases; i++) {
            Set<String> distinctStrings = solve();
            for (String distinctString: distinctStrings) {
                System.out.println(distinctString);
            }
            System.out.println();
        }
    }

    private static Set<String> solve() {
        Set<String> distinctStrings = new TreeSet<>();
        String[] strings = new String(scanner.nextLine()).split(" ");
        String first = strings[0];
        String second = strings[1];
        getAllDistinctWords(distinctStrings, first, second, "");
        return distinctStrings;
    }

    private static void getAllDistinctWords(Set<String> distinctStrings, String first, String second, String generated) {
        if (first.length() == 0 && second.length() == 0) {
            distinctStrings.add(generated);
        } else {
            if (first.length() > 0) {
                getAllDistinctWords(distinctStrings, first.substring(1), second, generated + first.substring(0, 1));
            }
            if (second.length() > 0) {
                getAllDistinctWords(distinctStrings, first, second.substring(1), generated + second.substring(0, 1));
            }
        }
    }
}
