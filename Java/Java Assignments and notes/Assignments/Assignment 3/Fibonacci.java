import java.util.*;

class Fibonacci
{
    public static void main(String args[])
    {
        int a=0,b=1,fib=0,n;
        Scanner s = new Scanner(System.in);

        System.out.println("\tFibonacci Serise..!");
        System.out.println("Enter the Terms of Fib: ");
        n = s.nextInt();

        System.out.println("\t"+a);
        System.out.println("\t"+b);

        for(int i = 2;i<n;i++)
        {
            fib = a+b;
            System.out.println("\t"+fib);
            a=b;
            b=fib;
        }
    }
}