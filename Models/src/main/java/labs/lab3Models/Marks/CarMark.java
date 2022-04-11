package labs.lab3Models.Marks;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "marks")
public class CarMark{
	@Id
    private String name;

    private String country;

    private Integer foundYear;
    
    public CarMark(String name, String country, Integer foundYear) {
    	this.name = name;
    	this.country = country;
    	this.foundYear = foundYear;
    }

}