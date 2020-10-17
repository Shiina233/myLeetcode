public class Offer35 {
    public class Node {
        int val;
        Node next;
        Node sibling;
    }

    public Node complexNodesClone(Node head) {
        nodesClone(head);
        connectSiblingNodes(head);
        return connectNodes(head);
    }

    private void nodesClone(Node head) {
        if (head == null) {
            return;
        }
        Node p = head;
        while (p != null) {
            Node newNode = new Node();
            newNode.val = p.val;
            newNode.next = p.next;
            newNode.sibling = null;
            p.next = newNode;
            p = newNode.next;
        }
    }

    private void connectSiblingNodes(Node head) {
        Node p = head;
        while (p != null) {
            Node newNode = p.next;
            if (p.sibling != null) {
                newNode.sibling = p.sibling.next;
            }

            p = newNode.next;
        }
    }

    private Node connectNodes(Node head) {
        Node p = head;
        Node newHead = null;
        Node newNode = null;

        if (p != null) {
            newHead = p.next;
            newNode = p.next;
            p.next = newNode.next;
            p = p.next;
        }

        while (p != null) {
            newNode.next = p.next;
            newNode = newNode.next;
            p.next = newNode.next;
            p = p.next;
        }

        return newHead;
    }
}
