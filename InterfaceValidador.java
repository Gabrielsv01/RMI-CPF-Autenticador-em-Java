import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceValidador extends Remote {
	
	// interface do servico oferecido
	public String echo(String entrada) throws RemoteException;

}
