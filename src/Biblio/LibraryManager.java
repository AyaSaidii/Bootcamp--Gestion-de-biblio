package Biblio;
import java.util.*;
import java.util.*;

import java.util.*;

public class LibraryManager {
    private List<Livre> livres;
    private Scanner scanner;

    // Constructeur
    public LibraryManager() {
        livres = new ArrayList<>();
        scanner = new Scanner(System.in);
        // Ajouter quelques livres par défaut pour tester
        ajouterLivresParDefaut();
    }

    // Ajouter des livres par défaut
    private void ajouterLivresParDefaut() {
        livres.add(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", "Roman"));
        livres.add(new Livre("1984", "George Orwell", "Science-fiction"));
        livres.add(new Livre("L'Étranger", "Albert Camus", "Philosophie"));
    }

    // Ajouter un livre
    public void ajouterLivre() {
        System.out.print("Titre du livre : ");
        String titre = scanner.nextLine();

        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();

        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine();

        livres.add(new Livre(titre, auteur, categorie));
        System.out.println("✓ Livre ajouté avec succès !");
    }

    // Lister tous les livres
    public void listerLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
            return;
        }

        System.out.println("\n=== LISTE DES LIVRES ===");
        for (int i = 0; i < livres.size(); i++) {
            System.out.println((i + 1) + ". " + livres.get(i));
        }
    }

    // Rechercher par catégorie
    public void rechercherParCategorie() {
        System.out.print("Catégorie à rechercher : ");
        String categorie = scanner.nextLine();

        System.out.println("\n=== RÉSULTATS POUR : " + categorie + " ===");
        boolean trouve = false;

        for (Livre livre : livres) {
            if (livre.getCategorie().toLowerCase().contains(categorie.toLowerCase())) {
                System.out.println("- " + livre);
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun livre trouvé dans cette catégorie.");
        }
    }

    // Emprunter un livre
    public void emprunterLivre() {
        listerLivres();

        System.out.print("Numéro du livre à emprunter : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < livres.size()) {
                Livre livre = livres.get(index);
                if (!livre.isEmprunte()) {
                    // Demander les informations de l'emprunteur
                    System.out.println("\n--- INFORMATIONS DE L'EMPRUNTEUR ---");
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();

                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();

                    System.out.print("ID : ");
                    String id = scanner.nextLine();

                    // Créer l'utilisateur et emprunter le livre
                    Utilisateur emprunteur = new Utilisateur(nom, prenom, id);
                    livre.emprunter(emprunteur);

                    System.out.println("✓ Livre emprunté avec succès !");
                    System.out.println("📖 Livre : " + livre.getTitre());
                    System.out.println("👤 Emprunteur : " + emprunteur);
                } else {
                    System.out.println("❌ Ce livre est déjà emprunté par : " + livre.getEmprunteur());
                }
            } else {
                System.out.println("❌ Numéro invalide !");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Veuillez entrer un numéro valide !");
        }
    }

    // Retourner un livre
    public void retournerLivre() {
        System.out.println("\n=== LIVRES EMPRUNTÉS ===");
        List<Livre> empruntes = new ArrayList<>();

        for (Livre livre : livres) {
            if (livre.isEmprunte()) {
                empruntes.add(livre);
            }
        }

        if (empruntes.isEmpty()) {
            System.out.println("Aucun livre emprunté.");
            return;
        }

        for (int i = 0; i < empruntes.size(); i++) {
            System.out.println((i + 1) + ". " + empruntes.get(i));
        }

        System.out.print("Numéro du livre à retourner : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < empruntes.size()) {
                Livre livre = empruntes.get(index);
                livre.retourner();
                System.out.println("✓ Livre retourné : " + livre.getTitre());
            } else {
                System.out.println("❌ Numéro invalide !");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Veuillez entrer un numéro valide !");
        }

    }
}