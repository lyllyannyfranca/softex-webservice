const express = require('express');
const app = express();
app.use(express.json());

//Coleção de objetos para simular um banco de dados

let students = [
  { id: 1, name: 'Bruna', age: 15 },
  { id: 2, name: 'Henrique', age: 16 },
  { id: 3, name: 'Ana', age: 17 }
];

// Listar todos os alunos
app.get('/student', (req, res) => {
  res.status(200).json(students);
});

// Lista um aluno por id passado
app.get('/student/:id', (req, res) => {
  const student = students.find(a => a.id === parseInt(req.params.id));
  if (!student) return res.status(404).send("Error: Student dont finded!");
  res.status(200).json(student);
});

// Criar um novo aluno
app.post('/student', (req, res) => {
  const student = {
    id: students.length + 1,
    name: req.body.name,
    age: req.body.age
  };
  students.push(student);
  res.status(201).json(student);
});

// Atualiza um aluno existente
app.put('/student/:id', (req, res) => {
  const student = students.find(a => a.id === parseInt(req.params.id));
  if (!student) return res.status(404).send("Student dont finded!");
  student.name = req.body.name;
  student.age = req.body.age;
  res.status(200).json(student);
});

// Remove um aluno existente
app.delete('/student/:id', (req, res) => {
  const student = students.find(a => a.id === parseInt(req.params.id));
  if (!student) return res.status(404).send("Student dont finded!");
  const index = students.indexOf(student);
  students.splice(index, 1);
  res.status(200).send('Student removed with success!');
});

app.listen(3000, () => console.log('Server started in port 3000'));