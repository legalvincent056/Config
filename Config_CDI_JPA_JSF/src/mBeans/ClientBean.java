package mBeans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import service.IService;

@ManagedBean // JSF
// @ManagedBean(name="clientBean")
//@SessionScoped // JSF
@Named // pour dire que c'est un Bean dans le conteneur de CDI
@ViewScoped //JSF
public class ClientBean {

	/* ----------------- Attributs ----------------- */

	// appel de la couche service
	@Inject
	private IService service;

	// objet client permettant de récupérer les paramètres saisis dans le
	// formulaire
	private Client client = new Client();

	/* ----------------- Méthodes ----------------- */

	public String add() {
		service.addClient(client);
		client = new Client();
		System.out.println(client.getNom() + client.getPrenom());
		return "index";
	}

	/* ----------------- Getters & Setters ----------------- */

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	/* Methode pour avoir la liste des clients de la BDD */
	
	public Collection<Client> listClient(){
		return service.findAllClient();
	}
	
	/*Methode pour supprimer un client de la BDD*/
	
	public void suppClient(){
		service.suppClient(client);
		
	}

}
