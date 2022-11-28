package com.OnlineMedicalShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnlineMedicalShop.model.Cart;


public interface CartRepository extends JpaRepository<Cart,Long>{


//    @Query(value = "SELECT * FROM cart WHERE user_id=:uid AND product_id=:pid",nativeQuery = true)
//    Cart findById(int uid, int pid);
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "DELETE  FROM cart WHERE user_id = :uid AND product_id=:pid",nativeQuery = true)
//    void deleteById(int uid, int pid);
//
//    @Query(value = "SELECT * FROM cart WHERE user_id=:uid",nativeQuery = true)
//    List<Cart> findByUid(int uid);

}
