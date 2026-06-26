package expensetracker.dao.impl;

import expensetracker.config.DBConnection;
import expensetracker.dao.ExpenseDAO;
import expensetracker.model.Expense;

import java.sql.*;
import java.sql.Date;

public class ExpenseDAOImpl implements ExpenseDAO
{
    @Override
    public void addExpenses(Expense expense){
        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO expenses(title, amount, category, expenses_date, expenses_description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4,(Date) expense.getExpenses_date());
            ps.setString(5, expense.getExpenses_description());

            int rowAffected = ps.executeUpdate();
            System.out.println("Rows affected" + rowAffected);

            //process the result
            if (rowAffected == 0) {
                System.out.println("operation failed");
            } else {
                System.out.println("operation successfull");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
















//        try {
//
//            Connection con = DBConnection.getConnection();
//
//            String sql = "INSERT INTO expenses(id , title, amount, category, expenses_date, expenses_description) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            System.out.println("the detailes of the expenses :");
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("title of the expenses :");
//            String title = sc.next();
//
//            System.out.println("amount of the expenses :");
//            Integer amount = sc.nextInt();
//
//            System.out.println("category :");
//            String category = sc.next();
//
//            System.out.println("Date (yyyy-mm-dd) :");
//            String dateInput = sc.next();
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//            Date expenses_date = (Date) format.parse(dateInput);
//
//            System.out.println("description :");
//            String expenses_description = sc.next();
//
//            ps.setString(2,title);
//            ps.setInt(3,amount);
//            ps.setString(4,category);
//            ps.setDate(5, expenses_date);
//            ps.setString(6,expenses_description);
//
//            int rowAffected = ps.executeUpdate();
//
//            //process the result
//            if (rowAffected == 0) {
//                System.out.println("operation failed");
//            } else {
//                System.out.println("operation successfull");
//            }
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Inavild date format");
//        }
//