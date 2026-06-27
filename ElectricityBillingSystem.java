import java.util.Scanner;
public class ElectricityBillingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   ELECTRICITY BILLING SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Meter Number: ");
        String meterNumber = sc.nextLine();

        System.out.print("Enter Previous Reading: ");
        int previousReading = sc.nextInt();

        System.out.print("Enter Current Reading: ");
        int currentReading = sc.nextInt();

        if (currentReading < previousReading) {
            System.out.println("Invalid meter readings!");
            return;
        }

        int unitsConsumed = currentReading - previousReading;
        double billAmount = calculateBill(unitsConsumed);

        System.out.println("\n========== BILL DETAILS ==========");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Meter Number  : " + meterNumber);
        System.out.println("Previous Unit : " + previousReading);
        System.out.println("Current Unit  : " + currentReading);
        System.out.println("Units Used    : " + unitsConsumed);
        System.out.println("Bill Amount   : " + billAmount);
        System.out.println("==================================");

        sc.close();
    }

    public static double calculateBill(int units) {

        double amount;

        if (units <= 100) {
            amount = units * 1.5;
        }
        else if (units <= 200) {
            amount = (100 * 1.5) + ((units - 100) * 2.5);
        }
        else if (units <= 300) {
            amount = (100 * 1.5)
                    + (100 * 2.5)
                    + ((units - 200) * 4.0);
        }
        else {
            amount = (100 * 1.5)
                    + (100 * 2.5)
                    + (100 * 4.0)
                    + ((units - 300) * 6.0);
        }

        double fixedCharge = 100;

        return amount + fixedCharge;
    }
} 