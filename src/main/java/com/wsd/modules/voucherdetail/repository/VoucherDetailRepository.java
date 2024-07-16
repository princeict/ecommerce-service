package com.wsd.modules.voucherdetail.repository;


import com.wsd.modules.voucherdetail.entity.VoucherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherDetailRepository extends JpaRepository<VoucherDetail, Long> {
}
