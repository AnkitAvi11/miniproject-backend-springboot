package expenser.miniproject.expenser.income;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Integer> {
    public List<Income> getIncomesByUsernameOrderByIdDesc(String username);
    public List<Income> findAllByUsernameAndPublicationDateBetween(String username, Date publicationDate, Date currentDate);
}
