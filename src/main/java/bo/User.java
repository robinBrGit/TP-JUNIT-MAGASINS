package bo;

/**
 * Classe Utilisateur
 */
public class User {
    private String name;
    private String mail;
    private int age;

    //Constructor
    public User(String name, String mail, int age) {
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return this.getMail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getMail().equals(((User)obj).getMail());
    }

    //Methods

}
