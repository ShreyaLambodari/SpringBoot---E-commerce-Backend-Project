package com.ecom_proj.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class ProductDTO {

    private String name;
    private BigDecimal price;
    private String brand;
    private String description;
    private String availability;
    private Long categoryId;
    private int available;
    private Date releasedate;
}
