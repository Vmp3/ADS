import java.util.Scanner;
public class testearvore {

    public static void main(String[] args) {
        class Node {
            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        class BinaryTree {
            Node root;

            BinaryTree() {
                root = null;
            }

            void insert(int key) {
                root = insertRec(root, key);
            }

            Node insertRec(Node root, int key) {
                if (root == null) {
                    root = new Node(key);
                    return root;
                }

                if (key < root.key)
                    root.left = insertRec(root.left, key);
                else if (key > root.key)
                    root.right = insertRec(root.right, key);

                return root;
            }

            boolean search(int key) {
                return searchRec(root, key);
            }

            boolean searchRec(Node root, int key) {
                if (root == null || root.key == key)
                    return root != null;

                if (key < root.key)
                    return searchRec(root.left, key);
                else
                    return searchRec(root.right, key);
            }
        }

        class BinarySearchTreeExample {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                BinaryTree tree = new BinaryTree();

                System.out.println("Insira os valores na árvore (digite -1 para encerrar):");
                int value = scanner.nextInt();
                while (value != -1) {
                    tree.insert(value);
                    value = scanner.nextInt();
                }

                System.out.print("Digite o valor a ser buscado na árvore: ");
                int valueToSearch = scanner.nextInt();

                if (tree.search(valueToSearch)) {
                    System.out.println("O valor " + valueToSearch + " foi encontrado na árvore.");
                } else {
                    System.out.println("O valor " + valueToSearch + " não foi encontrado na árvore.");
                }
                scanner.close();
            }
        }

    }
}
