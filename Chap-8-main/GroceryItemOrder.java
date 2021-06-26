import java.text.NumberFormat;//GroceryItemOrder BEGIN
import java.util.Locale;
import java.util.Scanner;

public class GroceryItemOrder
{
    private String name;
    private int quantity;
    double pricePerUnit;

    // -------------- Constructors ---------------
    public GroceryItemOrder()
    {
        name="";
        quantity=0;
        pricePerUnit=0;
    }

    public GroceryItemOrder(String name,int quantity,double pricePerUnit)
    {
        this.name=name;
        this.quantity=quantity;
        this.pricePerUnit=pricePerUnit;
    }    

    // ----------------- Helper Methods -------------
    public double getCost()
    {
        return quantity*pricePerUnit;
    }

    public void setQuantity(int q)
    {
        quantity=q;
    }

    // ----------------- toString ----------------
    public String toString()
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);                      

        return "Item Name: " + name +
        "\t Quantity: " + quantity +
        "\t Price Per Unit: $" + pricePerUnit +
        "\t Cost: " + moneyFormat.format(getCost());
    }

}//GroceryItemOrder END
