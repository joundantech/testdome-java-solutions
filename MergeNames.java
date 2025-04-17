import java.util.*;
import java.util.stream.*;

/**
 * Problème : Fusionner deux tableaux de noms en éliminant les doublons
 * Exemples :
 * - ["Ava", "Emma", "Olivia"] + ["Olivia", "Sophia", "Emma"]
 *   → ["Ava", "Emma", "Olivia", "Sophia"]
 * - ["Paul", "Jean"] + ["Pierre", "Jean"]
 *   → ["Paul", "Jean", "Pierre"]
 */
public class MergeNames {
    
    /**
     * Solution 1 - Avec ArrayList
     * Description : 
     * - Parcourt les tableaux et ajoute les éléments uniques dans une List
     * - Complexité : O(n²) à cause de contains() sur ArrayList
     * Cas d'usage : 
     * - Bon pour l'apprentissage
     * - À éviter pour les grandes listes
     */
    public static String[] uniqueNamesWithList(String[] names1, String[] names2) {
        List<String> result = new ArrayList<>();
        
        for (String name : names1) {
            if (!result.contains(name)) {
                result.add(name);
            }
        }
        
        for (String name : names2) {
            if (!result.contains(name)) {
                result.add(name);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    /**
     * Solution 2 - Avec HashSet
     * Description :
     * - Utilise un Set pour garantir l'unicité automatiquement
     * - Complexité : O(n) grâce à la HashSet
     * Cas d'usage :
     * - Solution optimale avant Java 8
     * - Meilleure performance que ArrayList
     */
    public static String[] uniqueNamesWithSet(String[] names1, String[] names2) {
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.addAll(Arrays.asList(names1));
        uniqueNames.addAll(Arrays.asList(names2));
        return uniqueNames.toArray(new String[0]);
    }
    
    /**
     * Solution 3 - Avec Streams (recommandée)
     * Description :
     * - Utilise l'API Stream de Java 8+
     * - Combine les tableaux, élimine les doublons et collecte le résultat
     * - Complexité : O(n) (utilise un Set en interne)
     * Cas d'usage :
     * - Code le plus concis et lisible
     * - Solution moderne recommandée
     */
    public static String[] uniqueNamesWithStream(String[] names1, String[] names2) {
        return Stream.concat(Arrays.stream(names1), Arrays.stream(names2))
                   .distinct()
                   .toArray(String[]::new);
    }
    
    public static void main(String[] args) {
        String[] names1 = {"Ava", "Emma", "Olivia"};
        String[] names2 = {"Olivia", "Sophia", "Emma"};
        
        System.out.println("=== Exemple 1 ===");
        System.out.println("Entrée : [" + String.join(", ", names1) + "] + [" 
                         + String.join(", ", names2) + "]");
        
        System.out.println("\nArrayList : " 
                         + String.join(", ", uniqueNamesWithList(names1, names2)));
        System.out.println("HashSet   : " 
                         + String.join(", ", uniqueNamesWithSet(names1, names2)));
        System.out.println("Streams   : " 
                         + String.join(", ", uniqueNamesWithStream(names1, names2)));
        
    }
}
