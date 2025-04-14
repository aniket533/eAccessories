package com.grownited.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import net.authorize.Environment;
import net.authorize.api.contract.v1.ANetApiResponse;
import net.authorize.api.contract.v1.CreateTransactionRequest;
import net.authorize.api.contract.v1.CreateTransactionResponse;
import net.authorize.api.contract.v1.CreditCardType;
import net.authorize.api.contract.v1.CustomerDataType;
import net.authorize.api.contract.v1.MerchantAuthenticationType;
import net.authorize.api.contract.v1.MessageTypeEnum;
import net.authorize.api.contract.v1.PaymentType;
import net.authorize.api.contract.v1.TransactionRequestType;
import net.authorize.api.contract.v1.TransactionResponse;
import net.authorize.api.contract.v1.TransactionTypeEnum;
import net.authorize.api.controller.CreateTransactionController;
import net.authorize.api.controller.base.ApiOperationBase;

@Service
public class AuthorizePaymentService {

	public String run(Double amount, String ccNum, String cvv, String expDate, String email) {

		// 1. Set API credentials and environment
		ApiOperationBase.setEnvironment(Environment.SANDBOX);

		// Create object with merchant authentication details
		MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
		merchantAuthenticationType.setName("3g2jk6YYs"); // Provide your real API credentials (could be loaded from
															// properties file)
		merchantAuthenticationType.setTransactionKey("739UCc8S59kser8g");

		// 2. Set card info
		CreditCardType creditCard = new CreditCardType();
		creditCard.setCardNumber(ccNum);
		creditCard.setCardCode(cvv);
		creditCard.setExpirationDate(expDate);

		// Populate the payment data
		PaymentType paymentType = new PaymentType();
		paymentType.setCreditCard(creditCard);

		// Set email address (optional)
		CustomerDataType customer = new CustomerDataType();
		customer.setEmail(email);

		// 3. Create the payment transaction object
		TransactionRequestType txnRequest = new TransactionRequestType();
		txnRequest.setTransactionType(TransactionTypeEnum.AUTH_CAPTURE_TRANSACTION.value());
		txnRequest.setPayment(paymentType);
		txnRequest.setCustomer(customer);
		txnRequest.setAmount(new BigDecimal(amount).setScale(2, RoundingMode.CEILING));

		// Create the API request and set the parameters for this specific request
		CreateTransactionRequest apiRequest = new CreateTransactionRequest();
		apiRequest.setMerchantAuthentication(merchantAuthenticationType);
		apiRequest.setTransactionRequest(txnRequest);

		// 4. Execute transaction, Call the controller
		CreateTransactionController controller = new CreateTransactionController(apiRequest);
		controller.execute();

		// 5. Get the response
		CreateTransactionResponse response = controller.getApiResponse();

		// Parse the response to determine results
		if (response != null) {
			// If API Response is OK, go ahead and check the transaction response
			if (response.getMessages().getResultCode() == MessageTypeEnum.OK) {
				TransactionResponse result = response.getTransactionResponse();
				if (result.getMessages() != null) {
					System.out.println("Successfully created transaction with Transaction ID: " + result.getTransId());
					System.out.println("Response Code: " + result.getResponseCode());
					System.out.println("Message Code: " + result.getMessages().getMessage().get(0).getCode());
					System.out.println("Description: " + result.getMessages().getMessage().get(0).getDescription());
					System.out.println("Auth Code: " + result.getAuthCode());
					return result.getTransId(); // ✅ Return transaction ID
				} else {

					System.out.println("Failed Transaction.");
					if (response.getTransactionResponse().getErrors() != null) {
						System.out.println("Error Code: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
						System.out.println("Error message: "
								+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
					}
				}
			} else {
				System.out.println("Failed Transaction.");
				if (response.getTransactionResponse() != null
						&& response.getTransactionResponse().getErrors() != null) {
					System.out.println("Error Code: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorCode());
					System.out.println("Error message: "
							+ response.getTransactionResponse().getErrors().getError().get(0).getErrorText());
				} else {
					System.out.println("Error Code: " + response.getMessages().getMessage().get(0).getCode());
					System.out.println("Error message: " + response.getMessages().getMessage().get(0).getText());
				}
			}
		} else {
			// Display the error code and message when response is null
			ANetApiResponse errorResponse = controller.getErrorResponse();
			System.out.println("Failed to get response");
			if (!errorResponse.getMessages().getMessage().isEmpty()) {
				System.out.println("Error: " + errorResponse.getMessages().getMessage().get(0).getCode() + " \n"
						+ errorResponse.getMessages().getMessage().get(0).getText());
			}
		}

		return "Error: Unknown error occurred during payment processing";
	}
}