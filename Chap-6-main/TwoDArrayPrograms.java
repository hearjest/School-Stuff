import java.util.*;
public class TwoDArrayPrograms
{
    public TwoDArrayPrograms()
    {
        int[][] a= { {1,1,1,2,2,2,2,2},
                {1,1,1,2,2,2,2,2}};
        int n=1234;
        int rem=0,revNum=0;

        n=1234;
        for(int i=0;i<=n;i++){
            rem=n%10;
            revNum=revNum*10+rem;
            n/=10;
        }
        System.out.println(revNum);
        revNum=0;
        n=1234;
        while(n!=0){
            rem=n%10;
            revNum=revNum*10+rem;
            n/=10;
        }
        System.out.println(revNum);
        revNum=0;
        n=1234;
        for(int i=n;i!=0;i/=10){
            rem=i%10;
            revNum=revNum*10+rem;

        }
        System.out.println(revNum);
    }

    public static void Num_10(int[][] a){
        char[][] seats=new char[a.length][a[0].length];
        Scanner console=new Scanner(System.in);
        int seatsFilled=0, max1stClassPerRow=3,current1stClass=0,current1stClassRow=0;//First Class
        int current2ndClass=0,current2ndClassRow=0;

        for(int i=0;i<seats.length;i++){//Initialize empty seats
            Arrays.fill(seats[i],'f');
        }

        while(seatsFilled<(a.length*a[0].length)){
            System.out.print("What class seat would you like?: ");
            int choice = console.nextInt();
            if(choice==1){//If user chooses first class
                if(current1stClassRow==seats.length){
                    System.out.println("\nSorry, there are no more 1st class seats, would you like a 2nd class seat? y/n : ");
                    String decision=console.next();

                    if(decision.equals("y")){
                        seats[current2ndClassRow][max1stClassPerRow+current2ndClass]='T';
                        current2ndClass++;

                        if(max1stClassPerRow+current2ndClass==seats[0].length&&current2ndClassRow<seats.length){
                            current2ndClass=0;
                            current2ndClassRow++;

                        }
                    }

                }else{
                    seats[current1stClassRow][current1stClass]='T';
                    current1stClass++;
                    if(current1stClass==max1stClassPerRow&&current1stClassRow<seats.length){
                        current1stClass=0;
                        current1stClassRow++;
                    }
                }
                seatsFilled++;
            }else{//If choice is second class
                if(current2ndClassRow==seats.length){
                    System.out.println("\nSorry, there are no more 2nd class seats, would you like a 1st class seat? y/n : ");
                    String decision=console.next();
                    if(decision.equals("y")){
                        seats[current1stClassRow][current1stClass]='T';
                        current1stClass++;
                        if(current1stClass==max1stClassPerRow&&current1stClassRow<seats.length){
                            current1stClass=0;
                            current1stClassRow++;
                        }

                    }
                }else{
                    seats[current2ndClassRow][max1stClassPerRow+current2ndClass]='T';
                    current2ndClass++;

                    if(max1stClassPerRow+current2ndClass==seats[0].length&&current2ndClassRow<seats.length){
                        current2ndClass=0;
                        current2ndClassRow++;
                    }
                } 
                seatsFilled++;
            }
            //Print out seats and avaliability
            System.out.println();
            for(int i=0;i<a.length;i++){//Print seats
                System.out.println(Arrays.toString(a[i]));
            }
            for(int i=0;i<seats.length;i++){//Print avalibility 
                System.out.println(Arrays.toString(seats[i]));
            }
            System.out.println();
        }
    }

