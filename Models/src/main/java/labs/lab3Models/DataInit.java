package labs.lab3Models;

import javax.annotation.PostConstruct;

import labs.lab3Models.Marks.CarMark;
import labs.lab3Models.Marks.MarkService;
import labs.lab3Models.Models.CarModel;
import labs.lab3Models.Models.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class
DataInit{
	@Autowired
	ModelService modelService;

	@Autowired
	MarkService markService;

	public DataInit(ModelService modelService) {
		this.modelService = modelService;
	}
	
	@PostConstruct
	public void init() throws Exception {

		CarMark mark = new CarMark("BMW", "", 0);
		markService.add(mark);
		
			CarModel model = new CarModel("E46 M3", 2000, mark);
			modelService.add(model);
			
			model = new CarModel("X1", 2013, mark);
			modelService.add(model);
			
			model = new CarModel("4-Series", 2013, mark);
			modelService.add(model);
			
			model = new CarModel("i8", 2014, mark);
			modelService.add(model);
			
			model = new CarModel("8-Series", 2018, mark);
			modelService.add(model);

		mark = new CarMark("Mercedes-Benz", "", 0);
		markService.add(mark);
			
			model = new CarModel("SLR McLaren", 2010, mark);
			modelService.add(model);
			
			model = new CarModel("500 E", 1994, mark);
			modelService.add(model);
			
			model = new CarModel("E 63 AMG", 2016, mark);
			modelService.add(model);
			
			model = new CarModel("SLS AMG", 2014, mark);
			modelService.add(model);
			
			model = new CarModel("C-Class", 2015, mark);
			modelService.add(model);

		mark = new CarMark("Ford", "", 0);
		markService.add(mark);
		
			model = new CarModel("Mustang Shelby GT 500", 2020, mark);
			modelService.add(model);
			
			model = new CarModel("GT350", 2015, mark);
			modelService.add(model);
			
			model = new CarModel("Focus", 2002, mark);
			modelService.add(model);
			
			model = new CarModel("GT", 2004, mark);
			modelService.add(model);
			
			model = new CarModel("Transit Connect", 2002, mark);
			modelService.add(model);

		mark = new CarMark("Toyota", "", 0);
		markService.add(mark);

			model = new CarModel("Camry", 2018, mark);
			modelService.add(model);
			
			model = new CarModel("Avalon", 2012, mark);
			modelService.add(model);
			
			model = new CarModel("86", 2017, mark);
			modelService.add(model);
			
			model = new CarModel("Corolla", 2012, mark);
			modelService.add(model);
			
			model = new CarModel("Prius", 2002, mark);
			modelService.add(model);

		mark = new CarMark("Dodge", "", 0);
		markService.add(mark);

			model = new CarModel("Charger", 1969, mark);
			modelService.add(model);
			
			model = new CarModel("Challenger", 20-8, mark);
			modelService.add(model);
			
			model = new CarModel("Viper", 2017, mark);

			modelService.add(model);
			
			model = new CarModel("Viper", 1992, mark);
			modelService.add(model);
			
			model = new CarModel("Challenger", 1970, mark);
			modelService.add(model);
		
	}
}
