const apiUrl = '/_web0830_2/api/items';//맨 앞에 프로젝트 명을 써줘야함 해당 url은 브라우저 주소를 나타냄

async function createItem() {//C
    const name = document.getElementById('createName').value;
    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'//한글 깨짐 방지용
        },
        body: JSON.stringify({ name })
    });
    const newItem = await response.json();
    alert(`Created item: ${newItem.name} with ID: ${newItem.id}`);
}

async function getAllItems() {//R
    const response = await fetch(apiUrl);//apiUrl에 작성한 주소를 통해 데이터를 담아옴
    const items = await response.json();//해당 데이터를 json형식으로 변환하여 items에 저장
    const itemsList = document.getElementById('itemsList');//해당 메소드를 사용할 때 html에 id값이 itemsList인 태그의 정보를 itemList에 저장
    itemsList.innerHTML = '';//해당 태그 내에 들어있는 내용을 초기화 
    items.forEach(item => {//item에 들어있는 정보를 li태그 내부에 데이터로 하나씩 받아옴, 받아온 데이터를 itemList(ul태그) 내부에 삽입하여 userinterface에 출력
        const li = document.createElement('li');
        li.textContent = `ID: ${item.id}, Name: ${item.name}`;
        itemsList.appendChild(li);
    });
}

async function updateItem() {//U
    const id = document.getElementById('updateId').value;
    const name = document.getElementById('updateName').value;
    const response = await fetch(`${apiUrl}/${id}`, {//이게 기본적인 fetch로 CRUD 하는 방식임
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({ name })
    });
    const result = await response.json();
    alert(result.message);
}

async function deleteItem() {//D
    const id = document.getElementById('deleteId').value;
    const response = await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    });
    const result = await response.json();
    alert(result.message);
}