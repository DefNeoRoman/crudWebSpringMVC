package app.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    public User() {

    }

    public User(int age, String name, String email) {

        this.age = age;
        this.name = name;
        this.email = email;
        this.role = "ROLE_USER";
        this.password = "user";
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

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

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<Role> grantedAuthorities = new HashSet<>();
        Role role = new Role(name);
        grantedAuthorities.add(role);
        return grantedAuthorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
