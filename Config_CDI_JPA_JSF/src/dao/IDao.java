package dao;

import java.util.Collection;

import metier.Client;

public interface IDao {

	public long addClient(Client client);
	
	public Collection<Client> findAllClient();
	
	public void suppClient(Client client);
	
}
