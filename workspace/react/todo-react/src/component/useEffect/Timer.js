import { useEffect } from "react";

const Timer = () => {

    useEffect(() => {
        const Timer = setInterval(() => {
            console.log("타이머 실행중");
        }, 1000);
        return () => {
            clearInterval(Timer);
            console.log('타이머 종료');
        }
    })
    return (
        <div>
            <span>타이머 시작</span>
        </div>
    );
}
export default Timer;