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
        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO expenses(title, amount, category, expenses_Date, expenses_description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, expense.getTitle());
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getCategory());
            ps.setDate(4,(Date) expense.getExpenses_Date());
            ps.setString(5, expense.getExpenses_description());

            int rowAffected = ps.executeUpdate();
            System.out.println("Rows affected" + rowAffected);

            //process the result
            if (rowAffected == 0) {
                System.out.println("operation failed");
            } else {
                System.out.println("operation successfull\n");
            }

            con.close();
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Expense> getAllExpense(){
        try {

            Connection con = DBConnection.getConnection();

            String sql1 = "SELECT * FROM expenses";
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();

            List<Expense> expenses = new ArrayList<>();

            while(rs.next()){
                Expense expense = new Expense();
                String title = rs.getString("title");
                Double amt = rs.getDouble("amount");
                String category = rs.getString("category");
                Date date = rs.getDate("expenses_Date");
                String description = rs.getString("expenses_description");

                expense.setTitle(title);
                expense.setAmount(amt);
                expense.setCategory(category);
                expense.setExpenses_Date(date);
                expense.setExpenses_description(description);

                expenses.add(expense);
            }

            con.close();
            ps.close();
            rs.close();

            return expenses;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}