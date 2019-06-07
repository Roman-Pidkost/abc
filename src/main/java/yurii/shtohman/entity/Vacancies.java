package yurii.shtohman.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Vacancies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long salary;

    @Column(columnDefinition = "text")
    private String description;

    private String nameOfCompany;

    private String city;

}
