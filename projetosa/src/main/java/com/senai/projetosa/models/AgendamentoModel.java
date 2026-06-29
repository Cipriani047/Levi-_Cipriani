package com.senai.projetosa.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colaborador", nullable = false)
    private String colaborador;

    @Column(name = "recurso", nullable = false)
    private String recurso;

    @Column(name = "dias")
    private List<String> data;

    @Column(name = "dia inicio")
    private LocalDate inicioAgendamento;

    @Column(name = "dia final")
    private LocalDate fimAgendamento;

    @Column(name = "hora inicial")
    private String horaInicio;

    @Column(name = "hora final")
    private String horaFinal;

    @Column(name = "cancelamento")
    private String cancelamento;

    @Column(name = "observação")
    private String observacao;

    public AgendamentoModel() {
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
