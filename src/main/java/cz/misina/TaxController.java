package cz.misina;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaxController {

    @GetMapping("/")
    public String TaxForm(Model model) {
        return "taxform";
    }

    @GetMapping("/tax/{income}")
    public String TaxResult(@PathVariable(value="income") String income, Model model) {
        model.addAttribute("tax", income);
        return "taxresult";
    }
}
