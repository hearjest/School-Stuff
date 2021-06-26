public class BankAccount
{
    public String name;
    public double balance;
    // YOU Write this variable/field
    // Exercise #11: Add a field/variable to this BankAccount class named 'transactionFee' for a real number representing an amount of money
    // to deduct every time the user withdraws money. The default value is $0.00, but the client can change the value.
    // Deduct the transaction fee money during every withdraw call (but not from deposits). Make sure that the balance
    // cannot go negative during a withdrawal. If the withdrawal (amount plus transaction fee) would cause it to become
    // negative, don’t modify the balance at all.

    public double transactionFee;

    // ==========================================================
    public BankAccount()
    {
        name ="";
        balance =0.00;
        transactionFee=0.00;
    }

    public BankAccount(String name,double balance) 
    {
        this.name = name;
        this.balance = balance;   
        transactionFee=0.00;        
    }

    public BankAccount(String name, double balance, double transactionFee){
        this.name=name;
        this.balance=balance;
        setTransactionFee(transactionFee);
    }

    // ==========================================================
    public void setTransactionFee(double transactionFee)
    {
        this.transactionFee=transactionFee;        
    }
    // ==========================================================
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    // Exercise 11: change withdraw to do as described above.
    public void withdraw(double amount) {
        if(balance - amount - transactionFee<0){
            System.out.println("Not enough funds");
        }else{
            balance = balance - amount - transactionFee;
        }
    }
   


    // >>>>>>>>>>>>>>>>>>>>>>>> YOU WRITE THESE METHODS <<<<<<<<<<<<<<<<<<<<<<

    // Exercise #12: Add a 'toString' method to the BankAccount class from the previous exercise. Your method should return a string that
    // contains the account's name and balance separated by a comma and space. For example, if an account object named yana
    // has the name "Yana" and a balance of 3.03, the call yana.toString() should return the string "Yana, $3.03".
    public String toString()
    {
        return "Name = " + name + "\t Balance = $" + balance + "      transactionFee = " + transactionFee;
        // + "      transactionFee = " + transactionFee
    }    

    // Exercise #13: Add a 'transfer' method to the BankAccount class from the previous exercises. Your method should move money
    // from the current bank account to another account. The method accepts two parameters: a second BankAccount to
    // accept the money, and a double 'transferAmount' for the amount of money to transfer. There is a 'transactionFee' fee for transferring
    // money, so this much must be deducted from the current account’s balance before any transfer. The method should
    // modify the two BankAccount objects such that “this” current object has its balance decreased by the given amount
    // plus 'this.transactionFee' fee, and the other account's balance is increased by just the given transferAmount. If this account object
    // does not have enough money to make the full transfer, transfer whatever money is left after the 'transactionFee' fee is deducted. If this account
    // has under 'transactionFee' or the amount is 0 or less, no transfer should occur and neither account's state should be modified. 
    // NOTE: You MUST use the 'withdraw()' and 'deposit()' methods to make this happen!
    public void transfer(BankAccount person,double amount){
        if(balance<transactionFee){
            System.out.println("NOT enough funds to perform transfer!");
            return;
        }

        if(this.balance<amount+transactionFee){//Not enough to do full transfer
            person.deposit(this.balance-transactionFee);
            withdraw(balance-transactionFee);
            
        }else{//Full transfer
            withdraw(amount);
            person.deposit(amount);
           
        }
    } 

} // BankAccount
/*public void transfer(BankAccount other,double transferAmount)
{
if (balance > transferAmount+transactionFee) { //  There is enough to do full transfer + transactionFee
other.deposit(transferAmount);  
this.withdraw(transferAmount);          
} else if (balance > transactionFee) {       //  There is NOT enough to do full transfer + transactionFee
other.deposit(balance-transactionFee);   //    so transfer as much as you can!
withdraw(balance-transactionFee);    
} else if (balance < transactionFee) { // Nothing to do!        
System.out.println("NOT enough funds to perform transfer!");
}
}    
/*
/*public void transfer(BankAccount person,double amount){

if(this.balance<amount+transactionFee){
person.balance+=this.balance-transactionFee;
this.balance=0;
}else{
withdraw(amount);
person.balance+=amount;
}
}

public void transfer(BankAccount person,double amount){
if(balance<transactionFee){
System.out.println("NOT enough funds to perform transfer!");
return;
}

if(this.balance<amount+transactionFee){//Not enough to do full transfer

person.deposit(this.balance);
this.balance=0;
}else{//Full transfer
withdraw(amount);
person.deposit(amount);
}
} */