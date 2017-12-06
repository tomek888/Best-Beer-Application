package pl.tomek888.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "beers")
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Column(unique=true)
	private String username;
	
	private String style;
	
	
	private Long extract;
	
	
	private Long alcohol;
	
	private int ibu;
	
	private String brewery;
	
	@Column(name="best_temp")
	private String bestTemp;
	
	private String glass;
	
	private String culinary;
	
	public Beer() {
		
	}

	public Beer(String username, String style, Long extract, Long alcohol, int ibu, String brewery,
			String bestTemp, String glass, String culinary) {
		
		this.username = username;
		this.style = style;
		this.extract = extract;
		this.alcohol = alcohol;
		this.ibu = ibu;
		this.brewery = brewery;
		this.bestTemp = bestTemp;
		this.glass = glass;
		this.culinary = culinary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Long getExtract() {
		return extract;
	}

	public void setExtract(Long extract) {
		this.extract = extract;
	}

	public Long getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(Long alcohol) {
		this.alcohol = alcohol;
	}

	public int getIbu() {
		return ibu;
	}

	public void setIbu(int ibu) {
		this.ibu = ibu;
	}

	public String getBrewery() {
		return brewery;
	}

	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}

	public String getBestTemp() {
		return bestTemp;
	}

	public void setBestTemp(String bestTemp) {
		this.bestTemp = bestTemp;
	}

	public String getGlass() {
		return glass;
	}

	public void setGlass(String glass) {
		this.glass = glass;
	}

	public String getCulinary() {
		return culinary;
	}

	public void setCulinary(String culinary) {
		this.culinary = culinary;
	}

	public long getId() {
		return id;
	}
	
	
	
	
	
}
