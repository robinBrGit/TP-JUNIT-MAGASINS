package processing;

import bo.Item;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Pannier
 */
public class ShopCart {
    private Map<Item,Integer> shopCart;

    //Constructor
    public ShopCart() {
        shopCart = new HashMap<Item,Integer>();
    }

    //Getter & Setter
    public Map<Item, Integer> getShopCart() {
        return shopCart;
    }

    public void setShopCart(Map<Item, Integer> shopCart) {
        this.shopCart = shopCart;
    }

    //Methods

    /**
     * Méthode qui ajoute un article et ça quantité au panier
     * @param item L'article a ajouter
     * @param amount La quantité à ajouter
     */
    public void addItemToCart(Item item,Integer amount){
        if(!shopCart.containsKey(item))
        shopCart.put(item,amount);
        else {
            int newValue = shopCart.get(item)+amount;
            shopCart.put(item,newValue);
        }
    }

    /**
     * Teste si un panier et vide
     * @return True si le panier et vide
     */
    public boolean isCartEmpty(){
        return shopCart.isEmpty();
    }
}
