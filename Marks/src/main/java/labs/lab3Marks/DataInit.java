package labs.lab3Marks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class
DataInit{
	@Autowired
	MarkService markService;

	public DataInit(MarkService markService) {
		this.markService = markService;
	}
	
	@PostConstruct
	public void init() throws Exception {
		
		CarMark mark = new CarMark("BMW", "Germany", 1917);
		markService.add(mark);
		
		mark = new CarMark("Mercedes-Benz", "Germany", 1883);
		markService.add(mark);

		mark = new CarMark("Ford", "USA", 1903);
		markService.add(mark);
		
		mark = new CarMark("Toyota", "Japan", 1937);
		markService.add(mark);
		
		mark = new CarMark("Dodge", "USA", 1900);
		markService.add(mark);

	}
}
