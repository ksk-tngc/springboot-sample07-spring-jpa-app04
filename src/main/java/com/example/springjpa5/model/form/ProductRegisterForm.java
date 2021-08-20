package com.example.springjpa5.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 商品登録フォームのモデル。
 */
@Data
public class ProductRegisterForm {

    /**
     * 商品名
     */
    @NotBlank(message = "商品名を入力してください") // 必須
    @Size(max = 40, message = "40文字以内で入力してください") // 40文字まで
    private String registerProductName;

    /**
     * 価格
     */
    @NotNull(message = "価格を入力してください") // 必須
    private Integer registerProductPrice;

}
