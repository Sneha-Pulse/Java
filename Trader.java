import java.util.*;

//Defining Class
public class ShareTrader {

    //Declaring a private static integer variable named maxProfit to store the calculated maximum profit
    private static int maxProfit;

    //method to take an array of stock prices as input and returns the maximum profit that can be achieved by making at most two transactions
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

    //entry point of the program, gets user input, calls the MaxProfit method, and prints the result
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
