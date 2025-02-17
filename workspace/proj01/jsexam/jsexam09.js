//객체 생성자 상속

function Animal(type, name, sound) {
    this.type = type;
    this.name = name;
    this.sound = sound;
}

Animal.prototype.say = function () {
    console.log(this.sound);
};

Animal.prototype.sharedValue = 1;

function Dog(name, sound) {
    Animal.call(this, '개', name, sound);
}

Dog.prototype = Animal.prototype; //프로토 타입 복사

function Cat(name, sound) {
    Animal.call(this, '고양이', name, sound);
}

Cat.prototype = Animal.prototype; //프로토 타입 복사 

const dog = new Dog('멍멍이', '멍멍');
const cat = new Cat('야옹이', '야옹');

dog.say();
cat.say();
