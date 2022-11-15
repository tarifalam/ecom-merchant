package com.ecom.merchant.merchant.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Divineit-Iftekher on 8/9/2017.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Override
    List<Product> findAll();
}
