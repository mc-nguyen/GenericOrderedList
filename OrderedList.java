//PROGRAMMER : PHUC DO
import java.io.IOException;
import java.io.PrintWriter;

public class OrderedList<E>
{
    //INSTANCE VARIABLES
    private int size;
    private OrderedListNode<E> oldestNode;
    private OrderedListNode<E> newestNode;

    //CONSTRUCTOR
    public OrderedList()
    {
        this.size = 0;
        this.oldestNode = null;
        this.newestNode = null;
    }

    public OrderedList(E[] elementArray)
    {
        
        for(int i = 0; i < elementArray.length ; i++)
        {
            add(elementArray[i]);
        }
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public boolean isEmpty()
    {
        if(this.size == 0)
            return true;
        return false;
    }

    public E getOldestValue()
    {
        return this.oldestNode.getElement();
    }

    public E getNewestValue()
    {
        return this.newestNode.getElement();
    }

    public boolean contains(E element) 
    {
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) 
        {
            if (current.getElement().equals(element)) 
            {
                return true;
            }
            current = current.getNewerNode();
        }
        return false;
    }

    public boolean containsAll(E[] elementArray) 
    {
        for (E element : elementArray) 
        {
            if (!contains(element)) 
            {
                return false;
            }
        }
        return true;
    }

    public boolean containsAll(OrderedList<E> otherList) 
    {
        OrderedListNode<E> current = otherList.oldestNode;
        while (current != null) 
        {
            if (!contains(current.getElement())) 
            {
                return false;
            }
            current = current.getNewerNode();
        }
        return true;
    }

    public int occurrences(E element) 
    {
        int res = 0;
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) 
        {
            if (current.getElement().equals(element)) 
            {
                res++;
            }
            current = current.getNewerNode();
        }
        return res;
    }

    public E[] toArray() 
    {
        E[] array = (E[]) new Object[this.size]; 
        OrderedListNode<E> current = this.oldestNode;
        int i = 0;
        while (current != null) 
        {
            array[i] = current.getElement();
            i++;
            current = current.getNewerNode();
        }
        return (E[]) array;
    }

    public void add(E element) 
    {
        OrderedListNode<E> newNode = new OrderedListNode<>(element,null, null);
        
        if (this.oldestNode == null) 
        {
            this.oldestNode = newNode;
            this.newestNode = newNode;
        } 
        else 
        {
            OrderedListNode<E> current = this.oldestNode;
            while(current.getNewerNode() != null)
            {
                current = current.getNewerNode();
            }
            current.setNewerNode(newNode);
            newNode.setOlderNode(current);
            this.newestNode = newNode;
        }

        size++;
    }

    public void addAll(E[] elementArray) 
    {
        for (E element : elementArray) 
        {
            add(element);
        }
    }

    public void addAll(OrderedList<E> otherList) 
    {
        OrderedListNode<E> current = otherList.oldestNode;
        while (current != null) 
        {
            add(current.getElement());
            current = current.getNewerNode();
        }
    }

    public E removeOldestValue() 
    {
        if (this.oldestNode != null) 
        {
            E removedValue = this.oldestNode.getElement();
            this.oldestNode = this.oldestNode.getNewerNode();
            if (this.oldestNode != null) {
                this.oldestNode.setOlderNode(null);
            } else {
                this.newestNode = null; 
            }
            size--;
            return removedValue;
        } 
        else 
        {
            throw new IllegalStateException("The ordered list is empty.");
        }
    }

    public E removeNewestValue() 
    {
        if (this.newestNode != null) 
        {
            E removedValue = this.newestNode.getElement();
            this.newestNode = this.newestNode.getOlderNode();
            if (this.newestNode != null) 
            {
                this.newestNode.setNewerNode(null);
            } else 
            {
                this.oldestNode = null; 
            }
            size--;
            return removedValue;
        } 
        else 
        {
            throw new IllegalStateException("The ordered list is empty.");
        }
    }

    public boolean remove(E element) 
    {
        OrderedListNode<E> current = this.oldestNode;
        while (current != null) 
        {
            if (current.getElement().equals(element)) 
            {
                OrderedListNode<E> olderNode = current.getOlderNode();
                OrderedListNode<E> newerNode = current.getNewerNode();

                if (olderNode != null) 
                {
                    olderNode.setNewerNode(newerNode);
                } else 
                {
                    oldestNode = newerNode;
                }

                if (newerNode != null) 
                {
                    newerNode.setOlderNode(olderNode);
                } else {
                    newestNode = olderNode;
                }

                size--;
                return true;
            }
            current = current.getNewerNode();
        }
        return false;
    }

    public boolean removeAll(E[] elementArray) 
    {
        boolean res = false;
        for (E element : elementArray) 
        {
            res = remove(element);
        }
        return res;
    }

    public boolean removeAll(OrderedList<E> otherList) 
    {
        boolean res = false;
        OrderedListNode<E> current = otherList.oldestNode;
        while (current != null) 
        {
            res = remove(current.getElement());
            current = current.getNewerNode();
        }
        return res;
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

    public void clear() 
    {
        oldestNode = null;
        newestNode = null;
        size = 0;
    }

    public void saveToFile(String filename) throws IOException
    {
        PrintWriter fileOutput = new PrintWriter(filename);
        OrderedListNode<E> current = this.oldestNode;
        while(current != null)
        {
            fileOutput.println(current.getElement());
            current = current.getNewerNode();
        }
        fileOutput.close();
    }

}
