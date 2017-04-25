package service;

import java.util.Collection;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class ServiceImpl implements IService {
	
	@Inject
	private IDao dao;
	
	@Override
	public long addClient(Client client) {
		return dao.addClient(client);
	}

	@Override
	public Collection<Client> findAllClient() {
		return dao.findAllClient();
	}

	@Override
	public void suppClient(Client client) {
		
		dao.suppClient(client);
		
	}

	
	
	
	
}
