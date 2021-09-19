package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PurchaseService {
    void transaction(Purchase purchase) throws JsonProcessingException;
}
