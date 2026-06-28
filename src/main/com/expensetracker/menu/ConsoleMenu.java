package expensetracker.menu;

import expensetracker.model.Expense;
import expensetracker.service.ExpenseService;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConsoleMenu
{
    public void test(){

        try {
            System.out.println("the details of the expenses :");
            Scanner sc = new Scanner(System.in);

            System.out.println("title of the expenses :");
            String title = sc.next();

            System.out.println("amount of the expenses :");
            Double amount = sc.nextDouble();

            System.out.println("category :");
            String category = sc.next();

            System.out.println("Date (yyyy-mm-dd) :");
            String dateInput = sc.next();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parseDate = format.parse(dateInput);
            java.sql.Date expenses_date = new java.sql.Date(parseDate.getTime());

            System.out.println("description :");
            String expenses_description = sc.next();

            //expense object
            Expense expense = new Expense();

            // Assigning the collected variables into the object
            expense.setTitle(title);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setExpenses_date(expenses_date);
            expense.setExpenses_description(expenses_description);

            ExpenseService service = new ExpenseService();
            service.addExpenses(expense);
        }
        catch (ParseException e){
            e.printStackTrace();
        }

    }
}
