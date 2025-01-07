// const dog = {
//     name: '멍멍이',
//     sound: '멍멍!',
//     say: function say() {
//         console.log(this.sound);
//     }
// };

const dog = {
    name: '멍멍이',
    sound: '멍멍!',
    say: function () { //함수 이름이 없어도 됨 
        console.log(this.sound);
        console.log("dog 객체 안에서의 ::" + this);
    }
};
dog.say();


function test() {
    console.log(this);
}

test();