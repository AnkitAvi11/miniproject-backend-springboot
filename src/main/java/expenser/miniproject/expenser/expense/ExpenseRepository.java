package expenser.miniproject.expenser.expense;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

}
