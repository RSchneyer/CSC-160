import java.awt.event.*;

/**
 * This class compiles! The code runs!  So why does it suck?
 * 
 * @author Cate Sheller (but she will deny it profusely) 
 * @version -0
 */
public class BadClass implements ActionListener
{
    public int x;
    private static String s;

    /**
     * Constructor for objects of class BadClass
     */
    public BadClass()
    {
        // initialise instance variables
        x = 0;
        s = null;
    }

    /**
     * sampleMethod: finds a sum
     * 
     * @param  y   a parameter
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        return x + y;
    }
    
    /**
     * nextOne
     * 
     * @param   y   position of character to be retrieved
     * @return      retrieved character
     */
    public char nextOne (int y)
    {
        if (y > s.length())
        {
            System.out.println("Don't waste my time, you moron");
            return '\0';
        }
        else
            x = y+1;
        return s.charAt(y);
    }
    
    /**
     * setMethod:   resets string
     * 
     * @param   n   new String value
     * @return  x   a number
     */
    public int setMethod (String n)
    {
        s = n;
        return x;
    }
    
    /**
     * getMethod:   retrieves string
     * 
     * @return  s   the string
     */
    
    public String getMethod ()
    {
        x = 0;
        return s;
    }
    
    /**
     * printMethod: prints an important message
     */
    public void printMethod ()
    {
        System.out.println("This is important!");
    }
    
    public void actionPerformed (ActionEvent e)
    {}
    
    public static void main (String [] args)
    {
        BadClass bc = new BadClass();
        System.out.println("This is bad, really bad");
    }
            
}
