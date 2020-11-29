package expenser.miniproject.expenser.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    //  method to add expense into the database for the given user
    public Expense addExpense(Expense expense)
    {
        expenseRepository.save(expense);
        return expense;
    }

    //  method to get all the expenses of the user from the database
    public List<Expense> getExpense(String username) {
        List expenses = new ArrayList<Expense>();
        expenseRepository.getExpensesByUsernameOrderByIdDesc(username)
                .forEach(expenses::add);
        return expenses;
    }

    //  method to get all the weekly expenses
    public List<Expense> getWeeklyExpense(String username, Date first_date, Date second)
    {
        List expenses = new ArrayList<Expense>();
        expenseRepository.findAllByUsernameAndPublicationDateBetween(username, first_date, second)
                .forEach(expenses::add);
        return expenses;
    }

    //  method to delete an expense
    public void deleteExpense(int id)
    {
        expenseRepository.deleteById(id);
    }
}
