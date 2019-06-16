package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{
	
	@Id @GeneratedValue
	@Column(name="ID_USER")
	private int idUser;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="BORN_DATE")
	private Date bornDate;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="USER_TYPE")
	private String userType;
	@Column(name="ENABLED")
	private boolean enabled;
	@Column(name="VOTED")
	private boolean voted;
	@Column(name="INSCRIPTION_NUMBER", unique=true)
	private String inscriptionNumber;
	@ManyToOne
	@JoinColumn(name="ID_ELECTORAL_SECTION", referencedColumnName="ID_ELECTORAL_SECTION")
	private ElectoralSection idElectoralSection;
	
	public User() {};
	
	public User(int idUser, String userName, Date bornDate, String password, String userType, boolean enabled,
			boolean voted, String inscriptionNumber, ElectoralSection idElectoralSection) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.bornDate = bornDate;
		this.password = password;
		this.userType = userType;
		this.enabled = enabled;
		this.voted = voted;
		this.inscriptionNumber = inscriptionNumber;
		this.idElectoralSection = idElectoralSection;
	}

	public String getUserType() {
		return userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInscriptionNumber() {
		return inscriptionNumber;
	}

	public void setInscriptionNumber(String inscriptionNumber) {
		this.inscriptionNumber = inscriptionNumber;
	}

	public ElectoralSection getIdElectoralSection() {
		return idElectoralSection;
	}

	public void setIdElectoralSection(ElectoralSection idElectoralSection) {
		this.idElectoralSection = idElectoralSection;
	}
}
