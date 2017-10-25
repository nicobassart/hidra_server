package hidra.com.pojos;

public class CompanyAlta {
	private String estado;
	private String resultado;
	private String modo;

	//Type Entity:
	private String typeEntity;
	private String locationWhere;
	private long idUsers;
	private long id;
	
	//Step 2
	private String nameCompanyOne;
	private String nameCompanyTwo;
	private String nameCompanyThree;
	//Address:
	private String addressPhysical;
	private String addressCity;
	private String addressState;
	private String addressZip;
	private String phone;
	private boolean addressDifferent;  //este era un boolean
	//STEP 3:
	//Company Details:
	private boolean registeredAgentOther;
	private boolean registeredAgentOwn;
	private Integer ownersQuantity;
	private int businessDo;

	private String businessDescription;
	//Step 4:
	//Owners/Managers Details:
	private String ownerTitle;
	private int ownerPercentage;
	private String ownerFullName;
	private String ownerState;
	private String ownerCity;
	private String ownerZip;
	private String ownerEmail;
	private String ownerPhone;
/*	
	private List <Owner>listOwners;
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}



	public long getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(long idUsers) {
		this.idUsers = idUsers;
	}




/*
    public List<Owner> getListOwners() {
        return listOwners;
    }
*/
/*    public void setListOwners(List<Owner> listOwners) {
        this.listOwners = listOwners;
    }
	*/
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTypeEntity() {
		return typeEntity;
	}
	public void setTypeEntity(String typeEntity) {
		this.typeEntity = typeEntity;
	}
	public String getLocationWhere() {
		return locationWhere;
	}
	public void setLocationWhere(String locationWhere) {
		this.locationWhere = locationWhere;
	}
	public String getNameCompanyOne() {
		return nameCompanyOne;
	}
	public void setNameCompanyOne(String nameCompanyOne) {
		this.nameCompanyOne = nameCompanyOne;
	}
	public String getNameCompanyTwo() {
		return nameCompanyTwo;
	}
	public void setNameCompanyTwo(String nameCompanyTwo) {
		this.nameCompanyTwo = nameCompanyTwo;
	}
	public String getNameCompanyThree() {
		return nameCompanyThree;
	}
	public void setNameCompanyThree(String nameCompanyThree) {
		this.nameCompanyThree = nameCompanyThree;
	}
	public String getAddressPhysical() {
		return addressPhysical;
	}
	public void setAddressPhysical(String addressPhysical) {
		this.addressPhysical = addressPhysical;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public boolean isAddressDifferent() {
		return addressDifferent;
	}
	public void setAddressDifferent(boolean addressDifferent) {
		this.addressDifferent = addressDifferent;
	}
	public boolean isRegisteredAgentOther() {
		return registeredAgentOther;
	}
	public void setRegisteredAgentOther(boolean registeredAgentOther) {
		this.registeredAgentOther = registeredAgentOther;
	}
	public boolean isRegisteredAgentOwn() {
		return registeredAgentOwn;
	}
	public void setRegisteredAgentOwn(boolean registeredAgentOwn) {
		this.registeredAgentOwn = registeredAgentOwn;
	}
	public Integer getOwnersQuantity() {
		return ownersQuantity;
	}
	public void setOwnersQuantity(Integer ownersQuantity) {
		this.ownersQuantity = ownersQuantity;
	}
	public int getBusinessDo() {
		return businessDo;
	}
	public void setBusinessDo(int businessDo) {
		this.businessDo = businessDo;
	}
	public String getBusinessDescription() {
		return businessDescription;
	}
	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}
	public String getOwnerTitle() {
		return ownerTitle;
	}
	public void setOwnerTitle(String ownerTitle) {
		this.ownerTitle = ownerTitle;
	}
	public int getOwnerPercentage() {
		return ownerPercentage;
	}
	public void setOwnerPercentage(int ownerPercentage) {
		this.ownerPercentage = ownerPercentage;
	}
	public String getOwnerFullName() {
		return ownerFullName;
	}
	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName;
	}
	public String getOwnerState() {
		return ownerState;
	}
	public void setOwnerState(String ownerState) {
		this.ownerState = ownerState;
	}
	public String getOwnerCity() {
		return ownerCity;
	}
	public void setOwnerCity(String ownerCity) {
		this.ownerCity = ownerCity;
	}
	public String getOwnerZip() {
		return ownerZip;
	}
	public void setOwnerZip(String ownerZip) {
		this.ownerZip = ownerZip;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}


}
