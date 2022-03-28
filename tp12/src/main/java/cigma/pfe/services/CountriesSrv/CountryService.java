package cigma.pfe.services.CountriesSrv;

import cigma.pfe.models.Countries;

import java.util.List;

public interface CountryService {
    Countries save(Countries ctr);
    Countries modify(Countries ctr);
    void remove(long idCtr);
    Countries getOne(long idCtr);
    List<Countries> getAll();
    List <Countries> Find(String ctr);

}
