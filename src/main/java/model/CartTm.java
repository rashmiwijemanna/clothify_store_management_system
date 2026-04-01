package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartTm {
    private String itemId;
    private String itemName;
    private Integer qty;
    private Double unitPrice;
    private Double total;
}
