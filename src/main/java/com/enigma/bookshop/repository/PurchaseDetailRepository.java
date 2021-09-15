package com.enigma.bookshop.repository;

import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, String> {
}
