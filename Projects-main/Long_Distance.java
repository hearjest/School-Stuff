import java.util.Scanner;
public class Long_Distance
{

    public Long_Distance()
    {
        LongDistance();
    }

    public void LongDistance(){
        boolean again=true;
        System.out.println("1 = M, 2 = T, 3 = W, 4 = Th, 5 = F, 6 = Sa, 7 = Su");
        while(again){
            Scanner console=new Scanner(System.in);
            System.out.print("On what number day of the week did you start the call?: ");
            int day = console.nextInt();
            System.out.print("At what hour did you start the call? (24 Hour Format): ");
            int hourStart=console.nextInt();
            System.out.print("And the minutes it started at?: ");
            int minStart=console.nextInt();
            System.out.print("How many minutes did the call last?: ");
            int totalMin=console.nextInt();
            System.out.println(LongDistanceProcess(day,hourStart,minStart,totalMin));
            System.out.println("Would you like to enter another? (yes/no): ");
            again=console.next().equals("yes");
            System.out.println("\n");
        }
    }

    private double LongDistanceProcess(int day, int hourStart, int minStart, int totalMinutes){
        double sum=0; double time= (hourStart * 60) + minStart;
        double rate=0;int hour=0;
 
        while(totalMinutes>0){
            if(day<6){
                
                if(time<480){//BEFORE 8:00
                    if(totalMinutes+time>480){//Goes beyond 480
                        sum+=(480-time)*0.25;
                        totalMinutes-=(480-time);
                        time=480;
                    }else{//Within 480 minutes
                        sum+=totalMinutes*0.25;
                        totalMinutes=0;
                    }
                }else if(time>1080){//AFTER 18:00/6:00PM
                    if(totalMinutes+time>1440){//Goes beyond 1440
                        sum+=(1440-time)*0.25;
                        totalMinutes-=(1440-time);
                        time=0;
                        day++;
                    }else{//Within 1440 minutes
                        sum+=((time+totalMinutes)-1080)*0.25;
                        totalMinutes=0;
                    }
                }else if(time>=480&&time<=1080&&totalMinutes>0){
                    if(totalMinutes+time>=1080){//Goes beyond 6:00PM
                        sum+=(1*0.25)+((1080-time)*0.40);
                        totalMinutes-=1081-time;
                        time=1081;
                    }else{//Within 8:00-AM-6:00PM 
                        sum+=((time+totalMinutes)-480)*0.40;
                        totalMinutes=0;
                    }
                }
                
            }else if(day>=6){
                
                if(time+totalMinutes>1440&&totalMinutes>0){
                    sum+=(1440-time)*0.15;
                    totalMinutes-=1440-time;
                    time=0;
                    if(day+1==8){
                        day=1;
                    }else{
                        day++;
                    }
                }else{
                    sum+=totalMinutes*0.15;
                    totalMinutes=0;
                    if(day+1==8){
                        day=1;
                    }else{
                        day++;
                    }
                }
                
            }

        }
        return sum;
    }
}

/*
if(time<480){
rate=0.25;
hour=480;
}else if(time>1080){
rate=0.25;
hour=1440;
}*/

