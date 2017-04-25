package service;

import java.util.Collection;

import metier.Client;

public interface IService {

	public long addClient(Client client);
	
	public Collection<Client> findAllClient();
	
	public void suppClient(Client client);
	
}
