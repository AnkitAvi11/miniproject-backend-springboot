package expenser.miniproject.expenser.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    //  method to add new income into the database
    public Income addIncome(Income income) {
        incomeRepository.save(income);
        return income;
    }

    //  method to get all the incomes by the username
    public List<Income> getIncomeByUsername(String username) {
        List incomes = new ArrayList<Income>();
        incomeRepository.getIncomesByUsernameOrderByIdDesc(username)
                .forEach(incomes::add);
        return incomes;
    }

    //  method to get the start and end date
    public List<Income> getIncomeOfWeek(String username, Date first_date, Date second) {
        List incomes = new ArrayList<Income>();
        incomeRepository.findAllByUsernameAndPublicationDateBetween(username, first_date, second)
                .forEach(incomes::add);
        return incomes;
    }

    //  method to update an income
    public Income updateIncome(Income income) {
        incomeRepository.save(income);
        return income;
    }

    //  service method to delete an income with its primary key
    public void deleteIncomeById(int id) {
        incomeRepository.deleteById(id);
    }

}
