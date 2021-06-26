import java.util.*;
public class magicSquare
{
    public magicSquare()
    {
        int ODDN = 5;
        magicSquare(ODDN);
    }

    public static void magicSquare(int n) {
        int[][] square = new int[n][n];
        int k = 1, count = 1,i=0,j=n/2;
        square[0][n / 2] = k;
        k++;
        while (count != (n * n)) {
            if ((i - 1 == -1 && j + 1 == square[i].length)) {
                // if can't place in upper right hand corner or spot is aleady filled, place k+1
                // below k
                square[i + 1][j] = k;
                i=i+1;
            } else if (i - 1 == -1) {
                // If can't go up, go to bottom and place k one column ahead
                square[square[i].length - 1][j + 1] = k;
                i=square.length-1;
                j=j+1;
            } else if (j + 1 == square[i].length) {
                // If can't go right, go up 1 row and place k in column 0 of row
                square[i - 1][0] = k;
                i=i-1;
                j=0;
            } else if(0 !=  square[i - 1][j + 1]){
                square[i + 1][j] = k;
                i=i+1;
            }else {
                square[i - 1][j + 1] = k;
                i=i-1;
                j=j+1;
            }
            k++;
            count++;
        }
        printSquare(square);
    }

    public static void printSquare(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            System.out.print("[");
            for(int j=0;j<matrix[i].length;j++){
                System.out.printf(" %2d", matrix[i][j]);
            }
            System.out.println(" ]");
        }
    }
}
