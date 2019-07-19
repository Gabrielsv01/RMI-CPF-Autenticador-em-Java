
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Remote;

public class Cliente {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		// cpf para verificacao
		String cpf = "758.533.800-79";
		
		// instanciando um objeto com o endecereco da conexao
		InterfaceValidador service = (InterfaceValidador) Naming.lookup("rmi://localhost:5099/CPF");
		
		// requisicao
		System.out.println("Chamando funcao: " + service.echo(cpf));
	}
}
