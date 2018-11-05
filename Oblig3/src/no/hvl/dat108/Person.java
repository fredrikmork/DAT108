package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "oblig3test", name = "person")
public class Person {
	@Id
	private String mobil;
	private String fornavn;
	private String etternavn;
	private String passord;
	private String kjonn;

	public Person() {

	}

	public Person(String mobil, String fornavn, String etternavn, String passord, String kjonn) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passord = passord;
		this.kjonn = kjonn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setTlf(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	@Override
	public String toString() {
		return "Person [mobil = " + mobil + ", fornavn = " + fornavn + ", etternavn = " + etternavn + ", kjonn = "
				+ kjonn + "]";
	}

}
