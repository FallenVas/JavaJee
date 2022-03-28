package cigma.pfe.repositories;

import cigma.pfe.models.Countries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Countries , Long> {
    List<Countries> findByName(String name);
    Countries findById(long id);
}
