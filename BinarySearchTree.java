/**
 * Problème : Vérifier si une valeur existe dans un arbre binaire de recherche (ABR)
 * Exemples :
 * - ABR [2, [1, null, null], [3, null, null]] contient 3 → true
 * - ABR [2, [1, null, null], [3, null, null]] contient 4 → false
 */
class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        if (root == null) return false;
        if (value == root.value) return true;
        return value < root.value 
            ? contains(root.left, value) 
            : contains(root.right, value);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node root = new Node(2, n1, n3);

        System.out.println(contains(root, 3)); // true
        System.out.println(contains(root, 4)); // false
    }
}
