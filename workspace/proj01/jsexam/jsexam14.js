function work(callback) { //callback함수를 받음 
    setTimeout(() => {
        const start = Date.now();
        for (let i = 0; i < 1000000000; i++) {
            // Intentionally empty loop for time consumption
        }
        const end = Date.now();
        console.log(`작업 시간: ${end - start}ms`);
        if (callback) {
            callback(); // 콜백 함수 호출
        }
    }, 0);
}

console.log('작업 시작!');

work(() => {
    console.log('작업이 끝났어요!'); //작업이 끝나고 실행시킬 코드 콜백 함수를 매개변수로 넘김 
});

console.log('다음 작업');


//콜백큐에 있던 함수(비동기 코드)들은 동기코드들이 끝나야 실행 됨 