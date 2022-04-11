package labs.lab3Marks;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MarkService {
	
	@Autowired
	private MarkRepos repos;

	@Transactional
	public List<CarMark> findall(){
		return repos.findAll();
	}

	@Transactional
	public MarkDTO convertToDTO(CarMark mark){
		MarkDTO md = new MarkDTO();
		md.setName(mark.getName());
		md.setCountry(mark.getCountry());
		md.setYear(mark.getFoundYear());
		return md;
	}

	@Transactional
	public List<MarkDTO> findallDTO(){
		return ((List<CarMark>) repos
                .findAll())
                .stream()
                .map(this::convertToDTO)
				        .collect(Collectors.toList());
	}

	@Transactional
	public Optional<CarMark> find(String name) {
		return repos.findById(name);
	}

	@Transactional
	public void delete(String name) {
		if (repos.existsById(name)){

			repos.deleteById(name);
		}

	}
	@Transactional
	public void add(CarMark mark) {
		repos.save(mark);
	}
	
	
}
