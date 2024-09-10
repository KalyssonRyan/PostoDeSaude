/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.postodesaude;

/**
 *
 * @author Kalysson
 */
public class Medicamento {
    private String nomeMedicamento;
    private String dosagem;
    private int quantidade;

    public Medicamento(String nomeMedicamento, String dosagem, int quantidade) {
        this.nomeMedicamento = nomeMedicamento;
        this.dosagem = dosagem;
        this.quantidade = quantidade;
    }
    //Construtor vazio
    public Medicamento() {
    }

	public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
