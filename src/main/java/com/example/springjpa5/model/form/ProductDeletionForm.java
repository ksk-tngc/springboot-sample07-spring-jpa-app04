package com.example.springjpa5.model.form;

import lombok.Data;

/**
 * 商品削除フォームのモデル。
 */
@Data
public class ProductDeletionForm {

    /**
     * 商品ID
     */
    private Long deletionProductId;

    /**
     * 商品名
     */
    private String deletionProductName;

    /**
     * 商品IDの削除ボタン
     * <p>このボタンで submit された場合 true
     */
    private Boolean isProductIdDeleteButtonClicked;

    /**
     * 商品名の削除ボタン
     * <p>このボタンで submit された場合 true
     */
    private Boolean isProductNameDeleteButtonClicked;

}
