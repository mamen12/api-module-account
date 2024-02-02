package com.test.sigmatech.account.service;

import java.text.ParseException;
import java.util.List;

import com.commons.beans.beans.UserRequest;
import com.commons.beans.beans.UserResponse;
import com.test.sigmatech.account.model.Account;

public interface IAccountService {
	public void insertAccount(UserRequest acct) throws ParseException;
	public List<UserResponse> getLisAccount(UserRequest payload); 
	public void inserAllAccounts(List<Account> accounts);
	public UserResponse getAccountById(String id);
}
