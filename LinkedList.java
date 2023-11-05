class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }
}

public class LinkedList {
    Node head;
    Node tail;
    int size;

    //Adds to last O(1)
    public void addToLast(String data) {
        Node node = new Node(data);
        if(size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }
    
    //O(1)
    public void addToFirst(String data) {
        Node node = new Node(data);
        if(size == 0) {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    public int add(String data, int index) {
        if(index >= size+1 || index < 0) {
            return -1;
        }
        if(index == 0) {
            addToFirst(data);
            return 1;
        }
        if(index == size) {
            addToLast(data);
            return 1;
        }

        int currentIndex = 0;
        Node prev = null;
        Node curr = head;

        while(currentIndex != index) {
            prev = curr;
            curr = curr.next;
            currentIndex++;
        }
        Node node = new Node(data);
        prev.next = node;
        node.next = curr;
        size++;
        return 1;
    }

    //O(1)
    public Node removeFirst() {
        if(size == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        return temp;
    }

    //O(n)
    public Node removeLast() {

        if(size == 0) {
            return null;
        }
        if(size == 1) {
            Node deleted = head;
            head = null;
            tail = null;
            size = 0;
            return deleted;
        }

        Node curr = head;

        while(curr.next.next!=null) {
            curr = curr.next;
        }

        Node deleted = curr.next;
        curr.next = null;
        tail = curr;
        size--;
        return deleted;
    }

    //O(n)
    public Node remove(int index) {

        if(index >= size || index < 0) {
            return null;
        }

        //remove first
        if(index == 0) {
            return removeFirst();
        }

        //remove last
        if(index == size-1) {
            return removeLast();
        }

        int currentIndex = 0;
        Node prev = null;
        Node curr = head;

        while(currentIndex != index) {
            prev = curr;
            curr = curr.next;
            currentIndex++;
        }
        prev.next = curr.next;
        size--;
        curr.next = null;
        return curr;
    }
    
    //Traversal - O(N)
    public String toString() {
    
        StringBuilder str = new StringBuilder();
    
        Node curr = head;
    
        while(curr != null) {
            str.append(curr.data);
            str.append("->");
            curr = curr.next;
        }
        str.append("null");
    
        return str.toString();
    }

}
