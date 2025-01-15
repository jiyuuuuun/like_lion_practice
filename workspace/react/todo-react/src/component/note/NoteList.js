import Note from "./Note";
const NoteList = ({ noteList, updateNote, deleteNote }) => {
    return (
        <ul className="note-list">
            {noteList.map((note) => (
                <li key={note.id}><Note memo={note} deleteNote={deleteNote} updateNote={updateNote}></Note></li>
            ))}
        </ul>
    );
}
export default NoteList;