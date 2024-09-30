import java.util.Scanner;

public class CalculRendement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demander les informations à l'utilisateur
        System.out.print("Montant investi : ");
        double amount = scanner.nextDouble();

        System.out.print("Taux d'intérêt (en %) : ");
        double rate = scanner.nextDouble();

        System.out.print("Durée de l'investissement (en années) : ");
        int years = scanner.nextInt();

        System.out.print("Frais de gestion (en %) : ");
        double fees = scanner.nextDouble();

        System.out.print("Type d'intérêt (1 pour simple, 2 pour composé) : ");
        int interestType = scanner.nextInt();

        // Calcul du rendement
        double netAmount = amount * (1 - (fees / 100)); // Appliquer les frais
        double total;

        if (interestType == 1) {
            // Intérêt simple
            total = netAmount * (1 + (rate / 100) * years);
        } else {
            // Intérêt composé
            total = netAmount * Math.pow(1 + (rate / 100), years);
        }

        // Affichage du résultat
        System.out.printf("Rendement total après %d ans : %.2f €%n", years, total);
        
        scanner.close();
    }
}
