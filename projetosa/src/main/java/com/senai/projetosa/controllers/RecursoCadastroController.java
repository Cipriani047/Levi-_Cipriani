package com.senai.projetosa.controllers;

import com.senai.projetosa.dtos.RecursoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecursoCadastroController {

    @GetMapping("/recursocadastro")
    public String viewCadastro(Model model){
        model.addAttribute("recursoDto", new RecursoDTO());
        return "recursocadastro";
    }
}
