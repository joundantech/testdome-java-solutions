/**
 * TestDome - Java Question: Song (Playlist cyclique)
 *
 * Énoncé :
 * Implémentez une méthode `isInRepeatingPlaylist` qui détecte si une playlist est cyclique.
 *
 * Chaque chanson est représentée par un objet `Song` qui peut pointer vers la chanson suivante
 * dans une liste chaînée. La méthode doit renvoyer `true` si la playlist contient une boucle,
 * c’est-à-dire qu’en suivant les `nextSong`, on repasse par une chanson déjà rencontrée.
 * Sinon, elle doit renvoyer `false`.
 *
 * Exemple :
 * - A → B → C → D → null → non cyclique → false
 * - A → B → C → A (retour vers A) → cyclique → true
 *
 * Cette détection de cycle est similaire à celle utilisée sur les listes chaînées classiques.
 */

package testDome;

import java.util.HashSet;
import java.util.Set;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    /**
     * Vérifie si la playlist contient une boucle en utilisant un ensemble (HashSet)
     * pour détecter si une chanson a déjà été visitée.
     *
     * @return true si une boucle est détectée, sinon false
     */
    public boolean isInRepeatingPlaylist() {
        Set<Song> visited = new HashSet<>();
        Song currentSong = this;

        while (currentSong != null) {
            if (visited.contains(currentSong)) {
                return true; // boucle détectée
            }
            visited.add(currentSong);
            currentSong = currentSong.nextSong;
        }

        return false; // pas de boucle
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first); // boucle créée

        System.out.println(first.isInRepeatingPlaylist()); // Affiche true
    }
}
