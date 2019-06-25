package processing;

import bo.Item;
import bo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Magasin
 */
public class Store {
    private Map<User, ShopCart> users;
    private Map<Item,Integer> items;

    //Constructor
    public Store() {
        users = new HashMap<User,ShopCart>();
        items = new HashMap<Item,Integer>();
    }

    //Getter & Setter
    public Map<User, ShopCart> getUsers() {
        return users;
    }

    public void setUsers(Map<User, ShopCart> users) {
        this.users = users;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }

    //Methods

    /**
     * Méthode qui ajoute un utilisateur à liste users et lui créer un panier vide
     * @param u l'utilisateur à ajouter
     */
    public void addUser(User u){
        users.put(u,new ShopCart());
    }

    /**
     * Méthode qui ajoute un article à la liste d'article et lui associe un stock
     * @param i L'article à ajouter
     * @param amount La quantité du stock
     */
    public void addItem(Item i,Integer amount){
        items.put(i,amount);
    }

    /**
     * Méthode qui ajoute un article au panier d'un utilisateur
     * @param user l'utilisateur concerné
     * @param item l'article a ajouter
     * @param amount la quantité a ajouter
     */
    public void addItemToCart(User user,Item item,Integer amount) {
        if(items.containsKey(item) && users.containsKey(user)){
            if(items.get(item)< amount){
                throw new RuntimeException("Il ne reste que "+items.get(item)+" "+item.getName());
            }
            ShopCart cart = users.get(user);
            cart.addItemToCart(item,amount);
            users.put(user,cart);
        }
        if(!items.containsKey(item))throw new RuntimeException("L'article "+item.getName()+" n'existe pas");
        if(!users.containsKey(user))throw new RuntimeException("L'utilisateur "+user.getName()+" n'existe pas");
    }

    /**
     * Méthode qui valide un panier et retire la quantité d'un ou des articles acheté par un utilisateur
     * @param user l'utilisateur qui valide son panier
     */
    public void payShopCart(User user){
        if(users.containsKey(user)){
            if(!users.get(user).isCartEmpty()){
                ShopCart cart = users.get(user);
                cart.getShopCart().entrySet().stream()
                        .forEach(c-> {
                            if(items.get(c.getKey()) < c.getValue())
                                throw new RuntimeException("Le stock pour l'article "
                                        +c.getKey().getName()
                                        +" est insufisant");
                            int newValue = items.get(c.getKey()) - c.getValue();
                            items.put(c.getKey(),newValue);
                        });
                users.put(user,new ShopCart());
            }
            else throw new RuntimeException("Le panier est vide");
        }
        else throw new RuntimeException("L'utilisateur "+user.getName()+" n'existe pas");
    }


}
