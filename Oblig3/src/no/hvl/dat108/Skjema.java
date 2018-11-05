package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordRepetert;
	private String kjonn;
	private String fornavnFeil;
	private String etternavnFeil;
	private String mobilFeil;
	private String passordFeil;
	private String passordRepetertFeil;
	private String kjonnFeil;
	private String kvinneC;
	private String mannC;
	
	public Skjema (HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordRepetert = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}
	
	@SuppressWarnings("static-access")
	public Person lagPerson() {
		PassordUtil pass = new PassordUtil();
		passord = pass.krypterPassord(passord);
		return new Person(mobil, fornavn, etternavn, passord, kjonn);
	}
	
	public void checker() {
		if(kjonn != null) {
			if(kjonn.equals("kvinne")) {
				kvinneC = "checked";
			} else {
				mannC = "checked";
			}
		}
	}
	public boolean AllInputGyldig() {
		return fornavnGyldig() && etternavnGyldig() && mobilGyldig() && passordGyldig() && passordRepGyldig() && kjonnGyldig();
	}
	private boolean fornavnGyldig() {
		return fornavn.matches("([A-ZÆØÅ][A-Za-z -æøå]{1,20})\\w+");
	}
	private boolean etternavnGyldig() {
		return etternavn.matches("([A-ZÆØÅ][A-Za-z-æøå]{1,20})\\w+");
	}
	private boolean mobilGyldig() {
		return mobil.matches("(0047|\\+47|\\+47 |47)?\\d{8}");
	}
	//Minimum eight characters, at least one letter, one number and one special character:
	private boolean passordGyldig() {
		return passord.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-ZÆØÅa-zæøå\\d@$!%*#?&]{8,}$");
	}
	private boolean passordRepGyldig() {
		return passordRepetert.equals(getPassord());
	}
	private boolean kjonnGyldig() {
		if(kjonn != null) {
			checker();
			return true;
		} else {
			return false;
		}
	}
	
	public void settOppFeilmeldinger() {
		
		if (!fornavnGyldig()) {
			fornavn = "";
			fornavnFeil = "Ugyldig fornavn!";
		} 
		if (!etternavnGyldig()) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn!";
		}
		if (!mobilGyldig()) {
			mobil = "";
			mobilFeil = "Ugyldig tlf-nummer!";
		}
		if (!passordGyldig()) {
			passord = "";
			passordFeil = "Ugyldig passord!";
		}
		if (!passordRepGyldig()) {
			passordRepetert = "";
			passordRepetertFeil = "Passordene må være like!";
		}
		if (!kjonnGyldig()) {
			kjonn = "";
			kjonnFeil = "Oppgi kjønn!";
		}
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}
	
	public String getMobilFeil() {
		return mobilFeil;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public String getPassordRepetertFeil() {
		return passordRepetertFeil;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}
	public String getKvinneC() {
		return kvinneC;
	}
	public String getMannC() {
		return mannC;
	}
	
}
