import java.util.*;

public class RotateArray
{
  public static void main(String args[])
  {
    Scanner s1 = new Scanner(System.in);
    int size,rotate;

    System.out.print("\nEnter the Value of Array: ");
    size = s1.nextInt();

    int arr1[] = new int[size];
    int arr2[] = new int[size];

    // This is for Value getting..!

    for(int i = 0; i<size;i++)
    {
      System.out.print("\nEnter the Value of "+(i+1)+" :");
      arr1[i] = s1.nextInt();
      arr2[i] = arr1[i];
    }
    System.out.print("\n\t Given Array is: \n");
    

    for(int i = 0 ; i<arr1.length;i++)
    {
      System.out.print(arr1[i]+ " ");
    }

    System.out.print("\n\n How many times rotate the Array: ");
    rotate = s1.nextInt();


    //Right Side Array..!
    for(int i=0;i<rotate;i++)
    {
      int firstElement = arr1[0];

      //System.out.print("\nThis is "+(i+1)+" element: "+firstElement);
      for(int j = 0 ;j<arr1.length-1;j++)
      {
        arr1[j] = arr1[j+1];
      }
      arr1[arr1.length-1] = firstElement; 
    }


    System.out.println("\nRight Side Rotated Array is here: ");

    for(int i = 0;i<arr1.length;i++)
    {
      System.out.print(arr1[i] + "   ");
    }
    
    //Left Side Array..!

    for(int i=0;i<rotate;i++)
    {
      int lastElement = arr2[arr2.length-1];

      //System.out.print("\nThis is "+(i+1)+" element: "+lastElement);
      for(int j = arr2.length-1 ;j>0;j--)
      {
        arr2[j] = arr2[j-1];
      }
      arr2[0] = lastElement; 
    }
    
    System.out.println("\nLeft Side Rotated Array is here: ");
    for(int i = 0;i<arr2.length;i++)
    {
      System.out.print(arr2[i] + "   ");
    }
  }
}