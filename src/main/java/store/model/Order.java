package store.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private LocalDate date = LocalDate.now();
    private BigDecimal totalValue = BigDecimal.ZERO;
    @ManyToOne(fetch=FetchType.LAZY) // Optimizing the query. Lazy only loads the client when it is needed.
    private Client client;
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderedItem> orderedItems = new ArrayList<>();

    public Order() {
    }
    public Order(Client client) {
        this.client = client;
    }
    public void addItem(OrderedItem item) {
        orderedItems.add(item);
        item.setOrder(this);
        totalValue = totalValue.add(item.getValue());
    }
    public List<OrderedItem> getOrderedItems() {
        return orderedItems;
    }
    public void setOrderedItems(List<OrderedItem> orderedItems){
        this.orderedItems = orderedItems;
    }

}
