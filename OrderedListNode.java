//PROGRAMMER : PHUC DO
public class OrderedListNode<E> {
    //INSTANCE VARIABLES
    private E element;
    private OrderedListNode<E> olderNode;
    private OrderedListNode<E> newerNode;

    //CONSTRUCTORs
    public OrderedListNode(E element, OrderedListNode<E> olderNode, OrderedListNode<E> newerNode)
    {
        this.element = element;
        this.olderNode = olderNode;
        this.newerNode = newerNode;
    }

    //INSTANCE METHODS
    public E getElement() { return element; }
    public void setElement(E element) { this.element = element; }
    public OrderedListNode<E> getOlderNode() { return this.olderNode; }
    public void setOlderNode(OrderedListNode<E> olderNode) { this.olderNode = olderNode; }
    public OrderedListNode<E> getNewerNode() { return this.newerNode; }
    public void setNewerNode(OrderedListNode<E> newerNode) { this.newerNode = newerNode; }
}

