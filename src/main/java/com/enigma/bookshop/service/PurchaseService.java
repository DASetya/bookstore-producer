package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;

public interface PurchaseService {
    Purchase transaction(Purchase purchase);
}
