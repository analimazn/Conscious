package model;

import java.util.Date;
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
@Table(name="ELECTORAL_SECTION")
public class ElectoralSection {
	
	@Id @GeneratedValue
    @Column(name="ID_ELECTORAL_SECTION")
	private int idElectoralSection;
	@Column(name="ISSUE_DATE")
	private Date issueDate;
	@Column(name="ELECTORAL_AREA", unique=true)
	private String electoralArea;
	@Column(name="ELECTORAL_SECTION", unique=true)
	private String electoralSection;
	@ManyToOne
	@JoinColumn(name="ID_COUNTY", referencedColumnName="ID_COUNTY", unique=true)
	private County idCounty;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_ELECTORAL_SECTION")
    private Set<User> users;
	
	public ElectoralSection() {}
	
	public ElectoralSection(int idElectoralSection, Date issueDate, String electoralArea, String electoralSection,
			County idCounty) {
		super();
		this.idElectoralSection = idElectoralSection;
		this.issueDate = issueDate;
		this.electoralArea = electoralArea;
		this.electoralSection = electoralSection;
		this.idCounty = idCounty;
	}

	public int getIdElectoralSection() {
		return idElectoralSection;
	}

	public void setIdElectoralSection(int idElectoralSection) {
		this.idElectoralSection = idElectoralSection;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getElectoralArea() {
		return electoralArea;
	}

	public void setElectoralArea(String electoralArea) {
		this.electoralArea = electoralArea;
	}

	public String getElectoralSection() {
		return electoralSection;
	}

	public void setElectoralSection(String electoralSection) {
		this.electoralSection = electoralSection;
	}

	public County getIdCounty() {
		return idCounty;
	}

	public void setIdCounty(County idCounty) {
		this.idCounty = idCounty;
	}
}
