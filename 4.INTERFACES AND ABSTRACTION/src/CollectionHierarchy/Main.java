package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        String[] items = scanner.nextLine().split("\\s");
        List<Integer> addCollectionAddOperations = new ArrayList<>();
        List<Integer> addRemoveCollectionAddOperations = new ArrayList<>();
        List<Integer> myListAddOperations = new ArrayList<>();
        for (String item:items
             ) {
            addCollectionAddOperations.add(addCollection.add(item));
            addRemoveCollectionAddOperations.add(addRemoveCollection.add(item));
            myListAddOperations.add(myList.add(item));
        }
        int removeCount = Integer.parseInt(scanner.nextLine());
        List<String> addRemoveCollectionRemoveOperations = new ArrayList<>();
        List<String> myListRemoveOperations = new ArrayList<>();
        for (int i = 0; i < removeCount; i++) {
            addRemoveCollectionRemoveOperations.add(addRemoveCollection.remove());
            myListRemoveOperations.add(myList.remove());
        }
        System.out.println(addCollectionAddOperations.toString().replaceAll("[\\[\\],]",""));
        System.out.println(addRemoveCollectionAddOperations.toString().replaceAll("[\\[\\],]",""));
        System.out.println(myListAddOperations.toString().replaceAll("[\\[\\],]",""));
        System.out.println(addRemoveCollectionRemoveOperations.toString().replaceAll("[\\[\\],]",""));
        System.out.println(myListRemoveOperations.toString().replaceAll("[\\[\\],]",""));
    }
}
