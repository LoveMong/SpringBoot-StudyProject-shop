package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    /* find + (엔티티 이름) + By + 변수이름
       itemNm(상품명)으로 데이터를 조회하기 위해서 By 뒤에 필드명인 ItemNm을 메소드의 이름에 붙여줌
       엔티티명은 생략이 가능
     */
    List<Item> findByItemNm(String itemNm);

    /* 상품을 상품명과 상품 상세 설명을 OR 조건을 이용하여 조회하는 쿼리 */
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    /* 파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리 */
    List<Item> findByPriceLessThan(Integer price);

    /* 내림차순 또는 오름차순으로 조회
       오름(내림)차순 : OrderBy + 속성명 + Asc(Desc) */
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);


    /* JPQL(객체지향 쿼리 언어) 사용하여 복잡한 쿼리도 처리 가능 */
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc ")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
