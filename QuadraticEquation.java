/**
 * Problème : Résolution d'équations quadratiques de la forme ax² + bx + c = 0
 * Exemples :
 * - 2x² + 10x + 8 = 0 → Racines (-1.0, -4.0)
 * - x² - 5x + 6 = 0 → Racines (3.0, 2.0)
 * - x² + x + 1 = 0 → Lance une exception (pas de racines réelles)
 */
public class QuadraticEquation {

    /**
     * Calcule les racines d'une équation quadratique
     * @param a Coefficient quadratique (doit être ≠ 0)
     * @param b Coefficient linéaire
     * @param c Terme constant
     * @return Objet Roots contenant les deux racines
     * @throws IllegalArgumentException Si pas de racines réelles ou a = 0
     */
    public static Roots findRoots(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Le coefficient 'a' ne peut pas être nul");
        }

        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            throw new IllegalArgumentException("Pas de racines réelles (discriminant négatif)");
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double x1 = (-b + sqrtDiscriminant) / (2 * a);
        double x2 = (-b - sqrtDiscriminant) / (2 * a);
        
        return new Roots(x1, x2);
    }

    public static void main(String[] args) {
        // Exemple 1
        Roots roots1 = findRoots(2, 10, 8);
        System.out.println("2x² + 10x + 8 = 0 → Racines: " + roots1.x1 + ", " + roots1.x1);

        // Exemple 2
        Roots roots2 = findRoots(1, -5, 6);
        System.out.println("x² - 5x + 6 = 0 → Racines: " + roots2.x1 + ", " + roots2.x2);

        // Exemple 3 (erreur)
        try {
            findRoots(1, 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("x² + x + 1 = 0 → " + e.getMessage());
        }
    }
}

/**
 * Conteneur immuable pour les racines d'une équation quadratique
 */
class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
