//프로토 타입 
function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
    this.say = function () {
        console.log(this.sound);
    }
}
//새로운 객체를 만들 때에는 new 키워드를 앞에 붙여주어야 함
const dog = new Animal('개', '멍멍이', '멍멍');
const cat = new Animal('고양이', '야옹이', '야옹'); //new 할 때 마다 다 다른 메모리로 생성 됨 

dog.say();
cat.say();

function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
}
Animal.prototype.say = function () { //특정 함수 또는 값을 재사용, 공통적인 부분은 객체가 여러개 생성 되어도 하나의 프로토타입 메모리만 생성 됨 
    console.log(this.sound);
};
Animal.prototype.sharedValue = 1;


const dog2 = new Animal('개', '멍멍이', '멍멍');
const cat2 = new Animal('고양이', '야옹이', '야옹');
dog2.say();
cat2.say();

cat2.say = function () {
    console.log("야옹야옹")
};

cat2.say(); //프로토타입으로 설정한 say가 아니라 새로 지정한 함수가 실행 됨