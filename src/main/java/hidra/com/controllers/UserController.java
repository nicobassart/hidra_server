package hidra.com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hidra.com.dao.ComponenteDao;
import hidra.com.dao.UsuarioDao;
import hidra.com.email.SimpleOrderManager;
import hidra.com.model.Usuario;
import hidra.com.pojos.Login;
import hidra.com.pojos.UserAlta;
import hidra.com.pojos.UserRecovery;

@RestController
public class UserController {

	@Autowired
	private UsuarioDao userDao;

	@Autowired
	private ComponenteDao companyDao;

	@Autowired
	private SimpleOrderManager simpleOrderManager;

	
	@RequestMapping(method = RequestMethod.POST)
	public void nuevaEntidad(){
		System.out.println("nuevaEntidad");
	}
	
	@RequestMapping(path="usuarios",method = RequestMethod.GET)
	public void listaEntidades(){
		System.out.println("listaEntidad");
		
	}

	/**
	 * 
	 * 
	 */
	@RequestMapping(path="usuario/{id}",method = RequestMethod.GET)
	public void unaEntidad(@PathVariable String id){
		System.out.println("listaEntidad id:" + id);
		
	}

	@RequestMapping(path="usuario/{idNew}/{idOld}",method = RequestMethod.PUT)
	public void update(@PathVariable String idNew,@PathVariable String idOld){
		System.out.println("listaEntidad id:" );
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path="usuario/{id}",method = RequestMethod.DELETE)
	public void deleteEntidad(@PathVariable String id){
		System.out.println("Eliminariamos el ID:" + id);
	}

	/**
	 * Create --> Create a new user and save it in the database.
	 * 
	 * @param email
	 *            User's email
	 * @param name
	 *            User's name
	 * @return A string describing if the user is succesfully created or not.
	 */
	@RequestMapping("usercreate")
	@ResponseBody
	public UserAlta userAlta(@RequestBody UserAlta userAlta) {

		Usuario user = null;
		try {
			user = new Usuario(userAlta.getUser(), userAlta.getPassword());
			userDao.save(user);
			userAlta.setIdUsuario((int) user.getIdUsuario());
			// DataIntegrityViolationException
		} catch (DuplicateKeyException ex) {
			// Si seteamos uno en el estado significa que algo anduvo mal.
			userAlta.setEstado("1");
			userAlta.setResultado("Duplicate user, plase try with other email or use recovery password.");

			return userAlta;
		} catch (DataIntegrityViolationException ex) {
			// Si seteamos uno en el estado significa que algo anduvo mal.
			userAlta.setEstado("1");
			userAlta.setResultado("We are getting some problems with Our system. Please try again later. Thanks.");

			return userAlta;
		} catch (Exception ex) {
			// Si seteamos uno en el estado significa que algo anduvo mal.
			userAlta.setEstado("2");
			userAlta.setResultado("We are getting some problems with Our system. Please try again later. Thanks.");

			return userAlta;
		}
		userAlta.setEstado("0");
		userAlta.setResultado("success");

		simpleOrderManager.sendMail("Casilla@prueba.com", userAlta.getUser(), "Star Business",
				"El usuario fue creado correctamente.");

		return userAlta;
	}

	@RequestMapping("/userrecovery")
	@ResponseBody
	public UserRecovery userRecovery(@RequestBody UserRecovery userAlta) {

		String userId;
		try {
			Usuario user = userDao.findByUsuario(userAlta.getUser());
			if (user != null) {

				/*
				 * * Deberiamos poder tomar el usuario y enviarle un email con
				 * la nueva clave.
				 * 
				 */
				simpleOrderManager.sendMail("Casilla@prueba.com", userAlta.getUser(), "Star Business",
						"Your Password is: " + user.getPasswords());

				userAlta.setEstado("0");
				userAlta.setResultado("success");
			} else {
				userAlta.setEstado("0");
				userAlta.setResultado("error");
			}
		} catch (Exception ex) {
			userAlta.setEstado("1");
			userAlta.setResultado("error");
			return userAlta;
		}

		return userAlta;
	}

	/**
	 * /delete --> Delete the user having the passed id.
	 * 
	 * @param id
	 *            The id of the user to delete
	 * @return A string describing if the user is succesfully deleted or not.
	 */
	@RequestMapping("/userdelete")
	@ResponseBody
	public String delete(long id) {
		try {
			Usuario user = new Usuario(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user: " + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("uservalidate")
	@ResponseBody
	public Login uservalidate(@RequestBody Login login) {

		String userId;
		try {
			/*
			 * Deberiamos compara el valor que viene con en password, con lo que
			 * figura en la base de datos.
			 */
			if (login != null) {
				if (login.getUser() != null && login.getPassword() != null && login.getUser() != ""
						&& login.getPassword() != "") {
					// Intentamos buscar el usuario
					Usuario user = userDao.findByUsuario(login.getUser());
					userId = String.valueOf(user.getIdUsuario());
					if (user != null) {
						// En este punto encontramos al usuario.
						// Deberiamos comparar la password.
						// Pongo en cero para decir que el procesos funciono
						// correctamente.
						login.setEstado("0");
						if (login.getUser().equals(user.getIdUsuario())
								&& user.getPasswords().equals(login.getPassword())) {
							login.setIdUsuario(user.getIdUsuario());
							login.setResultado("success");
						} else
							login.setResultado("denied");

					}

				}
			}

		} catch (Exception ex) {
			login.setEstado("1");
			login.setResultado("Error");

			return login;
		}
		return login;
	}

	/**
	 * /get-by-email --> Return the id for the user having the passed email.
	 * 
	 * @param email
	 *            The email to search in the database.
	 * @return The user id or a message error if the user is not found.
	 */
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			Usuario user = userDao.findByUsuario(email);
			userId = String.valueOf(user.getIdUsuario());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	/**
	 * /update --> Update the email and the name for the user in the database
	 * having the passed id.
	 * 
	 * @param id
	 *            The id for the user to update.
	 * @param email
	 *            The new email.
	 * @param name
	 *            The new name.
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String users, String password) {
		try {
			Usuario user = userDao.findOne(id);
			// user.setUser(users);
			// user.setPassword(password);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value="/loginAngular")
	@ResponseBody
	public List<Usuario> login(@RequestBody Login login) {

		List<Usuario> list = new ArrayList<Usuario>();
		Usuario asd = new Usuario();
		//asd.setPassword("asd");
		asd.setUsuario("un nome");
		list.add(asd);
		
		 //String [] lista= new String[2];
		 
		 //lista[0]="valor1"; lista[1]="valor2";

		return list;
	}
}