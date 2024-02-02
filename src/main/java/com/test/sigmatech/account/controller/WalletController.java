package com.test.sigmatech.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commons.beans.beans.Request;
import com.commons.beans.beans.Response;
import com.commons.beans.beans.UserRequest;
import com.commons.beans.beans.WalletRequest;
import com.commons.beans.beans.WalletResponse;
import com.commons.beans.constant.ApiResponse;
import com.test.sigmatech.account.service.IWalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private IWalletService walletService;
	
	@RequestMapping(value = "/ballance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public WalletResponse getBallanceAccountNo(@RequestBody Request<WalletRequest> rq){
		 WalletResponse response = new WalletResponse();
		 response =  walletService.getBallanceWallet(rq.getRequestPayload());
		 return response;
	 }
	
	@RequestMapping(value = "/update_saldo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public WalletResponse updateSaldo(@RequestBody Request<WalletRequest> rq){
		 WalletResponse response = new WalletResponse();
		 response =  walletService.updateBallance(rq.getRequestPayload());
		 return response;
	 }
	
	
}
