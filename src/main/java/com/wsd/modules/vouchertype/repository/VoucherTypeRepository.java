package com.wsd.modules.vouchertype.repository;


import com.wsd.modules.vouchertype.entity.VoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeRepository extends JpaRepository<VoucherType, Long> {
}
