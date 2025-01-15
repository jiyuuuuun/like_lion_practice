import { useEffect, useState } from "react";

const Todo = ({ list, deleteHandler, updateHandler }) => {
    const [updateMode, setUpdateMode] = useState(false);
    const [title, setTitle] = useState(list.title);

    useEffect(() => {
        console.log("ToDo 컴포넌트가 화면에 나타남" + list.title);

        return () => {
            console.log("ToDo 컴포넌트가 화면에서 사라짐" + list.title);
        };
    }, [list]);

    const updateModeHandler = () => {
        setUpdateMode(true);
    }
    function changeHandler(e) {
        setTitle(e.target.value);
    }
    const updater = () => {
        updateHandler({ id: list.id, title: title });
        setUpdateMode(false);
    };
    if (updateMode) {
        return <>
            <input type="text" onChange={changeHandler} value={title} />
            <button onClick={updater}>수정</button>
        </>

    } else {
        return (
            <>
                {list.title}
                <button onClick={() => deleteHandler(list.id)}>삭제</button>
                <button onClick={updateModeHandler}>수정</button>
            </>);
    }
}
export default Todo;