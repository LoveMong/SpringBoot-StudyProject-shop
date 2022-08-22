package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
public class CartItem extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 하나의 장바구니에는 여러개의 상품을 담을 수 있으므로 다대일 관게로 매핑
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY) // 하나의 상품은 여러 장바구니의 장바구니 상품으로 담길 수 있으므로 다대일 관계로 매핑
    @JoinColumn(name = "item_id")
    private Item item;

    private int count; // 같은 상품을 장바구니에 몇 개 담을지 저장
}
