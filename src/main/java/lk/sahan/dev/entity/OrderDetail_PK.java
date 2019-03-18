package lk.sahan.dev.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetail_PK implements Serializable {

    private String itemCode;

    private String orderId;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(String itemCode, String orderId) {
        this.setItemCode(itemCode);
        this.setOrderId(orderId);
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetail_PK{" +
                "itemCode='" + itemCode + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
