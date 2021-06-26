public class TimeSpan
 { 
 private int totalMinutes; 
 
    // -------------- Constructors ------------------
    public TimeSpan()
    {
        this(0,0);
    }
    // Constructs a time span with the given interval. 
    // pre: hours >= 0 && minutes >= 0 
    public TimeSpan(int hours, int minutes)
    { 
            totalMinutes = 0; 
            add(hours, minutes); 
    } 
 

    // Adds the given interval to this time span. 
    // pre: hours >= 0 && minutes >= 0 
    public void add(int hours, int minutes)
    { 
        if (hours < 0 || minutes < 0) { 
            throw new IllegalArgumentException("Error! No negatives allowed!"); 
        } 
        totalMinutes += 60 * hours + minutes; 
    } 
    
    // >>>>>>>>>>>>>>>>> YOU FILL IN THESE METHODS  <<<<<<<<<<<<<<<<<<<<<
    // Adds "span" amount of time to 'this' span object.
    public void add(TimeSpan that)
    {
       this.totalMinutes+=that.totalMinutes; 
    }
    // Subtracts "span" amount of time to 'this' span object.
    public void subtract(TimeSpan that)
    {
          this.totalMinutes-=that.totalMinutes;
    }    
    // Scales 'this' span by the given factor.  Basically, it multiplies 
    //   totalMinutes by factor.
    public void scale(int factor)
    {
        this.totalMinutes*=factor;  
    }
    
    // returns a String for this time span, such as "6h 15m" 
    public String toString() 
    { 
        return (totalMinutes / 60) + "h " + (totalMinutes % 60) + "m"; 
    } 
 } 
