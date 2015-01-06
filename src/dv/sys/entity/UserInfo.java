package dv.sys.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private Long userSex;
	private String userHigh;
	private Date userDate;
	private String userPlace;
	private Long userMarriage;
	private String userCard;
	private String userSpouse;
	private String userSpouseDate;
	private String userSpouseHigh;
	private String userSpouseWork;
	private String userCompanyPhone;
	private String userPhone;
	private String userFax;
	private String userAddress;
	private String userEmail;
	private Set personInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Long userId, String userName, Long userSex,
			String userHigh, Date userDate, String userPlace,
			Long userMarriage, String userCard, String userPhone,
			String userAddress) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userHigh = userHigh;
		this.userDate = userDate;
		this.userPlace = userPlace;
		this.userMarriage = userMarriage;
		this.userCard = userCard;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}

	/** full constructor */
	public UserInfo(Long userId, String userName, Long userSex,
			String userHigh, Date userDate, String userPlace,
			Long userMarriage, String userCard, String userSpouse,
			String userSpouseDate, String userSpouseHigh,
			String userSpouseWork, String userCompanyPhone, String userPhone,
			String userFax, String userAddress, String userEmail,
			Set personInfos) {
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userHigh = userHigh;
		this.userDate = userDate;
		this.userPlace = userPlace;
		this.userMarriage = userMarriage;
		this.userCard = userCard;
		this.userSpouse = userSpouse;
		this.userSpouseDate = userSpouseDate;
		this.userSpouseHigh = userSpouseHigh;
		this.userSpouseWork = userSpouseWork;
		this.userCompanyPhone = userCompanyPhone;
		this.userPhone = userPhone;
		this.userFax = userFax;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.personInfos = personInfos;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Long userSex) {
		this.userSex = userSex;
	}

	public String getUserHigh() {
		return this.userHigh;
	}

	public void setUserHigh(String userHigh) {
		this.userHigh = userHigh;
	}

	public Date getUserDate() {
		return this.userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getUserPlace() {
		return this.userPlace;
	}

	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}

	public Long getUserMarriage() {
		return this.userMarriage;
	}

	public void setUserMarriage(Long userMarriage) {
		this.userMarriage = userMarriage;
	}

	public String getUserCard() {
		return this.userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public String getUserSpouse() {
		return this.userSpouse;
	}

	public void setUserSpouse(String userSpouse) {
		this.userSpouse = userSpouse;
	}

	public String getUserSpouseDate() {
		return this.userSpouseDate;
	}

	public void setUserSpouseDate(String userSpouseDate) {
		this.userSpouseDate = userSpouseDate;
	}

	public String getUserSpouseHigh() {
		return this.userSpouseHigh;
	}

	public void setUserSpouseHigh(String userSpouseHigh) {
		this.userSpouseHigh = userSpouseHigh;
	}

	public String getUserSpouseWork() {
		return this.userSpouseWork;
	}

	public void setUserSpouseWork(String userSpouseWork) {
		this.userSpouseWork = userSpouseWork;
	}

	public String getUserCompanyPhone() {
		return this.userCompanyPhone;
	}

	public void setUserCompanyPhone(String userCompanyPhone) {
		this.userCompanyPhone = userCompanyPhone;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserFax() {
		return this.userFax;
	}

	public void setUserFax(String userFax) {
		this.userFax = userFax;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set getPersonInfos() {
		return this.personInfos;
	}

	public void setPersonInfos(Set personInfos) {
		this.personInfos = personInfos;
	}

}