package ma.cigma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccessController {
    @RequestMapping("/accessDenied")
    public String accessDenied(RedirectAttributes redAttrs) {

        redAttrs.addFlashAttribute("msgDenied", "Unauthorised Action. Admin privileges needed!");
        return "redirect:/client";
    }
}
