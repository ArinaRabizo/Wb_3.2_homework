public class MyList<E> {
    private class Node {
        public E element;
        public Node next;
        public Node (E element, Node next) {
            this.element = element;
            this.next = next;
        }
        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }
    private int size;
    private Node head;

    MyList () {
        size = 0;
        head = null;
    }
    public int getSize () {
        return size;
    }
    private Node getNode (int index) {
        if (index < 0|| index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node1 = head;
        for (int i = 0; i < index; i++) {
            node1 = node1.next;
        }
        return node1;
    }

    public E get (int index) {
        Node node = getNode(index);
        return node.element;
    }
    public int indexOf (Object obj) {
        Node node1 = head;
        for (int i = 0; i < size; i++) {
            if (node1.element.equals(obj)) return i;
            node1 = node1.next;
        }
        return -1;
    }
    public boolean add (E element) {
        if (head == null) {
            head = new Node(element);
        } else {
           Node node1 = new Node(element);
           Node currentNode = head;
            for (int i = 0; i < size-1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = node1;
        }
        size++;
        return true;
    }
    public void add(int index, E element) {
        if (index == size) {
            add(element);
        }   else if (index == 0) {
            head  = new Node(element, head);
            size++;

        }  else {
            Node currentNode = getNode(index -1);
           currentNode.next = new Node(element, currentNode.next);
            size++;
        }

    }


    public E remove (int index) {
        Node curNode = getNode(index);
        if (size == 1) {
            head = null;
        } else if (curNode == head) {
            head = head.next;
        } else if (index == size -1) {
            getNode(size -2).next = null;
        } else {
           getNode(index -1).next = getNode(index +1);

        }
        size--;
        return curNode.element;
    }

    public boolean remove (Object obj) {
        for (int i = 0; i < size; i++) {
            if (getNode(i).element.equals(obj)) {
                remove(i);
                i--;
            }
        }
        return true;
    }
    public String toString () {
        if (head == null) return "Your list is empty";

        String str = "[";
        Node currentNode = head;
        for (int i = 0; i < size-1; i++) {
            str = str + currentNode.element.toString() + ", ";
            currentNode = currentNode.next;
        }
        str = str + currentNode.element.toString() + "]";
        return str;
    }
        }

