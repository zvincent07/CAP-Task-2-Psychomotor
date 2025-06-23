// Members:
// Dimaandal, Glenn Roy
// Laylo, John Vincent
// Perce, John Adrian

class Student {
    private String name;
    private int grade1;
    private int grade2;
    private int grade3;

    public Student(String name, int grade1, int grade2, int grade3) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public double calculateAverage() {
        return (grade1 + grade2 + grade3) / 3.0;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.printf("Average Grade: %.2f%n", calculateAverage());
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating and testing entities.Student class
        Student student = new Student("Zymon", 85, 89, 89);
        student.displayInfo();
        
        System.out.println();
        
        // Creating and testing BankAccount class
        BankAccount account = new BankAccount("123456789", "Mark Bunyi", 1500.0);
        account.displayAccountInfo();
    }
}