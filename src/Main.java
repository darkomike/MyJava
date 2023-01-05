import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double grossPay, hours, getFundTax, netPay =0, totalNetPay =0 , avgNetPay= 0, totalDeduction =0;
        int numChild, numEmployees;

        System.out.print("Enter the number of employees: ");
        numEmployees = sc.nextInt();


      for (int i = 1; i <= numEmployees ; i++){
          // For individual
          System.out.println("Employee number " + i+ ".");
          System.out.print("Enter the number of hours worked: ");
          hours = sc.nextDouble();
          grossPay = grossPayFunc(hours);

//       Taxes
          System.out.print("Enter the number of children: ");
          numChild = sc.nextInt();

          getFundTax = getFundFunc(numChild);
          totalDeduction = totalDeduction +  totalDeductionFunc(grossPay,numChild);
          netPay = grossPay - totalDeductionFunc(grossPay,numChild);
          totalNetPay = totalNetPay +  netPay;

          System.out.println("Gross pay: " + grossPay);
          System.out.println("Income Tax: " + (grossPay * 0.15));
          System.out.println("NHIL Tax: " + (grossPay * 0.01));
          System.out.println("DistrictTax: " + (grossPay * 0.03));
          System.out.println("Get Fund Tax: " + getFundTax);
          System.out.println("Net pay: " + netPay);

          System.out.println();





      }
        avgNetPay = totalNetPay / numEmployees;
        System.out.println();
        System.out.println("Total Net pay: " + totalNetPay);
        System.out.println("Average net pay: " + avgNetPay);
        System.out.println("Total Deduction: " + totalDeduction);



    }


    static double grossPayFunc(double hours){
        double grossPay = 0;
        if (hours>40){
            grossPay = 40 * 50 + (hours - 40) * 75;
        }
        else {
            grossPay = hours * 50;
        }
            return  grossPay;
    }

    static double  getFundFunc(int numChild){
        double getFund = 0;
        if (numChild > 3) {
            getFund = (numChild - 3) * 1;
        }
        else {
            getFund = 0;
        }
        return  getFund;
    }

   static  double totalDeductionFunc(double grossPay, int numChild){
        double totalDeduction = 0;
        double incomeTax = grossPay * 0.15;
        double NHILTax = grossPay * 0.01;
        double districtTax = grossPay * 0.03;
        double getFundTax = getFundFunc(numChild);

        totalDeduction = incomeTax + NHILTax + districtTax + getFundTax;

        return totalDeduction;
    }

   static double netPayFunc(double hours, double grossPay, int numChild){
        double netPay =  grossPayFunc(hours) - totalDeductionFunc(grossPay,numChild );
        return  netPay;

    }

   static double totalNetPayFunc(int numEmp){
        double totalNetPay = 0;

        Scanner sc = new Scanner(System.in);

        for (int i=0; i <= numEmp;i++ ){

            System.out.print("Enter net pay: ");
            totalNetPay = totalNetPay + sc.nextDouble();


        }

        return  totalNetPay;
    }




}