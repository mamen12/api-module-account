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
import com.commons.beans.beans.UserResponse;
import com.commons.beans.constant.ApiResponse;
import com.test.sigmatech.account.service.IAccountService;

@RestController
@RequestMapping("/api/acct")
public class AccountController {

	
	@Autowired
	private IAccountService acctService;
	
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	 public Response<String> addedAccount(@RequestBody Request<UserRequest> rq){
		 Response<String> response = new Response<>();
		 
		 try {
			 acctService.insertAccount(rq.getRequestPayload());
			response.setStatusResponse(ApiResponse.SUCCESS);
		} catch (Exception e) {
			response.setStatusResponse(ApiResponse.FAILED);
		}
		 return response;
	 }
	
	 @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
     public UserResponse detailUser(@RequestBody Request<UserRequest> rq){
		UserResponse user =new UserResponse();
		try {
			user = acctService.getAccountById(rq.getRequestPayload().getId());
		} catch (Exception e) {
			throw e;
		}
		return user;
     }
	
}
