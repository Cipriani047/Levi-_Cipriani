package com.senai.projetosa.controllers;

import com.senai.projetosa.dtos.AgendamentoDTO;
import com.senai.projetosa.dtos.RecursoDTO;
import com.senai.projetosa.services.AgendamentoService;
import com.senai.projetosa.services.RecursoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;
    private final RecursoService recursoService;

    public AgendamentoController(AgendamentoService agendamentoService, RecursoService recursoService) {
        this.agendamentoService = agendamentoService;
        this.recursoService = recursoService;
    }

    @PostMapping
    public String cadastrar(@ModelAttribute("agendamentoDto") AgendamentoDTO agendamentoDTO) {
        agendamentoService.cadastrar(agendamentoDTO);
        return "redirect:/agendamentolista";
    }

    @GetMapping("/agendamentocancelar/{id}")
    public String cancelar(@PathVariable Long id) {
        agendamentoService.cancelar(id);
        return "redirect:/agendamentolista";
    }

    // Endpoint para buscar os dias disponíveis do recurso
    @GetMapping("/diasRecurso")
    @ResponseBody
    public String obterDiasRecurso(@RequestParam Long idRecurso) {
        RecursoDTO recurso = recursoService.obterRecurso(idRecurso);
        return recurso.getDiasDisponivel() != null ? recurso.getDiasDisponivel() : "";
    }
}
