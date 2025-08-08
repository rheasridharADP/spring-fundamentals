package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;

//	DONE-03: Add an annotation to this bean to make all methods transactional.
//	Be sure to import the annotation from "org.springframework..." 
@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired PurchaseDao purchaseDAO;

	public List<Purchase> findAllPurchases() {
		return purchaseDAO.getAllPurchases();
	}

	public Purchase findPurchase(int id) {
		return purchaseDAO.getPurchase(id);
	}

	public Purchase findPurchase(String name, Date Date) {
		return purchaseDAO.getPurchase(name, Date);
	}

	//	DONE-13: Add an annotation to override the transaction propagation behavior.
	//  We want to require a new transaction when this method is called.
	//  (Hint: if the propagation attribute is not available, you may have the wrong import.)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void savePurchase(Purchase purchase) {
		purchaseDAO.savePurchase(purchase);
	}

	//  DONE-14: Organize imports, save your work.
	//  Return to the previous test.  Run it again.  It should pass.
}
