import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ValidadorServico extends UnicastRemoteObject implements InterfaceValidador {

	public ValidadorServico() throws RemoteException {
		super();
	}

	public String echo(String CPF) throws RemoteException {
		
		// tratando a string cpf
		
		String resposta = "";
		int verificador1;
		int verificador2;
		int cpf_1, cpf_2, cpf_3, cpf_4, cpf_5, cpf_6, cpf_7, cpf_8, cpf_9, digito_Verificador = 0;
		 cpf_1 = 0;
		 cpf_2 = 0;
		 cpf_3 = 0;
		 cpf_4 = 0;
		 cpf_5 = 0;
		 cpf_6 = 0;
		 cpf_7 = 0;
		 cpf_8 = 0;
		 cpf_9 = 0;
		 
		 
		if (CPF.length() == 14) {
		
			cpf_1 = Integer.parseInt(CPF.substring(0,1));
			cpf_2 = Integer.parseInt(CPF.substring(1,2));
			cpf_3 = Integer.parseInt(CPF.substring(2,3));
			cpf_4 = Integer.parseInt(CPF.substring(4,5));
			cpf_5 = Integer.parseInt(CPF.substring(5,6));
			cpf_6 = Integer.parseInt(CPF.substring(6,7));
			cpf_7 = Integer.parseInt(CPF.substring(8,9));
			cpf_8 = Integer.parseInt(CPF.substring(9,10));
			cpf_9 = Integer.parseInt(CPF.substring(10,11));
			
			digito_Verificador = Integer.parseInt(CPF.substring(12,14));
			
			// calculo para gerar os codigos verificadores 
			verificador1 = (cpf_1 * 10) + (cpf_2 * 9) + (cpf_3 * 8) + (cpf_4 * 7) + (cpf_5 * 6) + (cpf_6 * 5) + (cpf_7 * 4) + (cpf_8 * 3) + (cpf_9 * 2);
			verificador1 = verificador1 % 11;
						
			if (verificador1 < 2 ) {
				verificador1 = 0;
			}else {
				verificador1 = 11 - verificador1;
			}
			
			verificador2 = (cpf_1 * 11) + (cpf_2 * 10) + (cpf_3 * 9) + (cpf_4 * 8) + (cpf_5 * 7) + (cpf_6 * 6) + (cpf_7 * 5) + (cpf_8 * 4) + (cpf_9 * 3) + (verificador1 * 2);
			verificador2 = verificador2 % 11;
			
			if (verificador2 < 2 ) {
				verificador2 = 0;
			}else {
				verificador2 = 11 -  verificador2;
			}
			
			// juntando os digitos verificadores
			String aux = Integer.toString(verificador1) + Integer.toString(verificador2);
			
			// Comparando os valores dos digitos de verificacao
			if (digito_Verificador == Integer.parseInt(aux)) {
				resposta = "CPF Valido: " + cpf_1 + cpf_2 + cpf_3 + "." + cpf_4 + cpf_5 + cpf_6 + "." + cpf_7 + cpf_8 + cpf_9 + "-" + digito_Verificador;
			}
			else {
				resposta = "CPF invalido";
			}
		}
		else {
			resposta = "CPF invalido";
		}
		
		return "Resposta da Funcao = " + resposta;
	}

}
