function myFunction() {

	var menuselect = document.getElementById("menuSelected").value;

	var item = menuselect.substring(0, menuselect.indexOf("--"));

	var start = menuselect.indexOf("Rs.");

	var end = menuselect.indexOf(".00");

	var price = menuselect.substring((start + 3), end);

	var table = document.getElementById("menuTable");

	var row = table.insertRow(1);

	var cell1 = row.insertCell(0);

	var cell2 = row.insertCell(1);

	var cell3 = row.insertCell(2);

	// alert(item+" ** "+price);

	var tbl = document.getElementById("menuTable");

	var listName = "levels-list" + (tbl.rows.length - 1);

	var itemTextName = "itemText" + (tbl.rows.length - 1);

	var priceTextName = "priceText" + (tbl.rows.length - 1);

	cell1.innerHTML = '<div type="text" id="' + itemTextName + '" name="'
			+ itemTextName + '" value ="' + item + '" readonly>' + item
			+ '</div>';

	cell2.innerHTML = '<div type="text" id="' + priceTextName + '" name="'
			+ priceTextName + '" value ="' + price + '" readonly>' + price
			+ '</div>';

	cell3.innerHTML = '<select class="inputtext" id="'
			+ listName
			+ '"><option value="1" id="option-1">1</option><option value="2" id="option-2">2</option><option value="3" id="option-3">3</option><option value="4" id="option-4">4</option></select>';

	document.getElementById("menuSelected").value = "";

}

function readTable() {

	var tbl = document.getElementById("menuTable");

	if (tbl != null) {

		// alert(tbl.rows.length);

		for (var i = 1; i < tbl.rows.length; i++) {

			var item = document.getElementById("itemText" + i);

			var price = document.getElementById("priceText" + i);

			var e = document.getElementById("levels-list" + i);

			var text = e.options[e.selectedIndex].text;
			var oldValue = document.getElementById("menuS").value;
			if (i == 1)
				document.getElementById("menuS").value = +item
						.getAttribute("value")
						+ "---" + price.getAttribute("value") + "---" + text;
			else
				document.getElementById("menuS").value = oldValue + ":"
						+ item.getAttribute("value") + "---"
						+ price.getAttribute("value") + "---" + text;
		}

	}

}

var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
	modal.style.display = "block";
}

span.onclick = function() {
	modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}