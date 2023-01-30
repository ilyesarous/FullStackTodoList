import "./NewTask.css";
import { useState } from "react";

const NewTask = () => {
  const [task, setTask] = useState("");

  const taskHandler = event => {
    setTask(event.target.value);
  }

  const submitHandler = event => {
    event.preventDefault();

    const tasks={
      title: task
    }
  

    // props.onAddTask(tasks)

    fetch(("http://localhost:8080/task/add"),{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(tasks)
    }).then(()=> console.log("added"))

    setTask("");
  };

  return (
    <form className="new-task" onSubmit={submitHandler}>
      <div className="new-task__description">
        <input
          type="text"
          className="new-task__input"
          placeholder=" Add new task"
          onChange={taskHandler}
          value={task}
        />
      </div>
      <button type="submit">Add</button>
    </form>
  );
};

export default NewTask;
