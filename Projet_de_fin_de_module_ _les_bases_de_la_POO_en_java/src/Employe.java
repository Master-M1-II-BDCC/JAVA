// Définition de la classe Employe
class Employe {
    // Déclaration des attributs privés de l'employé
    private int id;          // Identifiant unique de l'employé
    private String nom;      // Nom de l'employé
    private String poste;    // Poste ou fonction de l'employé
    private double salaire;  // Salaire de l'employé

    // Constructeur paramétré permettant d'initialiser un employé avec des valeurs spécifiques
    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;         // Affectation de l'identifiant
        this.nom = nom;       // Affectation du nom
        this.poste = poste;   // Affectation du poste
        this.salaire = salaire; // Affectation du salaire
    }

    // Constructeur par défaut (sans paramètres), utile pour créer un employé sans initialisation
    public Employe() {
    }

    // Méthode getter pour obtenir l'identifiant de l'employé
    public int getId() {
        return id;
    }

    // Méthode setter pour modifier l'identifiant de l'employé
    public void setId(int id) {
        this.id = id;
    }

    // Méthode getter pour obtenir le nom de l'employé
    public String getNom() {
        return nom;
    }

    // Méthode setter pour modifier le nom de l'employé
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode getter pour obtenir le poste de l'employé
    public String getPoste() {
        return poste;
    }

    // Méthode setter pour modifier le poste de l'employé
    public void setPoste(String poste) {
        this.poste = poste;
    }

    // Méthode getter pour obtenir le salaire de l'employé
    public double getSalaire() {
        return salaire;
    }

    // Méthode setter pour modifier le salaire de l'employé
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // Redéfinition de la méthode toString() pour retourner une représentation textuelle de l'objet
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", salaire=" + salaire +
                '}';
    }

    // Méthode statique permettant de comparer deux employés par leur salaire
    public static int compareParSalaire(Employe e1, Employe e2) {
        return Double.compare(e1.getSalaire(), e2.getSalaire()); // Compare les salaires des employés
    }
}
