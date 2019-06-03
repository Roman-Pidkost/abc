package yurii.shtohman.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VacanciesRequest {

    private String name;

    private Long salary;

    private String description;

    private String nameOfCompany;

    private String city;

}
