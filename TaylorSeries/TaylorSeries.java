import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;
public class TaylorSeries {  
    public static void main (String[] args){
        Scanner keyboard = new Scanner (System.in);
      
        String answer;
        do {
       p(" ");
       p("Taylor's Polynomial Calculator of the function f(x)=e^cos(x)");
       
       //User inputs
       p("Enter the number of Degree 2, 4, or 6 only:"); 
       int degree = getNum();
       if(degree != 2 && degree != 4 && degree != 6)
       {
           System.err.println("INVALID INPUT");
           System.exit(0);
       }
       else{}
       p("Enter the value of x:");  
       int x = getNum();
       p("Enter the center value:"); 
       int a = getNum();
       p("Enter number of Decimal place: "); 
       int y = getNum();
       
       //For Rounding
       String dec;
       dec = "%." + y + "f";
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(y);
       DecimalFormat commaformat;
       commaformat = new DecimalFormat("#.###");
       
       //formulas
       double eval=2.718281828;
       double newx=x-a;
       double term1=newx*0/getFact(1);
       double term2=Math.pow(newx,2)*eval/getFact(2);
       double term3=Math.pow(newx,3)*0/getFact(3);
       double term4=Math.pow(newx,4)*4*eval/getFact(4);
       double term5=Math.pow(newx,5)*0/getFact(5);
       double term6=Math.pow(newx,6)*31*eval/getFact(6);
        
       switch(degree)
       {
           case 0:
           {
              double result=eval;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 1:
           {
               double result=eval+term1;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 2:
           {
                double result=eval+term1-term2;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 3:
           {
                double result=eval+term1-term2+term3;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 4:
           {
                double result=eval+term1-term2+term3+term4;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 5:
           {
               double result=eval+term1-term2+term3+term4+term5;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
           case 6:
           {
                double result=eval+term1-term2+term3+term4+term5-term6;
               System.out.println("True Value: " + result);
               System.out.format("Rounded Value: " + dec + "\n", result);   
               chopping(result,y);
               break;
           }
       }
       System.out.println("Do you want to continue? Yes or No");
       answer = keyboard.nextLine();
      }
        while (answer.equalsIgnoreCase("Yes"));
    }
    //Factorial
    static int getFact(int degree)
    {
        int fact=1;
        for(int i=1;i<=degree;i++)
        {
            fact=fact*i;
        }
        return fact;
    }
    //Println
    static void p(String str)
    {
        System.out.println(str);
    }
    //Get Number
    static int getNum()
    {
        Scanner sc = new Scanner (System.in);
        int num = sc.nextInt();
        return num;
    }
    //For Chopping
    static void chopping(double firstvalue, int decimalpoint)
    {
        String temp_value = "" + firstvalue;
        String string_value = "";
  
        int counter = -1;
  
        for (int i = 0; i < temp_value.length(); ++i) {
  
            // checking the condition
            if (counter > decimalpoint) {
                break;
            }
            else
  
                if (temp_value.charAt(i) == '.') {
                counter = 1;
            }
            else if (counter >= 1) {
  
                ++counter;
            }
  
            // converting the number into string
            string_value += temp_value.charAt(i);
        }
  
        // parse the string
        double new_value = Double.parseDouble(string_value);
  
        System.out.println("Chopping Value: "+new_value);
    }
    
}

