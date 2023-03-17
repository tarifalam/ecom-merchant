package com.ecom.merchant.category;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;


    @OneToOne(optional = true,fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    Category category;
    
    
}
