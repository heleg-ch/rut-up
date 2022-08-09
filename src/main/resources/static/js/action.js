function back() {
    window.history.back();
}

function checkLogin() {
    let inputLoginElement = document.getElementById("login");
    let inputPasswordElement = document.getElementById("password");
    let button = document.getElementById("register-button");

    post('/api/registration/login',
        {login: inputLoginElement.value},
        (response) => {
            inputLoginElement.style.display = 'none';
            inputPasswordElement.style.display = 'inline';
            if (response.exist) {
                inputPasswordElement.setAttribute('placeholder', 'Введите пароль');
                button.onclick = signIn;
            } else {
                inputPasswordElement.setAttribute('placeholder', 'Введите код');
                button.onclick = confirmActivationCode;
            }
        });
}

function signIn() {
    console.log('SignIn');
}

function confirmActivationCode() {
    console.log('Activate Code');
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