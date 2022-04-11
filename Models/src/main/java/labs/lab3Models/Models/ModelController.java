package labs.lab3Models.Models;

import java.util.ArrayList;
import java.util.List;

import labs.lab3Models.Marks.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/models")
public class ModelController {
	@Autowired 
	private ModelService modelService;

	@Autowired
	private MarkService markService;

	@GetMapping("")
	public List<ModelDTO> getModelList(){
		return modelService.findallDTO();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelDTO> getModelById(@PathVariable Integer id) {
		if(modelService.find(id).isPresent()) {
			ModelDTO md = modelService.convertToDTO(modelService.find(id).get());
			return ResponseEntity.ok(md);
		}
		 else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/mark/{name}")
	public List<ModelDTO> getModelById(@PathVariable String name) {
		List<ModelDTO> md = new ArrayList<>();
		for(int i=0; i<modelService.findall().size(); i++){
			if (modelService.findall().get(i).getMark().getName().equals(name))
				md.add(modelService.convertToDTO(modelService.findall().get(i)));

		}
		return md;
	}

	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<Void> createModel(@RequestBody ModelDTO model) {
			CarModel nm = new CarModel(model.getName(), model.getYear(), markService.find(model.getMark()).get());
			modelService.add(nm);
			return ResponseEntity.ok().build();
	}
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateModel(@PathVariable Integer id, @RequestBody ModelDTO model) {
		if (modelService.find(id).isPresent()){
			 CarModel cm = modelService.find(id).get();
			 cm.setName(model.getName());
			 cm.setYear(model.getYear());
			 modelService.delete(id);
			 modelService.add(cm);
			 return ResponseEntity.ok().build();
		 }
		else
			return ResponseEntity.notFound().build();
	}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteModel(@PathVariable Integer id) {
		if (modelService.find(id).isPresent()){
			modelService.delete(id);
			return ResponseEntity.ok().build();
		}
		else
			return ResponseEntity.notFound().build();
	}
}
