public class Name
{
    public String firstName;
    public String middleInitial;
    public String lastName;

    public Name()
    {
        this("","","");
    }

    public Name(String first, String last)
    {
        this(first,"",last);
    }

    public Name(String first, String middle, String last)
    {
        firstName = first;
        middleInitial = middle;
        lastName = last;
    }

    public String toString()
    {
        return lastName + " " + middleInitial + " " + firstName;
    }
    /*
    public int compareTo(Name other){
        int name1,name2;
        
        if(other.lastName.equals("")){
            name2=(int)other.firstName.charAt(0);
        }else{
            name2=(int)other.lastName.charAt(0);
        }
        if(this.lastName.equals("")){
            name1=(int)this.firstName.charAt(0);
        }else{
            name1=(int)this.lastName.charAt(0);
        }
        
        
        return name1-name2;
    }
*/
}
