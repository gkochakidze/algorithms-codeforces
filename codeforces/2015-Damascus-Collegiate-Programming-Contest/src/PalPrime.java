import java.util.*;

public class PalPrime {
    private static int palindromeMaxLength = 22;

    public static void main(String[] args) {
        NavigableSet<Integer> primePalindromes = getSortedPrimePalindromes();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String binaryString = scanner.nextLine();
            int value = Integer.parseInt(binaryString, 2);
            int greaterNearestPrimePalindrome =  primePalindromes.ceiling(value);
            System.out.println(Integer.toBinaryString(greaterNearestPrimePalindrome));
        }
    }

    private static NavigableSet<Integer> getSortedPrimePalindromes() {
        NavigableSet<Integer> palindromes = new TreeSet<>();
        generatePrimePalindromes("0", palindromeMaxLength, palindromes);
        generatePrimePalindromes("1", palindromeMaxLength, palindromes);
        generatePrimePalindromes("00", palindromeMaxLength, palindromes);
        generatePrimePalindromes("11", palindromeMaxLength, palindromes);
        return palindromes;
    }

    private static void generatePrimePalindromes(String palindrome, int maxLength, NavigableSet<Integer> palindromes) {
        if (palindrome.length() > maxLength) {
            return;
        }
        if (palindrome.charAt(0) == '1') {
            int palindromeValue = Integer.parseInt(palindrome, 2);
            if (isPrime(palindromeValue)) {
                palindromes.add(palindromeValue);
            }
        }
        generatePrimePalindromes("1" + palindrome + "1", maxLength, palindromes);
        generatePrimePalindromes("0" + palindrome + "0", maxLength, palindromes);
    }

    private static boolean isPrime(int palindromeValue) {
        if (palindromeValue < 2)
            return false;
        double sqrt = Math.sqrt(palindromeValue);
        for (int i = 2; i <= sqrt; i++) {
            if (palindromeValue % i == 0) {
                return false;
            }
        }
        return true;
    }
}
