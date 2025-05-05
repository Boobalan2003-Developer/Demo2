import java.util.*;

class Circle
{ 
  void areaOfCircle(float diameter)
  { 
    
    double pi = 3.14159265358,area;
    area = pi*diameter*diameter;
    System.out.println("\tThe Area of Circle is: "+area +"\n");

  }

  public static void main(String args[])
  {
    float diameter;
    Scanner sa = new Scanner(System.in);
    System.out.println("\n\tArea of Circle");  
    System.out.println("\n\tEnter the Diameter: ");
    diameter = sa.nextFloat();
    Circle c1 = new Circle();
    c1.areaOfCircle(diameter);
  }

}