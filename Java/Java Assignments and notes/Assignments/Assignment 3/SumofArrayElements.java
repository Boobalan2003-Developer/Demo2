import java.util.*;

class SumofArrayElements
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
 
        int m = 0;


        for(int j = 0; j<size; j++)
        {
            m = val[j]+m;
        }
        System.out.println("\tThe Addition of Array elements is : "+m);

        System.out.print(m);
    }
}