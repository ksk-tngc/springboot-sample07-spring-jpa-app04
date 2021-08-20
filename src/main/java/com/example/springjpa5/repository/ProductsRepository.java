package com.example.springjpa5.repository;

import com.example.springjpa5.model.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品テーブルのリポジトリインターフェース。
 * <p>{@code JpaRepository} を継承する。
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {

    /**
     * 商品名で存在チェック。
     * @param name 商品名
     * @return 商品名に該当するデータが存在する場合 true
     */
    boolean existsByName(String name);

    /**
     * 商品名で削除するクエリメソッド。
     * <p>Spring Data JPA によりメソッド名からクエリが自動生成される。
     * @param name 商品名
     * @return 削除した件数
     */
    @Transactional
    Integer deleteByName(String name);

}
