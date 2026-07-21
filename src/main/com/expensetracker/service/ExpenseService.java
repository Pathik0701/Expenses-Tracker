package expensetracker.service;

import expensetracker.dao.ExpenseDAO;
import expensetracker.dao.impl.ExpenseDAOImpl;
import expensetracker.model.Expense;

import java.util.*;

public class ExpenseService
{
    private ExpenseDAO dao = new ExpenseDAOImpl();

        public void addExpenses(Expense expense) {
            if(expense.getAmount() <= 0 ){
                throw new IllegalArgumentException("Amount must be greater than zero");
            }
            dao.addExpenses(expense);
        }

    public List<Expense> getAllExpenses(){
            return dao.getAllExpense();
    }

    public Expense getExpenseById(int id){
           return dao.getExpenseById(id);
    }
}


