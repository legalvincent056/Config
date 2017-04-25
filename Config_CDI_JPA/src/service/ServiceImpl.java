package service;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class ServiceImpl implements IService {

	@Inject
	private IDao dao;

	@Override
	public long addClient(Client c) {
		return dao.addClient(c);
	}

}
