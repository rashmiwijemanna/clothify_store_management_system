package model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    private String id;
    private String name;
    private Double price;
    private int Qty;
    private String supplierId;
}
