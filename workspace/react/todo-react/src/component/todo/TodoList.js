import Todo from "./Todo";
const TodoList = ({ todoList, deleteHandler, updateHandler }) => {
    return (
        <ul>
            {todoList.map((list) => (
                <li key={list.id}><Todo list={list} deleteHandler={deleteHandler} updateHandler={updateHandler}></Todo></li>
            ))}
        </ul>
    );
}
export default TodoList;