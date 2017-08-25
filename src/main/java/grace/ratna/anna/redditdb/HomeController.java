package grace.ratna.anna.redditdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    LinkRepo linkRepo;

    @RequestMapping("/")
    public String listContact(Model model)
    {
        Iterable<Link> allink= linkRepo.findAllByOrderByDateDesc();

        model.addAttribute("allLinks", allink);
        return "welcome";
    }

    @RequestMapping("/login")
    public String logon(){
        return"login";
    }

    @GetMapping("/add")
    public String studentForm(Model model){
        Link link= new Link();

        model.addAttribute("link", link);
        return "linkform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Link link, BindingResult bresult){
        if (bresult.hasErrors()){
            return "linkform";
        }

        Date now= new Date();

        link.setDate(now);

        linkRepo.save(link);
        return "confirmation";
    }

    @GetMapping("/search")
    public String searchbyuserform()
    {

        return "searchform";
    }

    @PostMapping("/searchbyname")
    public String searchbyname(@RequestParam("searchName") String searchName, Model model){

        System.out.println(searchName);

        Iterable<Link> searchResult= linkRepo.findAllByUserNameOrderByDateDesc(searchName);
        model.addAttribute("searchResult", searchResult);
        return "listbyname";
    }


}
