package com.kacygilbert.mvcbakery.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="muffins")
public class Muffin {
	// This class has to be a bean to work the way needed...needs constructor with no arguments.
	//Member Variables directly correspond to the columns on the database table. name them the same.
	// These Member variables are always private, use class values (Integer, Boolean, etc.)
	
	// We need an annotation so that we can attach this to our rows.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SQL Commands mostly come all-caps.
	private Long  id; //Primary key thats always unique
	
	
	private String name;
	
	@NotNull //This annotation makes flavor required, as it cannot be null.
	@Size(min=4, max=100, message="Stop!") //Sets limits for the size of the string.
	private String flavor;
	
	@NotNull
	@Size(min=3, max=20)
	private String frosting;
	
	@NotNull
	@Min(250)
	private Integer calories;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chef_id")
	private Chef chef; // does not have to be imported in the same package.
	
	//Everything that goes into a database needs a created at and updated_at!!!!
	@Column(updatable=false)//makes it so createdAt cannot be altered once created.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Muffin() {	}
	
	public Muffin(String flavor,
			@NotNull @Size(min = 3, max = 20) String frosting, @NotNull @Min(250) Integer calories) {

		this.flavor = flavor;
		this.frosting = frosting;
		this.calories = calories;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getFrosting() {
		return frosting;
	}

	public void setFrosting(String frosting) {
		this.frosting = frosting;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	//getter/setters for createdAt& updatedAt
	@PrePersist //before it sends to the database it does this.
	protected void onCreate() { //when muffin is instantiated this will run.
		this.createdAt = new Date();
		if (updatedAt == null) {
			this.updatedAt = new Date();
		}
	}
	@PreUpdate //self explanatory, before the database is updated
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	


	
}
