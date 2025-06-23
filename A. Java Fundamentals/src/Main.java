// Members:
// Dimaandal, Glenn Roy
// Laylo, John Vincent
// Perce, John Adrian

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Sum of two numbers
        System.out.println("1. Sum of two numbers:");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.println("Sum is: " + (num1 + num2));
        System.out.println();
        
        // 2. Check if number is even or odd
        System.out.println("2. Check even or odd:");
        System.out.print("Enter a number: ");
        int checkNum = scanner.nextInt();
        if (checkNum % 2 == 0) {
            System.out.println(checkNum + " is even.");
        } else {
            System.out.println(checkNum + " is odd.");
        }
        System.out.println();
        
        // 3. Print numbers from 1 to 10
        System.out.println("3. Numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        
        // 4. Find largest among three numbers
        System.out.println("4. Find largest number:");
        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();
        System.out.print("Enter third number: ");
        int third = scanner.nextInt();
        
        int largest = first;
        if (second > largest) {
            largest = second;
        }
        if (third > largest) {
            largest = third;
        }
        System.out.println("The largest number is: " + largest);
        
        scanner.close();
    }
}