    public static void Num_9(int[][] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a[i].length;j++){
                int temp=a[j][i];
                a[j][i]=a[i][j];
                a[i][j]=temp; 
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static void Num_8(int[][] a){
        Random r=new Random();
        int row=0;
        int col=0;
        int num=0;
        int sum=0;
        for(int i=1;i<=3;i++){
            row=r.nextInt(a.length);
            col=r.nextInt(a.length);
            num=a[row][col];
            sum+=num;
            System.out.println("Hit Row = " + row + " Hit Column = " + col + " Point= " + num);
        }
        System.out.println("Sum = " + sum);
    }

    public static void Num_7(String[][] words){
        int vowelCount=0;
        int maxVowels=0;
        String maxWord="";
        int maxVowelRow=0;
        int maxVowelCol=0;
        for(int i=0;i<words.length;i++){

            for(int j=0;j<words[i].length;j++){  
                for(int k=0;k<words[i][j].length();k++){ 
                    char c=words[i][j].charAt(k);
                    if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                        vowelCount++; 
                    }
                }

                if(vowelCount>=maxVowels){
                    maxVowels=vowelCount;
                    maxWord=words[i][j];
                    maxVowelRow=i;
                    maxVowelCol=j;
                }
                vowelCount=0;
            }

        }
        System.out.println(maxWord + " Row = " + maxVowelRow + " Column = " + maxVowelCol + " Vowel Count = " + maxVowels);
    } 

    public static void Num_6(int[][] a){
        int sum=0;

        for(int i=0;i<a.length;i++){
            sum+=a[i][i];
            if(a.length%2==0&&i!=((a.length-1) / 2)){   //  ! (a.length%2!=0&&i==((a.length-1) / 2))
                sum+=a[i][a.length-1-i];
            } 
        }
        System.out.println(sum);
    }

    public static void Num_5(int[][] a){
        int sum=0;
        //Carve off top
        for(int i=0;i<a[0].length;i++){
            sum+=a[0][i];
        }
        //Keep taking first and last boxes until last row
        int k=1;
        while(k<a.length-1){
            sum+=a[k][0];
            sum+=a[k][a[k].length-1];
            k++;
        }

        for(int i=0;i<a[0].length;i++){
            sum+=a[a.length-1][i];
        }
        System.out.println(sum);
    }

    public static void Num_4(int[][] a){
        double rowSum=0,colSum=0;
        double maxAvgRow=0,maxAvgRowSum=0;
        double maxAvgCol=0,maxAvgColSum=0;
        double[] rowsAverage=new double[a.length];
        double[] columnsAverage=new double[a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){//Goes through each row
                rowSum+=a[i][j];
            }
            rowSum=rowSum/a[i].length;
            if(rowSum>maxAvgRowSum){
                maxAvgRowSum=rowSum;
                maxAvgRow=i;
            }
            rowsAverage[i]=rowSum;
            rowSum=0;
        }
        for(int k=0;k<a[0].length;k++){//Goes through each column
            for(int j=0;j<a.length;j++){
                colSum+=a[j][k];
            }
            colSum=colSum/a.length;
            if(colSum>maxAvgColSum){
                maxAvgColSum=colSum;
                maxAvgCol=k;
            }
            columnsAverage[k]=colSum;
            colSum=0;
        }
        int printUpTo=0;
        if(a.length>a[0].length){
            printUpTo=a.length;
        }else{
            printUpTo=a[0].length;
        }

        for(int i=0;i<printUpTo;i++){
            if(i<a.length){
                System.out.print("Average of row " + i +" = " + rowsAverage[i]);
                System.out.print("             ");
            }else{
                System.out.print("                                     ");
            }
            if(i<a[0].length){
                System.out.print("Average of column " + i +" = " + columnsAverage[i]);
            }
            System.out.println();
        }
        System.out.println("Max Avg Row = " + maxAvgRow + " with Max Avg = " + maxAvgRowSum);
        System.out.println("Max Avg Col = " + maxAvgCol + " with Max Avg = " + maxAvgColSum);
    }

    public static void Num_3(int[][] a){
        int evenCount=0,oddCount=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]%2==0){
                    evenCount++;
                }else{
                    oddCount++;
                }
            }
        }

        System.out.println("Evens = " + evenCount + " Odds = " + oddCount);
    }

    public static void Num_2(int[][] a){
        int max=a[0][0],min=max;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(max<a[i][j]){
                    max=a[i][j];
                }
                if(min>a[i][j]){
                    min=a[i][j];
                }
            }
        }
        System.out.println("Max = " + max + " Min = " + min);
    }

    public static void Num_1(int[][] a){
        int sum=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                sum+=a[i][j];
            }
        }
        System.out.println("Sum = " + sum + " Average = " + (sum/(a.length*a[a.length-1].length*1.0)));
    }

}
