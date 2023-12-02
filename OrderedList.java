//PROGRAMMER : PHUC DO
//TESTING AND REVISING: MC NGUYEN

import java.io.IOException;
import java.io.PrintWriter;

public class OrderedList<E> {
    //INSTANCE VARIABLES
    private int size;
    private OrderedListNode<E> oldestNode;
    private OrderedListNode<E> newestNode;

    //CONSTRUCTORS
    public OrderedList() { this.size = 0; }
    public OrderedList(E[] elementArray) {  
        for(int i = 0; i < elementArray.length ; i++) add(elementArray[i]);
    }
    public OrderedList(OrderedList<E> orderedList) {
        if (orderedList == null) this.size = 0;
        else if (orderedList.size == 0) this.size = 0;
        else if (orderedList.size == 1) {
            this.size = 1;
            this.oldestNode = new OrderedListNode<E>(orderedList.oldestNode.getElement(), null, null);
            this.newestNode = this.oldestNode;
        } else {
            this.size = orderedList.size;
            this.oldestNode = new OrderedListNode<E>(orderedList.oldestNode.getElement(), null, null);
            
            OrderedListNode<E> current = orderedList.oldestNode.getNewerNode();
            OrderedListNode<E> follow = this.oldestNode;
            while (current != null) {
                OrderedListNode<E> newNode = new OrderedListNode<E>(current.getElement(), follow, null);
                follow.setNewerNode(newNode);
                follow = newNode;
                current = current.getNewerNode();
            }
            this.newestNode = follow;
        }
    }
    
    //INSTANCE METHODS
    public int getSize() { return size; }    
    public boolean isEmpty() { return size == 0; }
    public E getOldestValue() { 
        if (size == 0) return null;
        return this.oldestNode.getElement(); 
    }
    public E getNewestValue() { 
        if (size == 0) return null;
        return this.newestNode.getElement(); 
    }
    public boolean contains(E element) {
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) {
            if (current.getElement().equals(element)) return true; // found the element
            current = current.getNewerNode();
        }
        // if not found
        return false;
    }
    public boolean containsAll(E[] elementArray) {
        for (E element : elementArray) if (!contains(element)) return false;
        return true;
    }
    public boolean containsAll(OrderedList<E> otherList) {
        OrderedListNode<E> current = otherList.oldestNode;
        while (current != null) {
            if (!contains(current.getElement())) return false;
            current = current.getNewerNode();
        }
        return true;
    }
    public int occurrences(E element) {
        int res = 0; // counting variable
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) {
            if (current.getElement().equals(element)) res++;
            current = current.getNewerNode();
        }
        return res;
    }
    public E[] toArray() {
        E[] array = (E[]) new Object[size]; // Cannot directly create generic array, so we need Object type
        OrderedListNode<E> current = this.oldestNode;
        for (int i = 0; i < size; i++) {
            array[i] = current.getElement();
            current = current.getNewerNode();
        }
        return array;
    }
    public void add(E element) {
        OrderedListNode<E> newNode = new OrderedListNode<>(element, null, null);
        
        if (this.oldestNode == null) {
            oldestNode = newNode;
            newestNode = newNode;
        } else {
            newestNode.setNewerNode(newNode);
            newNode.setOlderNode(newestNode);
            newestNode = newNode;
        }

        size++;
    }
    public void addAll(E[] elementArray) { for (E element : elementArray) add(element); }
    public void addAll(OrderedList<E> otherList) {
        this.newestNode.setNewerNode(otherList.oldestNode);
        otherList.oldestNode.setOlderNode(this.newestNode);
        this.newestNode = otherList.newestNode;
        this.size += otherList.size;
    }
    public E removeOldestValue() {
        if (size == 0) throw new IllegalStateException("The ordered list is empty.");
        else {
            E removeValue = oldestNode.getElement();
            if (size == 1) clear();
            else {
                oldestNode = oldestNode.getNewerNode();
                oldestNode.setOlderNode(null);
                size--;
            }
            return removeValue;
        }
    }
    public E removeNewestValue() {
        if (size == 0) throw new IllegalStateException("The ordered list is empty.");
        else {
            E removeValue = newestNode.getElement();
            if (size == 1) clear();
            else {
                newestNode = newestNode.getOlderNode();
                newestNode.setNewerNode(null);
                size--;
            }
            return removeValue;
        }
    }
    public boolean remove(E element) {
        if (!isEmpty())
            if (oldestNode.getElement().equals(element)) {
                removeOldestValue();
                return true;
            }
            else {
                OrderedListNode<E> currentNode = oldestNode.getNewerNode();
                while (currentNode != newestNode) {
                    if (currentNode.getElement().equals(element)) {
                        OrderedListNode<E> olderNode = currentNode.getOlderNode();
                        OrderedListNode<E> newerNode = currentNode.getNewerNode();
                        olderNode.setNewerNode(newerNode);
                        newerNode.setOlderNode(olderNode);
                        --size;
                        return true;
                    }
                    currentNode = currentNode.getNewerNode();
                }
                if (newestNode.getElement().equals(element)) {
                    removeNewestValue();
                    return true;
                }
            }
        return false;
    }
    public boolean removeAll(E[] elementArray) {
        boolean res = false;
        for (E element : elementArray) res = res || remove(element);
        return res; // at least 1 element found to remove
    }
    public boolean removeAll(OrderedList<E> otherList) {
        boolean res = false;
        OrderedListNode<E> current = otherList.oldestNode;
        while (current != null) {
            res = res || remove(current.getElement());
            current = current.getNewerNode();
        }
        return res; // at least 1 element found to remove
    }
    public boolean replace(E originalValue, E newValue) {
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) {
            if (current.getElement().equals(originalValue)) {
                current.setElement(newValue);
                return true;
            }
            current = current.getNewerNode();
        }
        return false;
    }
    public void clear() {
        oldestNode = null;
        newestNode = null;
        size = 0;
    }
    public void saveToFile(String filename) throws IOException {
        PrintWriter fileOutput = new PrintWriter(filename);
        OrderedListNode<E> current = this.oldestNode;
        while(current != null) {
            fileOutput.println(current.getElement());
            current = current.getNewerNode();
        }
        fileOutput.close();
    }
}
