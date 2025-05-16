import React from 'react';
import Task from './Task';

function TaskList({tasks, onTaskUpdate, onTaskDelete }) {

    const handleUpdate = (id, taskValue, isDone) => onTaskUpdate(id, taskValue, isDone);

    const handleDelete = id => onTaskDelete(id);

    const tasksToRender = tasks.map((task) => (
        <li key={task.id}><Task id={task.id} taskValue={task.taskValue} isDone={task.isDone} onUpdate={handleUpdate} onDelete={handleDelete} /></li>
    ));

    return (
        <div>
                {
                    tasksToRender.length === 0
                    ? <h3>No tasks added</h3>
                    : <ol>
                        {
                            tasksToRender
                        }
                    </ol>
                }
        </div>
    );
}

export default TaskList;
