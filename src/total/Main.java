package total;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Dados dados = new Dados();
		Scanner e = new Scanner(System.in);
        while(true){
	        System.out.println(menuInicial);
	        int oque = e.nextInt();
	        
	        switch (oque) {
	            case 1:
	                Funcoes.op1(e, dados.getStart());
	                break;
	            
	            case 2:
	                Funcoes.op2(e, dados.getStart());
	                break;
	        }
        }
	}
	
	public static String menuInicial = new String("***** BEM VINDO A ACADEMIA START *****  \n"
			+ " ------ Digite a opcao desejada ------- \n"
			+ "1 - Ja sou aluno \n"
			+ "2 - Ja sou professor");
}
          

