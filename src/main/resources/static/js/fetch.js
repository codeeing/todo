// page 가져오기
function fetchPage(fPage){
    //var removedPage = fPage.substring(1);
    //var state = { data: '안녕'};
    //history.pushState(state, null, fPage);
    console.log(fPage+'페이지 fetching 하는중..');
    fPage = '/source/' + fPage;
    return fetch(fPage)
        .then(function (response) {
            return response.text();
        })
        .then(function (text) {
            const fetchArea = document.querySelector('.fetch-area');
            fetchArea.innerHTML = text;
        });
}

