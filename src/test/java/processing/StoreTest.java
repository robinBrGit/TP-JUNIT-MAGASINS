package processing;

import bo.Item;
import bo.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import util.ItemDataset;
import util.UserDataset;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
static Store store;

    @BeforeAll
    static void before() {
        store = new Store();
        store.setItems(ItemDataset.itemMockup());
        store.setUsers(UserDataset.userMockup());
    }


    @Test
    void addUser() {
        //Création d'un nouvelle utilisateur pour le test
        User test = new User("Richard","richard@gmail.com",40);
        //On test que l'utilisateur est pas dans la liste d'utilisateur
        assertFalse(store.getUsers().containsKey(test));
        //On ajoute l'utilisateur avec la methode addUser et on verifie qu'il a bien était ajouter a notre liste d'utilisateur
        store.addUser(test);
        assertTrue(store.getUsers().containsKey(test));
        //On test que l'ajout d'un utilisateur existant fonctionne aussi
        store.addUser(test);
        assertTrue(store.getUsers().containsKey(test));
    }

    @Test
    void addItem() {
        //Création d'un nouvelle article pour le test
        Item item = new Item("Brosse à dent");
        //On test que l'article est pas dans la liste d'articles
        assertFalse(store.getItems().containsKey(item));
        //On ajoute l'article avec la methode addItem et on verifie qu'il a bien était ajouter a notre liste d'article
        store.addItem(item,10);
        assertTrue(store.getItems().containsKey(item));
        //On test que l'ajout d'un article existant modifie bien ça quantité
        int oldQt = store.getItems().get(item);
        store.addItem(item,15);
        assertFalse(oldQt == store.getItems().get(item));
        assertTrue(store.getItems().get(item) == 15);
    }

    @Test
    void addItemToCart() {
        User userE = new User("Robin","robin@gmail.com",26);
        User userNe = new User("Bernard","bernard@gmail.com",52);
        Item itemNe = new Item("Canette");
        Item itemE = new Item("Stylo");
        Item itemE2 = new Item("Montre");
        //on test d'ajouter un article qui n'existe pas a un utilisateur qui existe
        try{
            store.addItemToCart(userE,itemNe,10);
        }
        catch (RuntimeException e){
            assertTrue(true);
        }
        //on test d'ajouter un article qui existe a un utilisateur qui existe pas
        try{
            store.addItemToCart(userNe,itemE,10);
        }
        catch (RuntimeException e){
            assertTrue(true);
        }
        //On test d'ajouter un article qui existe a un utilisateur qui existe
        try {
            store.addItemToCart(userE,itemE,10);
            assertTrue(true);
        }catch (RuntimeException e){
            assertTrue(false);
        }
        //On test d'ajouter un article qui existe a un utilisateur qui existe dans une quantité supérieure a celle du stock
        try {
            store.addItemToCart(userE,itemE2,10);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
    }

    @Test
    void payShopCart() {
        User userE = new User("Robin","robin@gmail.com",26);
        User userE2 = new User("Clement","clement@gmail.com",26);
        User userE3 = new User("Alexei","alexei@gmail.com",30);
        User userNe = new User("Bernard","bernard@gmail.com",52);
        Item itemE = new Item("Stylo");
        Item itemE2 = new Item("Ecran");
        store.addItemToCart(userE2,itemE,10);
        //on essaye de payer le panier d'un utilisateur qui n'existe pas
        try{
            store.payShopCart(userNe);
        }catch (RuntimeException e){
            assertTrue(true);
        }
        //on essaye de payer un panier d'un utilisateur qui existe mais qui a un panier vide
        try{
            store.payShopCart(userE);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }
        //On essaye de payer un panier d'un utilisateur qui existe et qui a un panier qui contient au moins un article
        try{
            store.payShopCart(userE2);
            assertTrue(true);
        }catch (RuntimeException e){
            assertTrue(false);
        }
        //On essaye de payer un panier d'un utilisateur qui existe et qui a un panier qui contient un article qui a une quantité supérieur au stock
        store.addItemToCart(userE2,itemE2,10);
        store.addItemToCart(userE3,itemE2,10);
        store.payShopCart(userE2);

        try{
            store.payShopCart(userE3);
            assertTrue(false);
        }catch (RuntimeException e){
            assertTrue(true);
        }

    }
}