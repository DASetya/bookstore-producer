package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import com.enigma.bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Override
    public Purchase transaction(Purchase purchase) {
        Purchase purchase1 = purchaseRepository.save(purchase);
        for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
            purchaseDetail.setPurchase(purchase1);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);
        }
        return purchase1;
    }
}
