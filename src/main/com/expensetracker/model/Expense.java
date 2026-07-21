package expensetracker.model;

import java.util.Date;

public class Expense
{
    private int id;
    private String title;
    private Double amount;
    private String category;
    private Date expenseDate;
    private String description;

    public Integer getId(){ return id; }

    public void setId(Integer id){ this.id = id; }

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

    public Date getExpenses_Date() {
        return expenseDate;
    }

    public void setExpenses_Date(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenses_description() {
        return description;
    }

    public void setExpenses_description(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "--------------------------------------\n" +
                "ID                : " + id + "\n" +
                "Title             : " + title + "\n" +
                "Amount            : " + amount + "\n" +
                "Category          : " + category + "\n" +
                "Date              : " + expenseDate + "\n" +
                "Description       : " + description + "\n" +
                "--------------------------------------";
    }
}
