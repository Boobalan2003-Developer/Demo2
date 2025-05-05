import java.util.*;

class getNegativeValues
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int n,num[],sum=0,i;

        System.out.println("Enter the terms of numebrs adding:");
        n = s1.nextInt();

        //Creating Array size...
        int[] arr = new int[n];

        for(i=1;i<=n;i++)
        {
            System.out.println("Enter the Number: "+i);
            arr[i-1] = s1.nextInt();

            if(arr[i-1]>=0)
            {
                sum = sum+arr[i-1];
            }

            else
            {
                System.out.println("\nInvalid Number. Please enter the Positive or Valid Number to find Sum..!");
                i--;
            }
        }

        System.out.println("\tThe Addtion of Given Numebrs: "+sum);
    }
}