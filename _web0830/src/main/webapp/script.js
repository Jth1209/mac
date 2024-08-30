document.getElementById('createForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = Object.fromEntries(formData.entries());//매개변수로 받은 event의 목표가 되는 값을 FormData로 받아와 Object.fromEntries로 jsonData로 전환한다(객체로);
    sendRequest(jsonData);
});

document.getElementById('readButton').addEventListener('click', function() {
    const jsonData = { action: 'read' };//읽어올 때는 매개변수를 받을 필요가 없으니 jsonData를 직접 객체로 선언해준다.
    sendRequest(jsonData, displayReadResult);
});

document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = Object.fromEntries(formData.entries());
    sendRequest(jsonData);
});

document.getElementById('deleteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = Object.fromEntries(formData.entries());
    sendRequest(jsonData);
});

function sendRequest(jsonData, callback) {
    fetch('empJsonserver3.jsp', {//해당 위치로 요청을 보냄
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => response.json())
    .then(data => {
        if (callback) {
            callback(data);
        } else {
            alert(JSON.stringify(data));
        }
    })
    .catch(error => console.error('Error:', error));
}

function displayReadResult(data) {
    const readResultDiv = document.getElementById('readResult');
    readResultDiv.innerHTML = JSON.stringify(data, null, 2);
}