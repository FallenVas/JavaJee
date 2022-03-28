package cigma.pfe.controllers;

import cigma.pfe.models.Countries;
import cigma.pfe.services.ClientService;
import cigma.pfe.services.ClientServiceImp;
import cigma.pfe.services.CountriesSrv.CountrySrvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/countries")
public class CountriesController {
    @Autowired
    private ClientServiceImp clientServiceImp;
    @Autowired
    private CountrySrvImp service;
    @PostMapping("/add")
    public Countries save(@RequestBody Countries clt) {
        return service.save(clt);
    }
    @PutMapping("/modify")
    public Countries modify(@RequestBody Countries clt) {
        return service.modify(clt);
    }
    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable("id") long idClt) {
        try {
            service.remove(idClt);

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Something wrong has happened with the id: "+idClt);
        }
    }
    @GetMapping("/showCountry/{id}")
    public Countries getOne(@PathVariable("id") long idClt) {
        return service.getOne(idClt);
    }
    @GetMapping("/all")
    public List<Countries> getAll() {
        return service.getAll();
    }
    @GetMapping("/find/{name}")
    public List<Countries> Find(@PathVariable("name") String name){
        return service.Find(name);
    }
    @PutMapping("/{id}")
    public Countries update(@RequestBody Countries country) {
        return service.save(country);
    }
}
