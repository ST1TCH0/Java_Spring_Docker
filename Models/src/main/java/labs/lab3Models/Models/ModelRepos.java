package labs.lab3Models.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ModelRepos extends JpaRepository<CarModel, Integer> {

	public List<CarModel> findModelsByMark(String mark);
	
}