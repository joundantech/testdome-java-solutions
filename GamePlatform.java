/**
 * Problème : Calcul de vitesse finale d'un objet sur une plateforme
 * Règles :
 * - La vitesse change selon l'inclinaison (positive = ralentit, négative = accélère)
 * - La vitesse ne peut pas devenir négative (s'arrête à 0)
 * Exemple :
 * - Vitesse 60.0 avec inclinations [0, 30, 0, -45, 0] → 75.0
 */
public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;
        
        for (int incl : inclinations) {
            speed -= incl;
            if (speed <= 0) return 0;
        }
        
        return speed;
    }

    public static void main(String[] args) {
        System.out.println(calculateFinalSpeed(60.0, new int[] {0, 30, 0, -45, 0})); // 75.0
        System.out.println(calculateFinalSpeed(10.0, new int[] {20, 30})); // 0.0
        System.out.println(calculateFinalSpeed(50.0, new int[] {-10, -20})); // 80.0
    }
}
