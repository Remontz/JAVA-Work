package com.kacygilbert.relationships.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String number;
	private Date expirationDate;
	private String state;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// @JoinColumn(name="person_id") : Defines mapping for composite foreign keys.  It indicates that the corresponding table to this entity has a foreign_key to the referenced table.
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	private Person person;
	
	//Constructor(s)
	public License() {	}
	public License(String number, Date expirationDate, String state) {
		ArrayList<Character> alphabet = new ArrayList<Character>() {{
			add('A'); add('B'); add('E'); add('Z');
			add('F'); add('G'); add('J'); add('Y');
			add('K'); add('L'); add('O'); add('W');
		}};
		Random random = new Random();
		
		int licNumber = (123) + random.nextInt(868);
		for(int i = 0; i < 3; i++) {
			int pick = random.nextInt(alphabet.size() - 1);
			number = number + alphabet.get(pick);			
		}
		this.number = number + licNumber;
		this.expirationDate = expirationDate;
		this.state = state;
	}
	
	//Getters/Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
