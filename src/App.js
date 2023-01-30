import './App.css';
import NewTask from './newTask/NewTask';
import AllTasks from './tasks/AllTasks';
import { useState } from 'react';

const defaultTasks = []

function App() {

  const [tasks,setTasks] = useState(defaultTasks)
  
  const addTasksHandler =(newTask)=>{
    setTasks((preTask) => {
      return [newTask, ...preTask]
    })
  }

  return (
    <div>
      <NewTask onAddTask={addTasksHandler}/>
      <AllTasks task={tasks}/>
    </div>
  );
}

export default App;
