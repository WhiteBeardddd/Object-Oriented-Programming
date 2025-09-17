package Controllers;

import Models.User;
import dao.AuthDAO;

public class AuthController {
    private AuthDAO authDAO = new AuthDAO();
    private User currentUser; // track logged-in user

    // Register new user
    public boolean register(String firstname, String lastname, String email, String password) {
        User user = new User(0, firstname, lastname, email, password);
        return authDAO.register(user);
    }

    // Login user
    public User login(String email, String password) {
        currentUser = authDAO.login(email, password);
        return currentUser;
    }

    // Track logged in user
    public User getCurrentUser() {
        return currentUser;
    }

    // Change password for current user
    public boolean changePassword(String oldPassword, String newPassword) {
        if (currentUser != null) {
            return authDAO.changePassword(currentUser.getId(), oldPassword, newPassword);
        }
        return false;
    }
}
