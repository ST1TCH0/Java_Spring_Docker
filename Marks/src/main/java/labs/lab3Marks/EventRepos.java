package labs.lab3Marks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EventRepos  {

    private RestTemplate restTemplate;

    @Autowired
    public EventRepos(@Value("${models.url}") String baseUrl) {
        restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public void delete(CarMark mark) {
        restTemplate.delete("/marks/{name}", mark.getName());
    }

    public void create(CarMark mark) {
        MarkDTO md = new MarkDTO();
        md.setCountry("");
        md.setName(mark.getName());
        md.setYear(0);
        restTemplate.postForLocation("/marks", md);
    }
}