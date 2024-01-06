import java.util.Scanner;

//Defining Class
public class Frequency{
    
    //Declaring a private static array of integers named numbers to store the input array
    private static int[] numbers;
    //method sets the numbers array with the provided input array
    public static void Number(int[] array) {
        numbers = array;
    }

    //method finds and prints the top k frequent numbers in the numbers array
    public static void Frequent(int k) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("Array is empty or not initialized");
            return;
        }

        int maxnum = numbers[0];
        for (int num : numbers) {
            if (num > maxnum) {
                maxnum = num;
            }
        }

        int[] frequency = new int[maxnum + 1];
        for (int num : numbers) {
            frequency[num]++;
        }

        for (int i = 0; i < k; i++) {
            int maxFreq = 0;
            for (int freq : frequency) {
                if (freq > maxFreq) {
                    maxFreq = freq;
                }
            }

            if (maxFreq == 0) {
                System.out.println("Invalid input: The value of k exceeds the array size");
                return;
            }

            for (int j = 0; j < frequency.length; j++) {
                if (frequency[j] == maxFreq) {
                    System.out.println(j);
                    frequency[j] = 0;
                    break;
                }
            }
        }
    }

    //The entry point of the program, it gets user input, calls the Frequent method, and prints the results
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();
        numbers = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of K: ");
        int k = scanner.nextInt();
        System.out.println("Top " + k + " frequent numbers are:");
        Frequent(k);
    }
}
