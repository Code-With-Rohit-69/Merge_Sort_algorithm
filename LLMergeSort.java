public class LLMergeSort {

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head;
    public Node tail;

    public void addFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public Node midNode(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.data >= right.data) {
                current.next = right;
                right = right.next;
                current = current.next;
            } else {
                current.next = left;
                left = left.next;
                current = current.next;
            }
        }

        while (right != null) {
            current.next = right;
            right = right.next;
            current = current.next;
        }

        while (left != null) {
            current.next = left;
            left = left.next;
            current = current.next;
        }

        return dummy.next;

    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node midN = midNode(head);
        midN.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(midN.next);

        return merge(left, right);

    }

    public static void main(String[] args) {

        LLMergeSort ll = new LLMergeSort();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();

        ll.head = ll.mergeSort(ll.head);
        ll.print();

    }
}