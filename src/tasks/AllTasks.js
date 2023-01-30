import Tasks from "./Tasks"
import { useState, useEffect } from "react"

let id;

const AllTasks = props => {

    const [tasks, setTasks] = useState(props.task);
    
    useEffect(()=>{
        fetch("http://localhost:8080/task/getAll")
        .then(res => res.json())
        .then(json => setTasks(json))
    }, [tasks])

    // useEffect(() => {
    //     fetch(`http://localhost:8080/task/${id}`)
    //     .then(json => setTasks(json))
    // }, [tasks]);

    // const deleteTask = (i) =>{
    //     return id = i
    // }

    return(
        <div className="tasks-container">
            {tasks.map((t) =>( <Tasks key={t.id} id={t.id} title={t.title}/>))}
        </div>
    )
}

export default AllTasks