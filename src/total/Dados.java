package total;

public class Dados {
	
	public Academia start;
	
	public Dados(){
		start = new Academia("Start");
        Aluno novo = new Aluno("123123");
        start.getUsuarios().add(novo);
        
        Exercicio teste = new Exercicio();
        teste.setNome("abdominal");
        teste.setQntRepeticoes(20);
        teste.setTempoDescanso(5);

        Exercicio teste2 = new Exercicio();
        teste2.setNome("flexao");
        teste2.setQntRepeticoes(20);
        teste2.setTempoDescanso(2);

        Treino testet = new Treino();
        testet.setDia(2);
        testet.setTipo("resistencia");
        testet.inserirExercicio(teste);
        testet.inserirExercicio(teste2);

        novo.getTreinos().add(testet);
        
        Professor professor = new Professor();
        professor.setNome("Joao Tiburcio");
        professor.setCREF("12345");
        professor.setSenha("12345");
        
        start.adicionarUsuario(professor);
	}

	public Academia getStart() {
		return start;
	}

	public void setStart(Academia start) {
		this.start = start;
	}
	
}
