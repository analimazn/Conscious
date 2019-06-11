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
@Table(name="COUNTY")
public class County {
	
	@Id @GeneratedValue
	@Column(name="ID_COUNTY")
	private int idCounty;
	@Column(name="COUNTY_NAME", unique=true)
	private String countyName;
	@ManyToOne
	@JoinColumn(name="ID_DF", referencedColumnName="ID_DF", unique=true)
	private DistrictFederal idDF;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_COUNTY")
    private Set<ElectoralSection> electoralSections;
	
	public County() {}
	
	public County(int idCounty, String countyName, DistrictFederal idDF) {
		super();
		this.idCounty = idCounty;
		this.countyName = countyName;
		this.idDF = idDF;
	}

	public int getIdCounty() {
		return idCounty;
	}

	public void setIdCounty(int idCounty) {
		this.idCounty = idCounty;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public DistrictFederal getIdDF() {
		return idDF;
	}
	
	public void setIdDF(DistrictFederal idDF) {
		this.idDF = idDF;
	}
}
