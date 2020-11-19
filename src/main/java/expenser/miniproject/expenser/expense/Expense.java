package expenser.miniproject.expenser.expense;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expense {
    //  generating primary key automatically
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    int id;
    //  username for the user
    private String username;
    //  title of the income made
    private String title;
    //  amount of the income
    private float amount;

    @Column(nullable = false)
    private Date publicationDate;

    @PrePersist
    private void onCreate() {
        publicationDate = new Date();
    }

    public Expense(){}

    public Expense(int id, String username, String title, float amount, Date publicationDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.amount = amount;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}