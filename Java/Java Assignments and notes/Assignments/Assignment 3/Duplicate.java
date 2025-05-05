import java.util.*;


class Duplicate 
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    int size;

    System.out.println("Enter the Array Size: ");
    size = s.nextInt();

    int[] arr1 = new int[size];
    
    for(int i = 0;i<arr1.length;i++)
    {
      System.out.print("\nEnter the Value of "+(i+1)+" st Element of Array: ");
      arr1[i] = s.nextInt();
    }

    int k=0;

    for(int j = 0;j<arr1.length;j++)
    {
      if(arr1[j]!=-1)
      {
        for(int a=j+1;a<arr1.length;a++)
        {
          if(arr1[j]==arr1[a])
          {
            arr1[j] = k;
          }
        }
        
      }
      if(arr1[j]>0)
        System.out.print(arr1[j]+"   ");
    }

   
  }  
}
