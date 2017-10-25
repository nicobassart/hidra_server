package hidra.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hidra.com.dao.ComponenteDao;
import hidra.com.dao.PasswordDao;
import hidra.com.dao.PerfilDao;
import hidra.com.dao.UsuarioDao;
import hidra.com.email.SimpleOrderManager;
import hidra.com.model.Componente;
import hidra.com.model.Password;
import hidra.com.model.Perfil;
import hidra.com.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class UsuarioControllerTests {
	@Autowired
	private SimpleOrderManager simpleOrderManager;

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ComponenteDao componenteDao;
	@Autowired
	private PasswordDao passwordDao;
	@Autowired
	private PerfilDao perfilDao;

	/*
	 * @Autowired private WebApplicationContext ctx;
	 * 
	 * private MockMvc mockMvc;
	 * 
	 * @Autowired private CompanyDao companyDao;
	 * 
	 * @Autowired private OwnerDao ownerDao;
	 * 
	 * //Hace el alta de una empresa y un usuario // @Test // public void
	 * testRepostory() // { // // Company companyEnt = new Company(); // //
	 * companyEnt.setTypeEntity("C"); // companyEnt.setLocationWhere("C"); //
	 * companyEnt.setNameCompanyOne("C"); // companyEnt.setNameCompanyTwo("C");
	 * // companyEnt.setNameCompanyThree("C"); //
	 * companyEnt.setAddressPhysical("C"); // companyEnt.setAddressCity("C"); //
	 * companyEnt.setAddressState("C"); // companyEnt.setAddressZip("C"); //
	 * companyEnt.setAddressDifferent(false); //
	 * companyEnt.setRegisteredAgentOther(true); //
	 * companyEnt.setRegisteredAgentOwn(true); //
	 * companyEnt.setOwnersQuantity(2); // companyEnt.setBusinessDo(1); //
	 * companyEnt.setBusinessDescription("C"); // // // //User unUsuario =
	 * userDao.findByUser("n"); // // User unUsuario = new User(); //
	 * unUsuario.setPassword("e"); // unUsuario.setUser("e"); //
	 * userDao.save(unUsuario); // companyEnt.setUser(unUsuario); // //
	 * companyDao.save(companyEnt); // }
	 * 
	 * 
	 * //Hace el alta de una empresa y un usuario
	 * 
	 * @Test public void testTwoRepostory() { User user = userDao.findById(7);
	 * 
	 * Company myComp=null;// companyDao.findByUser(user); // if(myComp !=null){
	 * // // // Significa que encontro al menos uno. myComp.getTypeEntity();
	 * myComp.getLocationWhere(); myComp.getNameCompanyOne();
	 * myComp.getNameCompanyTwo(); myComp.getNameCompanyThree(); //
	 * companyAlta.setAddressPhysical(myComp.getAddressPhysical()); //
	 * companyAlta.setAddressCity(myComp.getAddressCity()); //
	 * companyAlta.setAddressState(myComp.getAddressState()); //
	 * companyAlta.setAddressZip(myComp.getAddressZip()); //
	 * companyAlta.setAddressDifferent(myComp.isAddressDifferent()); //
	 * companyAlta.setRegisteredAgentOther(myComp.isRegisteredAgentOther()); //
	 * companyAlta.setRegisteredAgentOwn(myComp.isRegisteredAgentOwn()); //
	 * companyAlta.setOwnersQuantity(myComp.getOwnersQuantity()); //
	 * companyAlta.setBusinessDo(myComp.getBusinessDo()); //
	 * companyAlta.setBusinessDescription(myComp.getBusinessDescription()); // }
	 * }
	 * 
	 * 
	 * // @Before // public void setUp() { // this.mockMvc =
	 * MockMvcBuilders.webAppContextSetup(ctx).build(); // } // // @Test //
	 * public void noParamGreetingShouldReturnDefaultMessage() throws Exception
	 * { // // this.mockMvc.perform(get("/companyCreate").param("idUser",
	 * "1").param("modo", "C")) // .andDo(print()) //
	 * .andExpect(status().isOk()) //
	 * .andExpect(jsonPath("$.content").value("Hello, World!")); // }
	 * 
	 * // @Test // public void paramGreetingShouldReturnTailoredMessage() throws
	 * Exception { // // this.mockMvc.perform(get("/greeting").param("name",
	 * "Spring Community")) // .andDo(print()) // .andExpect(status().isOk()) //
	 * .andExpect(jsonPath("$.content").value("Hello, Spring Community!")); // }
	 */
	//@Test
	public void testEmail() {
		simpleOrderManager.sendMail("nicobassart@gmail.com", "nicobassart@gmail.com", "Nada",
				"Estamos haciendo una prueba");

		/*
		 * try { String host = "smtp.gmail.com";
		 * 
		 * Properties props = System.getProperties(); props.put("mail.host",
		 * host); props.put("mail.transport.protocol", "smtp");
		 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port",
		 * "587"); //props.put("mail.smtp.ssl.trust", host);
		 * props.put("mail.smtp.socketFactory.fallback", "true");
		 * 
		 * Session mailSession = Session.getInstance(props);
		 * mailSession.setDebug(true);
		 * 
		 * Message msg = new MimeMessage(mailSession); msg.setFrom(new
		 * InternetAddress("nicobassart@gmail.com")); InternetAddress[] address
		 * = { new InternetAddress("nicobassart@gmail.com") };
		 * msg.setRecipients(Message.RecipientType.TO, address);
		 * msg.setSubject("prueba"); //msg.setSentDate((new Date()));
		 * msg.setText("nada");
		 * 
		 * Transport transport = mailSession.getTransport("smtps");
		 * transport.connect(host, "info@startabusinessapp.com", "Purple#1");
		 * transport.sendMessage(msg, msg.getAllRecipients());
		 * transport.close(); } catch (Exception ex) {
		 * ex.printStackTrace(System.err); }
		 */
	}

	// @Test
	public void testDaoDeleteUsuario() {
		Usuario usu = usuarioDao.findByUsuario("nicolas");
		usuarioDao.delete(usu);

	}

	@Test
	public void testDaoCreateUsuarioOnly() {
		try {
			Usuario usu = new Usuario();
			usu.setUsuario("Test9");

			this.usuarioDao.save(usu);
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Error:" + ex);
		}
	}

	// @Test
	public void testDaoCreateUsuario() {
		Usuario usu = new Usuario();
		usu.setUsuario("Test3");

		// Creamos el componente
		try {
			Password pass = new Password();
			pass.setPassword("prueba");
			pass.setFechaAlta(Calendar.getInstance().getTime());

			// this.usuarioDao.save(usu);
			// pass.setUsuario(usu);
			passwordDao.save(pass);

		} catch (DataIntegrityViolationException ex) {
			System.out.println("Error:" + ex);
		}

		// Creamos el componente
		try {
			Componente comp = new Componente();
			comp.setComponente("info1");
			componenteDao.save(comp);
			List<Componente> compList = new ArrayList<Componente>();
			compList.add(comp);
			usu.setComponentes(compList);
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Error:" + ex);
		}
		try {
			// Creamos el perfil
			Perfil perfil = new Perfil();
			perfil.setPerfil("info1");
			perfilDao.save(perfil);

			List<Perfil> perfilList = new ArrayList<Perfil>();
			perfilList.add(perfil);
			usu.setPerfiles(perfilList);
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Error:" + ex);
		}

		this.usuarioDao.save(usu);

	}
}
