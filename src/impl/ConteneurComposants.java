package impl;

import services.OCComponent;
import services.OCService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConteneurComposants {
    private Set<OCComponent> nouveauxComposants;
    private Set<OCComponent> actuelsComposants;
	private Set<OCComponent> supprimesComposants;

    public ConteneurComposants() {
        this.nouveauxComposants = new HashSet<OCComponent>();
        this.actuelsComposants = new HashSet<OCComponent>();
        this.supprimesComposants = new HashSet<OCComponent>();
    }

    public void ajouterComposant(OCComponent composant) {
        this.nouveauxComposants.add(composant);
    }

    public Set<OCComponent> getNouveauxComposants() {
        Set<OCComponent> set = nouveauxComposants;
        this.actuelsComposants.addAll(this.nouveauxComposants);
        this.nouveauxComposants = new HashSet<OCComponent>();
        return set;
    }

    public void supprimerComposant(OCComponent composant) {
        this.actuelsComposants.remove(composant);
        this.nouveauxComposants.remove(composant);
        this.supprimesComposants.add(composant);
    }

    public Set<OCService> getNouveauxServices() {
        Set<OCService> set = new HashSet<>();
        Iterator<OCComponent> iter = this.nouveauxComposants.iterator();
        while (iter.hasNext()) {
            OCComponent comp = iter.next();
            set.addAll(comp.getRequiredServices());
            set.addAll(comp.getProvidedServices());
        }

        return set;
    }

    public Set<OCService> getActuelsServices() {
        Set<OCService> set = new HashSet<>();
        Iterator<OCComponent> iter = this.nouveauxComposants.iterator();
        while (iter.hasNext()) {
            OCComponent comp = iter.next();
            set.addAll(comp.getRequiredServices());
            set.addAll(comp.getProvidedServices());
        }
        iter = this.nouveauxComposants.iterator();
        while (iter.hasNext()) {
            OCComponent comp = iter.next();
            set.addAll(comp.getRequiredServices());
            set.addAll(comp.getProvidedServices());
        }

        return set;
    }
}
