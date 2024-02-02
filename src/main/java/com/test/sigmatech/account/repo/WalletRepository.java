package com.test.sigmatech.account.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.sigmatech.account.model.Wallet;

import jakarta.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

	@Query("SELECT COUNT(u) FROM Wallet u WHERE u.accountNo=?1")
	public Integer countAccountNo(String accountNo);
	
	
	@Query("SELECT u FROM Wallet u WHERE u.accountNo=?1")
	public Wallet getAccountNo(String accountNo);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Wallet u SET u.ballance=?1 WHERE u.accountNo=?2")
	public void reducedBallance(BigDecimal ballance, String accountNo);
}
