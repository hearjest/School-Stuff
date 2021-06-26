import java.util.*;
public class Pascal_Triangle_Method4
{

    public Pascal_Triangle_Method4()
    {
        pascalTriangle4(9);
    }

    public static void pascalTriangle4(int n){
        int[][] pascal=new int[n-2][(n-2)/2+n%2];
        int sum=1,j=0;
        pascal[0][0]=2;pascal[1][0]=3;
        int[] mirror=new int[(n-2)/2+n%2];
        for(int i=2;i<pascal.length;i++){//Make stored array
            while(sum<((int)Math.pow(2,i+2)/2-1)){
                if(j==0){
                    pascal[i][j]=1+pascal[i-1][j];
                    sum+=pascal[i][j];
                }else if(pascal[i-1][j]!=0){
                    pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    sum+=pascal[i][j];                    
                }else if(i-1%2!=0){
                    pascal[i][j]=pascal[i-1][j-1]*2;
                    sum+=pascal[i][j];
                }
                j++;
            }
            j=0;sum=1;
        }

        for(int i=0;i<=1;i++){//Hardcode first two rows

            for(j=1;j<pascal.length-i+2;j++){//Space out
                System.out.print("_");
            }
            if(i==0){
                System.out.println("1");
            }else{
                System.out.println("1_1");
            }
        } 
        
        for(int i=0;i<pascal.length;i++){//Print triangle
            for(j=1;j<pascal.length-i;j++){//Space out
                System.out.print("_");
            }
            System.out.print("1_");
            for(int k=0;k<pascal[i].length;k++){
                if(pascal[i][k]!=0){
                    System.out.print(pascal[i][k]+"_");
                    if(i!=0){
                        if(i%2==0&&pascal[i][k]!=0&&k!=i/2){
                            mirror[k]=pascal[i][k];
                        }else if(i%2!=0&&pascal[i][k]!=0){
                            mirror[k]=pascal[i][k];
                        }
                    }
                }else{
                    break;
                }
            }
            for(j=mirror.length-1;j>=0;j--){//Print the first half backwards
                if(mirror[j]!=0){
                    System.out.print(mirror[j]);
                    if(j!=0){
                        System.out.print("_");
                    }
                }
            }
            if(i!=0){
                System.out.println("_1");
            }else{
                System.out.println("1");
            }

        }
        System.out.println();
        for(int i=0;i<pascal.length;i++){//Print array itself
            System.out.println(Arrays.toString(pascal[i]));
        }
    }

}
