import java.util.Arrays;
import java.util.Scanner;

// Classe principale pour la gestion des employés
public class GestionEmployes {
    // Déclaration d'un tableau statique pour stocker les employés (limité à 50 employés)
    private static Employe[] employes = new Employe[50];
    private static int nombreEmployes = 0; // Nombre actuel d'employés enregistrés
    private static Scanner scanner = new Scanner(System.in); // Scanner pour la saisie utilisateur

    // Méthode principale (point d'entrée du programme)
    public static void main(String[] args) {
        int choix;
        do {
            printMenu(); // Afficher le menu principal
            choix = scanner.nextInt(); // Lire le choix de l'utilisateur
            scanner.nextLine(); // Absorber la ligne restante

            // Structure de contrôle pour exécuter l'action choisie par l'utilisateur
            switch (choix) {
                case 1 -> ajouterEmploye();
                case 2 -> modifierEmploye();
                case 3 -> supprimerEmploye();
                case 4 -> afficherEmployes();
                case 5 -> rechercherEmploye();
                case 6 -> calculerMasseSalariale();
                case 7 -> trierEmployesParSalaire();
                case 8 -> System.out.println("Quitter...");
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 8); // Répéter jusqu'à ce que l'utilisateur choisisse de quitter
    }

    // Afficher le menu principal
    public static void printMenu() {
        System.out.println("\n--- Menu Gestion des Employés ---");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher la liste des employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print("Votre choix : ");
    }

    // Ajouter un nouvel employé
    public static void ajouterEmploye() {
        if (nombreEmployes >= 50) {
            System.out.println("Le tableau des employés est plein.");
            return;
        }

        // Saisie des informations de l'employé
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Poste: ");
        String poste = scanner.nextLine();
        System.out.print("Salaire: ");
        double salaire = scanner.nextDouble();

        // Ajout de l'employé dans le tableau
        employes[nombreEmployes++] = new Employe(id, nom, poste, salaire);
        System.out.println("Employé ajouté avec succès !");
    }

    // Modifier un employé existant
    public static void modifierEmploye() {
        System.out.print("ID de l'employé à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        // Recherche de l'employé par ID
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                // Saisie des nouvelles valeurs
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau poste : ");
                String poste = scanner.nextLine();
                System.out.print("Nouveau salaire : ");
                double salaire = scanner.nextDouble();

                // Mise à jour des informations de l'employé
                employes[i].setNom(nom);
                employes[i].setPoste(poste);
                employes[i].setSalaire(salaire);
                System.out.println("Modification réussie !");
                return;
            }
        }
        System.out.println("Employé introuvable.");
    }

    // Supprimer un employé en fonction de son ID
    public static void supprimerEmploye() {
        System.out.print("ID de l'employé à supprimer : ");
        int id = scanner.nextInt();

        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                // Remplace l'employé à supprimer par le dernier employé du tableau
                employes[i] = employes[nombreEmployes - 1];
                employes[nombreEmployes - 1] = null;
                nombreEmployes--; // Décrémentation du nombre d'employés
                System.out.println("Employé supprimé avec succès !");
                return;
            }
        }
        System.out.println("Employé introuvable.");
    }

    // Afficher la liste des employés
    public static void afficherEmployes() {
        if (nombreEmployes == 0) {
            System.out.println("Aucun employé enregistré.");
            return;
        }
        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println(employes[i]);
        }
    }

    // Rechercher un employé par nom ou poste
    public static void rechercherEmploye() {
        System.out.print("Saisie nom ou poste à rechercher : ");
        String critere = scanner.nextLine().toLowerCase(); // Convertir en minuscules pour éviter la casse

        for (int i = 0; i < nombreEmployes; i++) {
            // Vérifier si le nom ou le poste contient le critère recherché
            if (employes[i].getNom().toLowerCase().contains(critere) || employes[i].getPoste().toLowerCase().contains(critere)) {
                System.out.println(employes[i]);
            }
        }
    }

    // Calculer et afficher la masse salariale totale
    public static void calculerMasseSalariale() {
        double total = 0;
        for (int i = 0; i < nombreEmployes; i++) {
            total += employes[i].getSalaire();
        }
        System.out.println("Masse salariale totale : " + total);
    }

    // Trier les employés par salaire en ordre croissant ou décroissant
    public static void trierEmployesParSalaire() {
        System.out.print("Ordre croissant (true) ou décroissant (false) ? ");
        boolean ordreCroissant = scanner.nextBoolean();

        // Tri des employés avec Arrays.sort et une expression lambda pour comparer les salaires
        Arrays.sort(employes, 0, nombreEmployes, (e1, e2) ->
                ordreCroissant ? Employe.compareParSalaire(e1, e2) : Employe.compareParSalaire(e2, e1)
        );

        afficherEmployes(); // Afficher la liste triée
    }
}
