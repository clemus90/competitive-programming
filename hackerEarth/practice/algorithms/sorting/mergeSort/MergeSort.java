import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MergeSort {
    public static long merge(long[] arr, int start, int mid, int end){
        long count = 0;
        int si = start, mi= mid + 1;
        long[] sortedArr = new long[end-start+1];
        int k = 0;
        for(int i=start; i<=end; i++){
            if(si > mid){
                sortedArr[k++] = arr[mi++];
            }
            else if(mi > end){
                sortedArr[k++] = arr[si++];
                count += end - mid;
            }
            else if(arr[si] > arr[mi]){
                sortedArr[k++] = arr[mi++];
                count += mid - si + 1;
            }
            else{
                sortedArr[k++] = arr[si++];
            }
        }

        for(int i=0; i<k; i++){
            arr[start++] = sortedArr[i];
        }
        return count;
    }

    public static long mergeSort(long[] arr, int start, int end){
        if (start < end){
            long cont = 0;
            int mid = (end + start)/2;
            cont += mergeSort(arr, start, mid);
            cont += mergeSort(arr, mid + 1, end);
            cont += merge(arr, start, mid, end);
            return cont;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int size = Integer.parseInt(br.readLine());
        long[] arr = new long[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        out.println(mergeSort(arr, 0, size -1));
        out.close();

    }
}