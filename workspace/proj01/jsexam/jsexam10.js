//클래스

// Animal 클래스 정의
class Animal {
    constructor(type, name, sound) {
        this.type = type;
        this.name = name;
        this.sound = sound;
    }

    say() {
        console.log(this.sound);
    }
}

// Dog 클래스 정의 (Animal을 상속받음)
class Dog extends Animal {
    constructor(name, sound) {
        // 부모 클래스의 생성자 호출 (type을 '개'로 고정)
        super('개', name, sound);
    }
}

// Cat 클래스 정의 (Animal을 상속받음)
class Cat extends Animal {
    constructor(name, sound) {
        // 부모 클래스의 생성자 호출 (type을 '고양이'로 고정)
        super('고양이', name, sound);
    }
}

// Dog와 Cat의 인스턴스 생성
const dog = new Dog('멍멍이', '멍멍');
const cat = new Cat('야옹이', '야옹');


dog.say(); // 출력: 멍멍
cat.say(); // 출력: 야옹
