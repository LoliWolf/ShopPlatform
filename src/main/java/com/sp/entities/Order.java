package com.sp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String order_id;
    private boolean status;
    private int item_id;
    private String type_name;
    private String img;
    private String name;
    private String info;
    private float price;
}
