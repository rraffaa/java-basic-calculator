import java.util.Scanner;

public class SimpleCalculator {
    // Atributo para armazenar o histórico de operações
    private StringBuilder history = new StringBuilder();

    // Método para adicionar dois números
    public double add(double num1, double num2) {
        double result = num1 + num2;
        history.append("Addition: ").append(num1).append(" + ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Método para subtrair dois números
    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        history.append("Subtraction: ").append(num1).append(" - ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Método para multiplicar dois números
    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        history.append("Multiplication: ").append(num1).append(" * ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Método para dividir dois números
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error! Division by zero.");
            history.append("Attempted Division by Zero\n");
            return Double.NaN; // Retorna 'NaN' para indicar erro
        }
        double result = num1 / num2;
        history.append("Division: ").append(num1).append(" / ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Método para calcular o módulo de dois números
    public double modulo(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error! Division by zero.");
            history.append("Attempted Modulo by Zero\n");
            return Double.NaN; // Retorna 'NaN' para indicar erro
        }
        double result = num1 % num2;
        history.append("Modulo: ").append(num1).append(" % ").append(num2).append(" = ").append(result).append("\n");
        return result;
    }

    // Método para exibir o histórico de operações
    public void showHistory() {
        if (history.length() > 0) {
            System.out.println("\nOperation History:");
            System.out.println(history.toString());
        } else {
            System.out.println("No operations performed yet.");
        }
    }

    // Método para resetar o histórico
    public void resetHistory() {
        history.setLength(0);
        System.out.println("History has been reset.");
    }

    // Método para obter uma entrada válida (número decimal)
    public double getValidInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Limpar o buffer de entrada
            }
        }
    }

    // Método para exibir o menu e validar a escolha de operação
    public int getValidOperationChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 5) {
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
                scanner.next(); // Limpar o buffer de entrada
            }
        }
        return choice;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleCalculator calculator = new SimpleCalculator();

        while (true) {
            // Exibir o menu e obter a escolha do usuário
            int choice = calculator.getValidOperationChoice(scanner);

            if (choice == 8) {
                System.out.println("Exiting program...");
                break; // Sai do loop e encerra o programa
            }

            // Solicitar os números para a operação
            System.out.println("Enter the first number: ");
            double num1 = calculator.getValidInput(scanner);

            System.out.println("Enter the second number: ");
            double num2 = calculator.getValidInput(scanner);

            // Realizar a operação escolhida e exibir o resultado
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

            // Exibir o resultado da operação
            if (!Double.isNaN(result)) {
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
    }
}
