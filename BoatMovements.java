/**
 * Problème : Déplacement de bateau dans une grille maritime
 * Règles :
 * - Horizontal : 1-2 cases à droite OU 1 case à gauche
 * - Vertical : 1 case haut/bas seulement
 * - Ne peut traverser que des cases maritimes (true)
 */

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
    int rows = gameMatrix.length;
    int cols = gameMatrix[0].length;

        if(fromRow >= rows || fromColumn >= cols || toRow >= rows || toColumn >= cols)
            return false;
        if(fromRow == toRow && fromColumn == toColumn)
            return false;

        // Vérifie les règles de déplacement : pas de diagonale, et distance autorisée
        boolean horizontal = fromRow == toRow && Math.abs(toColumn - fromColumn) <= 2 && (fromColumn - toColumn) <= 1;
        boolean vertical = fromColumn == toColumn && Math.abs(toRow - fromRow) == 1;

        if(!horizontal && !vertical)
            return false;

        if(horizontal) {
            int start = Math.min(fromColumn, toColumn);
            int end = Math.max(fromColumn, toColumn);
            for (int i = start; i <= end; i++) {
                if(!gameMatrix[fromRow][i])
                    return false;
            }
        }
            else if(vertical) {
                int start = Math.min(fromRow, toRow);
                int end = Math.max(fromRow, toRow);
                for (int i = start; i <= end; i++) {
                    if (!gameMatrix[i][fromColumn])
                        return false;
                }
            }

        return true;
    }


    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                {false, true,  true,  false, false, false},
                {true,  true,  true,  false, false, false},
                {true,  true,  true,  true,  true,  true},
                {false, true,  true,  false, true,  true},
                {false, true,  true,  true,  false, true},
                {false, false, false, false, false, false},
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}
