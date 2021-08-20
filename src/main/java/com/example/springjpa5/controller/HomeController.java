package com.example.springjpa5.controller;

import com.example.springjpa5.model.entity.Product;
import com.example.springjpa5.model.form.ProductDeletionForm;
import com.example.springjpa5.model.form.ProductRegisterForm;
import com.example.springjpa5.repository.ProductsRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

/**
 * トップページのコントローラ。
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    /**
     * 商品テーブルのリポジトリ。
     * <p>コンストラクタインジェクション。
     */
    private final ProductsRepository productsRepository;

    /**
     * トップページ。
     */
    @GetMapping("/")
    public String index(Model model, @ModelAttribute ProductRegisterForm productRegisterForm,
            @ModelAttribute ProductDeletionForm productDeletionForm) {
        // 商品テーブルの全レコードを Model に追加
        model.addAttribute("products", productsRepository.findAll());
        return "index";
    }

    /**
     * 商品登録処理。
     * 
     * <p>MEMO: {@code RedirectAttributes#addFlashAttribute()} -> Flash Scope (1回のリダイレクトで有効なスコープ) で
     * リダイレクト先にパラメータを送ることができ、リダイレクト先ハンドラメソッドの Model に自動的に追加される。
     */
    @PostMapping("/product/create")
    public String createProduct(Model model, @Validated @ModelAttribute ProductRegisterForm productRegisterForm,
            BindingResult bindingResult, @ModelAttribute ProductDeletionForm productDeletionForm,
            RedirectAttributes redirectAttributes) {
        // バリデーションエラーあり
        if (bindingResult.hasErrors()) {
            return index(model, productRegisterForm, productDeletionForm); // エラー表示
        }

        // フォームの値を格納
        final String productName = productRegisterForm.getRegisterProductName(); // 商品名
        final Integer productPrice = productRegisterForm.getRegisterProductPrice(); // 価格

        // 商品名で存在チェック
        if (productsRepository.existsByName(productName)) {
            // "商品名" は登録済みです。
            model.addAttribute("registerErrorgMessage", String.format("\"%s\" は登録済みです。", productName));
            model.addAttribute(productRegisterForm);
            return index(model, productRegisterForm, productDeletionForm);
        }

        // 商品登録
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        productsRepository.save(product);

        // "商品名" を登録しました。
        redirectAttributes.addFlashAttribute("registerSuccessMessage", "\"" + productName + "\" を登録しました。");

        return "redirect:/";
    }

    /**
     * 商品削除処理。
     * 
     * <p>MEMO: {@code RedirectAttributes#addFlashAttribute()} -> Flash Scope (1回のリダイレクトで有効なスコープ) で
     * リダイレクト先にパラメータを送ることができ、リダイレクト先ハンドラメソッドの Model に自動的に追加される。
     */
    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute ProductDeletionForm productDeletionForm,
            RedirectAttributes redirectAttributes) {
        // 商品IDの削除ボタンで submit された場合
        if (productDeletionForm.getIsProductIdDeleteButtonClicked() != null) {
            // フォームの値を格納
            final Long productId = productDeletionForm.getDeletionProductId(); // 商品ID

            // 存在チェック
            if (productsRepository.existsById(productId)) { // 存在する場合
                productsRepository.deleteById(productId); // 商品IDをキーに削除
                // 商品ID xx を削除しました。
                redirectAttributes.addFlashAttribute("deletionSuccessMessage", "商品ID " + productId + " を削除しました。"); // リダイレクト先に送信するパラメータ
            } else { // 存在しない場合
                // 商品ID xx は存在しません。
                redirectAttributes.addFlashAttribute("deletionErrorMessage", "商品ID " + productId + " は存在しません。"); // リダイレクト先に送信するパラメータ
                redirectAttributes.addFlashAttribute(productDeletionForm); // 現在のForm入力値もリダイレクト先に渡す
            }
        } else if (productDeletionForm.getIsProductNameDeleteButtonClicked() != null) {
            // 商品名の削除ボタンで submit された場合
            // フォームの値を格納
            final String productName = productDeletionForm.getDeletionProductName(); // 商品名

            // 存在チェック
            if (productsRepository.existsByName(productName)) { // 存在する場合
                productsRepository.deleteByName(productName); // 商品名をキーに削除
                // "商品名" を削除しました。
                redirectAttributes.addFlashAttribute("deletionSuccessMessage", "\"" + productName + "\" を削除しました。"); // リダイレクト先に送信するパラメータ
            } else {
                // "商品名" を存在しません。
                redirectAttributes.addFlashAttribute("deletionErrorMessage", "\"" + productName + "\" は存在しません。"); // リダイレクト先に送信するパラメータ
                redirectAttributes.addFlashAttribute(productDeletionForm); // 現在のForm入力値もリダイレクト先に渡す
            }
        }

        return "redirect:/";
    }

}
