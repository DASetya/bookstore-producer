package com.enigma.bookshop.service;

import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import com.enigma.bookshop.exception.DataNotFoundException;
import com.enigma.bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    @Override
    @Transactional
    public Purchase transaction(Purchase purchase) {
        Purchase purchase1 = purchaseRepository.save(purchase);
        Member member = memberService.getmMemberById(purchase.getMember().getId());
        purchase1.setMember(member);
        Double grandTotal = 0.0;
        for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
            purchaseDetail.setPurchase(purchase1);
            Book book =bookService.getBookById(purchaseDetail.getBook().getId());

            // validasi buku masih ada stok atau tidak
            if (book.getStock() == 0)
                throw new DataNotFoundException("Book is out of stock");

            // validasi apakah ketersediaan mencukupi
            else if (book.getStock() < purchaseDetail.getQuantity()) {
                throw new DataNotFoundException("you can't buy this book with this amount");
            }

            // update stock buku
            book.setStock(book.getStock()- purchaseDetail.getQuantity());

            // get price sell from quantity * book price
            purchaseDetail.setPriceSell((double) (book.getPrice() * purchaseDetail.getQuantity()));
            purchaseDetail.setBook(book);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);

            purchase1.setGrandTotal(grandTotal+=purchaseDetail.getPriceSell());
        }
        return purchase1;
    }
}
