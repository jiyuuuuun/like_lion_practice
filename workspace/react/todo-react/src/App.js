
import './App.css';
import UseEffectCleanUp from './component/useEffect/UseEffectCleanUp';
import UseEffectExam from './component/useEffect/UseEffectExam';
import TodoBox from './component/todo/TodoBox';
import NoteBox from './component/note/NoteBox';

function App() {
  return (<div className='card'>
    {/* <TodoBox></TodoBox>
    <UseEffectExam></UseEffectExam>
    <UseEffectCleanUp></UseEffectCleanUp> */}
    <NoteBox></NoteBox>
  </div>);
}

export default App;
