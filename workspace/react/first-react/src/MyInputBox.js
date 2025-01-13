import { useRef, useState } from "react";

const MyInputBox = () => {
    // const text = "기본값";
    const [text, setText] = useState("기본값");

    const textInput = useRef();

    const resetHandler = () => {
        setText("");
        textInput.current.focus();
    }
    const changeHandler = (e) => {
        setText(e.target.value);
    }
    return (
        <div>
            <label>{text}</label><br></br>
            <input type="text" value={text} onChange={changeHandler} ref={textInput}></input>
            <button onClick={resetHandler}>RESET</button>
        </div>
    )
};
export default MyInputBox;