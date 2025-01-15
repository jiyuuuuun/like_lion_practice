var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' });
  // render한다 -> 페이지로 응답을 하겠다는 것이다.
});

router.get('/hi', function (req, res, next) {
  res.render('index', { title: 'Joowon' });
});

router.get('/test/hi', function (req, res, next) {
  res.render('index', { title: 'TEST Joowon' });
});

let todos = [
  {
    id: 3,
    title: "Todo 3",
    done: false,
  },
  {
    id: 2,
    title: "Todo 2",
    done: false,
  },
  {
    id: 1,
    title: "Todo 1",
    done: false,
  },
];


router.get("/api/todos", function (req, res) {
  res.status(200).json(todos);
  // 이 프로젝트는 res.render() 로 페이지를 넘기진 않는다.
  // json 으로 데이터로 응답할 것이다.
});

router.get("/api/todos/:id", function (req, res) {
  const id = parseInt(req.params.id);

  const todo = todos.find((todo) => todo.id === id);

  res.status(200).json(todo);
});

let idGen = 3;
router.post("/api/todos", function (req, res) {
  let title = req.body.title;

  let todo = { id: ++idGen, title: title, done: false };
  todos.unshift(todo);
  res.status(200).json(todo);
});

router.patch("/api/todos/:id", function (req, res) {
  const id = parseInt(req.params.id);
  const todo = todos.find((todo) => todo.id === id);
  todo.done = !todo.done;

  res.status(200).json(todos);
});

router.patch("/api/todos", function (req, res) {
  // request한테 todos 객체가 들어온 것이다.
  const id = req.body.id;
  const title = req.body.title;

  todos.map((todo) => {
    if (todo.id === id) {
      todo.title = title;
    }
  });

  // result는 정하기 나름
  res.status(200).json({ result: "ok" });
});

router.delete("/api/todos/:id", function (req, res) {
  const id = parseInt(req.params.id);
  todos = todos.filter((todo) => todo.id !== id);

  res.status(200).json(todos);
});
module.exports = router;