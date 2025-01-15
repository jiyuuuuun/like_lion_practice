const TodoInput = ({ addTodo }) => {
    const keyDownHandler = (e) => {
        console.log(e.key);
        if (e.key === "Enter") {
            addTodo(e.target.value);
            e.target.value = ""; // 입력 필드 초기화
            e.target.focus();
        }


    }

    return <input type="text" placeholder="할일을 입력하세요" onKeyDown={keyDownHandler}></input>;
}
export default TodoInput;