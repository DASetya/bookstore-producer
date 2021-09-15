package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import com.enigma.bookshop.repository.PurchaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService{

    @Autowired
    PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail) {
        return purchaseDetailRepository.save(purchaseDetail);
    }
}
