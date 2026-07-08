package com.senai.projetosa.services;

import com.senai.projetosa.dtos.*;
import com.senai.projetosa.models.AgendamentoModel;
import com.senai.projetosa.repositorys.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public RespostaDTO cadastrar(AgendamentoDTO agendamentoDto) {

        AgendamentoModel agendamentoModel = new AgendamentoModel();
        agendamentoModel.setColaborador(agendamentoDto.getColaborador());
        agendamentoModel.setRecurso(agendamentoDto.getRecurso());
        agendamentoModel.setData(agendamentoDto.getData());
        agendamentoModel.setInicioAgendamento(agendamentoDto.getInicioAgendamento());
        agendamentoModel.setFimAgendamento(agendamentoDto.getFimAgendamento());
        agendamentoModel.setHoraInicio(agendamentoDto.getHoraInicio());
        agendamentoModel.setHoraFinal(agendamentoDto.getHoraFinal());
        agendamentoModel.setCancelamento(agendamentoDto.getCancelamento());
        agendamentoModel.setObservacao(agendamentoDto.getObservacao());
        repository.save(agendamentoModel);

        RespostaDTO resposta = new RespostaDTO();
        resposta.setMensagem("sucesso");
        return resposta;
    }

    public void cancelar(Long id) {
        AgendamentoModel ag = repository.findById(id).orElseThrow(() -> new RuntimeException("AGENDAMENTO NÃO ENCONTRADO!"));

        ag.setCancelamento("Cancelado!");

        repository.save(ag);
    }

    public AgendamentoDTO obterAgendamento(Long id) {
        AgendamentoDTO agendamentoDTO = new AgendamentoDTO();
        Optional<AgendamentoModel> agendamentoOP = repository.findById(id);

        if (agendamentoOP.isPresent()) {
            agendamentoDTO.setId(agendamentoOP.get().getId());
            agendamentoDTO.setColaborador(agendamentoOP.get().getColaborador());
            agendamentoDTO.setRecurso(agendamentoOP.get().getRecurso());
            agendamentoDTO.setHoraInicio(agendamentoOP.get().getHoraInicio());
            agendamentoDTO.setHoraFinal(agendamentoOP.get().getHoraFinal());
            agendamentoDTO.setData(agendamentoOP.get().getData());
            agendamentoDTO.setInicioAgendamento(agendamentoOP.get().getInicioAgendamento());
            agendamentoDTO.setFimAgendamento(agendamentoOP.get().getFimAgendamento());
            agendamentoDTO.setCancelamento(agendamentoOP.get().getCancelamento());
            agendamentoDTO.setObservacao(agendamentoOP.get().getObservacao());
            return agendamentoDTO;
        }
        return agendamentoDTO;
    }

    public List<AgendamentoDTO> obterAgendamentos() {
        List<AgendamentoDTO> agendamentoDTO = new ArrayList<>();
        List<AgendamentoModel> agendamentoModels = repository.findAll();

        for (AgendamentoModel agendamentoModel : agendamentoModels) {
            AgendamentoDTO agendamento = new AgendamentoDTO();
            agendamento.setId(agendamentoModel.getId());
            agendamento.setColaborador(agendamentoModel.getColaborador());
            agendamento.setRecurso(agendamentoModel.getRecurso());
            agendamento.setHoraInicio(agendamentoModel.getHoraInicio());
            agendamento.setHoraFinal(agendamentoModel.getHoraFinal());
            agendamento.setData(agendamentoModel.getData());
            agendamento.setInicioAgendamento(agendamentoModel.getInicioAgendamento());
            agendamento.setFimAgendamento(agendamentoModel.getFimAgendamento());
            agendamento.setCancelamento(agendamentoModel.getCancelamento());
            agendamento.setObservacao(agendamentoModel.getObservacao());
            agendamentoDTO.add(agendamento);
        }
        return agendamentoDTO;
    }
}