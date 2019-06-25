package bo;

/**
 * Classe Article
 */
public class Item {
    private String name;

    //Constructor
    public Item(String name) {
        this.name = name;
    }

    //Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Item)obj).getName());
    }
}
