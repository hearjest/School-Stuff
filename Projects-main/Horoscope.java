import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class Horoscope
{

    public Horoscope()
    {
        Scanner console=new Scanner(System.in);
        System.out.print("Welcome to the horoscope reader. Do you know your horoscope?(y/n): " );
        String answer=console.next();
        if(answer.equalsIgnoreCase("y")){
            System.out.println("\nGreat, enter your sign, please: ");
            answer=console.next();
            List<String> signList=new ArrayList<String>(Arrays.asList("Aries","Taurus","Gemini","Cancer","Leo","Virog","Libra","Sagittarius","Capricorn","Aquarius"));
            while(!signList.contains(answer)){
                System.out.print("\nSorry, you may have spelt your sign incorrectly, please retype it: ");
                answer=console.next();
            }
            System.out.println("\nAlright, let's see your horoscope.");
            //Call for reading
            try{
                reading(answer);
            }catch(IOException ioe){
                return;
            }
        }else{
            System.out.print("Alright, let's find your sign.\nWhat's your month of birth?(Intgers): ");
            int month=console.nextInt();
            System.out.print("And your day of birth?: ");
            int day=console.nextInt();
            //Find out sign
            //Call for reading
        }
    }

    private static void findSign(int month, int day){
        String sign="";
        if(month==12&&day>=22&&day<=31||month==1&&day<=19){
            sign="Capricorn";
        }else if(month==1&&day>=20&&day<=31||month==2&&day<=18){
            sign="Aquarius";
        }else if(month==2&&day>=19&&day<=28||month==3&&day<=20){
            sign="Pisces";
        }else if(month==3&&day>=21&&day<=31||month==4&&day<=19){
            sign="Aries";
        }else if(month==4&&day>=20&&day<=30||month==5&&day<=20){
            sign="Taurus";
        }else if(month==5&&day>=21&&day<=31||month==6&&day<=20){
            sign="Gemini";
        }else if(month==6&&day>=21&&day<=30||month==7&&day<=22){
            sign="Cancer";
        }else if(month==7&&day>=23&&day<=31||month==8&&day<=22){
            sign="Leo";
        }else if(month==8&&day>=23&&day<=30||month==9&&day<=22){
            sign="Virgo";
        }else if(month==9&&day>=23&&day<=31||month==10&&day<=22){
            sign="Libra";
        }else if(month==10&&day>=23&&day<=31||month==11&&day<=21){
            sign="Scorpio";
        }else if(month==11&&day>=22&&day<=30||month==12&&day<=21){
            sign="Sagittarius";
        }
        try{
            reading(sign);
        }catch(IOException ioe){
            return;
        }
    }

    private static void reading(String sign) throws IOException{
        String page = "https://www.astrology.com/horoscope/daily/"+sign+".html";
        Document doc =Jsoup.connect(page).get();
        String date=doc.getElementById("content-date").text();
        String fortune=doc.getElementById("content").text();
        System.out.println(date);
        System.out.println(fortune);
    }
}
