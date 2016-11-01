import java.util.Scanner;

public class SortingBubbleSort{

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = in.nextInt();
    }
    int numSorts = bubbleSort(arr);
    System.out.println("Array is sorted in " + numSorts + " swaps.");
    System.out.println("First Element: " + arr[0]);
    System.out.println("Last Element: " + arr[arr.length - 1]);
  }  

  public static int bubbleSort(int[] a){
    int n = a.length;

    int totalNumSwaps = 0;

    for (int i = 0; i < n; i++) {
      // Track number of elements swapped during a single array traversal
      int numberOfSwaps = 0;
        
      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
          numberOfSwaps++;
        }
      }

      totalNumSwaps += numberOfSwaps;
        
      // If no elements were swapped during a traversal, array is sorted
      if (numberOfSwaps == 0) {
        break;
      }
    }

    return totalNumSwaps;
  }
}