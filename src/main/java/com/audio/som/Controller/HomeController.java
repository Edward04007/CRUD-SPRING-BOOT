package com.audio.som.Controller;
import com.audio.som.Model.ExibirModal;
import com.audio.som.Service.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
  
   @Autowired
   Database database;
    /* Visualizar */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView listar(){
       ModelAndView mav = new ModelAndView("index");
       mav.addObject("ed", database.findAll());
       return mav;
   }
   /* Salvar */
   @RequestMapping(value = "/", method = RequestMethod.POST)
   public String index(ExibirModal exibirModal) {
       database.save(exibirModal);
       return "redirect:/";
   }
   /* Deletar */
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
   public String delete(@PathVariable("id") int id){
   database.deleteById(id);
   return "redirect:/";
   }
   /* Atualizar */
   @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
   public String update(@PathVariable("id") Integer id, Model model){
   model.addAttribute("dados", database.findById(id));
   return "atualizar";
   }
}