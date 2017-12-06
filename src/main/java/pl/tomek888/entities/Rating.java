package pl.tomek888.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int aroma;
	
	private int apperance;
	
	private int taste;
	
	private int palate;
	
	private Long overall;
	
	private String description;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Beer beer;
	
	public Rating() {
		
	}

	public Rating(int aroma, int apperance, int taste, int palate, Long overall, String description) {
		
		this.aroma = aroma;
		this.apperance = apperance;
		this.taste = taste;
		this.palate = palate;
		this.overall = overall;
		this.description = description;
	}

	public int getAroma() {
		return aroma;
	}

	public void setAroma(int aroma) {
		this.aroma = aroma;
	}

	public int getApperance() {
		return apperance;
	}

	public void setApperance(int apperance) {
		this.apperance = apperance;
	}

	public int getTaste() {
		return taste;
	}

	public void setTaste(int taste) {
		this.taste = taste;
	}

	public int getPalate() {
		return palate;
	}

	public void setPalate(int palate) {
		this.palate = palate;
	}

	public Long getOverall() {
		return overall;
	}

	public void setOverall(Long overall) {
		this.overall = overall;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
	

}
