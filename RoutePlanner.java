/**
 * TestDome - Java Question: Route Planner
 *
 * Énoncé :
 * Une ville est représentée par une matrice `mapMatrix` de valeurs booléennes.
 * Chaque case représente une portion de terrain. Une valeur `true` indique une route praticable,
 * tandis que `false` représente un obstacle (pas de route).
 *
 * Étant donné :
 * - des coordonnées de départ (fromRow, fromColumn)
 * - des coordonnées d'arrivée (toRow, toColumn)
 * - la carte de la ville sous forme de matrice `mapMatrix`
 *
 * Implémentez la méthode `routeExists` qui détermine s’il existe un chemin
 * entre le point de départ et le point d’arrivée, uniquement en empruntant
 * les routes (cases avec `true`) et en se déplaçant dans les 4 directions
 * cardinales (haut, bas, gauche, droite).
 *
 * Contraintes :
 * - Vous ne pouvez pas sortir des limites de la matrice.
 * - Vous ne pouvez pas passer par une case contenant `false`.
 * - Retournez `true` s’il existe un chemin, sinon `false`.
 */

import java.util.*;

public class RoutePlanner {

    /**
     * Vérifie s'il existe un chemin entre deux points sur une carte représentée par une matrice.
     *
     * @param fromRow ligne de départ
     * @param fromColumn colonne de départ
     * @param toRow ligne d'arrivée
     * @param toColumn colonne d'arrivée
     * @param mapMatrix matrice représentant la carte (true = route, false = obstacle)
     * @return true si un chemin existe, false sinon
     */
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        // Vérification des coordonnées en dehors des limites
        if (!isValidCell(fromRow, fromColumn, mapMatrix) || !isValidCell(toRow, toColumn, mapMatrix)) {
            return false;
        }

        // Vérifie que les cellules de départ et d’arrivée sont praticables
        if (!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false;
        }

        // Cas où départ == arrivée
        if (fromRow == toRow && fromColumn == toColumn) {
            return true;
        }

        boolean[][] visited = new boolean[mapMatrix.length][mapMatrix[0].length];
        return dfs(fromRow, fromColumn, toRow, toColumn, mapMatrix, visited);
    }

    // Vérifie si une cellule est dans les limites et est une route
    private static boolean isValidCell(int row, int col, boolean[][] mapMatrix) {
        return row >= 0 && row < mapMatrix.length && col >= 0 && col < mapMatrix[0].length;
    }

    // Recherche récursive en profondeur (DFS)
    private static boolean dfs(int row, int col, int toRow, int toColumn,
                               boolean[][] mapMatrix, boolean[][] visited) {
        if (!isValidCell(row, col, mapMatrix) || !mapMatrix[row][col] || visited[row][col]) {
            return false;
        }

        // Si on atteint la destination
        if (row == toRow && col == toColumn) {
            return true;
        }

        visited[row][col] = true;

        // Explorer les 4 directions
        return dfs(row + 1, col, toRow, toColumn, mapMatrix, visited) || // bas
               dfs(row - 1, col, toRow, toColumn, mapMatrix, visited) || // haut
               dfs(row, col + 1, toRow, toColumn, mapMatrix, visited) || // droite
               dfs(row, col - 1, toRow, toColumn, mapMatrix, visited);   // gauche
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix)); // Doit afficher true
    }
}
