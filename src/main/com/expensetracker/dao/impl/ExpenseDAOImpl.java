package expensetracker.dao.impl;

import expensetracker.config.DBConnection;
import expensetracker.dao.ExpenseDAO;
import expensetracker.model.Expense;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO
{
    @Override
    public void addExpenses(Expense expense){

        String sql = "INSERT INTO expenses(title, amount, category, expenses_Date, expenses_description) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ) {

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4,(Date) expense.getExpenses_Date());
            ps.setString(5, expense.getExpenses_description());

            int rowAffected = ps.executeUpdate();
            System.out.println("Rows affected" + rowAffected);

            //process the result
//            if (rowAffected == 0) {
//                System.out.println("operation failed");
//            } else {
//                System.out.println("operation successfull\n");
//            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpense(){

        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ) {

            while(rs.next()){
                Expense expense = new Expense();

                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setExpenses_Date(rs.getDate("expenses_Date"));
                expense.setExpenses_description(rs.getString("expenses_description"));

                expenses.add(expense);
            }

            return expenses;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return expenses;
    }

}