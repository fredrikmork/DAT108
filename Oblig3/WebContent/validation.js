let etternavnReg = /^[a-zA-Zøæå ,.'-]+$/u;
let fornavnReg = /^[a-zA-ZàáâäãåæąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$/u;
let mobilReg = /^[0-9]{8,8}$/;
let passordReg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$";

document.getElementById("inputFornavn").addEventListener("keyup",
		validerFornavn);
document.getElementById("inputEtternavn").addEventListener("keyup",
		validerEtternavn);
document.getElementById("inputMobil").addEventListener("keyup", validerMobil);
document.getElementById("inputPassord").addEventListener("keyup",
		validerPassord);
document.getElementById("inputPassordRepetert").addEventListener("keyup",
		validerLikePassord);

function validerFornavn() {
	let fornavn = document.getElementById("inputFornavn").value;
	let feilMelding = document.getElementById("feilFornavn");
	// console.log(!fornavnReg.test(fornavn));
	if (!fornavnReg.test(fornavn)) {
		feilMelding.innerHTML = 'Stor forbokstav med mellomrom og "-" ';
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerEtternavn() {
	let etternavn = document.getElementById("inputEtternavn").value;
	let feilMelding = document.getElementById("feilEtternavn");

	if (!etternavnReg.test(etternavn)) {
		feilMelding.innerHTML = "Stor forbokstav med mellomrom og '-' ";
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerMobil() {
	let mobil = document.getElementById("inputMobil").value;
	let feilMelding = document.getElementById("feilMobil");

	if (!mobilReg.test(mobil)) {
		feilMelding.innerHTML = "Ugyldig nummer. Formen: (47)(+47)(0047)99887766";
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerPassord() {
	let passord = document.getElementById("inputPassord").value;
	let feilMelding = document.getElementById("feilPassord");
	let middlePassord = document.getElementById("middlePassord");
	let strongPassord = document.getElementById("strongPassord");
	console.log(passord.length);
	if (passord.length < 6 || passord.match(passordReg)){
		middlePassord.innerHTML = "";
		strongPassord.innerHTML = "";
		feilMelding.innerHTML = "Passordet er ugyldig!";
	} else if (passord.length < 8) {
		strongPassord.innerHTML = "";
		feilMelding.innerHTML = "";
		middlePassord.innerHTML = "Passordet er middels!";	
	} else if(passord.length > 7) {
		feilMelding.innerHTML = "";
		middlePassord.innerHTML = "";
		strongPassord.innerHTML = "Passordet er sterkt!";
	}
}
function validerLikePassord() {
	let passord = document.getElementById("inputPassord").value;
	let passordRepetert = document.getElementById("inputPassordRepetert").value;
	let feilMelding = document.getElementById("feilPassordRepetert");
	if (passord !== passordRepetert) {
		feilMelding.innerHTML = "Passordene er ulike!";
	} else {
		feilMelding.innerHTML = "";
	}
}
