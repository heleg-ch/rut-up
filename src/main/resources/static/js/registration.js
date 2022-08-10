function checkLogin() {
    let inputLoginElement = document.getElementById('login');
    let inputPasswordElement = document.getElementById('password');
    let button = document.getElementById('register-button');
    let form = document.getElementById('registration');
    post('/api/registration/login',
        {login: inputLoginElement.value},
        (response) => {
            inputLoginElement.style.display = 'none';
            inputPasswordElement.style.display = 'inline';
            button.onclick = null;
            button.setAttribute('type', 'submit')
            if (response.exist) {
                inputPasswordElement.setAttribute('placeholder', 'Введите пароль');
                form.setAttribute('action', 'registration/sign-in')
            } else {
                inputPasswordElement.setAttribute('placeholder', 'Введите код');
                form.setAttribute('action', 'registration/sign-up')
            }
        });
}

function signIn() {
    console.log('SignIn');
}

function confirmActivationCode() {

}