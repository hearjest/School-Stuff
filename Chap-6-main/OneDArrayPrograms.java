import java.util.Arrays;
import java.util.Scanner;
public class OneDArrayPrograms
{
    public OneDArrayPrograms()
    {
        int a[] ={1, 1, 1, 2, 2, 2, 2};
        Num10(a);
    }

    public static void Num1(int[] a){
        int min=a[0],max=min;
        for(int i=1;i<a.length;i++){
            if(min>a[i]){
                min=a[i];
            }
            if(max<a[i]){
                max=a[i];
            }
        }
        System.out.println("Largest = " +max +" Smallest = " +min);
    }

    public static void Num2(int[] a,int k){
        int equalK=0,greaterThanK=0,lessThanK=0;

        for(int i=0;i<a.length;i++){
            if(a[i]==k){
                equalK++;
            }else if(a[i]>k){
                greaterThanK++;
            }else if(a[i]<k){
                lessThanK++;
            }
        }
        System.out.println("K Count: " +equalK +" Less than k: " + lessThanK +" Greater than k: " + greaterThanK);
    }

    public static void Num3(String[] a){
        int longestLength=a[0].length(),shortestLength=longestLength;
        int longestPosition=0,shortestPosition=0;

        for(int i=1;i<a.length;i++){
            if(longestLength<a[i].length()){
                longestLength=a[i].length();
                longestPosition=i;
            }
            if(shortestLength>a[i].length()){
                shortestLength=a[i].length();
                shortestPosition=i;
            }
        }

        System.out.println("Longest: " + a[longestPosition] + " Position: " + longestPosition
            + "Shortest: " + a[shortestPosition] + " Position: " + shortestPosition);

    }

    public static void Num4(int[] a){
        int posCount=0,negCount=0;

        for(int n: a){
            if(n>=0){
                posCount++;
            }else{
                negCount++;
            }
        }

        System.out.println("Positive count: " + posCount + " Negative count: " + negCount);
    }

    public static void Num5(double[] a){
        double sum=0;

        for(double n: a){
            sum+=n;
        }

        System.out.println("Sum: " + sum +" Average: " + sum/a.length);
    }

    public static void Num6(int[] a){
        int temp;
        for(int i=0;i<=a.length/2;i++){
            temp=a[i];
            a[i]=a[a.length-i-1];
            a[a.length-i-1]=temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void Num7(int[] a){
        int big1=a[0],big2=-1,big3=-1;
        /*int i=1;
        while(i!=3){
        for(int n: a){
        if(n>big1){
        big1=n;
        }
        if(n>big2&&n<big1){
        big2=n;
        }
        if(n>big3&&n<big2){
        big3=n;
        }
        }
        i++;
        }*/
        Arrays.sort(a); //Big brain time
        big1=a[a.length-1];
        big2=a[a.length-2];
        big3=a[a.length-3];
        System.out.println("Largest: " + big1 + ", 2nd Largest: " + big2 + ", 3rd Largest: "
            + big3);
        if(big1>big2+big3){
            System.out.println("Yes, " + big1 +">" + (big2+big3));
        }else{
            System.out.println("No, " + big1 +"<" + (big2+big3));
        }
    }

    public static void Num8(int[] a){
        int median;
        String mode="None";
        double mean=0;
        int bubbleSortPassCount=1;//For median
        int occurencesMode=1;
        //Bubblesort First
        while(bubbleSortPassCount>=1){
            bubbleSortPassCount=0;
            for(int i=0;i<a.length-1;i++){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    bubbleSortPassCount++;
                }
            }
        }
        //Find median
        if(a.length%2==0){
            median=(a[a.length/2]+a[a.length/2-1])/2;
        }else{
            median=a[a.length/2];
        }
        //Find mean and begin finding max occurences of mode
        mean+=a[0];
        int occurs=0;
        for(int i=1;i<a.length;i++){
            mean+=a[i];
            if(a[i]==a[i-1]){
                occurencesMode++;
                if(occurs<occurencesMode){
                    occurs=occurencesMode;
                }
            }else{
                occurencesMode=1;
            }
        }
        mean/=a.length;
        occurencesMode=1;
        //If it has a mode
        if(occurs>1){
            mode="";
            for(int i=1;i<a.length;i++){
                if(a[i]==a[i-1]){
                    occurencesMode++;
                    if(occurencesMode==occurs){
                        mode+=a[i] +" ";
                    }
                }else{
                    occurencesMode=1;
                }
            }
        }
        System.out.println("Mean = " + mean + " Median = " + median + " Mode = " + mode);
    }

    public static void Num9(int n){
        int[] a=new int[8];
        for(int i=7;i>=0;i--){
            if(n==0){
                a[i]=0;
            }else{
                a[i]=n%2;
                n/=2;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    // 1 1 1 2 2 2 2
    // T T F T T F F
    public static void Num10(int[] seats){
        int firstClassCount=0,secondClassCount=0;
        int totalSeatsFilled=0; 
        int firstClassOccupied=-1,secondClassOccupied=-1;
        //Find out how many first and second class seats there are
        for(int n: seats){
            if(n==1){
                firstClassCount++;
            }else{
                secondClassCount++;
            }
        }
        String[] occupied=new String[seats.length];
        Arrays.fill(occupied,"F");
        Scanner console=new Scanner(System.in);
        while(totalSeatsFilled!=seats.length){
            System.out.println(Arrays.toString(seats)+"\n" +Arrays.toString(occupied));
            System.out.print("What kind of seat do you want?: ");
            int numClass=console.nextInt();

            if(numClass==1){
                firstClassOccupied++;
                //If there are no more avaliable 1st class seats
                if(firstClassOccupied>=firstClassCount){
                    System.out.println("Sorry, there are no more 1st class seats ");
                    //Offer second class seats if they are avaliable
                    if(totalSeatsFilled<seats.length){
                        System.out.println("Would you like a 2nd class seat?");
                        String confirmation=console.next();
                        if(confirmation.equalsIgnoreCase("yes")){
                            //Same exact code for the 2nd class seats below
                            secondClassOccupied++;
                            if(secondClassOccupied+firstClassCount==seats.length-1){
                                System.out.println("Sorry, there are no more 2nd class seats ");
                            }else{
                                occupied[secondClassOccupied+firstClassCount]="T";
                                totalSeatsFilled++;
                            }
                        }
                    }
                }else{
                    //Fill in a 1st class seat
                    occupied[firstClassOccupied]="T";
                    totalSeatsFilled++;
                } 
            }else{//If they select 2nd class
                secondClassOccupied++;
                //If there are no more 2nd class seats avaliable
                if(secondClassOccupied+firstClassCount==seats.length){
                    System.out.println("Sorry, there are no more 2nd class seats ");
                    //Offer 2nd class seats
                    if(totalSeatsFilled<seats.length){
                        System.out.println("Would you like a 1st class seat?");
                        String confirmation=console.next();
                        if(confirmation.equalsIgnoreCase("yes")){
                            //Same exact code for 1st class seats above
                            firstClassOccupied++;
                            if(firstClassOccupied>=firstClassCount){
                                System.out.println("Sorry, there are no more 2nd class seats ");
                            }else{
                                occupied[firstClassOccupied]="T";
                                totalSeatsFilled++;
                            }
                        }
                    }
                }else{
                    //Fill in a 2nd class seat
                    occupied[secondClassOccupied+firstClassCount]="T";
                    totalSeatsFilled++;
                }
            }
        }
        System.out.println(Arrays.toString(seats)+"\n" +Arrays.toString(occupied));
    }

}
