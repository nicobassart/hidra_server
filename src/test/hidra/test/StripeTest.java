package hidra.test;

public class StripeTest {

/*	public static void main(String[] args) {
//		Stripe.apiKey = "sk_test_xVLmDlIekpgrQOfkVNvUIE4U";
//
//		Map<String, Object> chargeParams = new HashMap<String, Object>();
//		chargeParams.put("amount", 2000);
//		chargeParams.put("currency", "usd");
//		Map<String, Object> sourceParams = new HashMap<String, Object>();
//		sourceParams.put("number", "4242424242424242");
//		sourceParams.put("exp_month", 8);
//		sourceParams.put("exp_year", 2017);
//		sourceParams.put("cvc", "314");
//		chargeParams.put("source", sourceParams);
//		chargeParams.put("description", "Charge for addison.taylor@example.com");
//
//		Charge.create(chargeParams);	

		
		
		// Set your secret key: remember to change this to your live secret key in production
		// See your keys here: https://dashboard.stripe.com/account/apikeys
		Stripe.apiKey = "sk_test_xVLmDlIekpgrQOfkVNvUIE4U";

		// Get the credit card details submitted by the form
		String token = "tok_18oWPdFZZD9ZznjYpr7kBFny";//request.getParameter("stripeToken");

		// Create a charge: this will charge the user's card
		try {
		  HashMap<String, Object> chargeParams = new HashMap<String, Object>();
		  chargeParams.put("amount", 625); // Amount in cents
		  chargeParams.put("currency", "usd");
		  chargeParams.put("source", token);
		  chargeParams.put("receipt_email", "nicobassart@gmail.com");
		  
		  chargeParams.put("description", "Example charge");

		  try {
			Charge charge = Charge.create(chargeParams);
		} catch (AuthenticationException | InvalidRequestException | APIConnectionException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (CardException e) {
		  // The card has been declined
		}
	}*/
}