package expensetracker.menu;

import expensetracker.model.Expense;
import expensetracker.service.ExpenseService;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu
{
    private void printMenu() {
        System.out.println();
        System.out.println("============ Expense Tracker ============");
        System.out.println();
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expense By Id");
        System.out.println("4. Update Expense");
        System.out.println("5. Delete Expense");
        System.out.println("6. Exit");
        System.out.println("Choose the option :");
    }

    private ExpenseService service = new ExpenseService();     //now all methods can use it

    public void showMenu(){

        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    addExpense(sc);
                    break;
                case 2:
                    viewExpenses();
                    break;

                case 3:
                    viewExpensesByID(sc);
                    break;

                case 4:
                    updateExpense();
                    break;

                case 5:
                    deleteExpense();
                    break;

                case 6:
                    System.out.println("Thank you for using Expense Tracker!");
                    return;
            }
        }
    }


    private void addExpense(Scanner sc){
        try {
            System.out.println("the details Added to the expenses :");
            System.out.println("title of the expenses :");
            String title = sc.nextLine();

            System.out.println("amount of the expenses :");
            Double amount = sc.nextDouble();
            sc.nextLine();

            System.out.println("category :");
            String category = sc.nextLine();

            System.out.println("Date (yyyy-mm-dd) :");
            String dateInput = sc.next();
            sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = format.parse(dateInput);
            java.sql.Date expenseDate = new java.sql.Date(parseDate.getTime());

            System.out.println("description :");
            String description = sc.nextLine();

            //expense object
            Expense expense = new Expense();

            // Assigning the collected variables into the object
            expense.setTitle(title);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setExpenses_Date(expenseDate);
            expense.setExpenses_description(description);

            service.addExpenses(expense);
            System.out.println("Expenses added succesfully");
        }
        catch (ParseException e){
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private void viewExpenses(){

        List<Expense> expenses = service.getAllExpenses();
        if(expenses.isEmpty()){
            System.out.println(" === No Record Found === ");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }

    }

    private void viewExpensesByID(Scanner sc){

        System.out.println("Enter Expense ID : ");
        int id = sc.nextInt();

        Expense expensess = service.getExpenseById(id);

        if (expensess == null) {
            System.out.println("Expense not found.");
        } else {
            System.out.println(expensess);
        }
    }

    private void deleteExpense(){

    }

    private void updateExpense(){

    }
}
