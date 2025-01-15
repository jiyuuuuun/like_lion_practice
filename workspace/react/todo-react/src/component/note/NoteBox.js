import { useState } from "react";
import NoteInput from "./NoteInput";
import NoteList from "./NoteList";
const NoteBox = () => {

    const [noteList, setNoteList] = useState([
        {
            id: Date.now(),
            text: "할일 1",
            createAt: new Date().toLocaleString(), //작성시간 
        },
    ])

    const addNote = (newNote) => {
        setNoteList([...noteList, newNote]);

    };

    const deleteNote = (id) => {
        const notes = noteList.filter((note) => note.id != id);
        setNoteList(notes);

    };

    const updateNote = (memo) => {
        const newNoteList = noteList.map((note) => {
            if (note.id === memo.id) {
                return { ...note, text: memo.text };
            } return note;
        })
        setNoteList(newNoteList);

    };

    return (
        <div className="note-box">
            <h1>⭐jiyun note⭐</h1>
            <NoteInput addHandler={addNote}></NoteInput>
            <NoteList noteList={noteList} deleteNote={deleteNote} updateNote={updateNote}></NoteList>
        </div>);
}
export default NoteBox;