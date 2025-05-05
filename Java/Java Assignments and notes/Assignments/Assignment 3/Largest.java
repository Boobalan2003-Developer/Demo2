import java.util.*;

class Largest
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int size;

        System.out.println("Enter the Array size: ");
        size = s1.nextInt();

        int[] val = new int[size];

        for(int i=0;i<size;i++)
        {
            System.out.println("Enter the value of "+(i+1));
            val[i] = s1.nextInt();
        }

        int m = val[0];

        for(int j = 0; j<size; j++)
        {
            if(val[j] > m)
            {
                m = val[j];
            }
        }
        System.out.println("\tLargest Number is: "+m);
    }
}