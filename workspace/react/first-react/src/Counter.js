import { useState } from "react";
import MyButton from "./MyButton";

const Counter = () => {
    console.log('counter 컴포넌트 실행!🆗');
    //let count = 0;
    const [count, setCount] = useState(0); //상태 값이 바뀌면 함수 다시 호출 

    const plusHandler = () => {
        // count++;
        console.log(count);
        setCount(count + 1);

    }
    const minusHandler = () => {
        // count--;
        console.log(count);

        setCount(count - 1);

    }
    const helloAlert = () => {
        alert("안녕하세요");
    };

    return (
        <div>
            <h1>{count}</h1>
            {/* <input type="button" value="+" onClick={plusHandler} />
            <input type="button" value="-" onClick={minusHandler} /> */}
            <MyButton title="+" clickHandler={plusHandler}></MyButton>
            <MyButton title="-" clickHandler={minusHandler}></MyButton>
            <MyButton title="안녕하세요" clickHandler={helloAlert}></MyButton>
        </div>
        //함수가 다시 호출이 되어야 count 값이 바뀐 화면도 다시 호출 


    );

};

export default Counter;