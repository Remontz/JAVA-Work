package com.kacygilbert.mvcbakery.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="chefs")
public class Chef {
	// We need an annotation so that we can attach this to our rows.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//SQL Commands mostly come all-caps.
	private Long  id; //Primary key thats always unique
	
	private String name;
	private Integer hatHeight;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="chef", fetch=FetchType.LAZY)	// name of this table is chef. Lazy means it wont do it every time Chef class is referred, but only when the data is fetched for.
	private List<Muffin> muffins;
	
	// Constructor
	public Chef() {	}
	public Chef(String name, Integer hatHeight, List<Muffin> muffins) {
		this.name = name;
		this.hatHeight = hatHeight;
		this.muffins = muffins;
	}
	
	// Getters/Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Muffin> getMuffins() {
		return muffins;
	}
	public void setMuffins(List<Muffin> muffins) {
		this.muffins = muffins;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHatHeight() {
		return hatHeight;
	}
	public void setHatHeight(Integer hatHeight) {
		this.hatHeight = hatHeight;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt= new Date();
		if (updatedAt == null) {
			this.updatedAt = new Date();
		}
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
}
