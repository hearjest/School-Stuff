import java.util.Arrays;
public class Pascal_Triangle_Method2
{

    public Pascal_Triangle_Method2()
    {
        pascalTriangle2(9);
    }

    public static void pascalTriangle2(int n){
        int[][] pascal=new int[n][n];
        pascal[0][0]=1;pascal[1][0]=1;pascal[1][1]=1; //Hard code first two rows

        for(int i=2;i<pascal.length;i++){
            pascal[i][0]=1;

            for(int k=1;k<=i;k++){
                pascal[i][k]=pascal[i-1][k-1]+pascal[i-1][k];
            }

            pascal[i][i]=1;
        }

        for(int i=0;i<pascal.length;i++){
            System.out.println(Arrays.toString(pascal[i]));
        }

        for(int i=0;i<pascal.length;i++){
            for(int j=0;j<pascal.length-i;j++){
                System.out.print("_");
            }
            if(i!=0){
                System.out.print("1_");
            }else{
                System.out.print("1");
            }

            for(int k=1;k<i;k++){
                System.out.print(pascal[i][k]+"_");

            }
            if(i!=0){
                System.out.print("1");
            }
            System.out.println();
        }
    }

}
