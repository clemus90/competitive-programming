import java.io.*;
public class ACircleAndASquare{

    public static char[][] getCircle(int r){
        char[][] filling = new char[r*2+1][r*2+1];
        for(int i=0; i<=r*2;i++){
            for(int j=0; j<=r*2;j++){
                if(i == r || j == r){
                    filling[i][j] = '#';
                }else{
                    filling[i][j] = '.';
                }
            }
        }

        for(int i=1; i<=r; i++){
            for(int j=1; j<=r; j++){
                double distance = Math.sqrt(i*i + j*j);
                double ratio = r / distance;
                double rx = (i * ratio);
                double ry = (j * ratio);
                if(i <= rx && j <= ry){
                    filling[r+j][r+i] = '#';
                    filling[r-j][r-i] = '#';
                    filling[r+j][r-i] = '#';
                    filling[r-j][r+i] = '#';
                }
            }
        }

        return filling;
    }

    public static void drawCircle(char[][] canv, int x, int y, int r){
        char[][] circle = getCircle(r);
        int begX = x - r;
        int begY = y - r;
        int endX = x + r;
        int endY = y + r;
        for(int i=0; i<canv.length; i++){
            for(int j=0; j<canv[i].length; j++){
                if( (j>=begX && j<=endX) &&
                (i>=begY && i<=endY) ){
                    canv[i][j] = circle[i - begY][j - begX];
                }
            }
        }
    }

    public static void drawRectangle(char[][] canv, int x1, int y1, int x3, int y3){
        double middleX = (x3 + x1)/(double)2;
        double middleY = (y3 + y1)/(double)2;

        
        double[] xs = new double[4];
        double[] ys = new double[4];

        xs[0] = x1;
        //rotate 90
        xs[1] = middleX + (y3 - middleY) * -1;
        xs[2] = x3;
        xs[3] = middleX + (y3 - middleY);

        ys[0] = y1;
        //rotate 90
        ys[1] = middleY + (x3 - middleX);
        ys[2] = y3;
        //rotate -90
        ys[3] = middleY + (x3 - middleX) * -1;


        //straight Square
        double theta = Math.atan((ys[1] - ys[0])/(xs[1] - xs[0]));
        theta *= -1;
        double[] xRotated = new double[4];
        double[] yRotated = new double[4];
        double minX, minY, maxX, maxY;
        minY = minX = 300;
        maxX = maxY = -200;
        for(int i=0; i<4; i++){
            xRotated[i] = Math.cos(theta)*xs[i] - Math.sin(theta)*ys[i];
            if(xRotated[i] < minX){
                minX = xRotated[i];
            }
            if(xRotated[i] > maxX){
                maxX = xRotated[i];
            }
            yRotated[i] = Math.sin(theta)*xs[i] + Math.cos(theta)*ys[i];
            if(yRotated[i] < minY){
                minY = yRotated[i];
            }
            if(yRotated[i] > maxY){
                maxY = yRotated[i];
            }
        }

        for(int i=0; i< canv.length; i++){
            for(int j=0; j<canv[i].length; j++){
                double xRot = Math.cos(theta)*j - Math.sin(theta)*i;
                double yRot = Math.sin(theta)*j + Math.cos(theta)*i;
                if ( (xRot >= (minX - 0.5) && xRot <= (maxX + 0.5)) &&
                    (yRot >= (minY - 0.5) && yRot <= (maxY + 0.5)) ) {
                    canv[i][j] = '#';
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" "); 

        char[][]board = new char[Integer.parseInt(line[1])][Integer.parseInt(line[0])];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = '.';
            }
        }

        line = br.readLine().split(" ");
        int x1, y1, x2, y2, r;
        x1 = Integer.parseInt(line[0]);
        y1 = Integer.parseInt(line[1]);
        r = Integer.parseInt(line[2]);

        drawCircle(board, x1, y1, r);
        
        line = br.readLine().split(" ");

        x1 = Integer.parseInt(line[0]);
        y1 = Integer.parseInt(line[1]);
        x2 = Integer.parseInt(line[2]);
        y2 = Integer.parseInt(line[3]);

        drawRectangle(board, x1,y1,x2,y2);

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}