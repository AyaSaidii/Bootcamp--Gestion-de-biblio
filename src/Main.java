import Biblio.LibraryManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🏛️  BIENVENUE DANS LE GESTIONNAIRE DE BIBLIOTHÈQUE");
        System.out.println("=================================================");

        while (true) {
            afficherMenu();

            System.out.print("Votre choix : ");
            String choix = scanner.nextLine();

            System.out.println(); // Ligne vide pour la lisibilité

            switch (choix) {
                case "1":
                    library.ajouterLivre();
                    break;

                case "2":
                    library.listerLivres();
                    break;

                case "3":
                    library.rechercherParCategorie();
                    break;

                case "4":
                    library.emprunterLivre();
                    break;

                case "5":
                    library.retournerLivre();
                    break;

                case "0":
                    System.out.println("👋 Au revoir !");
                    return;

                default:
                    System.out.println("❌ Choix invalide ! Veuillez réessayer.");
            }

            System.out.println("\nAppuyez sur Entrée pour continuer...");
            scanner.nextLine();
            clearScreen();
        }
    }

    private static void afficherMenu() {
        System.out.println("\n📚 === MENU PRINCIPAL ===");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Lister tous les livres");
        System.out.println("3. Rechercher par catégorie");
        System.out.println("4. Emprunter un livre");
        System.out.println("5. Retourner un livre");
        System.out.println("0. Quitter");
        System.out.println("========================");
    }

    // Nettoyer l'écran (marche sur la plupart des terminaux)
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
            }
        } catch (Exception e) {
            // Si ça marche pas, on affiche juste des lignes vides
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}