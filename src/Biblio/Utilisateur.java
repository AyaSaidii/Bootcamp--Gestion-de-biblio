package Biblio;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String id;

    // Constructeur
    public Utilisateur(String nom, String prenom, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getId() { return id; }

    // Affichage de l'utilisateur
    @Override
    public String toString() {
        return prenom + " " + nom + " (ID: " + id + ")";
    }
}
