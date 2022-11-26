package com.ecom.merchant.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Divineit-Iftekher on 8/9/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Override
    Set<Product> findAll();
}
