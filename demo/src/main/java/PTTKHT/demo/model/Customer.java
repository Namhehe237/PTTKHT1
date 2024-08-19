package PTTKHT.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    public Customer() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Customer( String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }
}
