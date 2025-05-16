import React, { useRef } from 'react';

function Create({onAdd}) {

    const taskInputField = useRef(null);

    const handleAdd = () => {
        const taskStr = taskInputField.current.value;
        if (taskStr.length > 0) {
            onAdd(taskStr);
        }
    };

    return (
        <div>
            <input ref={taskInputField} type="text" placeholder="Add new task" />
            <button type="button" onClick={handleAdd}>Add</button>
        </div>
    );  
}

export default Create;