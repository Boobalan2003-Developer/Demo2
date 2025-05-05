import java.util.*;

class leapyr
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int a,year1,year2;

        System.out.println("\n\tLeap Year");
        System.out.println("\n");
        System.out.println("\n\tEnter the Year to find leap or not:");
        a = s1.nextInt();

        if(a%4==0)
        {
            System.out.println("The Given year is Leap year..!");
        }
        else
        {
            System.out.println("the given Year is not Leap Year..!");
        }
 
        System.out.println("\n\nEnter the Starting year: ");
        year1 = s1.nextInt();
        System.out.println("\n\nEnter the Ending year: ");
        year2 = s1.nextInt();

        for(int i = year1;i<=year2;i++)
        {
            if(i%4==0)
            {
                System.out.println(i+" is Leap year..!");
            }
        }
    }
}