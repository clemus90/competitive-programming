import java.io.*;
import java.util.*;

public class FindThePoint {

    public static int[] findPointReflection(String[] c){
        int px = Integer.parseInt(c[0]);
        int py = Integer.parseInt(c[1]);
        int qx = Integer.parseInt(c[2]);
        int qy = Integer.parseInt(c[3]);

        int pxqx = qx - px;
        int pyqy = qy - py;

        int[] r = {(pxqx + qx), (pyqy + qy)};
        return r;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casos = Integer.parseInt(br.readLine());

        for (int i = 0; i < casos; i ++){
            String[] c = br.readLine().split(" ");
            int[] r = findPointReflection(c);
            System.out.println(r[0] + " " + r[1]);
        }
    }
} 