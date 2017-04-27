package service;

import dao.Dao;
import dao.IDao;
import metier.Client;

public class ServiceImpl implements IService {

	private IDao dao = new Dao();

	@Override
	public long addClient(Client c) {
		return dao.addClient(c);
	}


}
