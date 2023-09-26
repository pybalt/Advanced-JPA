package store.VO;

import java.time.LocalDate;

public class salesReport {
    private String productName;
    private Long quantity;
    private LocalDate lastSoldDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDate getLastSoldDate() {
        return lastSoldDate;
    }

    public void setLastSoldDate(LocalDate lastSoldDate) {
        this.lastSoldDate = lastSoldDate;
    }

    public salesReport(String productName, Long quantity, LocalDate lastSoldDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.lastSoldDate = lastSoldDate;
    }

    @Override
    public String toString() {
        return "salesReport { " +
                "productName = '" + productName + '\'' +
                ", quantity = " + quantity +
                ", lastSoldDate = " + lastSoldDate +
                " }";
    }
}
