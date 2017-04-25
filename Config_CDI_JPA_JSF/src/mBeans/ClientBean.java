package mBeans;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import service.IService;

//@ManagedBean // JSF
// @ManagedBean(name="clientBean")
// @SessionScoped // JSF
@Named // pour dire que c'est un Bean dans le conteneur de CDI
@ViewScoped // JSF
public class ClientBean {

	/* ----------------- Attributs ----------------- */

	// appel de la couche service
	@Inject
	private IService service;

	// Va distinguer si le bouton va modifier ou ajouter
	private boolean editMode = false;

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	// objet client permettant de récupérer les paramètres saisis dans le
	// formulaire
	private Client client = new Client();

	/* ----------------- Méthodes ----------------- */

	public String add() {
		if (editMode == false) { // va test la variable pour modifier l'action
									// du bouton ajouter ou modifier client
			if (!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase("")) // si nom et prenom ne sont pas vides
																									
			{
				service.addClient(client);

			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Veuillez saisir les valeurs non nulles",""));
			}

		} else {
			service.maj(client);
			editMode = false;

		}
		client = new Client();
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

	public Collection<Client> listClient() {
		return service.findAllClient();
	}

	/* Methode pour supprimer un client de la BDD */

	public void suppClient() {
		service.suppClient(client);
		client = new Client();
	}

	/* Methode de mise à jour */

	public void majClient() {
		// service.maj(client);
		editMode = true;
	}

}
