package expensetracker.dao;

import expensetracker.model.Expense;

import java.util.List;

public interface ExpenseDAO
{
    void addExpenses(Expense expense);

    List<Expense> getAllExpense();

    Expense getExpenseById(int id);

}
