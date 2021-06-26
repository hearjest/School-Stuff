import java.util.*;
public class main
{

    public main()
    {
        //String[] strings={"276453 Helena, MT","9847 New York, NY","123456 Seattle,WA"};
        //Arrays.sort(strings, new num());
        int[] a={123,1,12,28,183,16};
        bogoShuffle(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void bogoShuffle(int[] a){
        Random r=new Random();
        
        for(int i=0;i<a.length;i++){
            
            int j=r.nextInt(a.length);
            boolean isSmallest=false;
            while(a[i]>a[j]&&!isSmallest){
                j=r.nextInt(a.length);
                int smallest=i;
                for(int k=i;k<a.length;k++){
                    if(a[k]<a[smallest]){
                        smallest=k;
                    }
                }
                if(a[smallest]<a[j]){
                    isSmallest=true;
                }
            }  
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            
        }
    }
    
    public static void shuffle(int[] a){
        Random r=new Random();
        for(int i=0;i<a.length;i++){
            
            int j=r.nextInt(a.length);
            while(i>j){
                j=r.nextInt(a.length);
            }  
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            
        }
    }

    public static void modifiedSelectionSort(int[] a){
        for(int i=a.length-1;i>0;i--){
            int maxIndex=i;
            int minIndex=i;
            for(int j=i;j>=0;j--){
                if(a[j]>a[maxIndex]){
                    maxIndex=j;
                }
                
            }
            int temp=a[i];
            a[i]=a[maxIndex];
            a[maxIndex]=temp;
            
            //Below is exercise 19
            for(int j=i;j>=0;j--){  
                if(a[j]<a[minIndex]){
                    minIndex=j;
            }
            }
            
            temp=a[i-1];
            a[i-1]=a[minIndex];
            a[minIndex]=temp;
        }
    }

    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }//For modified selection sort
    

    public static int binarySearch(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            System.out.println(mid);
            if (numbers[mid] == target) {
                return mid; // found it!
            } else if (numbers[mid] < target) {
                min = mid + 1; // too small
            } else { // numbers[mid] > target
                max = mid - 1; // too large
            }
        }
        return -min-1; // not found
    }

    public void countBinary(int n){
        countBinary(n,"");
    }

    public void countBinary(int n,String s){
        if(n==0){
            System.out.println(s);
        }else{
            if(n>0){
                countBinary(n-1,s+"0");
                countBinary(n-1,s+"1");
            }
        }
    }

    public void waysToClimb(int n){
        waysToClimb(n,"[");
    }   

    private void waysToClimb(int n,String solution){
        if(n==0){
            System.out.println(solution.substring(0,solution.length()-1)+"]");
        }else if(n>0){
            waysToClimb(n-1,solution+"1,");
            waysToClimb(n-2,solution+"2,");
        }
    }

    public static int permut(int n, int r){
        if(r==1){
            return n;
        }else{
            return n*permut(n-1,r-1);
        }
    }

    public static int evenDigit(int n){
        if(n==0){
            return 0;
        }else if(n%2==0){
            return n%10 + (10*evenDigit(n/10));
        }else{
            return (evenDigit(n/10));
        }
    }

    public static int indexOf(String s, String c){
        if(s.length()==1&&c.length()>s.length()){
            return -1;
        }else if(s.startsWith(c)){
            return 0;
        }else{
            return 1+indexOf(s.substring(1,s.length()),c.substring(0,c.length()));
        } 
    }

    public static boolean isReverse(String n,String b){
        if((n.length()==1&&b.length()==1)&&b.equalsIgnoreCase(n)){
            return true;
        }else if(b.charAt(0)==n.charAt(n.length()-1)){
            return isReverse(n.substring(0,n.length()-1),b.substring(1,b.length()));
        }
        return false;
    }

    public static String repeat(String s, int n){
        if(n==1){
            return s;
        }else if(n-1==1){
            return s+s;
        }else{
            return s+repeat(s,n-1);
        }
    }

    public static int digitMatch(int n, int b){
        if(n%10==n||b%10==b){
            return 0;
        }else if(n%10==b%10){
            return 1 + digitMatch(n/10,b/10);
        }else{
            return 0+ digitMatch(n/10,b/10);
        }
    }

    public static int multiplyEvens(int n){
        if(n==1){
            return 2;
        }else{
            return (n*2)*multiplyEvens(n-1);
        }
    }

    public static void writeChars(int n){
        if(n==2){
            System.out.print("**");
        }else if(n==1){
            System.out.print("*");
        }else{
            System.out.print("<");
            writeChars(n-2);
            System.out.print(">");
        }
    }

    public static void writeSquares(int n){
        if(n==1&&n>0){
            System.out.print(n);
        }else if((int)Math.sqrt(Math.pow(n,2))==n){
            if(n%2!=0){
                System.out.print((int)Math.pow(n,2)+ ", ");
                writeSquares(n-1);
            }
            if(n%2==0){
                writeSquares(n-1);
                System.out.print(", " + (int)Math.pow(n,2));
            }
        }
        /*}else if(n%2!=0&&(int)Math.sqrt(Math.pow(n,2))==n){
        writeSquares(n-1);
        System.out.print((int)Math.pow(n,2)+", ");
        }else if(n%2==0&&(int)Math.sqrt(Math.pow(n,2))==n){
        writeSquares(n-1);
        System.out.print((int)Math.pow(n,2)+", ");
        }*/
    }

    public static void writeBinary(int n){
        if(n/2==0){
            System.out.print(n%2);
        }else{
            writeBinary(n/2);
            System.out.print(n%2); 
        }
    }

    public static int doubleDigits(int n){
        if(n*-1<10&&n<10){
            return 11*n;
        }else if(n>0){
            return ((n%10) * 11) + 100*(doubleDigits(n/10));
        }else{
            return (((n%10) * 11) - 100*-(doubleDigits(n/10)));
        }

    }

    public static void writeSequence(int n){
        if(n==0){
            System.out.print("");
        }else{
            System.out.print((n+1)/2 + " ");
            //writeSequence(n-1);
            if(n%2==0){
                writeSequence(n-2);
                System.out.print((n+1)/2 + " ");
            }else{
                writeSequence(n-1);
                System.out.print((n+1)/2 + " ");
            }
        }
    }

    public static void writeNums(int n){
        if(n==1){
            System.out.print("");
        }else{
            writeNums(n-1);
            System.out.print(", ");
            System.out.print(n);
        }
    }

    public static void starString(int n){
        if(n==0){
            System.out.print("*");
        }else{
            starString(n-1);
            starString(n-1);
        }
    }

}
