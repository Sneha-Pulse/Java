import java.util.*;
public class ShareTrader {

    private static int maxProfit;

    public static int MaxProfit(int[] stockPrices) {
        int n = stockPrices.length;
        if (n < 2) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = stockPrices[0];
        int max_First = 0;

        for (int i = 1; i < n; i++) {
            if (stockPrices[i] < minPrice) {
                minPrice = stockPrices[i];
            } else {
                int currentProfit = stockPrices[i] - minPrice;
                if (currentProfit > max_First) {
                    max_First = currentProfit;
                }
            }
        }

        int maxPrice = stockPrices[n - 1];
        int max_Second = 0;
        int[] potentialProfit = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (stockPrices[i] > maxPrice) {
                maxPrice = stockPrices[i];
            } else {
                int currentProfit = maxPrice - stockPrices[i];
                if (currentProfit > max_Second) {
                    max_Second = currentProfit;
                }
            }
            potentialProfit[i] = max_Second;
        }
        maxProfit = max_First;

        for (int i = 0; i < n; i++) {
            int totalProfit = potentialProfit[i] + max_First;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();
        int[] stockPrices = new int[n];

        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            stockPrices[i] = scanner.nextInt();
        }

        int maxProfit = MaxProfit(stockPrices);
        System.out.println("Maximum profit that can be achieved: " + maxProfit);
        
    }
}
