import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuickSort{
    public static int partition(long[] arr, int start, int end){
        int pivotIndex = start + (int)(Math.random() * (end + 1 - start));
        long pivot = arr[pivotIndex];
        
        long temp = arr[start];
        arr[start] = pivot;
        arr[pivotIndex] = temp;

        int i = start + 1;
        for(int j=start+1; j<=end; j++){
            if( arr[j] < pivot ){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++; 
            }
        }
        temp = arr[start];
        arr[start] = arr[i-1];
        arr[i-1]= temp;
        return i-1;
    }
    public static void quickSort(long[] arr,int start, int end){
        if(start<end){
            int pivotIndex = partition(arr,start,end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int size = Integer.parseInt(br.readLine());
        long[] arr = new long[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        quickSort(arr,0,size-1);
        for(int i=0; i<arr.length; i++){
            out.print(arr[i]);
            if(i<(arr.length - 1)) out.print(" ");
        }
        out.println();
        out.close();
    }
}
