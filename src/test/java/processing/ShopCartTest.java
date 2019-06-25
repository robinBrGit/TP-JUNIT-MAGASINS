package processing;

import bo.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopCartTest {

    @Test
    void addItemToCart() {
        ShopCart cart = new ShopCart();
        Item item = new Item("Patate");
        //On test l'ajout d'un article qui n'existe pas dans le panier
        assertFalse(cart.getShopCart().containsKey(item));
        cart.addItemToCart(item,10);
        assertTrue(cart.getShopCart().containsKey(item));
        //on test que si on ajoute un article qui existe la nouvelle est égale a la somme de l'ancienne valeur + la nouvelle
        int oldValue = cart.getShopCart().get(item);
        cart.addItemToCart(item,25);
        assertEquals(oldValue+25,cart.getShopCart().get(item));
    }

    @Test
    void isCartEmpty() {
        ShopCart cart = new ShopCart();
        Item item = new Item("Patate");
        //on test que le panier et bien vide
        assertTrue(cart.isCartEmpty());
        //on test qu'il n'est plus vide
        cart.addItemToCart(item,10);
        assertFalse(cart.isCartEmpty());

    }
}