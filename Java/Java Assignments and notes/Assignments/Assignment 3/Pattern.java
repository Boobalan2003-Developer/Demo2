import java.util.*;

class Pattern
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);

        int terms;

        System.out.println("Enter the Terms: ");
        terms = s1.nextInt();
        
        
        int count=1;
        for(int i = 1;i<=terms;i++)
        {

            //Pyramid Pattern..!
            for(int k = terms;k>i ;k--)
            {
                System.out.print(" ");
            }

            
            //Inner Loop Printing..!
            for(int j = 1;j<=i;j++,count++)
            {
                System.out.print(count +" ");
            }

            //NextLine Cursor moving..!
            System.out.println();
        }
    }
}