package com.mano.model;

import lombok.Data;

@Data
public class ProductGroup {
    private int productId;
    private Product product;
    private int count;
    private double price;
}
