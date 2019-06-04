var countryColumn;
var jsonData;
function getCountryName() {
	countryColumn = document.getElementById("countryName");
	var url = "https://restcountries.eu/rest/v2/all";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				jsonData = JSON.parse(xmlHttp.responseText);

				var i;
				for (i = 0; i < jsonData.length; i++) {

					countryColumn.options.add(new Option(jsonData[i].name));
				}
			}
		}
	}
	xmlHttp.open("GET", url, true);
	xmlHttp.send();
}

function getCountryCode() {

	var columnCode = document.getElementById("countryCode");
	var index = countryColumn.selectedIndex - 1;
	countryCode.value = jsonData[index].callingCodes;
}
