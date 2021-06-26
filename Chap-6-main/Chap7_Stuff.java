import java.util.*;
import java.io.*;
public class Chap7_Stuff
{
    Chap7_Stuff() throws FileNotFoundException
    {
        /*int n=0;
        int x=15;
        if(x/0>100&&n!=0){
            System.out.print("pass");
        }else{
            System.out.print("fail");
        }*/
        
        for(int i=1;i<=6;i++){
            for(int k=1;k<=6;k++)
                if(k==i)
                    System.out.print(2*k);
                else
                    System.out.print("-");     
            System.out.println();      
        }
        
        for(int i=1;i<=6;i++){
            for(int k=1;k<=i-1;k++)
                     System.out.print("-");
            System.out.print(2*i);
            for(int k=1;k<=6-i;k++)
                System.out.print("-");
            
            System.out.println();      
        }
        
        for(int i=1;i<=6;i++){
            for(int k=1;k<=i-1;k++)
                     System.out.print("-");
            System.out.print(2*i);
            for(int k=i+1;k<=6;k++)
                System.out.print("-");
            
            System.out.println();      
        }
        /*Scanner read=new Scanner(new File("text.txt"));
        wordLengths(read);
        int list[] = {1,3,5,7,9};

        for (int i=0; i<list.length; i++)
        {
        System.out.println(list[i] + " " );
        }

        for (int i=0; i<list.length; i++)
        {
        list[i]++;
        }

        System.out.println("\n\n");
        for (int i=0; i<list.length; i++)
        {
        System.out.println(list[i] + " " );
        }*/
    }

    public static void collaspe(int[] var){
        int count=0,odd=0;
        if(var.length%2!=0){
            odd=1;
        }
        int[] newVar=Arrays.copyOf(var,var.length/2+odd);
        for(int i=0;i<var.length-odd;i++){

            newVar[count]=(var[i]+var[i+1]);
            i++;
            count++;
        }
        if(var.length%2!=0){
            newVar[newVar.length-1]=var[var.length-1];
        }

        System.out.println(Arrays.toString(newVar));
    }

    public static void wordLengths(Scanner read){
        int longestStringLength=0;
        int trackLengths[]=new int[81];
        while(read.hasNext()){

            int nextLength=read.next().length();
            if(nextLength>longestStringLength){
                longestStringLength=nextLength;
            }
            trackLengths[nextLength]++;
        }

        for(int i=1;i<=longestStringLength;i++){
            System.out.print(i+": " +trackLengths[i]+" ");
            for(int j=0;j<=trackLengths[i];j++){
                System.out.print("*");
            }
            System.out.println();
        }
    } 

}
