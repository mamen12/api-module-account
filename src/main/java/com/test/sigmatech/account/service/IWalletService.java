package com.test.sigmatech.account.service;

import java.text.ParseException;

import com.commons.beans.beans.WalletRequest;
import com.commons.beans.beans.WalletResponse;

public interface IWalletService {
	public void insertWallet(WalletRequest wallet) throws ParseException;
	public WalletResponse getBallanceWallet(WalletRequest request);
	public WalletResponse updateBallance(WalletRequest rq);
}
