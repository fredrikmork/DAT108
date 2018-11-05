
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="inputFornavn" type="text"
					name="fornavn" value="" /> 
					<font id="feilFornavn" color="red">${skjema.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="inputEtternavn" type="text"
					name="etternavn" value="" /> 
					<font id="feilEtternavn" color="red">${skjema.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="inputMobil"type="text"
					name="mobil" value="" /> 
					<font id="feilMobil" color="red">${skjema.mobilFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input id="inputPassord" type="password"
					name="passord" value="" /> 
					<font id="feilPassord" color="red">${skjema.passordFeil}</font>
					<font id="middlePassord" color="orange"></font>
					<font id="strongPassord" color="green"></font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="inputPassordRepetert"
					type="password" name="passordRepetert"
					value="" /> 
					<font id="feilPassordRepetert" color="red">${skjema.passordRepetertFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann" ${skjema.mannC}
					 />mann
				<input type="radio" name="kjonn" value="kvinne" ${skjema.kvinneC}
					 />kvinne
				<font color="red">${skjema.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	<script type="text/javascript" charset="ISO-8859-1" src="${pageContext.request.contextPath}/validation.js" defer></script>
</body>
</html>