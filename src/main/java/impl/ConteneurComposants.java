package impl;

import services.OCComponent;
import services.OCService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
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

    public void creerComposant(Properties properties, Object userComponent) {
    	JavaComponent javaComponent = new JavaComponent(properties, userComponent);
        this.nouveauxComposants.add(javaComponent);
    }

    public void supprimerComposant(String id) {
    	OCComponent composant;
    	
    	composant = trouverComposant(id, nouveauxComposants);
    	if (composant != null) {
            this.actuelsComposants.remove(composant);
            this.supprimesComposants.add(composant);
            return;
    	}

    	composant = trouverComposant(id, actuelsComposants);
    	if (composant != null) {
            this.nouveauxComposants.remove(composant);
            this.supprimesComposants.add(composant);
    		
    	}
    }

    public OCComponent trouverComposant(String id, Set<OCComponent> setComposants) {
    	OCComponent composant = null;
    	
    	for (OCComponent tempComp : setComposants) {
    		if (tempComp.getComponentProperty("id").equals(id)) {
    			composant = tempComp;
    			break;
    		}
    	}
    	
    	return composant;
    }
    
    public Set<OCComponent> getNouveauxComposants() {
        Set<OCComponent> set = nouveauxComposants;
        this.actuelsComposants.addAll(this.nouveauxComposants);
        this.nouveauxComposants = new HashSet<OCComponent>();
        
        return set;
    }

    public Set<OCComponent> getActuelsComposants() {
    	Set<OCComponent> tempSet = new HashSet<OCComponent>();
    	tempSet.addAll(actuelsComposants);
    	tempSet.addAll(nouveauxComposants);
    	
    	return tempSet;
    }
    
    public Set<OCComponent> getDisappearedComposants() {
    	return supprimesComposants;
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
        iter = this.actuelsComposants.iterator();
        while (iter.hasNext()) {
            OCComponent comp = iter.next();
            set.addAll(comp.getRequiredServices());
            set.addAll(comp.getProvidedServices());
        }

        return set;
    }
    
    public Set<OCService> getDisappearedServices() {
        Set<OCService> set = new HashSet<>();
        Iterator<OCComponent> iter = this.supprimesComposants.iterator();
        while (iter.hasNext()) {
            OCComponent comp = iter.next();
            set.addAll(comp.getRequiredServices());
            set.addAll(comp.getProvidedServices());
        }

        //Sets

        return set;
    }
}
