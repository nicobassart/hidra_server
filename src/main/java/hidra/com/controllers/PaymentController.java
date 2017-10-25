package hidra.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import hidra.com.dao.ComponenteDao;
import hidra.com.dao.PerfilDao;
import hidra.com.dao.UsuarioDao;

@RestController
public class PaymentController {

	@Autowired
	private ComponenteDao companyDao;
	
	@Autowired
	private PerfilDao ownerDao;

	@Autowired
	private UsuarioDao usuDao;
	  

/*	@RequestMapping (value = "token", method = RequestMethod.POST,    produces="text/xml")
	public String paymentCheck(@RequestParam(value = "stripeToken", required = true) String tokenCustomer, 
			@RequestParam(value = "amount", required = true) String amount, @RequestParam(value = "mail", required = true) String mail,HttpServletRequest request ) {
		
		// Set your secret key: remember to change this to your live secret key in production
		// See your keys here: https://dashboard.stripe.com/account/apikeys
		Stripe.apiKey = "sk_test_xVLmDlIekpgrQOfkVNvUIE4U";

		// Get the credit card details submitted by the form
		String token = tokenCustomer;//request.getParameter("stripeToken");
		  BufferedReader in;
		try {
			in = new BufferedReader(          new InputStreamReader(request.getInputStream()));
			in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		// Create a charge: this will charge the user's card
		try {
		  HashMap<String, Object> chargeParams = new HashMap<String, Object>();
		  chargeParams.put("amount", amount); // Amount in cents
		  chargeParams.put("currency", "usd");
		  chargeParams.put("source", token);
		  chargeParams.put("receipt_email", mail);
		  
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
		return "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\"> <head><style> .alert { padding: 20px;background-color: #4CAF50; color: white;} .closebtn {margin-left: 15px; color: white; font-weight: bold; float: right; font-size: 22px; line-height: 20px; cursor: pointer; transition: 0.3s; } .closebtn:hover { color: black; }	</style> </head><body bgcolor=\"#fafafa\"><div class=\"alert\"> "+
			    "<center>"+
			      "<strong>Payment has been processed successfully.</strong> <br/><br/>  Thanks for your purchase. We will be in touch with you promptly.<br/>"+
			    "</center></div></body></html>";
//		return "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\"> <head><style> .alert { padding: 20px;background-color: #4CAF50; color: white;} .closebtn {margin-left: 15px; color: white; font-weight: bold; float: right; font-size: 22px; line-height: 20px; cursor: pointer; transition: 0.3s; } .closebtn:hover { color: black; }	</style> <script language=\"javascript\">   function validClick(){"+
//		"      alert('Estamos' ); Android.valid();\n" +
//		"   }\n" +
//		"</script></head><body><div class=\"alert\"> "+
//		"<center>"+
//		"<strong>Payment has been processed successfully.</strong> <br/><br/>  Thanks for your purchase. We will be in touch with you promptly.<br/> <br/>  <button type=\"button\" onClick=\"Android.valid();validClick();\" >Home</button>"+
//		"</center></div></body></html>";
	} */
	
}