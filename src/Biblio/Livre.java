package Biblio;
public class Livre {
    private String titre;
    private String auteur;
    private String categorie;
    private boolean emprunte;
    private Utilisateur emprunteur; // Nouvelle propriété

    // Constructeur
    public Livre(String titre, String auteur, String categorie) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.emprunte = false;
        this.emprunteur = null; // Pas d'emprunteur au début
    }

    // Getters
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public String getCategorie() { return categorie; }
    public boolean isEmprunte() { return emprunte; }
    public Utilisateur getEmprunteur() { return emprunteur; }

    // Méthodes pour l'emprunt
    public void emprunter(Utilisateur utilisateur) {
        this.emprunte = true;
        this.emprunteur = utilisateur;
    }

    public void retourner() {
        this.emprunte = false;
        this.emprunteur = null;
    }

    // Affichage du livre
    @Override
    public String toString() {
        if (emprunte && emprunteur != null) {
            return "[EMPRUNTÉ par " + emprunteur + "] " + titre + " - " + auteur + " (" + categorie + ")";
        } else {
            return "[DISPONIBLE] " + titre + " - " + auteur + " (" + categorie + ")";
        }
    }
}


