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
@Table(name="DISTRICT_FEDERAL")
public class DistrictFederal {

	@Id @GeneratedValue
	@Column(name="ID_DF")
	private int idDF;
	@Column(name="ACRONYM_DF", unique=true)
	private String acronymDF;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID_DF")
    private Set<County> counties;
	
	public DistrictFederal() {}
	
	public DistrictFederal(int idDF, String acronymDF) {
		super();
		this.idDF = idDF;
		this.acronymDF = acronymDF;
	}

	public int getIdDF() {
		return idDF;
	}
	
	public void setIdDF(int idDF) {
		this.idDF = idDF;
	}

	public String getAcronymDF() {
		return acronymDF;
	}
	
	public void setAcronymDF(String acronymDF) {
		this.acronymDF = acronymDF;
	}
}
