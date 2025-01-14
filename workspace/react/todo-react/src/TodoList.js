const TodoList = ({ todoList }) => {
    return (
        <ul>
            {todoList.map((list) => (
                <li key={list.id}>{list.title}</li>
            ))}
        </ul>
    );
}
export default TodoList;