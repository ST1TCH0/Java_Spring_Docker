package labs.lab3Marks;

import java.util.ArrayList;
import java.util.List;

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
	private EventRepos eventRepository;

	@GetMapping("")
	public List<MarkDTO> getMarkList(){
		return markService.findallDTO();
	}

	@GetMapping("/{name}")
	public ResponseEntity<MarkDTO> getModelById(@PathVariable String name) {
		if(markService.find(name).isPresent()) {
			MarkDTO md = markService.convertToDTO(markService.find(name).get());

			return ResponseEntity.ok(md);
		}
		return ResponseEntity.notFound().build();
	}
	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<Void> createMark(@RequestBody MarkDTO mark) {
		if (markService.find(mark.getName()).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		CarMark nm = new CarMark(mark.getName(), mark.getCountry(), mark.getYear());
		markService.add(nm);
		eventRepository.create(nm);
		return ResponseEntity.ok().build();
	}
	@CrossOrigin
	@PutMapping("/{name}")
	public ResponseEntity<Void> updateMark(@PathVariable String name, @RequestBody MarkDTO mark) {
		if (markService.find(name).isPresent()){
			CarMark cm = markService.find(name).get();
			cm.setFoundYear(mark.getYear());
			cm.setCountry(mark.getCountry());
			markService.add(cm);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	@CrossOrigin
	@DeleteMapping("/{name}")
	public ResponseEntity<Void> deleteMark(@PathVariable String name) {
		if (markService.find(name).isPresent()){
			eventRepository.delete(markService.find(name).get());
			markService.delete(name);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
