package expensetracker.config;

import java.sql.*;

public class DBConnection
{
    private static final String url = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String user = "root";
    private static final String password = "pathik@0701";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
























//    public static void main(String[] args) {
//
//        Statement s = null;
//        Connection c = null;
//        try{
//
//            //load and register the driver
//           Class.forName("com.mysql.cj.jdbc.Driver");
//
//           //establish the connection
//           String url = "jdbc:mysql://localhost:3306/expense_tracker";
//           String user = "root";
//           String password = "pathik@0701";
//           c = DriverManager.getConnection(url, user, password);
//
//           //creating statement
//           s = c.createStatement();
//
//           //execute query
//           String sql = "INSERT INTO expenses(id , title, amount, category, expenses_date, expenses_description) VALUES (1, 'shopping', 2000, 'clothes', '2026-06-25', 'wedding shopping')";
//           int rowAffected = s.executeUpdate(sql);
//
//
//           //process the result
//           if(rowAffected == 0){
//               System.out.println("operation failed");
//           }
//           else {
//               System.out.println("operation successfull");
//           }
//        }
//        catch (ClassNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        finally {
//            try{
//                //close the connection
//                s.close();
//                c.close();
//            }
//            catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }

