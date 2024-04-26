// 회원가입 요청
function register(url){
    var email = document.querySelector('#email').value;
    var nickname = document.querySelector('#nickname').value;
    var passwd = document.querySelector('#passwd').value;

    fetch(url,{
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            email: email,
            nickname: nickname,
            passwd: passwd,
            profile_img: null,
        })
    }).then(function (response) {
        if(response.status == 200){
            fetchPage('welcome');
        }
    });
}

// 로그인 요청
function login(url){
    var email = document.querySelector('#email').value;
    var passwd = document.querySelector('#passwd').value;
    url = url+'/'+email+'/'+passwd; // todo-user/aaa@bbb/1234
    fetch(url,{
        method: "GET"
    }).then(function (response) {
        return response.json();
    }).then(function (data) { // 응답받은 data 출력
        console.log(data);
        fetchPage('todo').then(function() {
            var today = document.querySelector('#today'); // 오늘 날짜
            var addBtn = document.querySelector('.add-icon'); // 할 일 추가 버튼
            var cubeBtn = document.querySelector('.cube-icon'); // 보관함 버튼
            var todoList = document.querySelector('.todo-list');
            var todoItem, checkBtn, todoInput, clickCnt = 0;

            var currentDate = new Date();
            today.innerText = `${currentDate.getFullYear() % 100}년 ${currentDate.getMonth()+1}월 ${currentDate.getDate()}일,`;

            // 할 일 추가 버튼 이벤트: mouseenter, mouseleave, click
            addBtn.addEventListener('mouseenter', function() {
                addBtn.setAttribute('name', 'add-circle');
            });

            addBtn.addEventListener('mouseleave', function() {
                addBtn.setAttribute('name', 'add-circle-outline');
            });

            addBtn.addEventListener('click', function() {
                // 할일 입력이 안 되어있는 todoInput이 있다면, 할일 추가 불가능
                if(document.querySelector('.todo') != null){
                    var lastTodo = todoItem.lastElementChild;
                    if(lastTodo.value === ''){
                        return;
                    }
                }
                ++clickCnt;
                //input text 요소 생기게 하기
                console.log(`플러스 버튼 ${clickCnt}회 클릭`);

                // todoList안에 각 한 줄씩 들어갈 todoItem만들기
                todoItem = document.createElement('div');
                todoItem.classList.add('todo-item');
                todoList.appendChild(todoItem);

                // check 버튼 만들기
                checkBtn = document.createElement('ion-icon');
                checkBtn.setAttribute('name', 'ellipse-outline');
                checkBtn.classList.add(`noncheck-icon${clickCnt}`, 'noncheck-icon', 'icon', 'btn');

                // todo 인풋 만들기
                todoInput = document.createElement('input');
                todoInput.setAttribute('type', 'text');
                todoInput.setAttribute('placeholder', '할 일 입력');
                todoInput.classList.add(`todo${clickCnt}`, 'todo', 'form-control', 'form-control-sm');

                todoItem.appendChild(checkBtn);
                todoItem.appendChild(todoInput);
                todoInput.focus();

                checkBtn.addEventListener('click', click);// 체크 버튼 클릭이 클릭될 때마다 아이콘이 바뀔 수 있도록
                todoInput.addEventListener('keydown', keydown);
            }); // 추가 버튼 클릭시

            // 보관함 버튼 이벤트: mouseenter, mouseleave, click
            cubeBtn.addEventListener('mouseenter', function() {
                cubeBtn.setAttribute('name', 'cube');
            });

            cubeBtn.addEventListener('mouseleave', function() {
                cubeBtn.setAttribute('name', 'cube-outline');
            });

            cubeBtn.addEventListener('click', function() {
                storage('/todo-storages');
            });

            function click(event){
                var targetElement = event.target;
                var sequence = targetElement.classList.item(0).slice(-1);
                console.log(`체크 버튼${sequence} 클릭`);
                if(targetElement.classList.contains('noncheck-icon')){
                    targetElement.setAttribute('name', 'checkmark-circle');
                    targetElement.classList.replace(`noncheck-icon${sequence}`, `check-icon${sequence}`);
                    targetElement.classList.replace('noncheck-icon', 'check-icon');

                } else if(targetElement.classList.contains('check-icon')){
                    targetElement.setAttribute('name', 'ellipse-outline');
                    targetElement.classList.replace(`check-icon${sequence}`, `noncheck-icon${sequence}`);
                    targetElement.classList.replace('check-icon', 'noncheck-icon');

                } else {;}
            }
            function keydown(event){
                // Enter 키를 눌렀을 때
                if (event.key === 'Enter') {
                    // 원하는 동작 수행
                    console.log('Enter 키가 눌렸습니다.');
                    event.target.blur();
                }
            } // 해당 todo3에 keydown 이벤트가 발생하면

            document.addEventListener('click', function(event) {
                if (event.target.closest('.add-icon') || event.target.closest('.todo-item')) {
                    return;
                }
                console.log('플러스 버튼 바깥쪽 클릭');
                // todoList 영역에 가장 마지막으로 추가된 todoItem의
                // todoInput의 value가 널스트링이면 todoItem을 없앤다.
                var lastTodo = todoItem.lastElementChild;
                if(lastTodo != null){
                    if(lastTodo.value === ''){
                        todoList.removeChild(todoItem);
                    }
                }
            }); // 아무데나 클릭시

            // 2. DOM 조작을 통해서 todo 페이지에 받아온 data 출력.
            var nickname = document.querySelector('#nickname');
            var profileImg = document.querySelector('#profile-img');
            nickname.innerText = data.nickname;
            profileImg.innerText = data.profile_img;
        }); // fetchPage('todo')
    });
}

// 보관함 요청
function storage(){

}
