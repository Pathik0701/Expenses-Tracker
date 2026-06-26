package expensetracker.service;

import expensetracker.dao.ExpenseDAO;
import expensetracker.dao.impl.ExpenseDAOImpl;
import expensetracker.model.Expense;

public class ExpenseService
{
    private ExpenseDAO dao = new ExpenseDAOImpl();

        public void addExpenses(Expense expense) {
            if(expense.getAmount() <= 0 ){
                throw new IllegalArgumentException("Amount must be greater than zero");
            }
            dao.addExpenses(expense);
        }

}
