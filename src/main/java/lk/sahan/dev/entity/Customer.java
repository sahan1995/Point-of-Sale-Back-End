package lk.sahan.dev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name="Customer.mataOniAddressMeaAkurenPatanGanna",
query="SELECT c FROM Customer c WHERE c.address LIKE ?1")
@Entity
public class Customer implements Serializable {

    @Id
    private String id;
    private String name;
    private String address;
    private String imageName;
    @Column(unique = true)
    private String username;
    @Lob
    private String password;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        getOrders().add(order);
    }

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

    public Customer(String id, String name, String address, String imageName, String username, String password) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.imageName = imageName;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
