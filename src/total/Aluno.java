package total;

import java.util.ArrayList;

public class Aluno extends Usuario {

    private String cpf;
    ArrayList<Treino> treinos;
 

    public Aluno(String cpf) {
        this.cpf = new String(cpf);
        this.treinos = new ArrayList<Treino>();
    }
    public Aluno(){
    	this.treinos = new ArrayList<Treino>();
    }

    public ArrayList<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(ArrayList<Treino> treinos) {
        this.treinos = treinos;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Treino procurarTreinoDia(int dia) {
        for (Treino a : treinos) {
            if (a.getDia() == dia) {
                return a;
            }
        }
        return null;
    }

    public String visualizarTreino(Treino treino) {
        String exercicios = new String();
        for (Exercicio ex : treino.getExercicios()) {
            exercicios = exercicios + " Tipo: " + ex.getNome()
                                    + " Repeticoes: " + ex.getQntRepeticoes()
                                    + " Tempo de descanso: " + ex.getTempoDescanso()
                                    +"\n";
        }        
        return exercicios;
    }
}
