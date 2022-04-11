package labs.lab3Models.Models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ModelService {

	@Autowired
	private ModelRepos repos;
	@Transactional
	public List<CarModel> findall(){
		return repos.findAll();
	}
	
	public ModelDTO convertToDTO(CarModel model){
		ModelDTO md = new ModelDTO();
		md.setId(model.getID());
		md.setName(model.getName());
		md.setYear(model.getYear());
		md.setMark(model.getMark().getName());
		return md;
	}
	@Transactional
	public List<ModelDTO> findallDTO(){
		return ((List<CarModel>) repos
                .findAll())
                .stream()
                .map(this::convertToDTO)
				        .collect(Collectors.toList());
	}
	@Transactional
	public Optional<CarModel> find(Integer id) {
		return repos.findById(id);
	}
	@Transactional
	public void delete(Integer id) {
		repos.deleteById(id);
	}
	@Transactional
	public List<CarModel> findModelsByMark(String mark){
		return repos.findModelsByMark(mark);
	}
	@Transactional
	public void add(CarModel model) {
		repos.save(model);
	}
	
}
