package org.monapplijdbc.service;

import com.gtm.monapplijdbc.dao.Dao;
import com.gtm.monapplijdbc.dao.IDao;
import com.gtm.monapplijdbc.metier.Client;

public class ServiceImpl implements IService {

	private IDao dao = new Dao();

	@Override
	public long addClient(Client c) {
		return dao.addClient(c);
	}


}
