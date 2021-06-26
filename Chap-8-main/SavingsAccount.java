import java.text.NumberFormat;
import java.util.Locale;

public class SavingsAccount
{
    private String myFirstName;
    private String myLastName;
    private final String mySSnum;        // Social Security #  - Answer these 3 questions: (1) Why is mySSnum a String?  
    private double mySavingsBalance;     //                   (2) Why is it declared final? (3) Why doesn't it have to be initialized now?
    //1.) You need the spaces inbetween 2.) You can't change a SS number 3.) The person may not be born yet/Not required(?)
    // >> Create a variable with the following:
    //             (1) Name it "myAnnualInterestRate"
    //             (2) Make it private
    //             (3) Make it of type 'double'
    //             (4) Make it be 'static' so that: 
    //                     "No body owns it. The Class actually owns it and All instances of the class share it
    //                      and even the class itself can see it."
    private static double myAnnualInterestRate;
    private Date2 myBirthDate;
    private Date2 myStartDate;

    // ------------------------- Constructors --------------------------
    public SavingsAccount()
    {
        this("","","",0,0,0,0,0,0,0);
        /*
        myFirstName = myLastName = "";
        mySSnum="";
        myBirthDate = new Date(0,0,0);
        myStartDate = new Date(0,0,0);        
        mySavingsBalance=0;
         */
        myAnnualInterestRate = 0.0;
    }

    public SavingsAccount(String firstName, String lastName,String ss,
    int bMonth,int bDay, int bYear,int sMonth, int sDay, int sYear, double sb)
    {  

        this.myFirstName=firstName;
        this.myLastName=lastName;
        this.mySSnum=ss;
        myBirthDate=new Date2(bMonth,bDay,bYear);
        myStartDate=new Date2(sMonth,sDay,sYear);
        mySavingsBalance=sb;
    }
    // ---------------------------------------------------------------------
    public void calculateMonthlyInterest()
    {
        //System.out.println((mySavingsBalance*myAnnualInterestRate)/12.0);
        mySavingsBalance+=mySavingsBalance*(myAnnualInterestRate/12);
    }
    // ---------------------------------------------------------------------
    public static void modifyInterestRate(double apr) // (1) WHY is this method "static"? (2)Take out "static" and what happens?
    {
        myAnnualInterestRate=apr; //Static because so the interest rate is modified across all instances. 2.)Each instance would get its own method, 
        //which is pointless if the variable being modified is shared between all of them
    }
    // ---------------------------------------------------------------------
    public static double getAnnualInterestRate() // (1) WHY is this method "static"? (2)Take out "static" and what happens?
    {
        return myAnnualInterestRate;//1.)The variable it is returning is not unique to the instance since its static as well.
        //2.) Every instance gets its own method, which is pointless if you're modifiying a static variable.
    }
    // ---------------------------------------------------------------------
    public double getSavingsBalance()
    {
        return mySavingsBalance;
    }    
    // ---------------------------------------------------------------------    
    public String printBalance()
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);                      

        return moneyFormat.format(mySavingsBalance)+"\n";           
    }
    // ---------------------------------------------------------------------    
    public String toString()
    {  
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>> YOUR CODE HERE <<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return "Name = " + myFirstName + " " + myLastName +"\nSocial Security = " +mySSnum + "\nBirthDate = " + myBirthDate + 
        "\nStart Date = " + myStartDate + "\nAnnaul Interest Rate = " + myAnnualInterestRate;
    }

}
