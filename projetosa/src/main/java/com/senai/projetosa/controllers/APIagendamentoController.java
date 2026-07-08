package com.senai.projetosa.controllers;

import com.senai.projetosa.dtos.*;
import com.senai.projetosa.services.AgendamentoService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/agendamento")
public class APIagendamentoController {
    private final AgendamentoService agendamentoService;

    public APIagendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<RespostaDTO> cadastrar(@RequestBody AgendamentoDTO agendamentoDTO) {
        RespostaDTO respostaDTO = agendamentoService.cadastrar(agendamentoDTO);

        if (respostaDTO.getMensagem().equals("sucesso")){
            respostaDTO.setMensagem("Agendamento cadastrado com sucesso!");
            return ResponseEntity.ok().body(respostaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(respostaDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> obterAgendamento(@PathVariable Long id){
        return ResponseEntity.ok().body(agendamentoService.obterAgendamento(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> obterAgendamentos(){
        return ResponseEntity.ok().body(agendamentoService.obterAgendamentos());
    }
}