function add(a) {
    console.log("a");
    return a;
}


function add(a, b) { //코드 덮어 씌우기 
    console.log("a+b");
    return a + b;
}

// console.log(add(3)); 
add(2, 3);
add(2, 3, 4);
add(2, 3, 4, 5, 6, 7, 96, 9);
add(2, 4, 6, 7, 4, 7, 5, 44, 4, 44, 3222, 2);

function add(a, b, c) { //코드 덮어 씌우기 
    console.log(arguments.length); //매개변수를 배열로 사용할 수 있음 
    console.log("1번째 매개변수 값::: " + arguments[0]);
}
