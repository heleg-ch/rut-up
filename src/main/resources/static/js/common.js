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

function back() {
    window.history.back();
}