package com.sp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int pid;
    private String type_name;
    private String image;
    private String pname;
    private String pdetails;
    private float price;

}
