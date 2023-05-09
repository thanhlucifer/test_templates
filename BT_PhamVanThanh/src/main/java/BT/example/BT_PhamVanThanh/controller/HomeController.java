package BT.example.BT_PhamVanThanh.controller;

import BT.example.BT_PhamVanThanh.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @Controller
    public class PersonController {
        @GetMapping("/person")
        public String index(Model model)
        {
            model.addAttribute("info", "<b>Thông tin </b> </br>");
            Person p = new Person();
            p.setName("Pham Van Thanh");
            p.setAge(22);
            p.setSex(1);
            p.setMarried(false);
            p.setCreateTime(LocalDate.now());
            p.setLanguage(Arrays.asList("Java","C#","Python")
            );
            model.addAttribute("person", p);
            return "person";
        }

        @GetMapping("/person/edit")
        public String edit(Model model)
        {
            Person p = new Person();
            p.setName("Thymeleaf Spring Boot");
            p.setAge(36);
            model.addAttribute("person", p);
            return "edit";
        }
        @PostMapping("/person/edit")
        public String edit(Model model, @ModelAttribute Person person){
            model.addAttribute("person",person);
            return "thankyou";
        }
    }
}
