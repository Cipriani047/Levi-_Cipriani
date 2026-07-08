package com.senai.projetosa.dtos;

import java.time.LocalDate;
import java.util.List;

public class AgendamentoDTO {

    private Long id;
    private String colaborador;
    private String recurso;
    private List<String> data;
    private LocalDate inicioAgendamento;
    private LocalDate fimAgendamento;
    private String horaInicio;
    private String horaFinal;
    private String cancelamento;
    private String observacao;

    public AgendamentoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public LocalDate getInicioAgendamento() {
        return inicioAgendamento;
    }

    public void setInicioAgendamento(LocalDate inicioAgendamento) {
        this.inicioAgendamento = inicioAgendamento;
    }

    public LocalDate getFimAgendamento() {
        return fimAgendamento;
    }

    public void setFimAgendamento(LocalDate fimAgendamento) {
        this.fimAgendamento = fimAgendamento;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(String cancelamento) {
        this.cancelamento = cancelamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
