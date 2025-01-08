//단축평가
//논리 연산자를 활용 

const food = { foodname: "피자" };
//if문을 안했더라면 null이 들어왔을 때 오류 
function getFoodName(food) {
    if (!food) return '아무거나';
    return food.foodname;
}

console.log(getFoodName(food));
console.log(getFoodName());

//단축평가를 이용해서 getFoodName함수를 수정 
function getFoodName(food) {
    return food && food.foodname; //food가 false면 false민 리턴, food.foodname을 실행시키지 않음 
    //food가 true일때만 뒤의 문장 실행해서 food.foodname 리턴 
}

//자바 스크립트에서 false라고 판단하는 경우
console.log("===========");
console.log(" " || "hello");
console.log(0 || "hello");
console.log(null || "hello");
console.log(undefined || "hello");
console.log("===========");


let a;
let b = null;
let c = undefined;
let d = 4;
let e = "test";

let f = a || b || c || d || e;

console.log(f);


const name = "hwang";

const username = name || "geust"; //name의 값이 있으면(true) name값 , name의 값이 없으면(false) "geust" 

console.log(username); //hwang 출력 