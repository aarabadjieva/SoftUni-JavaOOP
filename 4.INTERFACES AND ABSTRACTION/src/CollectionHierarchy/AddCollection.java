package CollectionHierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String string) {
        this.getItems().add(string);
        return this.getItems().size()-1;
    }
}
