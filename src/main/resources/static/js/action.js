function showAlert() {
    alert("The button was clicked!");
}

function back() {
    window.history.back();
}

function checkLogin() {
    const login = {
        login: document.getElementById("login").value
    }

    post('/api/sign-up', JSON.stringify(login));
}

function post(url, body) {
    const request = new XMLHttpRequest();
    request.open('POST',  url, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.onload = function () {
        console.log(this.response);
    };
    request.onerror = function () {
        console.log("error");
    }
    request.send(body);
}