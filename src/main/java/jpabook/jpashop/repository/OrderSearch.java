package jpabook.jpashop.repository;


import jpabook.jpashop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@Getter
@Setter

public class OrderSearch {

    private String memberName;//회원이름
    private OrderStatus orderStatus;

}
