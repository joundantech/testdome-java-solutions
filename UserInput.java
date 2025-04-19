/**
 * TestDome - Java Question: User Input
 *
 * Énoncé :
 * Implémentez deux classes `TextInput` et `NumericInput` :
 *
 * - `TextInput` permet d'ajouter n'importe quel caractère via la méthode `add(char c)`
 * - `NumericInput` hérite de `TextInput` mais ne doit permettre l’ajout que de chiffres (0 à 9)
 *
 * La méthode `getValue()` retourne l’ensemble des caractères ajoutés sous forme de chaîne.
 *
 * Exemple :
 * TextInput input = new NumericInput();
 * input.add('1');
 * input.add('a');
 * input.add('0');
 * System.out.println(input.getValue()); // Doit afficher "10"
 */

public class UserInput {

    /**
     * Classe de base qui accepte tous les caractères.
     */
    public static class TextInput {
        protected String value = "";

        // Ajoute n’importe quel caractère à la chaîne
        public void add(char c) {
            value += c;
        }

        // Retourne la chaîne construite
        public String getValue() {
            return value;
        }
    }

    /**
     * Classe dérivée qui n’accepte que les chiffres.
     */
    public static class NumericInput extends TextInput {

        // Redéfinit la méthode add pour filtrer les caractères non numériques
        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                value += c;
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput(); // On peut utiliser le polymorphisme
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue()); // Résultat : "10"
    }
}
