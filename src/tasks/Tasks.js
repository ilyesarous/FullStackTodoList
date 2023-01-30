import "./Tasks.css"

const Tasks = props =>{

    const deleteHandler = () =>{
            fetch(`http://localhost:8080/task/${props.id.toString()}`, {
            method: 'DELETE',
            });
    }

    return(
        <div className="container">
            <div className="title">{props.title}</div>
            <button onClick={deleteHandler}>Delete</button>
        </div>
    )
}

export default Tasks;