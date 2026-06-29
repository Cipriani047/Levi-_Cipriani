package com.senai.projetosa.controllers;

import com.senai.projetosa.dtos.AgendamentoDTO;
import com.senai.projetosa.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendamentoCadastroController {

    private final UsuarioService usuarioService;
    private final RecursoService recursoService;

    public AgendamentoCadastroController(UsuarioService usuarioService, RecursoService recursoService){
        this.usuarioService = usuarioService;
        this.recursoService = recursoService;
    }

    @GetMapping("/agendamentocadastro")
    public String viewCadastro(Model model){
        model.addAttribute("agendamentoDto", new AgendamentoDTO());
        model.addAttribute("usuarios", usuarioService.obterUsuarios());
        model.addAttribute("recursos", recursoService.obterRecursos());
        return "agendamentocadastro";
    }
}