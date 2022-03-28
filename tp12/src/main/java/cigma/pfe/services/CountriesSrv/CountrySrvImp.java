package cigma.pfe.services.CountriesSrv;

import cigma.pfe.models.Countries;
import cigma.pfe.repositories.CountryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountrySrvImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Countries save(Countries ctr) {
        return countryRepository.save(ctr);
    }

    @Override
    public Countries modify(@NotNull Countries ctr) {
        Countries country = countryRepository.findById(ctr.getId()).get();
        country.setName(ctr.getName());
        return countryRepository.save(ctr);
    }

    @Override
    public void remove(long idCtr) {
        countryRepository.deleteById(idCtr);
    }

    @Override
    public Countries getOne(long idCtr) {
        return countryRepository.findById(idCtr);
    }

    @Override
    public List<Countries> getAll() {
        return (List<Countries>) countryRepository.findAll();
    }

    @Override
    public List<Countries> Find(String ctr) {
        return countryRepository.findByName(ctr);
    }
}
