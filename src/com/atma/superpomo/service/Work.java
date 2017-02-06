package com.atma.superpomo.service;

import com.atma.superpomo.model.Pomodoro;
import com.atma.superpomo.model.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by diego.pessoa on 06/02/2017.
 */
public class Work {

    private List<Pomodoro> pomodoros;
    private Usuario usuario;
    private Date dataCriacao;

    public Work() {
        pomodoros = new ArrayList<>();
    }

    public List<Pomodoro> getPomodoros() {
        return pomodoros;
    }

    public void setPomodoros(List<Pomodoro> pomodoros) {
        this.pomodoros = pomodoros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
