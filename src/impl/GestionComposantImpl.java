package impl;

import services.GestionComposant;
import services.OCComponent;

public class GestionComposantImpl implements GestionComposant {

	ConteneurComposants conteneur;
	
	public GestionComposantImpl(ConteneurComposants conteneur) {
		this.conteneur = conteneur;
	}
	
	@Override
	public void creerComposant(OCComponent component) {

		conteneur.creerComposant(component);
	}

	@Override
	public void supprimerComposant(OCComponent component) {

		conteneur.supprimerComposant(component);
	}

}
