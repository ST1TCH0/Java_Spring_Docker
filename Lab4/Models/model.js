import {clearElementChildren, createLinkCell, createButtonCell, createTextCell, getBackendUrl, getParameterByName, setTextNode} from '../utils.js';

window.addEventListener('load', () => {
	document.getElementById('edit').addEventListener('click', event => edit());
	fetchAndDisplayModel();
});

function fetchAndDisplayModel() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayModel(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/models/' + getParameterByName('model'), true);
    xhttp.send();
}

function displayModel(model) {
    setTextNode('bigname', model.name);
    setTextNode('name', model.name);
	setTextNode('mark', model.mark);
    setTextNode('year', model.year);
    setTextNode('id', model.id);
} 

function edit(){
	window.open("model_edit.html?model=" + getParameterByName('model'),"_self")
}
