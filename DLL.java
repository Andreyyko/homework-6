import java.util.ArrayList;

public class DLL<T> {

    private class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public final void addFirst(T data) {
        Node<T> firstNode = new Node<>(data, null, head);
        if (head != null) {
            head.prev = firstNode;
            head = firstNode;
        } else {
            head = tail = firstNode;
            head.next = null;
        }
        size++;
    }

    public final void addLast(T data) {
        Node<T> lastNode = new Node<>(data, tail, null);

        if (head == null) {
            addFirst(data);
        } else {

            tail.next = lastNode;
            tail = lastNode;
            size++;
        }

    }

    public final T removeFromHead() {
        if (size == 0){
            head = null;
            return null;
        }
        T deletedData = null;
        if (head != null) {
            deletedData = head.data;
            head = head.next;
            if (head != null)
                head.prev = null;
        }

        size--;
        return deletedData;
    }

    public int size() {
        return size;
    }

    public void outputFromHead() {
        ArrayList<T> arrayList = new ArrayList();
        Node<T> curr = head;
        while (curr != null) {
            arrayList.add(curr.data);
            curr = curr.next;


        }
        System.out.println(arrayList);
    }

    public void outputFromTail() {
        ArrayList<T> arrayList2 = new ArrayList();
        Node<T> curr = tail;
        while (curr != null) {
            arrayList2.add(curr.data);
            curr = curr.prev;
        }
        System.out.println(arrayList2);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public final T getHead() {
        if (size == 0) return null;
        if (head != null) {
            //           System.out.println(head.data);
            return head.data;
        }
        return null;

    }

    public final T getTail() {
        if (size == 0) return null;
        if (tail != null) {
            System.out.println(tail.data);
            return tail.data;
        }
        return null;
    }

    // utility method is used by an add method
    private void insertInBetween(T data, Node<T> currNode) {
        Node<T> newNode = new Node<>(data, currNode.prev, currNode.next);
        currNode.prev.next = newNode;
        currNode.prev = newNode;
        size++;
    }

    public final void add(T data, int idx) {
        if (idx == 0) {
            addFirst(data);
        } else if (idx >= size) {
            addLast(data);
        } else {
            Node<T> currNode;
            int currPos;
            if ((size - idx) < (double) (size / 2)) {
                currPos = size;
                currNode = tail;
                while (currPos-- >= 0) {
                    currNode = currNode.prev;
                }
                insertInBetween(data, currNode);
            }
            if ((size - idx) > (double) (size / 2)) {
                currPos = 0;
                currNode = head;
                while (currPos++ <= idx) {
                    currNode = currNode.next;
                }
                insertInBetween(data, currNode);
            }

        }
    }
}