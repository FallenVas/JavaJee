package cigma.pfe.controllers;
import cigma.pfe.Pojos.ClientRequest;
import cigma.pfe.models.Countries;
import cigma.pfe.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import cigma.pfe.models.Client;
import cigma.pfe.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService service;

    @Autowired
    CountryRepository countryRepository;
    @PostMapping("/create")
    public Client save(@RequestBody ClientRequest clt) {
        System.out.println(clt);
        Countries country = countryRepository.findById(clt.getCountryId());
        Client newC = new Client(clt.getId() , clt.getName() , clt.getAge() , clt.getImageUrl(), country);
        return service.save(newC);
    }
    @PutMapping("/modify")
    public Client modify(@RequestBody Client clt) {
        return service.modify(clt);
    }
    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable("id") long idClt) {
       try {
           service.remove(idClt);
       }
       catch (Exception e){
           System.out.println("Something wrong has happened with the id: "+idClt);
       }
           }
    @GetMapping("/show-client/{id}")
    public Client getOne(@PathVariable("id") long idClt) {
        return service.getOne(idClt);
    }
    @GetMapping("/all")
    public List<Client> getAll() {
        return service.getAll();
    }
    @GetMapping("/find/{name}")
    public List<Client> Find(@PathVariable("name") String name){
        return service.Find(name);
    }
    @PutMapping("/{id}")
    public Client update(@RequestBody Client client) {
        return service.save(client);
    }
}

