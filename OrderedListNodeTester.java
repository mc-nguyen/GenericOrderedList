// PROGRAMMER : PHUC DO
// TESTING AND ADVISING: MC NGUYEN
public class OrderedListNodeTester {
    public static void test() {
        OrderedListNode<Integer> node1 = new OrderedListNode<>(1, null, null);
        OrderedListNode<Integer> node2 = new OrderedListNode<>(2, null, null);

        System.out.println("Element of node #1: " + node1.getElement());
        System.out.println("Element of node #2: " + node2.getElement());
        System.out.println();
        
        System.out.println("Change value of node #2");
        node2.setElement(3);
        System.out.println("Element of node #1: " + node1.getElement());
        System.out.println("Element of node #2: " + node2.getElement());
        System.out.println();
        
        System.out.println("Older node of node #1: " + node1.getOlderNode());
        System.out.println("Older node of node #2: " + node2.getOlderNode());
        System.out.println("Newer node of node #1: " + node1.getNewerNode());
        System.out.println("Newer node of node #2: " + node2.getNewerNode());
        System.out.println();
        
        System.out.println("Node #1 will be older than node #2");
        node2.setOlderNode(node1);
        node1.setNewerNode(node2);
        System.out.println("Older node of node #1: " + node1.getOlderNode());
        System.out.println("Older node of node #2: " + node2.getOlderNode());
        System.out.printf("Value: %d%n", node2.getOlderNode().getElement());
        System.out.println("Newer node of node #1: " + node1.getNewerNode());
        System.out.printf("Value: %d%n", node1.getNewerNode().getElement());
        System.out.println("Newer node of node #2: " + node2.getNewerNode());
        System.out.println();
    }
}
