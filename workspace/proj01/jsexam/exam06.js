//배열

let array1 = [1, 2, 3];//배열이 바뀔경우 let

array1 = [4, 5, 6];

const array2 = [];//배열이 바뀌지 않는 겅우 const  배열 자체가 바뀌는 것이 아니라 값이 바뀌는 것
console.log(typeof array2);

console.log(array1[0]);
array1[2] = 20;

console.log(array1);

const array3 = new Array(10); //값이 1개만 들어오면, 값 만큼 값의 크기 배열을 생성
console.log(array3); //[ <10 empty items> ]

const array4 = new Array(10, 2); //크기 10의 배열에 값 2로 채워짐 
console.log(array4);

array1[0] = { name: "Hwang" }; //객체 넣기
console.log(array1);

array1.push(10);//맨 마지막 요소에 값 추가
console.log(array1);

array1.push(() => console.log("hello array")); //배열에 함수 넣기 
console.log(array1);

array1[4](); //4번 인덱스의 함수 출력 

//배열 비구조 할당 
const [a, b, c, d, e] = array1;
e();