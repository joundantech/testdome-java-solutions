import java.util.ArrayList;
import java.util.List;

/**
 * Problème : Générer toutes les combinaisons possibles de glaces
 * Règles :
 * - Chaque ingrédient est combiné avec chaque topping
 * - Retourne une liste vide si aucun ingrédient ou topping
 * Exemple :
 * - Ingredients ["vanille", "chocolat"] + topping ["sauce chocolat"]
 *   → ["vanille, sauce chocolat", "chocolat, sauce chocolat"]
 */
public class IceCreamMachine {
    private final String[] ingredients;
    private final String[] toppings;

    public static class IceCream {
        public final String ingredient;
        public final String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredients, String[] toppings) {
        this.ingredients = ingredients != null ? ingredients : new String[0];
        this.toppings = toppings != null ? toppings : new String[0];
    }

    public List<IceCream> scoops() {
        List<IceCream> combinations = new ArrayList<>();
        
        for (String ingredient : ingredients) {
            for (String topping : toppings) {
                combinations.add(new IceCream(ingredient, topping));
            }
        }
        
        return combinations;
    }

    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine(
            new String[]{"vanilla", "chocolate"},
            new String[]{"chocolate sauce"}
        );

        machine.scoops().forEach(iceCream ->
            System.out.println(iceCream.ingredient + ", " + iceCream.topping)
        );
    }
}
