import { useState } from "react";

const TitilePriceInputBox = () => {

    const [input, setInput] = useState({
        title: "pen",
        price: "2000",
    });
    const { title, price } = input;

    const changeHandler = (e) => {
        const { name, value } = e.target;

        setInput({
            ...input,
            [name]: value, //객체를 새롭게 만든다, 키값은 중복되면 교체되는 성질을 이용 
        });

    }
    return (
        <div>
            <label>title:{title} </label>
            <br></br>
            <label>price:{price} </label>
            <br></br>

            제목 : <input type="text" name="title" value={title} onChange={changeHandler} placeholder="제목을 입력하세요"></input><br></br>
            가격 : <input type="text" name="price" value={price} onChange={changeHandler} placeholder="가격을 입력하세요"></input><br></br>
            <button>RESET</button>
        </div>
    )
};
export default TitilePriceInputBox;