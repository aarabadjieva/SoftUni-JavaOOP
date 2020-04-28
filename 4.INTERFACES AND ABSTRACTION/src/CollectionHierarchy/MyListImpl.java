package CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return this.getItems().size();
    }

    @Override
    public String remove() {
        String removed = this.getItems().get(0);
        this.getItems().remove(0);
        return removed;
    }

    @Override
    public int add(String string) {
        this.getItems().add(0,string);
        return 0;
    }
}
