package com.kacygilbert.relationships.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//@OneToOne: Defines the 1:1 relationship with another entity.  There are different options that you can have in the annotation and it is extremely important that you use the correct one depending on which side of the relationship your entity is.
		//...(mappedBy="person") : This will map the license attribute in the Person class to the person attribute in the License class.  It represents the field that owns the relationship.  This element is only specified on the inverse (non-owning) side of the association.
		// ...(cascade=CascadeType.All) : The operations that must be cascaded to the target of the association.  This will make sure referential integrity is preserved in ALL actions.
		// ...(fetch=FetchType.LAZY) : Whether the association should be lazily loaded or must be eagerly fetched.
			// ||.LAZY : The association is fetched when needed.
			// ||.EAGER : The association is fetched immediately.
			// There are a few other options that you can have. [http://www.objectdb.com/api/java/jpa/OneToOne]
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private License license;
	
	
	public Person() {	}
	public Person(String firstName, String lastName, License license) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
		if(updatedAt == null) {
			this.updatedAt = new Date();
		}
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
}
