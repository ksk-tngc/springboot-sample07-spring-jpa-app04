package com.example.springjpa5.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 商品テーブルのエンティティクラス。
 */
@Entity
@Data
@Table(name = "PRODUCTS")
public class Product {

    /**
     * 商品ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 商品名
     */
    @NotBlank
    @NotNull
    @Size(max = 40)
    private String name;

    /**
     * 価格
     */
    @NotNull
    private Integer price;

}
