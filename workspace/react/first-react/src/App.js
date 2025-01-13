import ChildrenExam from "./component/propsChildren/ChildrenExam";
import Counter from "./Counter";
import MyInputBox from "./MyInputBox";
import UseStateExam01 from "./component/useState/UseStateExam01";
import UseStateExam02 from "./component/useState/UseStateExam02";
import TitilePriceInputBox from "./TitlePriceInputBox";
import BoardList from "./BoardList";
import UseRefExam from "./component/useRef/UseRefExam";

function App() {
  console.log('App 컴포넌트 실행!');
  return <div className="card">
    {/* <h1>hello react</h1>
    <p>hello jiyun</p>
    <Counter></Counter> */}
    {/* <ChildrenExam></ChildrenExam> */}
    {/* <MyInputBox></MyInputBox> */}
    {/* <UseStateExam02></UseStateExam02> */}
    {/* <TitilePriceInputBox></TitilePriceInputBox> */}
    {/* <BoardList></BoardList> */}
    <UseRefExam></UseRefExam>
  </div>


}

export default App;