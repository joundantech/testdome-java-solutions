/**
 * TestDome - Java Question: Two Sum
 *
 * Énoncé :
 * Implémentez une méthode `findTwoSum(int[] list, int sum)` qui retourne les indices
 * de deux éléments d’un tableau dont la somme est égale à la valeur donnée `sum`.
 *
 * Si aucun couple ne donne cette somme, retournez `null`.
 *
 * Exemple :
 * - findTwoSum([3, 1, 5, 7, 5, 9], 10) → [1, 4], car 1 + 9 = 10 (ou 5 + 5)
 *
 * La solution doit être efficace (O(n)), donc on utilisera une table de hachage (HashMap)
 * pour stocker les compléments déjà vus.
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Cherche deux indices d'éléments du tableau dont la somme donne `sum`.
     * @param list tableau d’entiers
     * @param sum somme cible
     * @return tableau de 2 indices, ou null si aucun couple trouvé
     */
    public static int[] findTwoSum(int[] list, int sum) {
        if (list == null || list.length < 2) {
            return null;
        }

        // Map pour stocker les éléments déjà parcourus (valeur → index)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.length; i++) {
            int complement = sum - list[i]; // Ce qu’il faut pour compléter la somme

            // Si on a déjà vu le complément, on a trouvé une paire
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Sinon, on enregistre la valeur courante
            map.put(list[i], i);
        }

        // Aucun couple trouvé
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]); // Exemple : 1 5
        }
    }
}
