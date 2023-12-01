//PROGRAMMER : PHUC DO
public class OrderedListNodeTester
{
    public static void main(String[] args) 
    {
        
        OrderedListNode<Integer> node1 = new OrderedListNode<>(1, null, null);
        OrderedListNode<Integer> node2 = new OrderedListNode<>(2, node1, null);

        System.out.println("Element of node2: " + node2.getElement());
        System.out.println("Older node of node2: " + node2.getOlderNode().getElement());
    }
}
