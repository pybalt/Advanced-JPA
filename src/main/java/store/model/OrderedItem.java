package store.model;

import store.model.Product;
import store.model.Order;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordered_items")
public class OrderedItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private BigDecimal unitPrice;

    @ManyToOne(fetch=FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    private Order order;

    public OrderedItem() {

    }

    public OrderedItem(int quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
        this.unitPrice = product.getPrice();
    }

    public Long getId() {
        return id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getValue() {
        return this.unitPrice.multiply(new BigDecimal(this.quantity));
    }


}