import { useState } from "react";

const Note = ({ memo, updateNote, deleteNote }) => {

    const [updatemode, setUpdateMode] = useState(false);
    const [title, setTitle] = useState("");

    const turnHanler = () => {
        setUpdateMode(true);
    }

    const saveHandler = () => {
        updateNote({
            id: memo.id,
            text: title,
            createAt: new Date().toLocaleString(), //작성시간 
        })
        setUpdateMode(false);


    }
    const changeHandler = (e) => {
        setTitle(e.target.value);
    }

    if (updatemode) {
        return (
            <>
                <input type="text" value={title} placeholder="노트 내용 입력" onChange={changeHandler}></input>
                <button onClick={saveHandler}>저장</button>
            </>
        );

    } else {

        return (
            <>
                {memo.text}<br></br>
                {memo.createAt}<br></br>
                <button onClick={turnHanler}>수정</button>
                <button onClick={() => deleteNote(memo.id)}>삭제</button>
            </>);
    }
}
export default Note;