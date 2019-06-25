package util;

import bo.User;
import processing.ShopCart;

import java.util.HashMap;
import java.util.Map;

public class UserDataset {

    public static Map<User, ShopCart> userMockup(){
        Map<User,ShopCart> users = new HashMap<User,ShopCart>();
        users.put(new User("Robin","robin@gmail.com",26),new ShopCart());
        users.put(new User("Clement","clement@gmail.com",26),new ShopCart());
        users.put(new User("Jean Baptiste","jb@gmail.com",30),new ShopCart());
        users.put(new User("Glen","glen@gmail.com",23),new ShopCart());
        users.put(new User("Alexei","alexei@gmail.com",30),new ShopCart());
        users.put(new User("Adrien","adrien@gmail.com",26),new ShopCart());
        users.put(new User("Etiene","etiene@gmail.com",30),new ShopCart());
        return users;
    }
}
