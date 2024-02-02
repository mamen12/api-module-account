package com.test.sigmatech.account.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.commons.beans.beans.UserRequest;
import com.test.sigmatech.account.service.IAccountService;

@SpringBootTest
class AccountServiceImplTest {
	
	@Autowired
	private IAccountService acctService;;

	@Test
	void test() throws ParseException {
		UserRequest user = new UserRequest();
		user.setName("syahrul jons");
		user.setEmail("syahrulilham1011@gmail.com");
		
		acctService.insertAccount(user);
	}

}
