public class Rational
{
    private int numerator;
    private int denominator;

    public Rational()
    {
        numerator = 0;
        denominator = 1;
    }
    // initialize numerator part to n and denominator part to d
    public Rational( int n, int d )
    {
        numerator = n;
        denominator = d;
        //reduce();
    }

    // Use GET and SET methods!
    // Set the numerator
    public void setNumerator(int n)
    {
        this.numerator = n;
    }
    // Set the denominator
    public void setDenominator(int d)
    {
        this.denominator = d;
    }

    // Get the numerator
    public int getNumerator()
    {
        return this.numerator;
    }
    // Get the denominator
    public int getDenominator()
    {
        return this.denominator;
    }   

    // add two Rational numbers
    public Rational add(Rational right)
    {
        int num, den;
        Rational rationalSum;
        if(this.denominator==right.denominator){
            num = this.numerator + right.numerator;
            den = this.denominator;  
        }else{
            num=(this.numerator*right.denominator)+(right.numerator*this.denominator);
            den=(this.denominator*right.denominator);
        }
        rationalSum = new Rational(num,den);
        rationalSum.reduce();
        return rationalSum;
    }

    // subtract two Rational numbers
    public Rational subtract( Rational right )
    {
        int num, den;
        Rational rationalSum;
        if(this.denominator==right.denominator){
            num = this.numerator - right.numerator;
            den = this.denominator;  
        }else{
            num=(this.numerator*right.denominator)-(right.numerator*this.denominator);
            den=(this.denominator*right.denominator);
        }
        rationalSum = new Rational(num,den);
        rationalSum.reduce();
        return rationalSum;
    }

    // multiply two Rational numbers
    public Rational multiply( Rational right )
    {
        int num, den;
        Rational rationalSum;
        num=this.numerator*right.numerator;
        den=this.denominator*right.denominator;
        rationalSum = new Rational(num,den);
        rationalSum.reduce();
        return rationalSum;
    }

    // divide two Rational numbers
    public Rational divide( Rational right )
    {
        int num, den;
        Rational rationalSum;
        num=this.numerator*right.denominator;
        den=this.denominator*right.numerator;

        rationalSum = new Rational(num,den);
        rationalSum.reduce();
        return rationalSum;
    }

    // reduce the fraction

    public void reduce()
    {
        int commonDen=1;
        
        int numAbs=Math.abs(this.numerator);
        int denAbs=Math.abs(this.denominator);
        
            for(int i=denAbs;i>0;i--){
                if(denAbs%i==0&&numAbs%i==0){
                    commonDen=i;
                    this.numerator/=commonDen;
                    this.denominator/=commonDen;
                    break;
                }
            }
        
        /*
         * 
         * 
        for(int i=denAbs;i>0;i--){
        if(denAbs%i==0){
        for(int j=numAbs;j>0;j--){
        if(numAbs%j==0&&i==j&&i!=1){
        commonDen=j;
        } 
        }
        }
        }
        for(int i=1;i<=denAbs;i++){
        if(denAbs%i==0){
        for(int j=1;j<=numAbs;j++){
        if(numAbs%j==0&&i==j&&i!=1){
        commonDen=j;
        }
        }
        }
        }
         */

        
    }

    // return String representation of a Rational number
    public String toString()
    {
        return(this.numerator+"/"+this.denominator);
    }

    // return floating-point String representation of
    // a Rational number
    public String toFloatString()
    {
        return(""+((double)this.numerator/this.denominator));
    }

}  // end class Rational
