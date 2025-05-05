import java.util.*;

class NaturalNumbers
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int val,sum=0;

        System.out.println("\n\tNatural Numbers Addition ");
        System.out.println("\t************************");
        System.out.println("\tEnter the a Value: ");
        val = s1.nextInt();

        if(val>0)
        {
            for(int i = val; i>0;i--)
            {
                sum = sum+i;
            }
            System.out.println("The Sum is: "+sum);
        }
        else
        {
            System.out.println("Invalid Number. Please enter the Natural Integers.!");
        }
    }
}