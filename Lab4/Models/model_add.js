import {getParameterByName, getBackendUrl, setTextNode} from '../utils.js';

window.addEventListener('load', () => {
	document.getElementById('submit').addEventListener('click', event => add(event));
});

function add(event) {
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            window.open("../index.html", "_self")
        }
    };
    xhttp.open("POST", getBackendUrl() + '/models', true);

    const request = {
		'id': 0,
        'name': document.getElementById('name').value,
        'year': parseInt(document.getElementById('year').value),
        'mark': getParameterByName('mark')
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
	
	
}
