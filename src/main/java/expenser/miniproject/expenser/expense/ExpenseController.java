package expenser.miniproject.expenser.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    //  request mapping to add an expense
    @RequestMapping(method = RequestMethod.POST, value = "/expense/add")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    //  request mapping to get all the expenses
    @RequestMapping("/expense/{username}")
    public List<Expense> getAllExpenses(@PathVariable String username)
    {
        return expenseService.getExpense(username);
    }

    //  request mapping for getting the weekly expenses of the user
    @RequestMapping("expense/week/{username}")
    public List<Expense> getWeeklyExpenses(@PathVariable String username) {
        Date currentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);

        Date dateSevenDaysAgo = cal.getTime();
        System.out.println(dateSevenDaysAgo+" " + currentDate);
        return expenseService.getWeeklyExpense(username, dateSevenDaysAgo, currentDate);
    }

    //  request mapping to delete an expense
    @RequestMapping(method = RequestMethod.DELETE, value = "expense/delete/{id}")
    public void deleteExpense(@PathVariable int id)
    {
        expenseService.deleteExpense(id);
    }
}
