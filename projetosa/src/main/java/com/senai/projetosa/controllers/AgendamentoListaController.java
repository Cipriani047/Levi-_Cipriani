package com.senai.projetosa.controllers;

import com.senai.projetosa.dtos.AgendamentoDTO;
import com.senai.projetosa.services.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AgendamentoListaController {

    private final AgendamentoService agendamentoService;

    public AgendamentoListaController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping("/agendamentolista")
    public String viewUsuarioLista(Model model){
        List<AgendamentoDTO> listaDto = agendamentoService.obterAgendamentos();
        model.addAttribute("listaDto", listaDto);
        return "agendamentolista";
    }
}
