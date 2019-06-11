package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ELECTION")
public class Election {
	
	@Id @GeneratedValue
    @Column(name="ID_ELECTION")
	private int idElection;
    @ManyToOne
	@JoinColumn(name="ID_CANDIDATE", referencedColumnName="ID_CANDIDATE", unique=true)
	private Candidate idCandidate;
    @ManyToOne
	@JoinColumn(name="ID_PARTY", referencedColumnName="ID_PARTY", unique=true)
	private Party idParty;
	@Column(name="QUANTITY_VOTES")
	private int quantityVotes;
	
	public Election() {}
	
	public Election(int idElection, Candidate idCandidate, Party idParty, int quantityVotes) {
		super();
		this.idElection = idElection;
		this.idCandidate = idCandidate;
		this.idParty = idParty;
		this.quantityVotes = quantityVotes;
	}

	public int getIdElection() {
		return idElection;
	}

	public void setIdElection(int idElection) {
		this.idElection = idElection;
	}

	public Candidate getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(Candidate idCandidate) {
		this.idCandidate = idCandidate;
	}

	public Party getIdParty() {
		return idParty;
	}

	public void setIdParty(Party idParty) {
		this.idParty = idParty;
	}

	public int getQuantityVotes() {
		return quantityVotes;
	}

	public void setQuantityVotes(int quantityVotes) {
		this.quantityVotes = quantityVotes;
	}
	
	
}
