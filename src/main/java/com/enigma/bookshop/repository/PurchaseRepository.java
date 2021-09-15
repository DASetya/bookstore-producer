package com.enigma.bookshop.repository;

import com.enigma.bookshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
