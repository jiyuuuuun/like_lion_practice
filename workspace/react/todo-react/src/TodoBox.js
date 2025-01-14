import TodoInput from "./TodoInput";
import TodoList from "./TodoList";
import { useRef, useState } from "react";

const TodoBox = () => {
    const [todoList, setTodoList] = useState([
        { id: 1, title: "리액트 공부하기" },
        { id: 2, title: "스프링 공부하기" },
        { id: 3, title: "병원 가기" },
    ])

    const id = useRef(Math.max(...todoList.map((todo) => todo.id)) + 1);

    const addTodoList = (title) => {
        console.log(title);

        const newTodo = {
            id: id.current++,
            title: title,
        };

        setTodoList([...todoList, newTodo]);

    }
    //삭제
    const deleteTodoList = (id) => {
        setTodoList(todoList.filter((todo) => todo.id != id))
    }

    //수정
    const updateTodoList = (todo) => {
        todoList.map((item) => {
            if (item.id === todo.id) {
                item.title = todo.title
            }
        })


    }
    return (
        <div>
            <TodoInput addTodo={addTodoList} ></TodoInput>
            <TodoList todoList={todoList} deleteTodoList={deleteTodoList} updateTodoList={updateTodoList}></TodoList>
        </div>
    );

}




export default TodoBox;