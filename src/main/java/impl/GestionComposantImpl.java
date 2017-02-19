package impl;

import services.GestionComposant;

import java.util.Properties;

public class GestionComposantImpl implements GestionComposant {
    ConteneurComposants conteneur;

    public GestionComposantImpl(ConteneurComposants conteneur) {
        this.conteneur = conteneur;
    }

    @Override
    public void creerComposant(Properties properties, Object userComponent) {
        conteneur.creerComposant(properties, userComponent);
    }

    @Override
    public void supprimerComposant(String properties) {
        conteneur.supprimerComposant(properties);
    }
}
