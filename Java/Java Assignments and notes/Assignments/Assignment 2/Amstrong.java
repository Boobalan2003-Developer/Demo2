import java.util.*;
import java.math.*;

class Amstrong
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        String valstr;
        int len,i,reminder,valInt,temp;
        double sum=0;
        
        System.out.println("\n\t Amstrong Calculator");
        System.out.println("\n\t Enter the Value: ");
        valInt = s1.nextInt();
        valstr = Integer.toString(valInt);
        temp = valInt;
        len = valstr.length();


        for(i=1; i<=len; i++)
        {
            reminder = valInt%10;
            sum = sum+Math.pow(reminder,len);
            valInt = valInt/10;
        }
        if(sum==temp)
        {
            
            System.out.println("The given Value is Amstrong value..!");

        }
        else
        {
            System.out.println("The Given Value is Not Amstrong Number..!");
        }
    }
}