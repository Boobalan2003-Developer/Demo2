import java.util.*;

class Swap
{
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        int a, b;

        System.out.println("Swapping Two values..!");
        System.out.println("______________________");
        System.out.println("Enter 1st Value: ");
        a = s1.nextInt();
        
        System.out.println("Enter 2nd Value: ");
        b = s1.nextInt();

        System.out.println("Before Swapping 1st Value: "+a);
        System.out.println("Before Swapping 2nd Value: "+b);

        b = a+b;
        a = b-a;
        b = b-a;


        System.out.println("________Swapping________\n");
        System.out.println("After Swapping 1st Value: "+a);
        System.out.println("After Swapping 2nd Value: "+b);

    }
}