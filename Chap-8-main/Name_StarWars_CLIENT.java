
import java.util.Arrays;
public class Name_StarWars_CLIENT
{
    public static void main()
    {
        Name n1 = new Name("Luke","R","Skywalker");
        Name n2= new Name("Anakin","E","Skywalker"); 
        Name n3 = n2;

        // Output n1-n3
        System.out.println("   n1 = " + n1);
        System.out.println("   n2 = " + n2);
        System.out.println("   n3 = " + n3);  
        System.out.println();

        // Fill array with names.
        Name names[ ] = {n1, n2, new Name("Leia","R","Skywalker"),
                new Name("Han","R","Solo"), new Name("Kylo Ren","E","Solo"),
                new Name("Yoda","R",""), new Name("R2D2","R","Droid"),
                new Name("C3PO","R","Droid"), new Name("Chewbacca","R","Wookie"),
                new Name("Darth","E","Vader"), new Name("Boba","E","Fett")
            };

        // call printList and output names array 
        System.out.println("Original List: ");
        printList(names);
        System.out.println("\n\n");         

        // sort list by last then first name
        System.out.println("Sorted List: ");         
        sortList(names);
        printList(names);
        System.out.println("\n\n");              

        System.out.println("Most common last name = " + mostCommonLastName(names));  
        System.out.println("Shortest total name = " + shortestTotalName(names));
        System.out.println("Largest group in Names = " + largestMembersInNames(names));       
        /* */      
    } // main 

    // ===========================================================================
    // Print the entire array
    public static void printList(Name names[])
    {
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }
    }
    // ===========================================================================
    // Sort the list by last/first name via BubbleSort OR any sort you want,
    // but YOU write the code….and NOT using Arrays.sort(nameList)
    public static void sortList(Name nameList[])
    {
        Name temp=new Name();

        for(int i=0;i<nameList.length-1;i++){
            for(int j=0;j<nameList.length-1;j++){
                /*if(nameList[j].lastName.equals(nameList[j+1].lastName)){
                if(nameList[j].firstName.compareTo(nameList[j+1].firstName)>0){
                temp=nameList[j];
                nameList[j]=nameList[j+1];
                nameList[j+1]=temp;
                }
                }else{//Compare last names
                if(nameList[j+1].lastName.equals("")){
                temp=nameList[j];
                nameList[j]=nameList[j+1];
                nameList[j+1]=temp;
                }else if(nameList[j].lastName.compareTo(nameList[j+1].lastName)>0){
                temp=nameList[j];
                nameList[j]=nameList[j+1];
                nameList[j+1]=temp;
                }

                }*/

                if((nameList[j].lastName.equals(nameList[j+1].lastName)&&nameList[j].firstName.compareTo(nameList[j+1].firstName)>0)
                ||nameList[j+1].lastName.equals("")||(nameList[j].lastName.compareTo(nameList[j+1].lastName)>0)){
                    temp=nameList[j];
                    nameList[j]=nameList[j+1];
                    nameList[j+1]=temp;
                }
            }
        }
    }  

    // ===========================================================================
    // Return the most common last name found,null if none.If more than one exists
    //   common, pick the first one.
    public static String mostCommonLastName(Name list[])
    {
        int count=1,nextCount=0;
        String current=list[0].lastName,next="";

        for(int i=0;i<list.length-1;i++){
            if(current.equals(list[i+1].lastName)){
                count++;
            }else{
                next=list[i+1].lastName;
                nextCount++;
            }

            if(count<nextCount){
                count=nextCount;
                current=next;
                nextCount=0;
            }
        }

        return current;
    }

    // ==============================================================================
    // Find and return the Name that is the shortest in total.If more than one exists
    //   common, pick the first one.
    public static Name shortestTotalName(Name n[])
    {
        int pos=0;
        String name1;
        String name2;
        name1=n[0].firstName+n[0].middleInitial+n[0].lastName;
        for(int i=1;i<n.length;i++){

            name2=n[i].firstName+n[i].middleInitial+n[i].lastName;

            if(name1.length()>name2.length()){
                pos=i;
                name1=name2;
            }
        }
        return n[pos];
    }

    // ===========================================================================    
    // Return the group that has the largest number of members (R or E) 
    public static String largestMembersInNames(Name nl[])
    {
        int rCount=0,eCount=0;
        
        for(int i=0;i<nl.length;i++){
            if(nl[i].middleInitial.charAt(0)=='E'){
                eCount++;
            }else{
                rCount++;
            }
        }
        
        if(eCount>rCount){
            return "Empire: " +eCount;
        }else if(eCount<rCount){
            return "Republic: " + rCount;
        }else{
            return "Neither";
        }
        
    }
    /*
     */
}
// Name_StarWars_CLIENT
