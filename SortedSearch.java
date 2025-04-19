/**
 * TestDome - Java Question: Sorted Search
 *
 * Énoncé :
 * Écrivez une fonction `countNumbers(int[] sortedArray, int lessThan)`
 * qui retourne combien d'éléments dans `sortedArray` (trié en ordre croissant)
 * sont strictement inférieurs à `lessThan`.
 *
 * Vous devez utiliser une recherche binaire pour obtenir une complexité en O(log n).
 *
 * Exemple :
 * - countNumbers([1, 3, 5, 7], 4) → 2, car seuls 1 et 3 sont strictement inférieurs à 4.
 */

public class SortedSearch {

    /**
     * Utilise une recherche binaire pour trouver le nombre d'éléments 
     * strictement inférieurs à `lessThan` dans un tableau trié.
     *
     * @param sortedArray tableau trié en ordre croissant
     * @param lessThan valeur seuil
     * @return nombre d'éléments < lessThan
     */
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int left = 0;
        int right = sortedArray.length - 1;

        // Recherche binaire pour trouver la première position où un élément >= lessThan apparaît
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] < lessThan) {
                left = mid + 1; // continuer à droite
            } else {
                right = mid - 1; // continuer à gauche
            }
        }

        // À la fin, `left` est l’indice du premier élément >= lessThan
        // donc le nombre d’éléments < lessThan est exactement `left`
        return left;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4)); // Résultat attendu : 2
    }
}
