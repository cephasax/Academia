package total;

public class Exercicio {

    private String nome;
    private int qntRepeticoes;
    private int tempoDescanso;

    public Exercicio() {
        this.nome = new String();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntRepeticoes() {
        return qntRepeticoes;
    }

    public void setQntRepeticoes(int qntRepeticoes) {
        this.qntRepeticoes = qntRepeticoes;
    }

    public int getTempoDescanso() {
        return tempoDescanso;
    }

    public void setTempoDescanso(int tempoDescanso) {
        this.tempoDescanso = tempoDescanso;
    }

}
