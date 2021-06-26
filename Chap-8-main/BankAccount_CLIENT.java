public class BankAccount_CLIENT
{
   
   public static void main()
   {
    BankAccount ben = new BankAccount("Ben",100,5);
    BankAccount hal = new BankAccount("Hal",200,7);    
    
        System.out.println("Chapter 8: Exercise #11-13  BankAccount:");
        
        // >>>>>>>>>>>>>>>>>> Initial Values: <<<<<<<<<<<<<<<<<<<<<
        // OUTPUT:
        //      ben [initial]: Name = Ben    Balance = 100.0      transactionFee = 5.0
        //      hal [initial]: Name = Hal    Balance = 200.0      transactionFee = 7.0
        System.out.println("ben [initial]: " + ben.toString());
        System.out.println("hal [initial]: " + hal.toString());
        System.out.println(); 
        
        // >>>>>>>>>>>>>>>>>>  Deposits:  <<<<<<<<<<<<<<<<<<<<<
        // OUTPUT:
        //      After ben.deposit(80.00): Name = Ben	 Balance = 180.0      transactionFee = 5.0
        //      After hal.deposit(20.00): Name = Hal	 Balance = 220.0      transactionFee = 7.0       
        ben.deposit(80.00);
        hal.deposit(20.00);
        System.out.println("After ben.deposit(80.00): " + ben.toString());
        System.out.println("After hal.deposit(20.00): " + hal);   
        System.out.println(); 
        
        // >>>>>>>>>>>>>>>>>> Withdraws: <<<<<<<<<<<<<<<<<<<<<  
        // OUTPUT:
        //      After ben.withdraw(50.00): Name = Ben	 Balance = 125.0      transactionFee = 5.0
        //      After hal.withdraw(10.00): Name = Hal	 Balance = 203.0      transactionFee = 7.0        
        ben.withdraw(50.00);
        hal.withdraw(10.00);
        System.out.println("After ben.withdraw(50.00): " + ben);
        System.out.println("After hal.withdraw(10.00): " + hal.toString());   
        System.out.println();          
        
        // >>>>>>>>>>>>>>>>>> Transfers: <<<<<<<<<<<<<<<<<<<<<
        // Transfer Set #1: 
        // After ben.transfer(hal, 50.00) to hall: 
        //      Name = Ben	 Balance = 70.0      transactionFee = 5.0
        //      Name = Hal	 Balance = 253.0      transactionFee = 7.0
        // After hal.transfer(ben, 30.00) to ben: 
        //      Name = Ben	 Balance = 100.0      transactionFee = 5.0
        //      Name = Hal	 Balance = 216.0      transactionFee = 7.0        
        System.out.println("Transfer Set #1: ");
        ben.transfer(hal, 50.00);
        System.out.println("After ben.transfer(hal, 50.00) to hall: ");
        System.out.println("\t" + ben);  
        System.out.println("\t" + hal);                  
        hal.transfer(ben, 30.00);
        System.out.println("After hal.transfer(ben, 30.00) to ben: ");
        System.out.println("\t" + ben);  
        System.out.println("\t" + hal);  
        System.out.println(); 
        // Transfer Set #2: 
        // After ben.transfer(hal, 101.00) to hall: 
        // NOTE: since ben only had $100 and his trasfer fee is $5,
        //       only $95 was added to hal's account bringing it to $311
        //      Name = Ben	 Balance = 0.0      transactionFee = 5.0
        //      Name = Hal	 Balance = 311.0      transactionFee = 7.0
        System.out.println("Transfer Set #2: ");
        ben.transfer(hal, 101.00);
        System.out.println("After ben.transfer(hal, 101.00) to hall: ");
        System.out.println("NOTE: since ben only had $100 and his trasfer fee is $5,\n" +
                           "      only $95 was added to hal's account bringing it to $311");
        System.out.println("\t" + ben);  
        System.out.println("\t" + hal);                   
        System.out.println();        
        // Transfer Set #3: 
        // NOT enough funds to perform transfer!
        // After ben.transfer(hal, 1.00) to hall: 
        //      Name = Ben	 Balance = 0.0      transactionFee = 5.0
        //      Name = Hal	 Balance = 311.0      transactionFee = 7.0
        System.out.println("Transfer Set #3: ");
        ben.transfer(hal, 1.00);
        System.out.println("After ben.transfer(hal, 1.00) to hall: ");
        System.out.println("\t" + ben);  
        System.out.println("\t" + hal);                   
        System.out.println();        

    } // main
    
}  // BankAccount_CLIENT
