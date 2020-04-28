package MilitaryElite;

public class Mission {
    private String name;
    private String state;

    public Mission(String name, String state) {
        this.name = name;
        this.setState(state);
    }

    public void setState(String state) {
        if (!state.equals("inProgress")&&!state.equals("Finished")){
            throw new IllegalArgumentException();
        }
        this.state = state;
    }

    private String getName() {
        return this.name;
    }

    private String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.getName(),this.getState());
    }
}
