import { useState } from "react";

const UseStateExam01 = () => {
    const [time, setTime] = useState(1);

    const timeHandler = () => {
        if (time >= 12) {
            setTime(1);
        } else {
            setTime(time + 1);
        }

    }

    return (
        <div>
            <span>시간: {time} 시</span> <br></br>
            <button onClick={timeHandler}>update</button>
        </div>
    );
}
export default UseStateExam01;