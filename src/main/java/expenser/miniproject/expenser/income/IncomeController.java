package expenser.miniproject.expenser.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @RequestMapping("/")
    public String getHome() {
        return "hello world!";
    }

    //  api to add income by a user
    @RequestMapping(method = RequestMethod.POST, value="/income/add")
    public Income addIncome(@RequestBody Income income) {
        return incomeService.addIncome(income);
    }

    //  api to get all the incomes of the current user
    @RequestMapping("/income/{username}")
    public List<Income> getIncomeByUsername(@PathVariable String username) {
        return incomeService.getIncomeByUsername(username);
    }

    //  api to get the last seven days income of the current user
    @RequestMapping("/income/week/{username}")
    public List<Income> getLastSevenDaysIncome(@PathVariable String username) {
        Date currentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);

        Date dateSevenDaysAgo = cal.getTime();
        System.out.println(dateSevenDaysAgo+" " + currentDate);
        return incomeService.getIncomeOfWeek(username, dateSevenDaysAgo, currentDate);
    }

    //  api to get the start and end date
    @RequestMapping("/startend")
    public List<Date> getStartEndDate() {
        Date currentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);

        Date dateSevenDaysAgo = cal.getTime();
        return Arrays.asList(
                dateSevenDaysAgo,
                currentDate
        );
    }

    //  method to delete income
    @RequestMapping(method = RequestMethod.DELETE, value = "income/delete/{id}")
    public void deleteExpense(@PathVariable int id)
    {
        incomeService.deleteIncomeById(id);
    }

}
