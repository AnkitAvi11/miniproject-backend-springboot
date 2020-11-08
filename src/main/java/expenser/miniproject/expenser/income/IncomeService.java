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

    public Income addIncome(Income income) {
        incomeRepository.save(income);
        return income;
    }

    public List<Income> getIncomeByUsername(String username) {
        List incomes = new ArrayList<Income>();
        incomeRepository.getIncomesByUsernameOrderByIdDesc(username)
                .forEach(incomes::add);
        return incomes;
    }

    public List<Income> getIncomeOfWeek(String username, Date first_date, Date second) {
        List incomes = new ArrayList<Income>();
        incomeRepository.findAllByUsernameAndPublicationDateBetween(username, first_date, second)
                .forEach(incomes::add);
        return incomes;
    }

}
