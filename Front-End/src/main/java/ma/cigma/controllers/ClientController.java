package ma.cigma.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.cigma.Pojos.ClientRequest;
import ma.cigma.models.Client;
import ma.cigma.models.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class ClientController {
    ObjectMapper mapper = new ObjectMapper();

    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = {"/", "/client"})
    public String home(Model model) {
        List<Client> client = restTemplate.getForObject(apiUrl+"/client/all", List.class);
        List<Countries> countries = restTemplate.getForObject(apiUrl+"/countries/all" ,List.class );
        model.addAttribute("countries" , countries);
        model.addAttribute("clients",client);
        model.addAttribute("client",new Client());
        return "index-client";

    }
    @GetMapping(value = {"/delete-client/{id}"})
    public String deleteClientById(
            Model model, @PathVariable long id , RedirectAttributes redAttrs) {
        restTemplate.delete(apiUrl+"/client/remove/"+id);
        redAttrs.addFlashAttribute("msgSuccess", "User Deleted Successfully");
        return "redirect:/client";
    }
    @PostMapping(value = "/add-client")
    public String addClient(Model model,
                            @ModelAttribute("client") ClientRequest
                                    client , RedirectAttributes redAttrs) {
        if(client.getImageUrl() == ""){
            client.setImageUrl(null);
        }
        restTemplate.postForObject(
                apiUrl+"/client/create/",
                client,
                ClientRequest.class);
        redAttrs.addFlashAttribute("msgSuccess", "User Added Successfully");
        return "redirect:/client";
    }
    @GetMapping("/show-client/{id}")
    public String show( Model model, @PathVariable long id) {
        Client client = restTemplate.getForObject(apiUrl+"/client/show-client/"+id, Client.class);
       model.addAttribute("client",client);
        System.out.println(client);
        return "edit";
    }

    @PostMapping(value = {"/save-client"})
    public String save(Model model, @ModelAttribute("client") Client client) {
        restTemplate.put(apiUrl+"/client/"+client.getId(), client, Client.class);
        return "redirect:/client";
    }


}
