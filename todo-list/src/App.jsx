import { useState, useEffect } from 'react'
import Create from './Create';
import TaskList from './TaskList';
import axios from 'axios';

import './App.css'

function App() {

  const [tasks, setTasks] = useState([]);

  useEffect(() => {

    axios.get('http://localhost:8080/get')
    .then(result => {
      // console.log(result.data);
      setTasks(result.data);
    })
    .catch(error => console.log(error));

  }, []);

  const handleAdd = taskValue => {

    axios.post('http://localhost:8080/add', { taskValue: taskValue })
    .then(result => setTasks(prevTasks => {
      let updatedTasks = prevTasks.slice();

      updatedTasks.push(result.data);

      return updatedTasks;
    }))
    .catch(error => console.log(error));
  }

  const handleTaskUpdate = (id, taskValue, isDone) => {
    axios.put(`http://localhost:8080/update/${id}`, { taskValue: taskValue, isDone: isDone })
    .then(result => setTasks(prevTasks => {
      let updatedTasks = prevTasks.slice();

      const updatedTaskResponse = result.data;  

      const updatedTaskIndex = updatedTasks.findIndex(task => task.id === id);

      updatedTasks[updatedTaskIndex] = {
        ...updatedTasks[updatedTaskIndex],
        taskValue: updatedTaskResponse.taskValue,
        isDone: updatedTaskResponse.isDone
      };

      return updatedTasks;
    }))
    .catch(error => console.log(error));
  };

  const handleTaskDelete = id => {
    axios.delete(`http://localhost:8080/delete/${id}`)
    .then(result => setTasks(prevTasks => {
      let updatedTasks = prevTasks.slice();

      const deletedTaskResponse = result.data;

      const deletedTaskIndex = updatedTasks.findIndex(task => task.id === deletedTaskResponse.id);
      updatedTasks.splice(deletedTaskIndex, 1);

      return updatedTasks;
    }))
    .catch(error => console.log(error));
  };

  return (
    <>
      <h2>Todo List</h2>
      <Create onAdd={handleAdd} />
      <TaskList tasks={tasks} onTaskUpdate={handleTaskUpdate} onTaskDelete={handleTaskDelete}/>
    </>
  );
}

export default App;
