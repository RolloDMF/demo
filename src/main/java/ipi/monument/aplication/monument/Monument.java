package ipi.monument.aplication.monument;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Monument {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String description;
	private String urlAudio;
	private String urlImage;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Point> pts;
	
	public Monument() {
		
	}
	
	public Monument(String nom, String description, String urlAudio, String urlImage, List<Point> pts) {
		this.nom = nom;
		this.description = description;
		this.urlAudio = urlAudio;
		this.urlImage = urlImage;
		this.pts = pts;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getUrlAudio() {
		return urlAudio;
	}
	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public List<Point> getPts() {
		return pts;
	}
	public void setPts(List<Point> pts) {
		this.pts = pts;
	}
}
