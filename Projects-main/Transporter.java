import java.util.Scanner;
public class Transporter
{
    private double myBank;
    Scanner console=new Scanner(System.in);
    public Transporter()
    {
        System.out.print("How much do you have today?: ");
        myBank=console.nextDouble();
        init(console);
    }

    public void init(Scanner console){
        int startingRegion, destinationRegion, timeStart; char AmPm; boolean anotherTrip=true;
        int mountain=4,marquesIsland=1,tripCount=0,newTime=0;char newAmPm;String askAgain="";
        int timeEnd;double cost;
        String startEnum="",destinationEnum="";
        while(anotherTrip){
            //Need to check if enough balance
            cost=0;
            System.out.println("Input:\n(1) Atlantic\n(2) Eastern\n(3) Central\n(4) Mountain\n(5) Pacific");
            System.out.print("What is the starting region?: ");
            startingRegion=console.nextInt();
            System.out.print("What is the destination region?: ");
            destinationRegion=console.nextInt();
            System.out.print("What time do you start?: ");
            timeStart=console.nextInt();
            System.out.print("AM or PM?(A/P): ");
            AmPm=console.next().charAt(0);
            startEnum=enumerate(startingRegion);
            destinationEnum=enumerate(destinationRegion);

            if((startingRegion==marquesIsland||destinationRegion==marquesIsland)&&startingRegion!=destinationRegion){
                cost+=0.75;
            }
            if(startingRegion>=mountain||destinationRegion>=mountain){
                cost+=0.50;
            }

            if(AmPm=='P'&&timeStart<=12){
                newTime+=12;
            }/*else if(AmPm=='A'&&timeStart==12){
            newTime=12;
            }*/
            if(timeStart!=12){
                newTime+=timeStart; 
            }

            newTime-=destinationRegion-startingRegion;

            if(newTime>24){
                newTime-=24;
                newAmPm='A';
            }else if(newTime==24){
                newTime=12;
                newAmPm='A';
            }else if(newTime>13){
                newTime-=12;
                newAmPm='P';
            }else if(newTime<12&&newTime>0){
                newAmPm='A';
            }else if(newTime==12){
                newAmPm='P';
            }else if(newTime<0){
                newTime+=12;
                newAmPm='P';
            }else{// if(newTime==0)
                newTime=12;
                newAmPm='A';
            }

            cost+=Math.abs(destinationRegion-startingRegion);
            myBank=myBank-cost;
            tripCount++;
            if(enuffInTheBank(cost)){                
                printResults(startEnum,destinationEnum,cost,tripCount,AmPm,newAmPm,newTime,timeStart);
                System.out.println("Would you like to go again?(y/n): ");
                askAgain=console.next();
                if(askAgain.equals("n")){
                    anotherTrip=false;
                    System.out.println("Thank you for traveling today!");
                }
            }else{
                anotherTrip=false;
                System.out.println("INSUFFICIENT FUNDS. BANK = $"+myBank);
            }

            newTime=0;
        } 
    }

    private boolean enuffInTheBank(double cost){
        if(myBank-cost>=0.0){
            return true;
        }
        return false;
    }

    private void printResults(String startEnum,String destinationEnum,double cost,int tripCount,char AmPm,char newAmPm,int newTime,int timeStart){
        System.out.println("From " +startEnum +" to "+destinationEnum+" starting @"+timeStart+""+AmPm+"M\n"+"You will arrive @" 
            +newTime+""+newAmPm+"M");
        System.out.println("Cost = "+cost);
        System.out.println("Trip count = "+tripCount);
        System.out.println("Bank = "+myBank);
        System.out.println("\n\n");
    }

    private String enumerate(int region){
        if(region==1){
            return "Mr.Marques' Island";
        }else if(region==2){
            return "EASTERN";
        }else if(region==3){
            return "CENTRAL";
        }else if(region==4){
            return "MOUNTAIN";
        }else if(region==5){
            return "PACIFIC";
        }else{
            throw new IllegalArgumentException("Invalid Region");
        }
    }

    /*if(timeStart==12){
    if(AmPm=='A'){
    newTime+=12;
    }else{
    newTime+=24;
    }
    }else{
    if(AmPm=='P'){
    newTime+=12;
    }else if(timeStart-(destinationRegion-startingRegion)<0){
    newTime+=24;
    }
    newTime+=timeStart;
    }
    newTime-=destinationRegion-startingRegion;
    if(newTime>=12&&newTime<24){
    newAmPm='P';
    newTime-=12;
    }else if(newTime>=24){
    newAmPm='A';
    newTime-=24;
    }else{
    newAmPm='A';
    }
    if(newTime==0){
    newTime=12;
    } */

}
