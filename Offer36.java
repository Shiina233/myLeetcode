public class Offer36 {
    public class Node {
        int val;
        Node left;
        Node right;
    }

    public Node convert(Node root) {
        if (root == null) {
            return null;
        }
        Node lastNode = new Node();
        convert(root, lastNode);
        Node head = lastNode;

        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;

    }

    private void convert(Node root, Node lastNode) {
        if (root == null) {
            return;
        }

        Node current = root;
        if (current.left != null) {
            convert(current.left, lastNode);
        }

        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }

        lastNode = current;
        if (current.right != null) {
            convert(current.right, lastNode);
        }
    }

}
