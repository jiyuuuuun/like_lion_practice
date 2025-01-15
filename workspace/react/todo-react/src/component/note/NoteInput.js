const NoteInput = ({ addHandler }) => {
    const keyDownHandler = (e) => {
        if (e.key === "Enter") {
            const newNote = {
                id: Date.now(),
                text: e.target.value,
                createAt: new Date().toLocaleString(), // 작성 시간
            };
            addHandler(newNote);
            e.target.value = ""; // 입력 필드 초기화
            e.target.focus();
        }

    };
    return (
        <div className="note-input">
            <input type="text" onKeyDown={keyDownHandler} placeholder="노트 내용 입력"></input>
        </div>
    );
}
export default NoteInput;