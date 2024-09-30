import java.util.Scanner;

public class CalculRendement {
    public static void main(String[] args) {
        // J'utilise Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        double amount = 0;
        double rate = 0;
        int years = 0;
        double fees = 0;
        int interestType = 0;

        // Je demande à l'utilisateur d'entrer le montant investi et vérifie qu'il est positif
        while (amount <= 0) {
            System.out.print("Montant investi (doit être positif) : ");
            amount = scanner.nextDouble();
            if (amount <= 0) {
                System.out.println("Erreur : Le montant investi doit être supérieur à zéro.");
            }
        }

        // Je demande à l'utilisateur d'entrer le taux d'intérêt en pourcentage et vérifie qu'il est positif
        while (rate <= 0) {
            System.out.print("Taux d'intérêt (en %, doit être positif) : ");
            rate = scanner.nextDouble();
            if (rate <= 0) {
                System.out.println("Erreur : Le taux d'intérêt doit être supérieur à zéro.");
            }
        }

        // Je demande à l'utilisateur d'entrer la durée de l'investissement en années et vérifie qu'elle est positive
        while (years <= 0) {
            System.out.print("Durée de l'investissement (en années, doit être positive) : ");
            years = scanner.nextInt();
            if (years <= 0) {
                System.out.println("Erreur : La durée de l'investissement doit être supérieure à zéro.");
            }
        }

        // Je demande à l'utilisateur d'entrer les frais de gestion en pourcentage et vérifie qu'ils sont positifs
        while (fees < 0) {
            System.out.print("Frais de gestion (en %, doit être positif ou zéro) : ");
            fees = scanner.nextDouble();
            if (fees < 0) {
                System.out.println("Erreur : Les frais de gestion doivent être supérieurs ou égaux à zéro.");
            }
        }

        // Je demande à l'utilisateur de choisir le type d'intérêt (simple ou composé) et vérifie qu'il est valide
        while (interestType != 1 && interestType != 2) {
            System.out.print("Type d'intérêt (1 pour simple, 2 pour composé) : ");
            interestType = scanner.nextInt();
            if (interestType != 1 && interestType != 2) {
                System.out.println("Erreur : Le type d'intérêt doit être 1 (simple) ou 2 (composé).");
            }
        }

        // Je calcule le montant net après application des frais de gestion
        double netAmount = amount * (1 - (fees / 100)); // Appliquer les frais
        double total;

        // Je calcule le rendement en fonction du type d'intérêt choisi
        if (interestType == 1) {
            // Si l'utilisateur a choisi l'intérêt simple
            total = netAmount * (1 + (rate / 100) * years);
        } else {
            // Si l'utilisateur a choisi l'intérêt composé
            total = netAmount * Math.pow(1 + (rate / 100), years);
        }

        // J'affiche le rendement total après la durée spécifiée
        System.out.printf("Rendement total après %d ans : %.2f €%n", years, total);
        
        // Je ferme le scanner pour éviter les fuites de ressources
        scanner.close();
    }
}