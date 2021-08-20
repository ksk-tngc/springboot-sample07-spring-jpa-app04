package com.example.springjpa5.config;

import com.example.springjpa5.model.entity.Product;
import com.example.springjpa5.repository.ProductsRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * データローダコンポーネント。
 * 
 * <p>DBの初期データを登録するコンポーネント。
 * Spring Boot 起動時にコマンドラインとして実行される。（{@link CommandLineRunner}）
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    /**
     * 商品テーブルのリポジトリ。
     * <p>コンストラクタインジェクション。
     */
    private final ProductsRepository productsRepository;

    /**
     * Spring Boot 起動時に実行されるコマンドライン処理。
     */
    @Override
    public void run(String... args) throws Exception {
        // 商品テーブルの初期データを登録
        Product p = new Product();
        p.setName("商品A");
        p.setPrice(1000);
        productsRepository.save(p);

        p = new Product();
        p.setName("商品B");
        p.setPrice(2000);
        productsRepository.save(p);

        p = new Product();
        p.setName("商品C");
        p.setPrice(3000);
        productsRepository.save(p);
    }

}
