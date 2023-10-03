// 변수 선언
let idFlag = false;
let pwFlag = false;
let nmFlag = false;

// 유효성 검사 : 아이디
document.getElementById("id").addEventListener("change", function() {

    // 유효성 검사
    const regExp = /^[a-z][a-zA-Z0-9]{5,13}$/;

    // 값이 없을 경우
    if(this.value == 0) {
        this.style.backgroundColor = 'white';
        return;
    }

    // 형식이 일치할 경우
    if(regExp.test(this.value)) {
        this.style.backgroundColor = 'green';
        this.style.color = 'white';
        idFlag = true;
    } else {
        // 형식이 일치하지 않을 경우
        this.style.backgroundColor = 'red';
        this.style.color = 'black';
        idFlag = false;
    }
});

// 유효성 검사 : 비밀번호
document.getElementById("pw2").addEventListener("keyup", function() {

    // 비밀번호 객체 가져오기
    const pw = document.getElementById("pw");

    if(pw.value == 0) {
        this.value = "";
        alert("비밀번호를 입력해주세요");      
        pw.focus();
        return;
    }

    // pw-span 객체 가져오기
    const pwSpan = document.getElementById("pw-span");

    // 비밀번호가 일치할 경우
    if(pw.value == this.value) {
        pwSpan.innerText = "비밀번호 일치";
        pwSpan.style.color = 'green';
        pwFlag = true;
    } else {
        // 비밀번호가 일치하지 않을 경우
        pwSpan.innerText = "비밀번호 불일치";
        pwSpan.style.color = 'red';
        pwFlag = false;
    }
});

// 유효성 검사 : 닉네임
document.getElementById("nm").addEventListener("change", function() {

    // nmSpan 객체 가져오기
    const nmSpan = document.getElementById("nm-span");

    // 정규표현식
    const regExp = /^[가-힣]{2,5}$/;

    if(this.value == 0) {
        nmSpan.innerText = "";
        return;
    }

    // 형식이 일치할 경우
    if(regExp.test(this.value)) {
        nmSpan.innerText = "정상입력";
        nmSpan.style.color = 'green';
        nmFlag = true;
    } else {
        // 형식이 일치하지 않을 경우
        nmSpan.innerText = "한글만 입력하세요";
        nmSpan.style.color = 'red';
        nmFlag = false;
    }
});

// 가입하기 버튼
document.getElementById("signup-btn").addEventListener("click", function(event) {

    // Flag Check
    if(idFlag == false || pwFlag == false || nmFlag == false) {
        alert("아이디, 비밀번호, 닉네임 중 유효하지 않은 형식이 있습니다.");
        event.preventDefault();
        return;
    }
});


