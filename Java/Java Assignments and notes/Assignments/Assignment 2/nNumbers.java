import java.util.*;

class nNumbers
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int n,num[],sum=0;

        System.out.println("Enter the terms of numebrs adding:");
        n = s1.nextInt();

        //Creating Array size...
        int[] arr = new int[n];

        for(int i=1;i<=n;i++)
        {
            System.out.println("Enter the Number: "+i);
            arr[i-1] = s1.nextInt();
           
            if(arr[i-1]>0)
            {
                sum = sum+arr[i-1];
            }
        }

        System.out.println("\tThe Addtion of Given Numebrs: "+sum);
    }
}