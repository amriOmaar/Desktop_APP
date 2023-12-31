
package ijacampi.Entities;

/**
 *
 * @author Omar Amri
 */
public class Moyen_Transport {
    
    private int id_transport;
    int nbr_place ;
    //Utilisateur user;
    String type, matricule, marque;
    double frais;

    public Moyen_Transport() {
    }

    public Moyen_Transport(int id_transport, int nbr_place, String type, String matricule, String marque, double frais) {
        this.id_transport = id_transport;
        this.nbr_place = nbr_place;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.frais = frais;
    }

    
    
    
    
    public Moyen_Transport(String type, String matricule, String marque, int nbr_place, double frais) {
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.nbr_place = nbr_place;
        this.frais = frais;
        
    }

    public Moyen_Transport(int nbr_place, String type, String matricule, String marque, double frais) {
        this.nbr_place = nbr_place;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.frais = frais;
    }

    public Moyen_Transport(String matricule) {
        this.matricule = matricule;
    }

    public Moyen_Transport(int id, String type, String matricule, String marque, int nbr_place, double frais) {
        this.id_transport=id;
        this.nbr_place = nbr_place;
        this.type = type;
        this.matricule = matricule;
        this.marque = marque;
        this.frais = frais;
    }
    
    
    

    public int getId_transport() {
        return id_transport;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public double getFrais() {
        return frais;
    }
    
    

    public String getType() {
        return type;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }
    
    
    
    public void setType(String type) {
        this.type = type;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Moyen_Transport{" + "id_transport=" + id_transport + ", nbr_place=" + nbr_place + ", type=" + type + ", matricule=" + matricule + ", marque=" + marque + ", frais=" + frais + '}';
    }
    
    
    
    
    
}
