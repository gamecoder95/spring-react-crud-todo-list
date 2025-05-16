import React from 'react';

function Task({id, taskValue, isDone, onUpdate, onDelete}) {

    const handleDone = () => onUpdate(id, taskValue, !isDone);

    const handleDelete = () => onDelete(id);

    return (
        <span style={{display: 'flex'}}><button onClick={handleDone}>{isDone ? "Done" : "Not Done"}</button><p>{taskValue}</p><button onClick={handleDelete}>Delete</button></span>
    );
}

export default Task;