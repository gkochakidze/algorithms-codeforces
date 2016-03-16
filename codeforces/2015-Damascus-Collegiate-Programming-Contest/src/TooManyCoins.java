import java.util.*;

public class TooManyCoins {
    public static class CoinQuantity implements Comparable {
        public int value;
        public int quantity;

        public CoinQuantity(Integer value, Integer quantity) {
            this.value = value;
            this.quantity = quantity;
        }

        public int amount() {
            return value * quantity;
        }

        @Override
        public int compareTo(Object o) {
            CoinQuantity other = (CoinQuantity) o;
            if (amount() == other.amount()) {
                return other.value - value;
            }
            return other.amount() - amount();
        }
    }


    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfTestCases; i++) {
            int numOfCoins = scanner.nextInt();
            int necessaryMoney = scanner.nextInt();
            System.out.println(solve(numOfCoins, necessaryMoney));
        }
    }

    private static String solve(int numOfCoins, int necessaryMoney) {
        List<CoinQuantity> coinQuantities = readCoins(numOfCoins);
        Set<Integer> selectedCoins = new TreeSet<>();
        int selectedCoinsAmount = 0;
        for (CoinQuantity coinQuantity: coinQuantities) {
            if (selectedCoinsAmount >= necessaryMoney) {
                break;
            }
            selectedCoinsAmount += coinQuantity.amount();
            selectedCoins.add(coinQuantity.value);
        }

        if (selectedCoinsAmount < necessaryMoney) {
            return "Impossible";
        } else {
            String ans = "";
            for (Integer coin: selectedCoins) {
                ans += coin + " ";
            }
            return ans;
        }
    }

    private static List<CoinQuantity> readCoins(int numOfCoins) {
        List<CoinQuantity> coinQuantities = new ArrayList<>();
        Map<Integer, Integer> coins = new TreeMap<>();
        for (int i = 0; i < numOfCoins; i++) {
            int coin = scanner.nextInt();
            Integer coinQuantity = coins.get(coin);
            if (coinQuantity == null) {
                coins.put(coin, 1);
            } else {
                coins.put(coin, coinQuantity + 1);
            }
        }
        for (Integer coin : coins.keySet()) {
            CoinQuantity coinQuantity = new CoinQuantity(coin, coins.get(coin));
            coinQuantities.add(coinQuantity);
        }
        Collections.sort(coinQuantities);
        return coinQuantities;
    }
}
