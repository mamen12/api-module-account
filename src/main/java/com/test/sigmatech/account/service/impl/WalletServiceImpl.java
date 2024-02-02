package com.test.sigmatech.account.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.commons.beans.beans.WalletRequest;
import com.commons.beans.beans.WalletResponse;
import com.commons.beans.constant.AppConstants;
import com.test.sigmatech.account.model.Wallet;
import com.test.sigmatech.account.repo.WalletRepository;
import com.test.sigmatech.account.service.IWalletService;

@Service
public class WalletServiceImpl implements IWalletService {
	
	Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

	@Autowired
	private WalletRepository repo;
	
	@Override
	public void insertWallet(WalletRequest rq) throws ParseException {
		String id = UUID.randomUUID().toString();
		if (repo.countAccountNo(rq.getAccountNo()) < 1) {
			
			Wallet wallet = new Wallet();
			wallet.setIdWallet(id);
			wallet.setAccountNo(rq.getAccountNo());
			wallet.setBallance(new BigDecimal(0));
			wallet.setIsDel("N");
			wallet.setVersion(0);
			wallet.setCreatedAt(new Date());
			wallet.setCreatedBy(AppConstants.SYSTEM);
			
			repo.save(wallet); 
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exits");
		}
		
	}

	@Override
	public WalletResponse getBallanceWallet(WalletRequest rq) {
		WalletResponse response = new WalletResponse();
		response.setIsInsufficient(AppConstants.INSUFFFICIENT_BALANCE);
		try {
			Wallet wallet = repo.getAccountNo(rq.getAccountNo());
			if (wallet.getBallance().compareTo(rq.getBallance()) >= 0 ) {
				response.setIsInsufficient(AppConstants.BALANCE);
			}
		} catch (Exception e) {
			logger.info(rq.getAccountNo() + " " + AppConstants.INSUFFFICIENT_BALANCE);
		}
		return response;
		
	}
	
	@Override
	public WalletResponse updateBallance(WalletRequest rq) {
		WalletResponse response = new WalletResponse();
		response.setReduced(false);
		try {
			Wallet wallet = repo.getAccountNo(rq.getAccountNo());
			if (wallet.getBallance().compareTo(rq.getBallance()) >= 0 ) {
				BigDecimal reduced = wallet.getBallance().subtract(rq.getBallance());
				repo.reducedBallance(reduced, rq.getAccountNo());
				response.setReduced(true);
			}
		} catch (Exception e) {
			logger.info(rq.getAccountNo() + " " + AppConstants.INSUFFFICIENT_BALANCE);
		}
		return response;
		
	}
	
}
