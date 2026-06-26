package expensetracker.model;

import java.util.Date;

public class Expense
{
    private String title;
    private Double amount;
    private String category;
    private Date expenses_date;
    private String expenses_description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getExpenses_date() {
        return expenses_date;
    }

    public void setExpenses_date(Date expenses_date) {
        this.expenses_date = expenses_date;
    }

    public String getExpenses_description() {
        return expenses_description;
    }

    public void setExpenses_description(String expenses_description) {
        this.expenses_description = expenses_description;
    }

}
