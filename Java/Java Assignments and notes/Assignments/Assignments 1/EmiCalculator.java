import java.util.*;
 

class EmiCalculator
{
 double EmiCalculation(double loan, int period, float interest)
  {  
    // Variable Declaration..
    
    double emi;
    
    // EMI Calculations

    double monthAmnt = loan/period;
    double rateOfInterest = (loan*interest)/100;
    emi = monthAmnt + rateOfInterest;  

    return emi;
  }

 public static void main(String args[])
 {

   // Variable Declarations..

   double loan,emi,total;
   int period;
   float interest;
   

   //Create a obj for Scanner Class
   
   Scanner sa = new Scanner(System.in);
   
   // Get the Inout Values..

   System.out.println("\n\t EMI Calculator");

   System.out.println("\nEnter The loan Amount: ");
   loan = sa.nextInt();

   System.out.println("\nEnter The Period of months: ");
   period = sa.nextInt();

   System.out.println("\nEnter The Rate of Interest (in percentage): ");
   interest = sa.nextFloat();

   // Create a obj for our class..

   EmiCalculator ec = new EmiCalculator();
   emi = ec.EmiCalculation(loan, period, interest);


   // find total Amount..

   total = emi*period;

   // Print the Values..

   System.out.println("\nThe Monthly Loan Amount is: "+emi);
   System.out.println("\nTotal Amount at the end: "+total+"\n");

   
 }
}