package sas.finalpo.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.*;
import sas.finalpo.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    private String code;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "items_orders",joinColumns = @JoinColumn(name = "item_id"),inverseJoinColumns = @JoinColumn(name = "order_id"))    @Builder.Default
    private List<Order> orders = new ArrayList<>();
}
