// PROGRAMMER: PHUC DO
// TESTING AND REVISING: MC NGUYEN

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class OrderedListTester {    
    public static void defaultConstructorTest() throws IOException {
        System.out.println("\nDEFAULT constructors and its instance methods TESTING:");
        OrderedList<String> defaultInstance = new OrderedList<String>();
        
        System.out.println("\nSize: " + defaultInstance.getSize());
        System.out.println("Is the test list empty? " + defaultInstance.isEmpty());
        System.out.println("Does the list contain 'Lemon'? " + defaultInstance.contains("Lemon"));
        System.out.println("Does the list contain 'Lemon' and 'Banana'? " + defaultInstance.containsAll(new String[]{"Lemon", "Banana"}));
        
        System.out.println("\nCreating another instance ('Lemon' and 'Banana')");
        OrderedList<String> otherInstance = new OrderedList<String>(new String[]{"Lemon", "Banana"});
        System.out.println("Does the list contain the instance? " + defaultInstance.containsAll(otherInstance));
        
        System.out.println("\nOccurrences of 'Banana': " + defaultInstance.occurrences("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        
        System.out.println("\nAdding Strawberry"); defaultInstance.add("Strawberry");
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Adding 'Lemon' and 'Banana'"); defaultInstance.addAll(new String[]{"Lemon", "Banana", "Strawberry"});
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Adding instance of 'Lemon' and 'Banana'"); defaultInstance.addAll(otherInstance);
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        
        System.out.println("\nRemove oldest value: " + defaultInstance.removeOldestValue());
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Remove newest value: " + defaultInstance.removeNewestValue());
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Remove 'Banana': " + defaultInstance.remove("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana': " + defaultInstance.removeAll(new String[]{"Lemon", "Banana"}));
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana': " + defaultInstance.removeAll(new OrderedList<String>(new String[]{"Lemon", "Banana"})));
        System.out.println("Instance in array: " + Arrays.toString(defaultInstance.toArray()));
        
        System.out.println("\nReplace 'Strawberry' with 'Cranberry': " + defaultInstance.replace("Strawberry", "Cranberry"));
        
        System.out.print("\nSaving the instance in filename: ");
        Scanner consoleInput = new Scanner(System.in);
        defaultInstance.saveToFile(consoleInput.next());
        
        System.out.print("\nClear all! "); defaultInstance.clear();
        System.out.println("Is it empty? " + defaultInstance.isEmpty());
        
        System.out.println();
    }
    
    public static void arrayOverloadedConstructorTest() throws IOException {
        System.out.println("\nARRAY OVERLOADED constructors and its instance methods TESTING:");
        OrderedList<String> arrayInstance = new OrderedList<String>(new String[]{"Apple", "Banana", "Cranberry"});
        
        System.out.println("\nSize: " + arrayInstance.getSize());
        System.out.println("Is the test list empty? " + arrayInstance.isEmpty());
        System.out.println("Oldest Value: " + arrayInstance.getOldestValue());
        System.out.println("Newest Value: " + arrayInstance.getNewestValue());
        System.out.println("Does the list contain 'Lemon'? " + arrayInstance.contains("Lemon"));
        System.out.println("Does the list contain 'Lemon' and 'Banana'? " + arrayInstance.containsAll(new String[]{"Lemon", "Banana"}));
        
        System.out.println("\nCreating another instance ('Lemon' and 'Banana')");
        OrderedList<String> otherInstance = new OrderedList<String>(new String[]{"Lemon", "Banana"});
        System.out.println("Does the list contain the instance? " + arrayInstance.containsAll(otherInstance));
        
        System.out.println("\nOccurrences of 'Banana': " + arrayInstance.occurrences("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        
        System.out.println("\nAdding Strawberry"); arrayInstance.add("Strawberry");
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Adding 'Lemon' and 'Banana'"); arrayInstance.addAll(new String[]{"Lemon", "Banana", "Strawberry"});
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Adding instance of 'Lemon' and 'Banana'"); arrayInstance.addAll(otherInstance);
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        
        System.out.println("\nRemove oldest value: " + arrayInstance.removeOldestValue());
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Remove newest value: " + arrayInstance.removeNewestValue());
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Remove 'Banana': " + arrayInstance.remove("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana': " + arrayInstance.removeAll(new String[]{"Lemon", "Banana"}));
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana': " + arrayInstance.removeAll(new OrderedList<String>(new String[]{"Lemon", "Banana"})));
        System.out.println("Instance in array: " + Arrays.toString(arrayInstance.toArray()));
        
        System.out.println("\nReplace 'Strawberry' with 'Cranberry': " + arrayInstance.replace("Strawberry", "Cranberry"));
        
        System.out.print("\nSaving the instance in filename: ");
        Scanner consoleInput = new Scanner(System.in);
        arrayInstance.saveToFile(consoleInput.next());
        
        System.out.print("\nClear all! "); arrayInstance.clear();
        System.out.println("Is it empty? " + arrayInstance.isEmpty());
        
        System.out.println();
    }
    
    public static void listOverloadedConstructorTest() throws IOException {
        System.out.println("\nORDERED LIST OVERLOADED constructors and its instance methods TESTING:");
        OrderedList<String> arrayInstance = new OrderedList<String>(new String[]{"Banana", "Cranberry"});
        OrderedList<String> listInstance = new OrderedList<String>(arrayInstance);
        
        System.out.println("\nSize: " + listInstance.getSize());
        System.out.println("Is the test list empty? " + listInstance.isEmpty());
        System.out.println("Oldest Value: " + listInstance.getOldestValue());
        System.out.println("Newest Value: " + listInstance.getNewestValue());
        System.out.println("Does the list contain 'Lemon'? " + listInstance.contains("Lemon"));
        System.out.println("Does the list contain 'Lemon' and 'Banana'? " + listInstance.containsAll(new String[]{"Lemon", "Banana"}));
        
        System.out.println("\nCreating another instance ('Lemon' and 'Banana')");
        OrderedList<String> otherInstance = new OrderedList<String>(new String[]{"Lemon", "Banana"});
        System.out.println("Does the list contain the instance? " + listInstance.containsAll(otherInstance));
        
        System.out.println("\nOccurrences of 'Banana': " + listInstance.occurrences("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        
        System.out.println("\nAdding Strawberry"); listInstance.add("Strawberry");
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Adding 'Lemon' and 'Banana'"); listInstance.addAll(new String[]{"Lemon", "Banana", "Strawberry"});
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Adding instance of 'Lemon' and 'Banana'"); listInstance.addAll(otherInstance);
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        
        System.out.println("\nRemove oldest value: " + listInstance.removeOldestValue());
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Remove newest value: " + listInstance.removeNewestValue());
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Remove 'Banana': " + listInstance.remove("Banana"));
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana' as an array: " + listInstance.removeAll(new String[]{"Lemon", "Banana"}));
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        System.out.println("Remove 'Lemon' and 'Banana' as an instance: " + listInstance.removeAll(new OrderedList<String>(new String[]{"Lemon", "Banana"})));
        System.out.println("Instance in array: " + Arrays.toString(listInstance.toArray()));
        
        System.out.println("\nReplace 'Strawberry' with 'Cranberry': " + listInstance.replace("Strawberry", "Cranberry"));
        
        System.out.print("\nSaving the instance in filename: ");
        Scanner consoleInput = new Scanner(System.in);
        listInstance.saveToFile(consoleInput.next());
        
        System.out.print("\nClear all! "); listInstance.clear();
        System.out.println("Is it empty? " + listInstance.isEmpty());
        
        System.out.println();
    }
}
