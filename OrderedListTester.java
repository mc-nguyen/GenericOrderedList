public class OrderedListTester {
    public static void main(String[] args) 
    {
        String[] array = {"Apple", "Banana", "Orange", "Grapes"};
        OrderedList<String> test1 = new OrderedList<>(array);
        System.out.println("Is the test list empty? " + test1.isEmpty());
        System.out.println("Oldest Value: " + test1.getOldestValue());
        System.out.println("Newest Value: " + test1.getNewestValue());
        System.out.println("Occurrences of 'Banana': " + test1.occurrences("Banana"));
        System.out.println("Does the list contain 'lemon'? " + test1.contains("lemon"));
        test1.remove("banana");
        test1.replace("Apple","lemon");
        System.out.println();
    }
}
