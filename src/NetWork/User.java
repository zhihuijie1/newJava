package p1;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -5277241181336911365L;
    String name;
    String password;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
