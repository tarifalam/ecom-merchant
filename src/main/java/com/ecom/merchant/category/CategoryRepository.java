package com.ecom.merchant.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Divineit-Iftekher on 8/9/2017.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    @Override
    List<Category> findAll();
}
