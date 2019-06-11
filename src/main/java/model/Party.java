package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PARTY")
public class Party {
	
	@Id @GeneratedValue
    @Column(name="ID_PARTY")
	private int idParty;
	@Column(name="PARTY_NUMBER")
	private int partyNumber;
	@Column(name="PARTY_NAME", unique=true)
	private String partyName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID_PARTY")
	private Set<Candidate> candidates;
	
	public Party() {}
	
	public Party(int idParty, int partyNumber, String partyName) {
		super();
		this.idParty = idParty;
		this.partyNumber = partyNumber;
		this.partyName = partyName;
	}
	
	public int getIdParty() {
		return idParty;
	}

	public void setIdParty(int idParty) {
		this.idParty = idParty;
	}

	public int getIdPartyNumber() {
		return partyNumber;
	}

	public void setIdPartyNumber(int partyNumber) {
		this.partyNumber = partyNumber;
	}

	public String getPartyName() {
		return partyName;
	}
	
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
}
