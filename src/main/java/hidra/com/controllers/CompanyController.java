package hidra.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import hidra.com.dao.ComponenteDao;
import hidra.com.dao.PerfilDao;
import hidra.com.dao.UsuarioDao;

@RestController
public class CompanyController {

	@Autowired
	private ComponenteDao companyDao;
	
	@Autowired
	private PerfilDao ownerDao;

	@Autowired
	private UsuarioDao usuDao;
	  

                           
/*	@RequestMapping("companyCreate")
	@ResponseBody
	public CompanyAlta create(@RequestBody CompanyAlta companyAlta) {
		*//**
		 * Primero vamos a averiguar que modo es y desde vemos que hacemos.
		 * *//*
		if(companyAlta !=null && "C".equals(companyAlta.getModo())){
			try {
				Usuario user = usuDao.findByIdUsuario(companyAlta.getIdUsers());
				
				List<Company> listComp= companyDao.findByUser(user);
				
				Company myComp = null;
				if(!listComp.isEmpty()){
					myComp =  listComp.get(0);	
				}
						
				
				
				
				if(myComp !=null){
					
					// Significa que encontro al menos uno.
					companyAlta.setTypeEntity(myComp.getTypeEntity());
					companyAlta.setLocationWhere(myComp.getLocationWhere());
					companyAlta.setNameCompanyOne(myComp.getNameCompanyOne());
					companyAlta.setNameCompanyTwo(myComp.getNameCompanyTwo());
					companyAlta.setNameCompanyThree(myComp.getNameCompanyThree());
					companyAlta.setAddressPhysical(myComp.getAddressPhysical());
					companyAlta.setAddressCity(myComp.getAddressCity());
					companyAlta.setAddressState(myComp.getAddressState());
					companyAlta.setAddressZip(myComp.getAddressZip());
					companyAlta.setAddressDifferent(myComp.isAddressDifferent());
					companyAlta.setRegisteredAgentOther(myComp.isRegisteredAgentOther());
					companyAlta.setRegisteredAgentOwn(myComp.isRegisteredAgentOwn());
					companyAlta.setOwnersQuantity(myComp.getOwnersQuantity());
					companyAlta.setBusinessDo(myComp.getBusinessDo());
					companyAlta.setBusinessDescription(myComp.getBusinessDescription());
					companyAlta.setPhone(myComp.getPhone());
					for (Owner unOwner: myComp.getListOwners()) {
						Owner dos = new Owner();
						dos.setId(unOwner.getId());
						dos.setOwnerTitle(unOwner.getOwnerTitle());
						dos.setOwnerPercentage(unOwner.getOwnerPercentage());
						dos.setOwnerFirstName(unOwner.getOwnerFirstName());
						dos.setOwnerLastName(unOwner.getOwnerLastName());
						dos.setOwnerState(unOwner.getOwnerState());
						dos.setOwnerCity(unOwner.getOwnerCity());
						dos.setOwnerZip(unOwner.getOwnerZip());
						dos.setOwnerEmail(unOwner.getOwnerEmail());
						dos.setOwnerPhone(unOwner.getOwnerPhone());
						companyAlta.getListOwners().add(dos);
						
					}
					
					companyAlta.setId(myComp.getId());
					
				}
			}catch (Exception ex) {
				companyAlta.setEstado("1");
				companyAlta.setResultado("error");
			  return companyAlta;
			}
			
		}else if (companyAlta !=null && "A".equals(companyAlta.getModo())) {
			 *
			 * Primero tiene que buscar la empresa y despues crearla.
			 *  
			 * 
			Company companyEnt = null;
			try {
				companyEnt = new Company();
				
				companyEnt.setTypeEntity(companyAlta.getTypeEntity());
				companyEnt.setLocationWhere(companyAlta.getLocationWhere());
				companyEnt.setNameCompanyOne(companyAlta.getNameCompanyOne());
				companyEnt.setNameCompanyTwo(companyAlta.getNameCompanyTwo());
				companyEnt.setNameCompanyThree(companyAlta.getNameCompanyThree());
				companyEnt.setAddressPhysical(companyAlta.getAddressPhysical());
				companyEnt.setAddressCity(companyAlta.getAddressCity());
				companyEnt.setAddressState(companyAlta.getAddressState());
				companyEnt.setAddressZip(companyAlta.getAddressZip());
				companyEnt.setAddressDifferent(companyAlta.isAddressDifferent());
				companyEnt.setRegisteredAgentOther(companyAlta.isRegisteredAgentOther());
				companyEnt.setRegisteredAgentOwn(companyAlta.isRegisteredAgentOwn());
				companyEnt.setOwnersQuantity(companyAlta.getOwnersQuantity());
				companyEnt.setBusinessDo(companyAlta.getBusinessDo());
				companyEnt.setBusinessDescription(companyAlta.getBusinessDescription());
				companyEnt.setPhone(companyAlta.getPhone());
				
				
				
				Usuario usu = usuDao.findByIdUsuario(companyAlta.getIdUsers());
				//usu.setId(companyAlta.getIdUsers());
				companyEnt.setUser(usu);
				companyDao.save(companyEnt);
				
				
				for (Owner iter: companyAlta.getListOwners()) {
					iter.setTheCompany(companyEnt);
					ownerDao.save(iter);
				}
			
			}
			catch (Exception ex) {
				companyAlta.setEstado("1");
				companyAlta.setResultado("error");
			  return companyAlta;
			}

		}else if (companyAlta !=null && "M".equals(companyAlta.getModo())) {
			 *
			 * Primero tiene que buscar la empresa y despues crearla.
			 *  
			 * 

			Usuario user = usuDao.findByIdUsuario(companyAlta.getIdUsers());
			
			Company companyEnt = null;//= companyDao.findByUser(user);
			
			try {
				//companyEnt = new Company();
				if(user!=null && user.getListCompany()!=null && !user.getListCompany().isEmpty()){
					companyEnt = user.getListCompany().get(0);
				}else{
					companyEnt = new Company(); 
				}
				
				
				companyEnt.setTypeEntity(companyAlta.getTypeEntity());
				companyEnt.setLocationWhere(companyAlta.getLocationWhere());
				companyEnt.setNameCompanyOne(companyAlta.getNameCompanyOne());
				companyEnt.setNameCompanyTwo(companyAlta.getNameCompanyTwo());
				companyEnt.setNameCompanyThree(companyAlta.getNameCompanyThree());
				companyEnt.setAddressPhysical(companyAlta.getAddressPhysical());
				companyEnt.setAddressCity(companyAlta.getAddressCity());
				companyEnt.setAddressState(companyAlta.getAddressState());
				companyEnt.setAddressZip(companyAlta.getAddressZip());
				companyEnt.setAddressDifferent(companyAlta.isAddressDifferent());
				companyEnt.setPhone(companyAlta.getPhone());
				companyEnt.setRegisteredAgentOther(companyAlta.isRegisteredAgentOther());
				companyEnt.setRegisteredAgentOwn(companyAlta.isRegisteredAgentOwn());
				companyEnt.setOwnersQuantity(companyAlta.getOwnersQuantity());
				companyEnt.setBusinessDo(companyAlta.getBusinessDo());
				companyEnt.setBusinessDescription(companyAlta.getBusinessDescription());
				//companyAlta.setListOwners(companyAlta.getListOwners());
				companyEnt.setUser(user);
				companyDao.save(companyEnt);
				
				
				for (Owner iter: companyAlta.getListOwners()) {
					Owner unOwner= ownerDao.findById(iter.getId());
					if(unOwner==null )
						unOwner= new Owner();  
					unOwner.setId(iter.getId());
					unOwner.setOwnerTitle(iter.getOwnerTitle());
					unOwner.setOwnerPercentage(iter.getOwnerPercentage());
					unOwner.setOwnerFirstName(iter.getOwnerFirstName());
					unOwner.setOwnerLastName(iter.getOwnerLastName());
					unOwner.setOwnerState(iter.getOwnerState());
					unOwner.setOwnerCity(iter.getOwnerCity());
					unOwner.setOwnerZip(iter.getOwnerZip());
					unOwner.setOwnerEmail(iter.getOwnerEmail());
					unOwner.setOwnerPhone(iter.getOwnerPhone());
					unOwner.setTheCompany(companyEnt);

					ownerDao.save(unOwner);
				}
			}
			catch (Exception ex) {
				companyAlta.setEstado("1");
				companyAlta.setResultado("error");
				return companyAlta;
			}
		}
		companyAlta.setEstado("0");
		companyAlta.setResultado("success");
			
		

	    return companyAlta;
	}*/
//
//	@RequestMapping("ownerCreate")
//	@ResponseBody
//	public OwnerAlta create(@RequestBody OwnerAlta ownerAlta) {
//		/* *
//		 * Primero tiene que buscar la empresa y despues crearla.
//		 *  
//		 * */
//		Owner ownerEnt = null;
//		try {
//			ownerEnt = new Owner();
//			ownerEnt.setOwnerTitle(ownerAlta.getOwnerTitle());
//			ownerEnt.setOwnerPercentage(ownerAlta.getOwnerPercentage());
//			ownerEnt.setOwnerFullName(ownerAlta.getOwnerFullName());
//			ownerEnt.setOwnerState(ownerAlta.getOwnerState());
//			ownerEnt.setOwnerCity(ownerAlta.getOwnerCity());
//			ownerEnt.setOwnerZip(ownerAlta.getOwnerZip());
//			ownerEnt.setOwnerEmail(ownerAlta.getOwnerEmail());
//			ownerEnt.setOwnerPhone(ownerAlta.getOwnerPhone());
//			ownerDao.save(ownerEnt);
//		}
//		catch (Exception ex) {
//			ownerAlta.setEstado("1");
//			ownerAlta.setResultado("error");
//			return ownerAlta;
//		}
//		ownerAlta.setEstado("0");
//		ownerAlta.setResultado("success");
//		return ownerAlta;
//	}
  
  
//  
//  
//  /**
//   * /delete  --> Delete the user having the passed id.
//   * 
//   * @param id The id of the user to delete
//   * @return A string describing if the user is succesfully deleted or not.
//   */
//  @RequestMapping("/userdelete")
//  @ResponseBody
//  public String delete(long id) {
//    try {
//      User user = new User(id);
//      userDao.delete(user);
//    }
//    catch (Exception ex) {
//      return "Error deleting the user: " + ex.toString();
//    }
//    return "User succesfully deleted!";
//  }
//  
//  @RequestMapping("uservalidate")
//  @ResponseBody
//  public Login uservalidate(@RequestBody Login login) {
//	  
//	  String userId;
//	  try {
//		  /* Deberiamos compara el valor que viene con en password, con lo que  figura en la base de datos.*/
//		  if(login != null){
//			  if(login.getUser()!=null && login.getPassword() !=null && login.getUser()!="" && login.getPassword() !=""){
//				  //Intentamos buscar el usuario
//				  User user = userDao.findByUser(login.getUser());
//				  userId = String.valueOf(user.getId());
//				  if(user != null){
//					  //En este punto encontramos al usuario.
//					  //Deberiamos comparar la password.
//					  //Pongo en cero para decir que el procesos funciono correctamente.
//					  login.setEstado("0");
//					  if(login.getUser().equals(user.getUser()) && user.getPassword().equals(login.getPassword()) )
//						  login.setResultado("success");
//					  else
//						  login.setResultado("denied");
//					  
//				  }
//				  
//			  }
//		  }
//		  
//	  }
//	  catch (Exception ex) {
//		  login.setEstado("1");
//		  return login;
//	  }
//	  return login;
//  }
//  /**
//   * /get-by-email  --> Return the id for the user having the passed email.
//   * 
//   * @param email The email to search in the database.
//   * @return The user id or a message error if the user is not found.
//   */
//  @RequestMapping("/get-by-email")
//  @ResponseBody
//  public String getByEmail(String email) {
//    String userId;
//    try {
//      User user = userDao.findByUser(email);
//      userId = String.valueOf(user.getId());
//    }
//    catch (Exception ex) {
//      return "User not found";
//    }
//    return "The user id is: " + userId;
//  }
//  
//  /**
//   * /update  --> Update the email and the name for the user in the database 
//   * having the passed id.
//   * 
//   * @param id The id for the user to update.
//   * @param email The new email.
//   * @param name The new name.
//   * @return A string describing if the user is succesfully updated or not.
//   */
//  @RequestMapping("/update")
//  @ResponseBody
//  public String updateUser(long id, String users, String password) {
//    try {
//      User user = userDao.findOne(id);
//      //user.setUser(users);
//   //   user.setPassword(password);
//      userDao.save(user);
//    }
//    catch (Exception ex) {
//      return "Error updating the user: " + ex.toString();
//    }
//    return "User succesfully updated!";
//  }
}