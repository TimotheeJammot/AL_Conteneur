package impl;

import services.GestionComposant;
import services.OCComponent;

import java.util.List;

public class GestionComposantImpl implements GestionComposant {

	ConteneurComposants conteneur;
	
	public GestionComposantImpl(ConteneurComposants conteneur) {
		this.conteneur = conteneur;
	}
	
	@Override
	public void creerComposant(String id) {

		conteneur.creerComposant(id);
	}

	@Override
	public void supprimerComposant(String id) {

		conteneur.supprimerComposant(id);
	}

}
