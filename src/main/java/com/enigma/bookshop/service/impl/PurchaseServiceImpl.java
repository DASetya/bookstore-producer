package com.enigma.bookshop.service.impl;

import com.enigma.bookshop.config.KafkaConfig;
import com.enigma.bookshop.entity.Book;
import com.enigma.bookshop.entity.Member;
import com.enigma.bookshop.entity.Purchase;
import com.enigma.bookshop.entity.PurchaseDetail;
import com.enigma.bookshop.exception.DataNotFoundException;
import com.enigma.bookshop.repository.PurchaseRepository;
import com.enigma.bookshop.service.BookService;
import com.enigma.bookshop.service.MemberService;
import com.enigma.bookshop.service.PurchaseDetailService;
import com.enigma.bookshop.service.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    @Transactional
    public void transaction(Purchase purchase) throws JsonProcessingException {
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

            // get GrandTotal from SUM(totalPrice)
            purchase1.setGrandTotal(grandTotal+=purchaseDetail.getPriceSell());
        }
        String response =objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(purchase1);
        this.kafkaTemplate.send(KafkaConfig.TOPIC, response);
    }
}
