package labs.lab3Models.Marks;

import labs.lab3Models.Models.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/marks")
public class MarkController {
	@Autowired
	private MarkService markService;
	@Autowired
	private ModelService modelService;

	@PostMapping("")
	public ResponseEntity<Void> createMark(@RequestBody MarkDTO mark) {
		if (markService.find(mark.getName()).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		CarMark nm = new CarMark(mark.getName(), mark.getCountry(), mark.getYear());
		markService.add(nm);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<Void> deleteMark(@PathVariable String name){
		if (markService.find(name).isPresent()){
			for (int i=0; i<modelService.findall().size(); i++){
				if (modelService.findall().get(i).getMark().getName().equals(name))
					modelService.delete(modelService.findall().get(i).getID());
			}
			markService.delete(name);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
