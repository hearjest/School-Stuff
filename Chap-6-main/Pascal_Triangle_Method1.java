import java.util.Arrays;
public class Pascal_Triangle_Method1
{
    public Pascal_Triangle_Method1()
    {
        pascalTriangle1(9);
    }

    public static void pascalTriangle1(int n){
        int[][] pascal=new int[n][2*n-1];
        pascal[0][pascal[0].length/2]=1; //Set up first and second rows
        pascal[1][pascal[0].length/2-1]=1;
        pascal[1][pascal[0].length/2+1]=1;
        
        for(int i=2;i<pascal.length;i++){
            pascal[i][pascal[0].length/2-i]=1;
            for(int k=pascal[0].length/2-i+2;k<=pascal[0].length/2+i-2;k+=2){
                pascal[i][k]=pascal[i-1][k-1]+pascal[i-1][k+1];

            }
            pascal[i][pascal[0].length/2+i]=1;
        }

        
        for(int i=0;i<pascal.length;i++){
            for(int j=0;j<=pascal[0].length/2+i;j++){
                if(pascal[i][j]==0){
                    System.out.print("_");
                }else{
                    System.out.print(pascal[i][j]);
                }
            }
            System.out.println();
        }
        
        
        
        
        /*for(int i=0;i<pascal.length;i++){
            System.out.println(Arrays.toString(pascal[i]));
        }*/
    }

}
