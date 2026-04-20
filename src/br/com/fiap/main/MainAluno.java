// Giovana Carnevali - RM566196
// Henrique Vicente - RM564116

package br.com.fiap.main;

import br.com.fiap.bean.Aluno;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainAluno {
    public static void main(String[] args) {

        Aluno aluno1, aluno2, aluno3, aluno4;

        String auxiliar, nome;
        int rm;
        LocalDate dataNascimento;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            LocalDate dataAtual = LocalDate.now();

            // objetos com construtor vazio
            aluno1 = new Aluno();
            aluno1.setNome("Giovana Bernardino Carnevali");
            aluno1.setRegistroMatricula(566196);
            aluno1.setDataDeNascimento(LocalDate.of(2006,12,15));

            aluno2 = new Aluno();
            aluno2.setNome("Henrique Vicente Vicente");
            aluno2.setRegistroMatricula(564116);
            aluno2.setDataDeNascimento(LocalDate.of(2006,11,21));

            // objetos com entrada do usuário
            nome = JOptionPane.showInputDialog("Digite o nome");
            auxiliar = JOptionPane.showInputDialog("Digite o RM");
            rm = Integer.parseInt(auxiliar);
            auxiliar = JOptionPane.showInputDialog("Digite a data de nascimento dia/mes/ano");
            dataNascimento = LocalDate.parse(auxiliar,dtf);
            aluno3 = new Aluno(nome,rm,dataNascimento);

            nome = JOptionPane.showInputDialog("Digite o nome");
            auxiliar = JOptionPane.showInputDialog("Digite o RM");
            rm = Integer.parseInt(auxiliar);
            auxiliar = JOptionPane.showInputDialog("Digite a data de nascimento dia/mes/ano");
            dataNascimento = LocalDate.parse(auxiliar,dtf);
            aluno4 = new Aluno(nome,rm,dataNascimento);

            JOptionPane.showMessageDialog(null,String.format(
                    "RM: %d\nNome: %s\nIdade: %s",
                    aluno1.getRegistroMatricula(), aluno1.getNome(), aluno1.calcularIdadeCompleta()
            ));

            JOptionPane.showMessageDialog(null,String.format(
                    "RM: %d\nNome: %s\nIdade: %s",
                    aluno2.getRegistroMatricula(), aluno2.getNome(), aluno2.calcularIdadeCompleta()
            ));

            JOptionPane.showMessageDialog(null,String.format(
                    "RM: %d\nNome: %s\nIdade: %s",
                    aluno3.getRegistroMatricula(), aluno3.getNome(), aluno3.calcularIdadeCompleta()
            ));

            JOptionPane.showMessageDialog(null,String.format(
                    "RM: %d\nNome: %s\nIdade: %s",
                    aluno4.getRegistroMatricula(), aluno4.getNome(), aluno4.calcularIdadeCompleta()
            ));

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}