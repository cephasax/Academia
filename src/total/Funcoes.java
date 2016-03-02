package total;

import java.util.Scanner;

public class Funcoes {

	public static void op1(Scanner e, Academia start){
		
		System.out.println("Digite seu CPF: ");
	    String cpf1 = e.next();
	    Aluno alunoLogado = new Aluno();
	    alunoLogado = start.buscarAlunoCPF(cpf1);
	    if (alunoLogado != null) {
	        System.out.println("Deseja visualizar o treino de qual dia?");
	        System.out.println(menuDias);
	        String op2 = new String(e.next());
	        int dia = Integer.valueOf(op2);
	        if (dia >= 2 && dia <= 7) {
	            Treino treino = new Treino();
	            treino = alunoLogado.procurarTreinoDia(dia);
	            if (treino != null) {
	                System.out.println("Treino tipo: " + treino.getTipo());
	                System.out.println("Exercicios: \n" + alunoLogado.visualizarTreino(treino));
	                System.out.println("Academia START te deseja um bom treino");
	            } 
	            else {
	                System.out.println("Nao existe treino cadastrado para esse aluno para este dia");
	            }
	        } 
	        else {
	            System.out.println("Opcao invalida, digite novamente");
	        }
	    } 
	    else {
	        System.out.println("Aluno nao encontrado, procure um professor para se cadastrar.");
	    }
	}
	
