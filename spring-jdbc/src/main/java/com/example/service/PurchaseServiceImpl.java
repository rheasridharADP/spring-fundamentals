package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;

// DONE-09: Annotate to this class to define it as a Spring bean.
// Select the most descriptive stereotype annotation.
@Service
public class PurchaseServiceImpl implements PurchaseService {

	// DONE-10: Have Spring inject the PurchaseDao into this class.
	// Use whatever injection technique you like (constructor, setter, field).

	@Autowired PurchaseDao purchaseDAO;


	public void savePurchase(Purchase purchase) {
		purchaseDAO.savePurchase(purchase);
	}

	public List<Purchase> findAllPurchases() {
		return purchaseDAO.getAllPurchases();
	}

	public Purchase findPurchase(int id) {
		return purchaseDAO.getPurchase(id);
	}

	public Purchase findPurchase(String name, Date Date) {
		return purchaseDAO.getPurchase(name, Date);
	}

}
