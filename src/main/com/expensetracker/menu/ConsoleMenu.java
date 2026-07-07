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
        System.out.println("============ Expense Tracker ============ \n");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. Update Expense");
        System.out.println("4. Delete Expense");
        System.out.println("5. Exit");
        System.out.println("Choose the option :");
    }

    private ExpenseService service = new ExpenseService();     //now all methods can use it

    public void showMenu(){

        try {
            Scanner sc = new Scanner(System.in);

            while (true) {

                printMenu();
                int num = sc.nextInt();
                sc.nextLine();

                switch (num) {
                    case 1:
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
                        break;

                    case 2:
                        List<Expense> expenses = service.getAllExpenses();
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.println("coming soon");
                        break;

                    case 4:
                        System.out.println("coming soon!");
                        break;

                    case 5:
                        System.out.println("Thank you for using Expense Tracker!");
                        return;
                }
            }
        }
        catch (ParseException e){
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }

    }
}
