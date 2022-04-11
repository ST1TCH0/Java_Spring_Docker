package labs.lab3Models.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import labs.lab3Models.Marks.CarMark;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@NoArgsConstructor
@Table(name = "models")
public class CarModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    private String name;

    private Integer year;

    @ManyToOne
    @JoinColumn(name ="mark")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private CarMark mark;

    
    public CarModel(String name, Integer year, CarMark mark) {
    	this.name = name;
    	this.year = year;
    	this.mark = mark;
    }
    
    public Integer getID() {
		return id;
	}
    
    public String getName() {
		return name;
	}
    
    public Integer getYear() {
		return year;
	}
    
    public CarMark getMark() {
		return mark;
	}
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setYear(Integer year) {
    	this.year = year;
    }
}