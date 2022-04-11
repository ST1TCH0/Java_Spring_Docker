import {
    getParameterByName,
    clearElementChildren,
    createLinkCell,
    createButtonCell,
    createTextCell,
    setTextNode,
	getBackendUrl
} from '../utils.js';

window.addEventListener('load', () => {
	document.getElementById('edit').addEventListener('click', event => edit());
	document.getElementById('add').addEventListener('click', event => add());
    fetchAndDisplayMark();
    fetchAndDisplayModels();
});

function fetchAndDisplayModels() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayModels(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/models/mark/' + getParameterByName('mark'), true);
    xhttp.send();
}

function displayModels(models) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    models.forEach(model => {
        tableBody.appendChild(createTableRow(model));
    })
}

function createTableRow(model) {
    let tr = document.createElement('tr');
    tr.appendChild(createLinkCell(model.name, '../Models/model.html?model=' + model.id));
    tr.appendChild(createButtonCell('delete', () => deleteModel(model.id)));
    return tr;
}

function deleteModel(model) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            fetchAndDisplayModels();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/models/' + model, true);
    xhttp.send();
}

function fetchAndDisplayMark() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayMark(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/marks/' + getParameterByName('mark'), true);
    xhttp.send();
}

function displayMark(mark) {
    setTextNode('bigname', mark.name);
    setTextNode('name', mark.name);
    setTextNode('year', mark.year);
    setTextNode('country', mark.country);
} 

function edit(){
	window.open("mark_edit.html?mark=" + getParameterByName('mark'),"_self")
}
function add(){
	window.open("../Models/model_add.html?mark=" + getParameterByName('mark'), "_self")
}
