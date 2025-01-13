import { useState } from "react";

const UseStateExam02 = () => {

    const [input, setInput] = useState("");
    const [names, setNames] = useState(["jiyun", "kong"]);

    const inputChangeHandler = (e) => {
        setInput(e.target.value);

    };
    const uploadHandler = () => {
        console.log(names);
        console.log(...names);
        setNames([input, ...names]);
        // 새로운 배열을 넣어줘야함 , 스프레드 연산 

    };
    return (
        <div>
            <input type="text" value={input} onChange={inputChangeHandler}></input>
            <button onClick={uploadHandler}>입력</button>



            {names.map((name) => {
                return <p>{name}</p>
            })}
        </div>
    );
};
export default UseStateExam02;