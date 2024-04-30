package uz.pdp.ecommerce.services;

import uz.pdp.ecommerce.entity.User;

public class AuthService {
    public static User currentUser = User.builder().id(1).build();
}
