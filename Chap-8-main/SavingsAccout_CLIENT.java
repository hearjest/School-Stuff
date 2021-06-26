public class SavingsAccout_CLIENT
{
    public static void main()
    {
     SavingsAccount s1 = new SavingsAccount("Robert","Smith","012-34-5678",5,18,1986,2,12,2004,2000.00);
     SavingsAccount s2 = new SavingsAccount("Mary","Jones","987-65-4321",3,17,1987,7,28,2004,3000.00);                   

     // ========================= Person 1 ================================
        // modify the 'static' annualInterestRate
        SavingsAccount.modifyInterestRate(0.03);
        
        // output first person
        System.out.println("========================= Person 1 ================================");
        System.out.println("Output montly balances for one year at " + SavingsAccount.getAnnualInterestRate());

        System.out.println(s1);     
        System.out.println();
        System.out.println(" -- Balance for one year --");
        
        for (int i=1; i<=12; i++) {
            s1.calculateMonthlyInterest();
            System.out.println("   Month " + i + ": " + s1.getSavingsBalance() );
        }
        SavingsAccount.modifyInterestRate(0.04);
        s1.calculateMonthlyInterest();
        System.out.println("\nAfter setting interest rate to 0.04 & \n" + 
                           " calculating another month: " + s1.printBalance());

     // ========================= Person 2 ================================
        // modify the 'static' annualInterestRate
        SavingsAccount.modifyInterestRate(0.03);
        
        // output second person
        System.out.println("\n\n");
        System.out.println("========================= Person 2 ================================");        
        System.out.println("Output monthly balances for one year at " + SavingsAccount.getAnnualInterestRate());

        System.out.println(s2);     
        System.out.println();
        System.out.println(" -- Balance for one year --");
        
        for (int i=1; i<=12; i++) {
            s2.calculateMonthlyInterest();
            System.out.println("   Month " + i + ": " + s2.getSavingsBalance() );
        }
        SavingsAccount.modifyInterestRate(0.04);
        s2.calculateMonthlyInterest();
        System.out.println("\nAfter setting interest rate to 0.04 & \n" + 
                           " calculating another month: " + s2.printBalance());
    }

} // SavingsAccount
