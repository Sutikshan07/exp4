import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;
    
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All Employees\n6. Exit");
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addEmployee(); break;
                case 2: updateEmployee(); break;
                case 3: removeEmployee(); break;
                case 4: searchEmployee(); break;
                case 5: displayEmployees(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addEmployee() {
        int id = getIntInput("Enter Employee ID: ");
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        double salary = getDoubleInput("Enter Employee Salary: ");
        employees.add(new Employee(id, name, salary));
    }

    static void updateEmployee() {
        int id = getIntInput("Enter ID to update: ");
        boolean found = false;
        for (Employee e : employees) {
            if (e.id == id) {
                scanner.nextLine();  // Consume newline
                System.out.print("Enter new Name: ");
                e.name = scanner.nextLine();
                e.salary = getDoubleInput("Enter new Salary: ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found!");
        }
    }

    static void removeEmployee() {
        int id = getIntInput("Enter ID to remove: ");
        boolean removed = employees.removeIf(e -> e.id == id);
        if (!removed) {
            System.out.println("Employee not found!");
        }
    }

    static void searchEmployee() {
        int id = getIntInput("Enter ID to search: ");
        boolean found = false;
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println(e);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found!");
        }
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    // Helper method to safely get an integer input from the user
    static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    // Helper method to safely get a double input from the user
    static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid decimal number.");
            scanner.next(); // Consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }
}
