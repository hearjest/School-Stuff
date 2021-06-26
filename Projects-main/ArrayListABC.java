import java.util.*;
public class ArrayListABC
{    
    public static void main() 
    {
        // ==========>  declare letterList ArrayList here <===========
        String letter;
        int k;  // Position we are on.
        int count=1; 
        int newPos;  // New Position randomly picked.
        int newLetter;  // New Letter randomly picked.
        String temp;  // Holding variable.
        ArrayList<String> letterList=new ArrayList<String>();
        letterList.add("A"); letterList.add("B"); letterList.add("D"); 
        letterList.add("A"); letterList.add("C"); letterList.add("A"); 
        letterList.add("E"); letterList.add("H"); letterList.add("F"); 
        letterList.add("H"); letterList.add("G"); letterList.add("C"); 
        letterList.add("B");      

        // =====>  YOUR CODE HERE <=======
        // Go through the loop adding, setting, removing, or ignoring elements 
        // as described above printing out the letterList each time through.

        k = 0;      
        count = 1;
        while (k < letterList.size())
        {  
            System.out.println("Acting on: " +letterList.get(k)+"\n");
            if(letterList.get(k).equals("A")){
                letterList.add(k+1,"A");
                k++;
            }else if(letterList.get(k).equals("B")){
                letterList.set(k,"Z");
            }else if(letterList.get(k).equals("C")){
                letterList.remove(k);
                k--;
            }else if(letterList.get(k).equals("D")){
                newPos=(int)(Math.random()*letterList.size());
                while(newPos==k){
                    newPos=(int)(Math.random()*letterList.size());
                }
                temp=letterList.get(newPos);
                letterList.set(k,letterList.get(newPos));
                letterList.set(newPos,"D");
                if(!temp.equals("A")){
                    k--;
                }
            }else if(letterList.get(k).equals("E")){
                newPos=(int)(Math.random()*letterList.size());
                while(newPos==k){
                    newPos=(int)(Math.random()*letterList.size());
                }
                letterList.remove(k);
                letterList.add(k,""+letterList.get(newPos));
                letterList.remove(newPos);
                letterList.add(newPos,"E");
                if(!letterList.get(k).equals("A")){
                    k--;
                }
            }else if(letterList.get(k).equals("F")){
                newPos=(int)(Math.random()*letterList.size());
                while(newPos==k){
                    newPos=(int)(Math.random()*letterList.size());
                }
                letterList.add(newPos,""+((char)(int)((Math.random()*8)+65)));
            }else if(letterList.get(k).equals("G")){
                //For a random amount of times within the limit of the list size,
                //Swap two random positions
                int pos1=0;
                int pos2=0;
                newPos=(int)(Math.random()*letterList.size());
                System.out.println(newPos);
                for(int i=0;i<newPos;i++){
                    while(pos1==pos2&&pos1!=k){
                        pos1=(int)(Math.random()*letterList.size());
                        pos2=(int)(Math.random()*letterList.size()); 
                    }
                    temp=letterList.get(pos1);
                    letterList.set(pos1,letterList.get(pos2));
                    letterList.set(pos2,temp);
                    pos1=0;pos2=0;
                } 
            }//Else if H, do nothing
            k++;
            // Output the ArrayList
            System.out.print("count = " + count + ": ");
            for (int i=0; i < letterList.size(); i++){
                System.out.print("   ("+i+")" + letterList.get(i));
            }
            System.out.println("\n");
            count++; 

        } // while
        System.out.println(letterList);
    }  // main

}  // ArrayListABC

