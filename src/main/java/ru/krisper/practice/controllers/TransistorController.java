package ru.krisper.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.krisper.practice.data.TransistorDao;
import ru.krisper.practice.data.TypeDao;
import ru.krisper.practice.models.Transistor;
import ru.krisper.practice.models.Type;

import javax.validation.Valid;

@Controller
@RequestMapping("transistor")
public class TransistorController {

    @Autowired
    private TransistorDao transistorDao;

    @Autowired
    private TypeDao typeDao;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("transistors", transistorDao.findAll());
        model.addAttribute("title", "Transistors DB");

        return "transistor/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTransistorForm(Model model){
        model.addAttribute("title", "Add Transistor");
        model.addAttribute("types", typeDao.findAll());
        model.addAttribute(new Transistor());
        return "transistor/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTransistorForm(@ModelAttribute @Valid Transistor newTransistor,
                                           Errors errors, @RequestParam int typeId, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Transistor");
            model.addAttribute("types", typeDao.findAll());
            return "transistor/add";
        }
        Type type = typeDao.findById(typeId).orElse(null);
        newTransistor.setType(type);
        transistorDao.save(newTransistor);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTransistorForm(Model model){
        model.addAttribute("transistors", transistorDao.findAll());
        model.addAttribute("title", "Remove Transistor");
        return "transistor/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTransistorForm(@RequestParam int[] transistorIds){
        for(int transistorId : transistorIds){
            transistorDao.deleteById(transistorId);
        }
        return "redirect:";
    }

    /*@RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int id){
        Type t = typeDao.findById(id).orElse(null);
        List<Transistor> transistors = t.getTransistors();
        model.addAttribute("transistors", transistors);
        model.addAttribute("title", "Transistors with type: " + t.getName());
        return "transistor/index";
    }*/
}
