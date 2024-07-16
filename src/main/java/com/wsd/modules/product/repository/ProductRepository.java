package com.wsd.modules.product.repository;


import com.wsd.modules.usertype.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<UserType, Long> {
}
