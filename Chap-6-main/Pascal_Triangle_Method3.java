import java.util.*;
public class Pascal_Triangle_Method3
{

    public Pascal_Triangle_Method3()
    {
        pascalTriangle3Test(9);
    }

    public static void pascalTriangle3Test(int n){
        int[][] pascal=new int[n][n/2+n%2];
        pascal[1][0]=1; pascal[0][0]=1;//Hard code first two rows
        int sum=1;int j=1;int k=0;
        int[] mirror=new int[n/2+n%2];
        for(int i=2;i<pascal.length;i++){
            while(sum<((int)Math.pow(2,i)/2)){
                pascal[i][0]=1;
                if(pascal[i-1][j]!=0){
                    pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
                    sum+=pascal[i][j];                    
                }else if(i-1%2!=0){
                    pascal[i][j]=pascal[i-1][j-1]*2;
                    sum+=pascal[i][j];
                }
                j++;
            }
            j=1;sum=1;
        }

        for(int i=0;i<pascal.length;i++){//Print array itself
            System.out.println(Arrays.toString(pascal[i]));
        }

        for(int i=0;i<pascal.length;i++){//Print triangle
            for(k=1;k<pascal.length-i;k++){//Space out
                System.out.print("_");
            }
            if(i!=0){
                System.out.print("1_");
            }else{
                System.out.print("1");
            }

            for(j=1;j<pascal[i].length;j++){//Print first half
                if(pascal[i][j]!=0){
                    if(j<pascal[i].length-1){
                        System.out.print(pascal[i][j]+"_");
                    }else{
                        System.out.print(pascal[i][j]);
                    }
                    if(i%2==0&&j!=i/2&&pascal[i][j]!=0){//Build up an array to mirror first half
                        mirror[j]=pascal[i][j];
                    }else if(i%2!=0&&pascal[i][j]!=0){
                        mirror[j]=pascal[i][j];
                    }
                }else{
                    break;
                }
            }
            if(j==pascal[i].length){
                System.out.print("_");
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
                System.out.print("1"); 
            }
            System.out.println();
            Arrays.fill(mirror,0);

            //Even i rows have an odd amount of values, odd i rows have evn amounts of values
        }
    }

    public static void pascalTriangle3(int n){
        int columns;
        if(n%2==0){
            columns=n;
        }else{
            columns=n/2+1;
        }
        int[][] pascal=new int[n][columns];
        pascal[1][0]=1; pascal[0][0]=1;//Hard code first two rows
        int j;
        boolean notDuplicateOrEqual=true;
        for(int i=2;i<pascal.length;i++){
            pascal[i][0]=1;
            j=1;
            while(notDuplicateOrEqual){
                pascal[i][j]=nChoosek(i)/(nChoosek(j)*nChoosek(i-j)); 
                if(pascal[i][j]>=(nChoosek(i)/(nChoosek(j+1)*nChoosek(i-(j+1))))){
                    notDuplicateOrEqual=false;
                }
                j++;
            }
            notDuplicateOrEqual=true;
        }
        for(int i=0;i<pascal.length;i++){
            System.out.println(Arrays.toString(pascal[i]));
        }
    }

    public static int nChoosek(int k){
        int product=1;
        for(int i=1;i<=k;i++){
            product*=i;
        }

        return product;
    }
}
