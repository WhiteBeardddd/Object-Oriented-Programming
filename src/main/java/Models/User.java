package Models;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    // For existing users (with ID)
    public User(int id, String firstname, String lastname, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    // For new users (no ID yet)
    public User(String firstname, String lastname, String email, String password) {
        this(0, firstname, lastname, email, password);
    }

    // Getters
    public int getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}

