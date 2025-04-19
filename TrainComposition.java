/**
 * TestDome - Java Question: Train Composition
 *
 * Énoncé :
 * Implémentez une classe `TrainComposition` qui gère l'attachement et le détachement
 * de wagons à gauche ou à droite d’un train.
 *
 * - `attachWagonFromLeft(int wagonId)` : ajoute un wagon à l'avant du train.
 * - `attachWagonFromRight(int wagonId)` : ajoute un wagon à l'arrière du train.
 * - `detachWagonFromLeft()` : détache et retourne le wagon à l'avant du train.
 * - `detachWagonFromRight()` : détache et retourne le wagon à l’arrière du train.
 *
 * Le comportement attendu est celui d’une **deque (double-ended queue)**.
 *
 * Exemple d’exécution :
 * TrainComposition train = new TrainComposition();
 * train.attachWagonFromLeft(7);
 * train.attachWagonFromLeft(13);
 * System.out.println(train.detachWagonFromRight()); // 7
 * System.out.println(train.detachWagonFromLeft());  // 13
 */

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {

    // On utilise une LinkedList comme Deque pour une manipulation efficace des extrémités
    private Deque<Integer> wagons = new LinkedList<>();

    /**
     * Ajoute un wagon à l'avant du train.
     */
    public void attachWagonFromLeft(int wagonId) {
        wagons.addFirst(wagonId);
    }

    /**
     * Ajoute un wagon à l'arrière du train.
     */
    public void attachWagonFromRight(int wagonId) {
        wagons.addLast(wagonId);
    }

    /**
     * Retire et retourne le wagon situé à l'avant du train.
     */
    public int detachWagonFromLeft() {
        return wagons.removeFirst();
    }

    /**
     * Retire et retourne le wagon situé à l'arrière du train.
     */
    public int detachWagonFromRight() {
        return wagons.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft());  // 13
    }
}
