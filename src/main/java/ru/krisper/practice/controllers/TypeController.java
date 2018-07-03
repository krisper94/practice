package ru.krisper.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.krisper.practice.data.TypeDao;
import ru.krisper.practice.models.Type;

import javax.validation.Valid;

@Controller
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeDao typeDao;

    @RequestMapping(value = "")
    public String index (Model model){
        model.addAttribute("types", typeDao.findAll());
        model.addAttribute("title", "Transistor types");
        return "type/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTransistorForm(Model model){
        model.addAttribute("title", "Add Type");
        model.addAttribute(new Type());
        return "type/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Type type, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Add Type");
            return "type/add";
        }
        typeDao.save(type);
        return "redirect:";
    }
}
