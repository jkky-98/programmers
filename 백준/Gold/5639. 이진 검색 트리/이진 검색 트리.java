
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BinaryTree bt = new BinaryTree();

    public static void main(String[] args) throws IOException {
        String item = "";
        while ((item = br.readLine()) != null) {
            int i = Integer.parseInt(item);
            bt.add(i);
        }

        bt.search();
    }

    public static class BinaryTree {
        Node RootNode;

        public void add(int value) {
            if (RootNode == null) {
                RootNode = new Node(value);
            } else {
                RootNode.add(value);
            }

        }

        public void search() {
            RootNode.search();
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void add(int value) {

            if (value <= this.value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.add(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.add(value);
                }
            }
        }

        public void search() {
            if (this.left == null && this.right == null) {
                System.out.println(this.value);
                return;
            }

            if (this.left != null) {
                this.left.search();
            }

            if (this.right != null) {
                this.right.search();
            }

            System.out.println(this.value);
        }
    }
}
