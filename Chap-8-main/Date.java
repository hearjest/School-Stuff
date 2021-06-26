
public class Date
{
    private int daysInMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private int year, month, day; 
    public Date()
    {
        this(0,0,0);
    }

    public Date(int year,int month, int day)
    {
        this.year=year;
        this.month=month;
        this.day=day;
    }
    // ================= gets =========================    
    public int getDay()
    {
        return day;
    }

    public int getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }
    // ================ helper methods ==========================
    public void setDate(int y,int m,int d)
    {
        this.year=y;
        this.month=m;
        this.day=d;
    }

    public boolean isLeapYear()
    {
        if(year%4==0&&(year%100!=0||year%400==0)){
            return true;
        }

        return false;
    }

    public void addDays(int daysToAdd)
    {
        day+=daysToAdd;
        if(day>28){
            while((day>31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12))||
            (day>30&&(month==4||month==6||month==9||month==11))||
            (!isLeapYear()&&day>28&&(month==2))||
            (isLeapYear()&&day>29&&month==2)){//Need to account for leap year feb
                //prereq:day greater than 28
                if(day>31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
                    day=day-31;
                    if(month==12){
                        year++;
                        month=1;
                    }else{
                        month++;
                    }
                }else if(day>30&&(month==4||month==6||month==9||month==11)){
                    day=day-30;
                    month++;
                }else if(isLeapYear()&&day>29&&month==2){
                    day=day-29;
                    month++;
                }else if(!isLeapYear()&&day>28&&month==2){
                    day=day-28;
                    month++;
                }

            }

        }
        if(day==0){
            day++;
        }
        /*if((month==1||month==3||month==5||month==7||month==10||month==12)){
        day=day-31;
        month++;//Account for new year for this one in particular
        }else if((month==4||month==6||month==9||month==11)){
        day=day-30;
        month++;
        }*/
    } // addDays

    public void addWeeks(int weeks)
    {
        addDays((int)Math.ceil(weeks/7));
    }    

    // ==========================================
    public String toString()
    {
        String formatMonth,formatDay;
        if(day<10){
            formatDay="0"+day;
        }else{
            formatDay=""+day;
        }
        if(month<10){
            formatMonth="0"+month;
        }else{
            formatMonth=""+month;
        }
        return ""+year+"/"+formatMonth+"/"+formatDay;
    }

}  // Date

