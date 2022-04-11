import {clearElementChildren, createLinkCell, createButtonCell, createTextCell, getBackendUrl} from './utils.js';


window.addEventListener('load', () => {
	document.getElementById('add').addEventListener('click', event => add());
	fetchAndDisplayMarks();
});

function fetchAndDisplayMarks() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayMarks(JSON.parse(this.responseText))
        }
    };
	
    xhttp.open("GET", getBackendUrl() + '/marks', true);
    xhttp.send();
}

function displayMarks(marks) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    marks.forEach(mark => {
        tableBody.appendChild(createTableRow(mark.name));
    })
}

function createTableRow(mark) {
    let tr = document.createElement('tr');
    tr.appendChild(createLinkCell(mark, 'Marks/mark.html?mark=' + mark));
    tr.appendChild(createButtonCell('delete', () => deleteMark(mark)));
    return tr;
}

function deleteMark(mark) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            fetchAndDisplayMarks();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/marks/' + mark, true);
    xhttp.send();
}
function add(){
	window.open("Marks/mark_add.html","_self")
}