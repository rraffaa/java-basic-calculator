import java.util.Scanner;

public class SimpleCalculator {
    // Attribute to store the history of operations
    private StringBuilder history = new StringBuilder();

    // Method to add two numbers
    public double add(double num1, double num2) {
        double result = num1 + num2;
        history.append("Addition: ").append(num1).append(" + ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Method to subtract two numbers
    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        history.append("Subtraction: ").append(num1).append(" - ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Method to multiply two numbers
    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        history.append("Multiplication: ").append(num1).append(" * ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Method to divide two numbers
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error! Division by zero.");
            history.append("Attempted Division by Zero\n");
            return Double.NaN; // Return 'NaN' to indicate an error
        }
        double result = num1 / num2;
        history.append("Division: ").append(num1).append(" / ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Method to calculate the modulo of two numbers
    public double modulo(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error! Division by zero.");
            history.append("Attempted Modulo by Zero\n");
            return Double.NaN; // Return 'NaN' to indicate an error
        }
        double result = num1 % num2;
        history.append("Modulo: ").append(num1).append(" % ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Method to display the history of operations
    public void showHistory() {
        if (history.length() > 0) {
            System.out.println("\nOperation History:");
            System.out.println(history.toString());
        } else {
            System.out.println("No operations performed yet.");
        }
    }

    // Method to reset the history
    public void resetHistory() {
        history.setLength(0);
        System.out.println("History has been reset.");
    }

    // Method to get a valid input (decimal number)
    public double getValidInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the input buffer
            }
        }
    }

    // Method to display the menu and validate the operation choice
    public int getValidOperationChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 8) { // Now checking for choice 1-8
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulo");
            System.out.println("6. Show History");
            System.out.println("7. Reset History");
            System.out.println("8. Exit");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please choose a valid option.");
                scanner.next(); // Clear the input buffer
            }
        }
        return choice;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleCalculator calculator = new SimpleCalculator();

        while (true) {
            // Display the menu and get the user's choice
            int choice = calculator.getValidOperationChoice(scanner);

            if (choice == 8) {
                System.out.println("Exiting program...");
                break; // Exit the loop and terminate the program
            }

            // Ask for the numbers to perform the operation
            System.out.println("Enter the first number: ");
            double num1 = calculator.getValidInput(scanner);

            System.out.println("Enter the second number: ");
            double num2 = calculator.getValidInput(scanner);

            // Perform the selected operation and display the result
            double result = 0;
            switch (choice) {
                case 1:
                    result = calculator.add(num1, num2);
                    break;
                case 2:
                    result = calculator.subtract(num1, num2);
                    break;
                case 3:
                    result = calculator.multiply(num1, num2);
                    break;
                case 4:
                    result = calculator.divide(num1, num2);
                    break;
                case 5:
                    result = calculator.modulo(num1, num2);
                    break;
                case 6:
                    calculator.showHistory();
                    continue;
                case 7:
                    calculator.resetHistory();
                    continue;
            }

            // Display the result of the operation
            if (!Double.isNaN(result)) {
                System.out.println("Result: " + result);
            }
        }

        
        scanner.close();
    }
}
