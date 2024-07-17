package com.wsd.modules.Product.entity;


import com.wsd.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Product extends BaseEntity implements Serializable {
    private String name;
    private String code;
    @Column(columnDefinition="TEXT", length = 5000)
    private String description;
    private Double amount;
}
