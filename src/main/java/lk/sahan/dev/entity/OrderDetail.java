package lk.sahan.dev.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderDetail implements Serializable {

    @EmbeddedId
    private
    OrderDetail_PK orderDetailPk;

    private int qty;

    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false,updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="itemCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Item item;

    public Order getOrder() {
        return order;
    }

    public Item getItem() {
        return item;
    }

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, int qty, BigDecimal unitPrice) {
        this.orderDetailPk = new OrderDetail_PK(itemCode, orderId);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(OrderDetail_PK orderDetailPk, int qty, BigDecimal unitPrice) {
        this.orderDetailPk = orderDetailPk;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail_PK getOrderDetailPk() {
        return orderDetailPk;
    }

    public void setOrderDetailPk(OrderDetail_PK orderDetailPk) {
        this.orderDetailPk = orderDetailPk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderDetailPk=" + orderDetailPk +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
