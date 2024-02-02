package com.test.sigmatech.account.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.sigmatech.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("SELECT COUNT(u) FROM Account u WHERE u.email=?1")
	public Integer countEmailAccount(String email);
	
	@Query("SELECT u FROM Account u Where u.email=?1")
	public Account findAccountByEmail(String email);
	
}
