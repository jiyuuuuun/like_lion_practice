const style = {
    border: "4px solid green",
    padding: "16px",
};

const Parent = (p) => {
    return <div style={style}>{p.children}</div>;
};

export default Parent;