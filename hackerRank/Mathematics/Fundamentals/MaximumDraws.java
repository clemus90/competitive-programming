import java.io.*;
import java.util.*;

public class MaximumDraws {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(br.readLine());

        for (int i = 0; i < casos; i ++){
            System.out.println(Integer.parseInt(br.readLine()) + 1);
        }
    }
} 