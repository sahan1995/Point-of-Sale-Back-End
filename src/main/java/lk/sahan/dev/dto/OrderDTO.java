package lk.sahan.dev.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private String id;
    private Date date;
    private CustomerDTO customer;

    private List<OrderDetailDTO> orderDetails = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(String id, Date date, CustomerDTO customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
