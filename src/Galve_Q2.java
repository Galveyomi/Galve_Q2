import java.util.Arrays;
import java.util.Scanner;

public class Galve_Q2 { 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input Power Levels
        int[] powerLevels = new int[10];
        System.out.println("Enter 10 power levels:");
        for (int i = 0; i < 10; i++) {
            powerLevels[i] = scanner.nextInt();
        }

        // 2. Bubble Sort (Ascending)
        bubbleSort(powerLevels);
        System.out.println("Bubble Sort (Ascending): " + Arrays.toString(powerLevels));

        // 3. Selection Sort (Descending)
        int[] descendingLevels = Arrays.copyOf(powerLevels, 10); 
        selectionSort(descendingLevels);
        System.out.println("Selection Sort (Descending): " + Arrays.toString(descendingLevels));

        // 4. Analysis
        Analysis analysis = analyze(powerLevels);
        System.out.println("\nAnalysis:");
        System.out.println("Sum of Even Numbers: " + analysis.sumEven);
        System.out.println("Sum of Odd Numbers: " + analysis.sumOdd);
        System.out.println("Minimum Power Level: " + analysis.min);
        System.out.println("Maximum Power Level: " + analysis.max);

        scanner.close();
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Helper method to perform the analysis
    public static Analysis analyze(int[] arr) {
        int sumEven = 0;
        int sumOdd = 0;
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return new Analysis(sumEven, sumOdd, min, max);
    }

    // Helper class to store analysis results
    static class Analysis {
        int sumEven;
        int sumOdd;
        int min;
        int max;

        Analysis(int sumEven, int sumOdd, int min, int max) {
            this.sumEven = sumEven;
            this.sumOdd = sumOdd;
            this.min = min;
            this.max = max;
        }
    }
}