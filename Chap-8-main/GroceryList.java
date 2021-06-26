import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
public class GroceryList
{
    private GroceryItemOrder gList[];
    private int size;
    private final int MAX_SIZE=10;
    private Scanner console=new Scanner(System.in);
    // -------------- Constructor ------------
    public GroceryList()
    {
        size=0;
        gList = new GroceryItemOrder[MAX_SIZE];

        for (int i=0; i<MAX_SIZE; i++)
        {
            gList[i] = new GroceryItemOrder();
        }
    }

    // ---------------- Helper Methods ---------
    public void add(GroceryItemOrder item)
    {
        if(size==MAX_SIZE){
            return;
        }
        
        gList[size]=item;
        size++;
    }        

    public String getTotalCost()
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);                              
        double total = 0;

        for(int i=0;i<size;i++){
            total+=gList[i].getCost();
        }

        return moneyFormat.format(total);
    }

    // ------------------------ toString ----------------
    public String toString()
    {
        String list="";
        for(int i=0;i<size;i++){
            list+=gList[i].toString()+"\n\n";
        }
        return list;
    }
}//GroceryList END

