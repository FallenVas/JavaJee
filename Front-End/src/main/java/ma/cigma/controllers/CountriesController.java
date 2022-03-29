package ma.cigma.controllers;

import ma.cigma.Pojos.ClientRequest;
import ma.cigma.models.Client;
import ma.cigma.models.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CountriesController {
    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/countries"})
    public String home(Model model) {
        List<Countries> country = restTemplate.getForObject(apiUrl+"/countries/all", List.class);
        model.addAttribute("Countries",country);
        model.addAttribute("country",new Countries());
        return "index-countries";

    }
    @PostMapping("addCountry")
    public String addCountry(Model model,
                            @ModelAttribute("country") Countries
                                    country ,  RedirectAttributes redAttrs) {
        restTemplate.postForObject(
                apiUrl+"/countries/add",
                country,
                Countries.class);
        redAttrs.addFlashAttribute("msgSuccess", "Country Added Successfully");
        return "redirect:/countries";
    }
    @GetMapping(value = {"/deleteCountry/{id}"})
    public String deleteClientById(
            Model model, @PathVariable long id ,  RedirectAttributes redAttrs) {
        restTemplate.delete(apiUrl+"/countries/remove/"+id);
        redAttrs.addFlashAttribute("msgSuccess", "Country Deleted Successfully");

        return "redirect:/countries";
    }
    @GetMapping("/show-country/{id}")
    public String show( Model model, @PathVariable long id) {
        Countries country = restTemplate.getForObject(apiUrl+"/countries/showCountry/"+id, Countries.class);
        model.addAttribute("country",country);
        return "edit-Country";
    }
    @PostMapping(value = {"/update-country"})
    public String save(Model model, @ModelAttribute("country") Countries country , RedirectAttributes redAttrs) {

        restTemplate.put(apiUrl+"/countries/"+country.getId(), country, Countries.class);
        redAttrs.addFlashAttribute("msgSuccess", "Country Updated Successfully");

        return "redirect:/client";
    }
}
