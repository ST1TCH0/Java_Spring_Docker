package labs.lab3Marks;

import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface MarkRepos extends JpaRepository<CarMark, String> {


}