package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member; //Member와의 연관관계에서 연관관계의 주인

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    //연관관계 편의 메서드
    //둘의 연관관계를 함께 묵어주는 메서드
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem); //orderItem == 객체   Order에 있는 orderItems에 orderItem을 추가해줌
        orderItem.setOrder(this); //this == Order     OrderItem에 Order를 세팅해줌
    }
}
