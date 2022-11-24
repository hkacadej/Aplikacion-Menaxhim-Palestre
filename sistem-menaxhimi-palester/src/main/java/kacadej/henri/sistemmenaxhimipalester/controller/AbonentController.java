package kacadej.henri.sistemmenaxhimipalester.controller;

import kacadej.henri.sistemmenaxhimipalester.entity.Abonent;
import kacadej.henri.sistemmenaxhimipalester.repository.AbonentRepository;

import kacadej.henri.sistemmenaxhimipalester.services.AbonentService;
import kacadej.henri.sistemmenaxhimipalester.services.implementations.AbonentServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AbonentController {

    private AbonentService abonentService;

    public AbonentController(AbonentService abonentService) {
        this.abonentService = abonentService;
    }

    @GetMapping("/abonentet")
    public String abonentetHome(Model model){
       model.addAttribute("abonentet",abonentService.getAllAbonents());
       return "/abonentet";
    }

    @GetMapping("/abonenti/view/{id}")
    public String zgjeroAbonent(@PathVariable Long id, Model model){
        model.addAttribute("abonenti",abonentService.getAbonentById(id));
        return "/abonenti";
    }
    @GetMapping("/abonime_qe_perfundojne")
    public String abonimetQePerfundojen(Model model){
        model.addAttribute("abonentet",abonentService.getAbonentNoSubscription());
        return "/abonime_qe_perfundojne";
    }
    @GetMapping("/abonent/fshij/{id}")
    public String fshijAbonent(@PathVariable Long id){
        abonentService.fshijAbonent(id);
        return "redirect:/abonentet";
    }
    @GetMapping("/abonent/rinovo/{id}")
    public String rinovoAbonimin(@PathVariable Long id,Model model ){
        abonentService.rinovoAbonim(id);
        return zgjeroAbonent(id , model);
    }

    @GetMapping("/abonenti/edit/{id}")
    public String editAbonentinForm(@PathVariable Long id, Model model){
        model.addAttribute(abonentService.getAbonentById(id));
        return "/edit";
    }
    @PostMapping("/edit/{id}")
    public String editAbonentin(@PathVariable Long id ,@ModelAttribute Abonent abonent,Model model){
        abonentService.updateAbonentin(abonent,id);
        return zgjeroAbonent(id, model);
    }


    @GetMapping("/abonent/new")
    public String shtoAbonentForm(Model model){
        Abonent abonent = new Abonent();
        model.addAttribute(abonent);
        return "shto_abonent";
    }

    @PostMapping("/abonentet/shto")
    public String shtoAbonent(@ModelAttribute ("abonent") Abonent abonent ){
        abonentService.shtoAbonent(abonent);
        return "redirect:/abonentet";
    }
    @GetMapping("/abonentet/kerko")
    public String kerkoAbonent(@RequestParam(value="searchString")String string,Model model){
        if (abonentService.kerkoAbonent(string).isEmpty()){
            return"/error";
        }
        model.addAttribute("abonentet",abonentService.kerkoAbonent(string));

        return "/abonentet";
    }
}
