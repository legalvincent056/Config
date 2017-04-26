package service;

import javax.inject.Inject;
import javax.inject.Named;

import dao.IDao;
import metier.Client;
@Named
public class ServiceImpl implements IService {

	@Inject
	private IDao dao;

	
	public long addClient(Client c) {
		return dao.addClient(c);
	}

}
