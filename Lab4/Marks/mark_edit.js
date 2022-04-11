import {getParameterByName, getBackendUrl, setTextNode} from '../utils.js';

window.addEventListener('load', () => {
    fillForm();
	document.getElementById('submit').addEventListener('click', event => update(event));
});

function fillForm(){
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            for (const [key, value] of Object.entries(response)) {
                let input = document.getElementById(key);
                if (input) {
                    input.value = value;
                }
            }
			setTextNode('bigname', "Edit mark: " + response.name);
        }
    };
    xhttp.open("GET", getBackendUrl() + '/marks/' + getParameterByName('mark'), true);
    xhttp.send();
}

function update(event) {
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            window.open("mark.html?mark=" + getParameterByName('mark'),"_self")
        }
    };
    xhttp.open("PUT", getBackendUrl() + '/marks/' + getParameterByName('mark'), true);

    const request = {
        'name': "",
        'year': parseInt(document.getElementById('year').value),
        'country': document.getElementById('country').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
	
	
}
