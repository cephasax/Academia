package total;

import java.util.ArrayList;

public class Treino {

    private ArrayList<Exercicio> exercicios;
    private int dia;
    private String tipo;
    private Professor professor;
    private Aluno aluno;

    public Treino(int dia, String tipo, ArrayList<Exercicio> exercicios) {
        this.dia = dia;
        this.tipo = tipo;
        this.exercicios = new ArrayList<Exercicio>();
        this.exercicios = exercicios;
    }
    public Treino(){
        this.exercicios = new ArrayList<Exercicio>();
        this.tipo = new String();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void inserirExercicio(Exercicio x) {
        exercicios.add(x);
    }

    public Exercicio procurarExercicio(String nome) {
        for (Exercicio exercicio : exercicios) {
            if (exercicio.getNome().equals(nome)) {
                return exercicio;
            }
        }
        return null;
    }

}
