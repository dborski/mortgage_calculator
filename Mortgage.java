import java.util.Scanner;
import java.lang.Math;
import java.text.NumberFormat;

public class Mortgage {

  public static void main(String[] args) {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Principal: ");
    int principal = scanner.nextInt();
    
    System.out.println("Annual Interest Rate: ");
    float annualInterest = scanner.nextFloat();
    float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

    System.out.println("Period (Years): ");
    byte totalYears = scanner.nextByte();
    int numberOfPayments = totalYears * MONTHS_IN_YEAR;

    double calculation = calculateMortgage(principal, monthlyInterest, numberOfPayments);

    String formattedNumber = NumberFormat.getCurrencyInstance().format(calculation);
    System.out.println("Mortgage Payment: " + formattedNumber);
  }

  static double calculateMortgage(int principal, float monthlyInterest, int numberOfPayments) {
    return principal * ((monthlyInterest * (Math.pow((1 + monthlyInterest), numberOfPayments))) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));
  }
}
