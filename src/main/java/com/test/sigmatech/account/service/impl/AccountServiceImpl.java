package com.test.sigmatech.account.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.commons.beans.beans.UserRequest;
import com.commons.beans.beans.UserResponse;
import com.commons.beans.beans.WalletRequest;
import com.commons.beans.beans.utils.RandomNumberUtils;
import com.commons.beans.constant.AppConstants;
import com.test.sigmatech.account.model.Account;
import com.test.sigmatech.account.repo.AccountRepository;
import com.test.sigmatech.account.service.IAccountService;
import com.test.sigmatech.account.service.IWalletService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private IWalletService walletService;
	
	@Override
	public void insertAccount(UserRequest acct) throws ParseException {
		String id = UUID.randomUUID().toString();
		long random = RandomNumberUtils.getCurrentTime();
		if (repo.countEmailAccount(acct.getEmail()) < 1) {
			Account account = new Account();
			account.setIdUser(id);
			account.setName(acct.getName());
			account.setEmail(acct.getEmail());
			account.setIsDel("N");
			account.setVersion(0);
			account.setCreatedAt(new Date());
			account.setCreatedBy(AppConstants.SYSTEM);
			account.setAccountNo(RandomNumberUtils.generate(random));
			
			repo.save(account); 
			
			try {
				WalletRequest wallet = new WalletRequest();
				wallet.setAccountNo(account.getAccountNo());
				
				walletService.insertWallet(wallet);
			} catch (Exception e) {
				throw e;
			}
			
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exits");
		}
		
		
	}

	@Override
	public List<UserResponse> getLisAccount(UserRequest payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserAllAccounts(List<Account> accounts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserResponse getAccountByEmail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
