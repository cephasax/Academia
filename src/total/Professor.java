package total;

import java.util.ArrayList;

public class Professor extends Usuario {

    private String CREF;
    private String senha;

    ArrayList<Treino> treinos = new ArrayList<Treino>();

    public void inserirTreino(Treino x) {
        treinos.add(x);

    }

    public String getCREF() {
        return CREF;
    }

    public void setCREF(String CREF) {
        this.CREF = CREF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Treino criarTreino(int dia, String tipo, Aluno aluno, ArrayList<Exercicio> exercicios) {
        Treino novoTreino = new Treino(dia, tipo, exercicios);
        novoTreino.setAluno(aluno);
        novoTreino.setProfessor(this);
        return novoTreino;
    }

    public void editarTreinoAluno(Aluno aluno, int dia, String nomeExercicio, Exercicio novoExercicio) {

        for (Treino treino : aluno.getTreinos()) {
            if (treino.getDia() == dia) {
                for (Exercicio exercicio : treino.getExercicios()) {
                    if (exercicio.getNome().equals(nomeExercicio)) {
                        exercicio = novoExercicio;
                    }
                }
            }
        }

    }

    public void excluirTreinoAluno(Aluno aluno, int dia) {
        for (Treino treino : aluno.getTreinos()) {
            if (treino.getDia() == dia) {
                aluno.getTreinos().remove(treino);
            }
        }

    }

}
