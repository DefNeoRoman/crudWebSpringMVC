package app.model;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "users")
public class User {
    public User() {

    }

    public User(int age, String name, String email) {

        this.age = age;
        this.name = name;
        this.email = email;
        this.role = "USER";
        this.password = "user";
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private long id;

    @Column(name="age", length=200)
    private int age;

    @Column(name="name", length=2000)
    private String name;

    @Column(name="email", length=2000)
    private String email;

    @Column(name="createdDate", length=2000)
    private Timestamp createdDate;

    @Column(name="role", length=2000)
    private String role;

    @Column(name="password", length=2000)
    private String password;

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isNew() {
        return id == 0;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
