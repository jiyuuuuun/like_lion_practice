//{}객체

const dog = { name: "멍멍이", age: 2 };
console.log(dog.name);
console.log(dog.age);
console.log(dog["name"]);

const hwang = {
    name: "jiyun",
    age: 23,
    adress: "경기도 부천시"
};

console.log(hwang.name);
console.log(hwang.age);
console.log(hwang.adress);

//JSON 으로 데이터를 받아서 자바스크립트 객체로 변환하여 값을 꺼내기 쉬움
//자바스크립트의 객체 표현 방식과 같음 

const ironMan = {
    name: "토니 스타크",
    actor: "로버트 다우니 주니어",
    alias: "아이언맨",
};

const captainAmerica = {
    name: "스티븐 로저스",
    actor: "크리스 에반스",
    alias: "캡틴 아메리카",
};

function print(hero) {
    console.log(`${hero.name}은 ${hero.actor}가 연기 하였다 히어로의 이름은 ${hero.alias}이다`)
};

print(ironMan);
print(captainAmerica);


//객체 비구조화 할당
//객체에서 값들을 추출해서 새로운 상수로 선언
function print(hero) {
    const { name, actor, alias } = hero;
    console.log(`${name}은 ${actor}가 연기 하였다 히어로의 이름은 ${alias}이다`) //더 간결하게 쓸 수 있음
};

function print({ name, actor, alias }) {
    console.log(`${name}은 ${actor}가 연기 하였다 히어로의 이름은 ${alias}이다`)
}
