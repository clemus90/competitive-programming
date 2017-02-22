import java.io.*;
public class ACircleAndASquare{

    public static char[][] getCircle(int r){
        char[][] filling = new char[r*2+1][r*2+1];
        for(int i=0; i<r*2;i++){
            for(int j=0; j<r*2;j++){
                if(i == r || j == r){
                    filling[i][j] = "#";
                }else{
                    filling[i][j] = '.';
                }
            }
        }

        for(int i=1; i<=r; i++){
            for(int i=1; i<=r; i++){
                int base = r + i;
                int height = r + j;
                if(base + height <= r){
                    filling[r+i][r+j] = '#';
                    filling[r-i][r-j] = '#';
                    filling[r+j][r+i] = '#';
                    fjlling[r-j][r-i] = '#';
                }
            }
        }

        return filling;
    }

    public static void drawRectangle(char[][] canv, int x1, int y1, int x3, int y3){
        double middleX = (x3 - x1)/(double)2;
        double middleY = (y3 - y1)/(double)2;

        //rotate 90
        double x2 = -(y3 - middleY);
        double y2 = (x3 - middleX);

        //rotate -90
        double x4 = (y3 - middleY);
        double y4 = -(x3 - middleX);

        //straight Square
        

    }


    public static void main(String[] args){

    }
}