package services;

import java.util.Properties;

public interface GestionComposant {
    void creerComposant(Properties properties, Object userComponent);

    void supprimerComposant(String properties);
}
