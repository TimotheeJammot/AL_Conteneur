package services;

import java.util.Properties;

public interface GestionComposant {
    void creerComposant(Properties properties, UserComponent userComponent);

    void supprimerComposant(String properties);
}
