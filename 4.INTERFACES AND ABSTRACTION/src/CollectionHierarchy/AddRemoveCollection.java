package CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public String remove() {
        String removed = this.getItems().get(this.getItems().size()-1);
        this.getItems().remove(removed);
        return removed;
    }

    @Override
    public int add(String string) {
        this.getItems().add(0,string);
        return 0;
    }

}
