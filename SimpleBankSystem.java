import java.util.Scanner;  

class BankAccount {  
    private String accountHolder;  
    private double balance;  

    BankAccount(String accountHolder) {  
        this.accountHolder = accountHolder;  
        this.balance = 0.0;  
    }  

    public void deposit(double amount) {  
        if (amount > 0) {  
            balance += amount;  
            System.out.println("Depósito exitoso! Nuevo saldo: " + balance);  
        } else {  
            System.out.println("El monto debe ser positivo.");  
        }  
    }  

    public void withdraw(double amount) {  
        if (amount > 0 && amount <= balance) {  
            balance -= amount;  
            System.out.println("Retiro exitoso! Nuevo saldo: " + balance);  
        } else {  
            System.out.println("Retiro fallido. Verifica el monto.");  
        }  
    }  

    public double getBalance() {  
        return balance;  
    }  

    public String getAccountHolder() {  
        return accountHolder;  
    }  
}  

public class SimpleBankSystem {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Nombre del titular de la cuenta: ");  
        String name = scanner.nextLine();  
        BankAccount account = new BankAccount(name);  

        int option;  
        do {  
            System.out.println("\n--- Sistema Bancario ---");  
            System.out.println("1. Depositar");  
            System.out.println("2. Retirar");  
            System.out.println("3. Consultar saldo");  
            System.out.println("0. Salir");  
            System.out.print("Elige una opción: ");  
            option = scanner.nextInt();  

            switch (option) {  
                case 1:  
                    System.out.print("Monto a depositar: ");  
                    double depositAmount = scanner.nextDouble();  
                    account.deposit(depositAmount);  
                    break;  
                case 2:  
                    System.out.print("Monto a retirar: ");  
                    double withdrawAmount = scanner.nextDouble();  
                    account.withdraw(withdrawAmount);  
                    break;  
                case 3:  
                    System.out.println("Saldo actual: " + account.getBalance());  
                    break;  
                case 0:  
                    System.out.println("Saliendo...");  
                    break;  
                default:  
                    System.out.println("Opción inválida.");  
            }  
        } while (option != 0);  
    }  
}