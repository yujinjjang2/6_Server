// 회원가입 시 유효성 검사 명세

// 변수 선언
let idFlag = false;
let pwFlag = false;
let nmFlag = false;

// 아이디
document.getElementById("id").addEventListener("keyup", function() {

    const idSpan = document.getElementById("id-span");

    const regExp = /^[a-z][a-zA-Z0-9]{5,13}$/;

    if(this.value == 0) {
        this.style.backgroundColor = "white";
        return;
    }

    if(regExp.test(this.value)) {
        this.style.backgroundColor = "green";
        idFlag = true;
    } else {
        this.style.backgroundColor = "red";
        idFlag = false;
    }
});

// 비밀번호, 비밀번호 확인
document.getElementById("pw2").addEventListener("keyup", function() {

    const pw = document.getElementById("pw");

    if(pw.value == 0) {
        this.value = "";
        alert("비밀번호를 입력해주세요");
        pw.focus();
    }
});

// 비밀번호가 일치할 경우
document.getElementById("pw2").addEventListener("keyup", function() {

    const pw = document.getElementById("pw");

    const pw2Span = document.getElementById("pw2-span");

    if(this.value == pw.value) {
        pw2Span.innerText = "비밀번호 일치";
        pw2Span.style.color = "green";
        pwFlag = true;
    } else {
        pw2Span.innerText = "비밀번호 불일치";
        pw2Span.style.color = "red";
        pwFlag = false;
    }
});

// 이름
document.getElementById("nm").addEventListener("keyup", function() {

    const nmSpan = document.getElementById("nm-span");

    const regExp = /^[가-힣]{2,5}$/;

    if(regExp.test(this.value)) {
        nmSpan.innerText = "정상입력";
        nmSpan.style.color = "green";
        nmFlag = true;
    } else {
        nmSpan.innerText = "한글만 입력하세요";
        nmSpan.style.color = "red";
        nmFlag = false;
    }
});

// 가입하기 버튼
document.getElementById("sign-btn").addEventListener("click", function(event) {

    const inputId = document.getElementById("id");
    const inputPw = document.getElementById("pw");
    const inputNm = document.getElementById("nm");

    // 아이디 체크
    if(isNull(inputId.value)) {
        alert("아이디를 입력하세요.");
        event.preventDefault();
        return;
    } else {
        if(idFlag == false) {
            alert("유효한 형식의 아이디를 입력해주세요.");
            event.preventDefault();
            return;
        }
    }

    // 비밀번호 체크
    if(isNull(inputPw.value)) {
        alert("비밀번호를 입력하세요.");
        event.preventDefault();
        return;
    } else {
        if(pwFlag == false) {
            alert("유효한 형식의 비밀번호를 입력해주세요.");
            event.preventDefault();
            return;
        }
    }

    // 닉네임 체크
    if(isNull(inputNm.value)) {
        alert("닉네임을 입력하세요.");
        event.preventDefault();
        return;
    } else {
        if(nmFlag == false) {
            alert("유효한 형식의 닉네임을 입력해주세요.");
            event.preventDefault();
            return;
        }
    }
});

// NULL 체크 함수
function isNull(str) {
    if(str == null || str == "" || str == undefined) {
        return true;
    } else {
        return false;
    }
}


