import java.util.*;
import java.io.*;
public class main
{

    public main() throws FileNotFoundException
    {
        //PrintStream output=new PrintStream("text.txt");
        Scanner scan=new Scanner(new File("text.txt"));
        
        wordWrap(scan);
    }
    
    public static void leetSpeak(Scanner read,PrintStream output){
        while(read.hasNextLine()){
            Scanner line=new Scanner(read.nextLine());
            //I'm aware of the size, just couldn't figue out a more effient way.
            while(line.hasNext()){
                String word=line.next();
                System.out.print("(");
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)=='o'){
                        output.print("0");
                    }else if(word.charAt(i)=='l'){
                        output.print("1");
                    }else if(word.charAt(i)=='e'){
                        output.print("3");
                    }else if(word.charAt(i)=='a'){
                        output.print("4");
                    }else if(word.charAt(i)=='t'){
                        output.print("7");
                    }else if(word.charAt(i)=='s'&&i==word.length()-1){
                        output.print("z");
                    }else{
                        output.print(word.charAt(i));
                    }
                }
                output.print(") ");
            }
            output.println();
        }
    }
    
    public static void plusScores(Scanner read){
        while(read.hasNextLine()){
            String name=read.nextLine();
            String score=read.nextLine();
            double total=0;
            double pluses=0;
            for(int i=0;i<score.length();i++){
                if(score.charAt(i)=='+'){
                    pluses++;
                }
                total++;
            }
            System.out.println(name+": " + ((int)(pluses/total*1000.0))/10.0+"% plus");
        
        }
    }

    public static void inputStats(Scanner read){
        int lineCount=0;
        int lengthCount=0;
        String longest="";
        while(read.hasNextLine()){
            String l=read.nextLine();
            Scanner line=new Scanner(l);
            int tokens=1;
            int longestToken=line.next().length();
            lineCount++;
            while(line.hasNext()){
                tokens++;
                int temp=longestToken;
                longestToken=line.next().length();
                if(temp>longestToken){
                    longestToken=temp;
                }
            }
            if(tokens>lengthCount){
                lengthCount=tokens;
                longest=l;
            }
            System.out.println("Line " + lineCount + " has " +tokens+" tokens (longest = " +longestToken+")");
        }
        System.out.println("Longest line: " +longest);
    }

    public static void mostCommonNames(Scanner read){
        while(read.hasNextLine()){
            Scanner line=new Scanner(read.nextLine());
            String name=line.next(),current=name;
            int count=0,curCount=0;
            while(line.hasNext()){
                String temp=current;
                current=line.next();

                if(temp.equals(current)){
                    curCount++;
                    if(!name.equals(current)&&count<curCount){
                        name=current;
                        count=curCount;
                    }else if(name.equals(current)){
                        count++;
                        curCount=1;
                    }
                }else{
                    curCount=1;
                }
            }
            System.out.println("Most common: " + name);
        }
    }

    public static void coinFlip(Scanner read){
        while(read.hasNextLine()){
            Scanner line=new Scanner(read.nextLine());
            int headCount=0;
            double total=0;

            while(line.hasNext()){
                if(line.next().equalsIgnoreCase("h")){
                    headCount++;
                }
                total++;
            }
            double percentage=((int)(headCount/total*10000.0))/100.0;
            if(percentage>=50){
                System.out.println(headCount +" heads (" +percentage+"%)");
                System.out.println("You win");
            }else{
                System.out.println(headCount +" heads (" +percentage+"%)");
            }
        }

    }

    public static void printDuplicates(Scanner read){
        while(read.hasNextLine()){
            String line=read.nextLine();
            Scanner words=new Scanner(line);
            int count=1;
            String token=words.next();
            while(words.hasNext()){
                String token2=words.next();
                if(token.equals(token2)){
                    count++;
                }else if(!token.equals(token2)&&count>1){
                    System.out.print(token + " * " + count +" ");
                    token=token2;
                    count=1;
                }else{
                    token=token2;
                    count=1;
                }

            }
            if(count>1){
                System.out.print(token + " * " + count +" ");
            }

            System.out.println();
        }
    }

    public static void stripComments(Scanner read){
        while(read.hasNextLine()){
            String line=read.nextLine();
            if(line.startsWith("/*")){
                if(!line.contains("*/")){
                    line="";
                }else{
                    line=line.substring(line.indexOf("*/")+2);
                }
            }else if(line.endsWith("*/")){
                line="";
            }

            while(line.indexOf("/*")!=-1&&line.indexOf("*/")!=-1){
                String temp=line.substring(line.indexOf("*/")+2);
                line=line.substring(0,line.indexOf("/*")-1)+temp;
            }

            if(line.indexOf("/")!=-1){
                line=line.substring(0,line.indexOf("/"));
            }

            System.out.println(line);
        }

    }

    public static void stripHtmlTags(Scanner read){
        while(read.hasNextLine()){
            String line=read.nextLine();
            if(line.startsWith("<")){
                line=line.substring(line.indexOf(">")+1);
            }
            while(line.indexOf("<")!=-1&&line.indexOf(">")!=-1){
                String temp=line.substring(line.indexOf(">")+1);
                line=line.substring(0,line.indexOf("<"));
                line+=temp;
            }
            if(line.equals("")){

            }else{
                System.out.println(line);
            }
        }
    }

    public static void wordWrap(Scanner read)throws FileNotFoundException{//Ex.9, 10, 11
        List<String> list=new ArrayList<String>();
        Iterator<String> it=list.iterator();
        while(read.hasNextLine()){
            int cutOff=20;
            String line=read.nextLine();
            while(line.length()>cutOff){
                int i=cutOff;
                while(line.charAt(i-1)!=' '){
                    i--;
                }
                list.add(line.substring(0,i-1));
                line=line.substring(i);
            }
            //output.println(line);
            list.add(line);
        }
        PrintStream output=new PrintStream(new File("text.txt")); 
        for(int i=0;i<list.size();i++){
            output.println(list.get(i));
        }
    }

    public static void doubleSpace(Scanner read,PrintStream output){
        while(read.hasNext()){
            output.println(read.nextLine());
            output.println();
        }
    }

    public static void flipLines(Scanner read){
        while(read.hasNextLine()){
            String first=read.nextLine();

            if(read.hasNextLine()){
                String second=read.nextLine();
                System.out.println(second);
                System.out.println(first);
            }else{
                System.out.println(first);
            } 
        }
    }
    
    /*
       public main() throws FileNotFoundException
    {
        //PrintStream output=new PrintStream("text.txt");
        Scanner scan=new Scanner(new File("text.txt"));
        Chap6_Ex6(scan);
    }
public static void Chap6_Ex6(Scanner read){
    String contents="";
        while(read.hasNextLine()){
            contents+=read.nextLine();
        }
        return contents;
    }
    
public static void Chap6_Ex6(Scanner read){
        while(read.hasNextLine()){
            System.out.println(read.nextLine());
        }
    }


       */

    public static void readEntireFile(Scanner read){
        while(read.hasNextLine()){
            System.out.println(read.nextLine());
        }
    }

    public static void collaspeSpaces(Scanner read){
        System.out.print(read.next());
        while(read.hasNext()){
            System.out.print(" " + read.next());
        }
    }

    public static void countCoins(Scanner read){
        double veryCash=0,hold=0;
        Map<String,Double> convert = new HashMap<String,Double>();
        convert.put("pennies",0.01);
        convert.put("nickels",0.05);
        convert.put("dimes",0.10);
        convert.put("quarters",0.25);
        while(read.hasNext()){
            hold=read.nextInt();
            veryCash+=hold*convert.get(read.next().toLowerCase());
        }
        System.out.println("The monies = $" + ((int)(veryCash*100))/100.0);
    }

    public static boolean negativeSum(Scanner read){
        int sum=0,steps=0;
        while(read.hasNextInt()){
            steps++;
            sum+=read.nextInt();
            if(sum<0){
                System.out.println("Sum of " + sum + " after " + steps + " steps.");
                return true;
            }
        }
        return false;
    }

    public static void evenNumbers(Scanner read){
        int totalNums=0,sum=0;
        double evenPer=0;
        while(read.hasNextInt()){
            int num=read.nextInt();
            totalNums++;
            sum+=num;
            if(num%2==0){
                evenPer++;
            }
        }
        System.out.println(totalNums + " numbers, sum = " + sum);
        System.out.println((int)evenPer + " evens (" + ((int)
                (evenPer/totalNums*10000))/100.0 +"%)");
    }

    public static void boyGirl(Scanner read){
        int boyCount=0,boySum=0;
        int girlCount=0,girlSum=0;  
        while(read.hasNext()){
            if(boyCount==girlCount){
                read.next();
                boyCount++;
                boySum+=read.nextInt();
            }else{
                read.next();
                girlCount++;
                girlSum+=read.nextInt();
            }
        }

        System.out.println(boyCount + " boys, " + girlCount + " girls,");
        System.out.println("Difference between the boys' and girls' sums: " + (int)
            Math.abs(boySum-girlSum));
    }

}
