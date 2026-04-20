// Giovana Carnevali - RM566196
// Henrique Vicente - RM564116

package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    //atributos
    private String nome;
    private int registroMatricula;
    private LocalDate dataDeNascimento;

    //construtores
    public Aluno(){

    }

    public Aluno(String nome, int registroMatricula, LocalDate dataDeNascimento){
        this.nome = nome;
        setRegistroMatricula(registroMatricula);
        setDataDeNascimento(dataDeNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRegistroMatricula() {
        return registroMatricula;
    }

    public void setRegistroMatricula(int registroMatricula) {
        try{
            if(registroMatricula >= 80000 && registroMatricula <= 599999){
                this.registroMatricula = registroMatricula;
            }else{
                throw new Exception("Registro de matrícula inválido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0);
        }
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        try{
            LocalDate dataMinima = LocalDate.of(1960,1,1);
            LocalDate dataAtual = LocalDate.now();

            if((dataDeNascimento.isEqual(dataMinima) || dataDeNascimento.isAfter(dataMinima))
                    && (dataDeNascimento.isEqual(dataAtual) || dataDeNascimento.isBefore(dataAtual))){
                this.dataDeNascimento = dataDeNascimento;
            }else{
                throw new Exception("Data de nascimento inválida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            System.exit(0);
        }
    }

    //metodos
    public String calcularIdadeCompleta(){
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataDeNascimento,dataAtual);
        return String.format("%d anos, %d meses e %d dias",
                periodo.getYears(),periodo.getMonths(),periodo.getDays());
    }
}