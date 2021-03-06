package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Speisekarteneintrag {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER) 
    private Set<Speisekarte> speisekarte = new HashSet<>();
    
	@ManyToOne(cascade = CascadeType.ALL)
	private Rezept rezept; 
	
    @Embedded
    private Bild bild;
     
	private float preis; 
	//needed for JPA
    protected Speisekarteneintrag() {
	
    }
    
    public Speisekarteneintrag(float preis, Rezept rezept, Bild bild){
    	this.preis = preis;
    	this.rezept = rezept; 
    	this.bild = bild;
    }

	public float getPreis() {
		return preis;
	}
	 
	public Rezept getRezept() {
		return rezept;
	}
	public void  setRezept(Rezept rezept){
		this.rezept= rezept;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	} 
	 
	public Set<Speisekarte> getSpeisekarte() {
		return speisekarte; 
	} 
	
	@Override
	public String toString() {
    	return "Eintrag: ID: " + id + ", Preis: " + preis + ", Rezept: " + rezept.getName(); 
    }

}
