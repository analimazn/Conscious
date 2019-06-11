package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CANDIDATE")
public class Candidate {
	
	@Id @GeneratedValue
	@Column(name="ID_CANDIDATE")
	private int idCandidate;
	@Column(name="CANDIDATE_NUMBER", unique=true)
	private int candidateNumber;
	@Column(name="CANDIDATE_NAME")
	private String candidateName;
	@Column(name="CANDIDATE_URL_PHOTO")
	private String candidateUrlPhoto;
	@ManyToOne
	@JoinColumn(name="ID_PARTY", referencedColumnName="ID_PARTY")
	private Party idParty;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_CANDIDATE")
    private Set<Election> elections;
	
	public Candidate() {}
	
	public Candidate(int idCandidate, int candidateNumber, String candidateName, String candidateUrlPhoto,
			Party idParty) {
		super();
		this.idCandidate = idCandidate;
		this.candidateNumber = candidateNumber;
		this.candidateName = candidateName;
		this.candidateUrlPhoto = candidateUrlPhoto;
		this.idParty = idParty;
	}

	public int getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public int getCandidateNumber() {
		return candidateNumber;
	}

	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateUrlPhoto() {
		return candidateUrlPhoto;
	}

	public void setCandidateUrlPhoto(String candidateUrlPhoto) {
		this.candidateUrlPhoto = candidateUrlPhoto;
	}

	public Party getIdPartyNumber() {
		return idParty;
	}
	
	public void setIdPartyNumber(Party idParty) {
		this.idParty = idParty;
	}
}