	public static void op2(Scanner e, Academia start){
		System.out.println("Digite seu CREF:");
        String cref = new String(e.next());
        System.out.println("Digite sua senha:");
        String senha = new String(e.next());
        Professor prof = new Professor();
        prof = start.buscarProfessorCREF(cref);
        if (prof != null) {
            if (prof.getSenha().equals(senha)) {
                System.out.println(menuGeral);
                String op3 = new String(e.next());
                int iop3 = Integer.valueOf(op3);
                
                //CRIAR TREINO
                if (iop3 == 1){
                	Treino treinoCriar = new Treino();
                	treinoCriar.setProfessor(prof);
                    System.out.println(menuDias);
                    String diaTreino = new String(e.next());
                    int idiaTreino = Integer.valueOf(diaTreino);
                    treinoCriar.setDia(idiaTreino);    
                    System.out.println("Qual o tipo ?");
                    String tipo1 = e.next();
                    treinoCriar.setTipo(tipo1);
                    System.out.println(" ");
                    System.out.println("Digite o numero de exercicios que deseja adicionar:");
                    String numExe = new String(e.next());
                    int iNumExe = Integer.valueOf(numExe);
                    for(int i = 1; i <= iNumExe; i++){
                    	Exercicio exercicio = new Exercicio();
                        System.out.println("Digite o nome do exercicio:");
                        exercicio.setNome(e.next());
                        System.out.println("Digite o numero de repeticoes: ");
                        exercicio.setQntRepeticoes(e.nextInt());
                        System.out.println("Digite o tempo de descanso: ");
                        exercicio.setTempoDescanso(e.nextInt());
                        treinoCriar.inserirExercicio(exercicio);
                    }
                	System.out.println("Digite o CPF do aluno que ira realizar esse treino:");
                	String cpfTemp = new String(e.next());
                    Aluno alunoTemp = new Aluno();
                    alunoTemp = start.buscarAlunoCPF(cpfTemp);
                    if(alunoTemp != null){
                    	alunoTemp.getTreinos().add(treinoCriar);
                    	treinoCriar.setAluno(alunoTemp);
                    	System.out.println("Treino criado com sucesso");

                    }
                    else{
                    	System.out.println("Aluno nao encontrado");
                    }
                }
               
                //EDITAR TREINO
                else if(iop3 == 2){
                    System.out.println("Digite o CPF do aluno que possui o treino desejado: ");
                	String cpfTemp = new String(e.next());
                    Aluno alunoTemp = new Aluno();
                    alunoTemp = start.buscarAlunoCPF(cpfTemp);
                    if(alunoTemp != null){
                    	System.out.println(menuDias);
                        String diaTreino = new String(e.next());
                        int idiaTreino = Integer.valueOf(diaTreino);
                        Treino tEdicao = new Treino();
                        tEdicao = alunoTemp.procurarTreinoDia(idiaTreino);
                        if(tEdicao != null){
                        	System.out.println("Exercicios que fazem parte desse treino: ");
                            System.out.println(alunoTemp.visualizarTreino(tEdicao));
                            System.out.println("Digite o nome do exercicio a ser editado: ");
                            String nomeExe = new String(e.next());
                            Exercicio exercicio = new Exercicio();
                            exercicio = tEdicao.procurarExercicio(nomeExe);
                            if(exercicio != null){
                            	Exercicio novoExe = new Exercicio();
                            	System.out.println("Digite o novo nome do exercicio: ");
                            	novoExe.setNome(e.next());
                            	System.out.println("Digite a nova quantidade de repeticoes: ");
                            	novoExe.setQntRepeticoes(e.nextInt());
                            	System.out.println("Digite o novo intervalo de descanso: ");
                            	novoExe.setTempoDescanso(e.nextInt());
                            	
                            	//Excluir antigo exercicio da lista
                            	tEdicao.getExercicios().remove(exercicio);
                            	//Adicionar novo(editado) exercicio na lista
                            	tEdicao.getExercicios().add(novoExe);
                            	
                            	System.out.println("Edicao realizada com sucesso! ");
                            	System.out.println("Exercicios apos edicao: ");
	                            System.out.println(alunoTemp.visualizarTreino(tEdicao));
                            }
                            else{
                            	System.out.println("Exercicio nao encontrado");
                            }
                        }
                        else{
                        	System.out.println("Treino nao encontrado");
                        }
                    }
                    else{
                    	System.out.println("Aluno nao encontrado");
                    }
                }
                 
                //EXCLUIR TREINO
                else if(iop3 == 3){
                    System.out.println("Digite o CPF do aluno que possui o treino a ser excluido: ");
                	String cpfTemp2 = new String(e.next());
                    Aluno alunoTemp2 = new Aluno();
                    alunoTemp2 = start.buscarAlunoCPF(cpfTemp2);
                    if(alunoTemp2 != null){
                    	System.out.println(menuDias);
                        String diaTreino = new String(e.next());
                        int idiaTreino = Integer.valueOf(diaTreino);
                        Treino tExcluir = new Treino();
                        tExcluir = alunoTemp2.procurarTreinoDia(idiaTreino);
                        if(tExcluir != null){
                        	System.out.println("Exercicios que fazem parte desse treino: ");
                            System.out.println(alunoTemp2.visualizarTreino(tExcluir));
                            System.out.println("Digite sim para confirmar a exclusao: ");
                            String confirmExc = e.next();
                            if(confirmExc.equals("sim")){
                            	alunoTemp2.getTreinos().remove(tExcluir);
                            	System.out.println("Treino removido com sucesso!");
                            }
                            else{
                            	System.out.println("Opcao invalida");
                            }
                        }
                        else{
                        	System.out.println("Treino nao encontrado.");
                        }
                    }
                    else{
                    	System.out.println("Aluno nao encontrado");
                    }
                }
                
                //INSERIR ALUNO
                else if(iop3 == 4){
                	
                	Aluno alunoCriar = new Aluno();
                	
                	System.out.println("Digite o cpf do aluno: ");
                	String cpf3 = e.next();
                	if (start.buscarAlunoCPF(cpf3) == null){ 
                		alunoCriar.setCPF(cpf3);
                		System.out.println("Digite o nome do aluno: ");
                    	alunoCriar.setNome(e.next());
                		start.adicionarUsuario(alunoCriar);
                		System.out.println("Aluno cadastrado com sucesso!");
                	}
                	else {
                		System.out.println("Esse CPF já foi cadastrado!");                        
                	}
                }
                	
                //INSERIR PROFESSOR
                else if (iop3 == 5){
                	Professor profCriar = new Professor();
                	
                	System.out.println("Digite o CREF: ");
                	String cref3 = e.next();
                	if (start.buscarProfessorCREF(cref3) == null){
                		profCriar.setCREF(cref3);
                		System.out.println("Digite o nome do Professor: ");
                    	profCriar.setNome(e.next());
                    	System.out.println("Digite a senha: ");
                    	String senha1 = e.next();
                    	System.out.println("Confirme sua senha: ");
                    	String senha2 = e.next();
                    	if (senha1.equals(senha2)){
                    		profCriar.setSenha(senha1);
                    		start.adicionarUsuario(profCriar);
                    		System.out.println("Professor cadastrado com sucesso!");
                    	}
                    	else{
                    		System.out.println("Senhas nao conferem!");
                    	}
                	}
                	else {
                		System.out.println("CREF ja cadastrado!");
                	}
                }
                //OPCAO INVALIDA
                else{
                	System.out.println("Opcao inválida");
                }
                
            }
            else{
            	System.out.println("Senha incorreta");
            }
        }
	}
	
	public static String menuDias = new String("Digite o dia da semana do treino desejado:\n" 
			+ "(2) Segunda-feira\n"
			+ "(3) Terca-feira\n" 
			+ "(4) Quarta-feira\n" 
			+ "(5) Quinta-feira\n" 
			+ "(6) Sexta-feira\n" 
			+ "(7) Sabado\n");

	public static String menuGeral = new String("1 - Criar treino\n" 
			+ "2 - Editar treino\n" 
			+ "3 - Excluir treino\n"
			+ "4 - Inserir aluno\n" 
			+ "5 - Inserir professor\n");

	
}
