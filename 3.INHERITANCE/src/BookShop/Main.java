package BookShop;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            String author = scanner.nextLine();
            String title = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());

            Book book = new Book(author,title,price);

            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author,title,price);

            Method[] goldenBookDeclareMethods = GoldenEditionBook.class.getDeclaredMethods();

            if (goldenBookDeclareMethods.length>1){
                throw new IllegalClassFormatException("Code duplication in GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        }catch (IllegalArgumentException | IllegalClassFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
}
