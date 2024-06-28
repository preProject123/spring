package web.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "lastname", nullable = false)
    String lastname;

    @Column(name = "age", nullable = true)
    Integer age;
    @Column(name = "email", nullable = true)
    String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "phone", nullable = true)
    String phone;

    public User() {
    }

    public User(String name, String lastname, Integer age, String email, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String surname) {
        this.lastname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{ ");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email);
        sb.append(", PHONE=").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}