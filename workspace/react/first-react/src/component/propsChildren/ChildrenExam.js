import Second from "./Second";
import Parent from "./Parent";
import First from "./First";

const ChildrenExam = () => {
    return (
        <Parent>
            <First></First>
            <Second name="jiyun"></Second>
        </Parent>);
};
export default ChildrenExam;