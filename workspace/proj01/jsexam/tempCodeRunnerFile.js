const person = { name: "" };

console.log(person.age);

person.age ??= 23; //person에 age라는 속성이 없다면 적용, 없다면 무시    
console.log(person);

person.name ||= "hwang";
console.log(person.name);
console.log(person);
