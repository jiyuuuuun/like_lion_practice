//단축 평가   거짓을 판단하는 기준이 단지 값으로만 판단
console.log(" " ?? "hello"); //공백백
console.log(0 ?? "hello"); //0
console.log(null ?? "hello"); //hello
console.log(undefined ?? "hello"); //hello
console.log(false ?? "hello"); //false

let oldName = "송아지";
let newName = "황지윤"

//단축 평가 사용 X
if (newName) {
    oldName = newName
};
console.log("단축 평가 사용 전 ::" + oldName);

//단축 평가 사용 O
oldName = "송아지";
newName && (oldName = newName);
console.log("단축 평가 사용 후 ::" + oldName)

oldName = "송아지";
oldName &&= newName; //oldName&&(oldName=newName) 
console.log("단축 평가 &&= 사용 후 ::" + oldName);

const person = { name: "" };

console.log(person.age);

person.age ??= 23; //person에 age라는 속성이 없다면 적용, 없다면 무시    
console.log(person);

person.name ||= "hwang";
console.log(person.name);
console.log(person);

