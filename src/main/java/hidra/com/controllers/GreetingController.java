package hidra.com.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hidra.com.pojos.Login;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
/*    @RequestMapping("/login")
    @ResponseBody
    public Login login(@RequestBody Login login) {
    	
    	//El siguiente metodo lo vamos a usar para validar usuario y password.
    	
    	
    //public Login login(@RequestParam(value="user",defaultValue="blanco") String user,@RequestParam(value="clave",defaultValue="blanco") String clave) {
    	System.out.println("Ingreso al servicio Usu=" + login.getUser() + " Pass:" + login.getPassword());
    	//return new Login(user, String.format(template, clave));
    	return new Login();
    }*/
//    
//    @RequestMapping("/empresaAlta")
//    @ResponseBody
//    public CompanyAlta empresaAlta(@RequestBody CompanyAlta login) {
//
//    	return new CompanyAlta("OK");
//    }
}
