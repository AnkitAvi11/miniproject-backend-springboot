package expenser.miniproject.expenser.expense;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
    public List<Expense> getExpensesByUsernameOrderByIdDesc(String username);
    public List<Expense> findAllByUsernameAndPublicationDateBetween(String username, Date publicationDate, Date currentDate);
}
