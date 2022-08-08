function showAlert() {
    alert("The button was clicked!");
}

function back() {
    window.history.back();
}

function checkLogin() {
    let inputElement = document.getElementById("login");
    let login = inputElement.value;
    post('/api/check-login',
        {login: inputElement.value},
        (response) => {
            if (response.exist) {
                inputElement.value = '';
                inputElement.setAttribute('placeholder', 'Введите пароль')
            } else {
                inputElement.value = '';
                inputElement.setAttribute('placeholder', 'Введите код')
            }
        });
}

function post(url, body, callback) {
    const request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    request.onload = function () {
        callback(JSON.parse(this.response));
    };
    request.onerror = function () {
        console.log("error");
    }
    request.send(JSON.stringify(body));
}