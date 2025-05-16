package com.ahmad.practice.todolistapi.api.models;

import org.springframework.data.annotation.Id;

public class TodoTask/*(Integer id, String taskValue, boolean isDone)*/
{
    @Id
    private String id;

    private String taskValue;
    private boolean isDone;

    public TodoTask()
    {
        this("", false);
    }

    public TodoTask(String taskValue)
    {
        this(taskValue, false);
    }

    public TodoTask(String taskValue, boolean isDone)
    {
        this.taskValue = taskValue;
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public String getTaskValue()
    {
        return taskValue;
    }

    public void setTaskValue(String taskValue)
    {
        this.taskValue = taskValue;
    }

    public boolean getIsDone()
    {
        return isDone;
    }

    public void setIsDone(boolean isDone)
    {
        this.isDone = isDone;
    }

    @Override
    public String toString()
    {
        return String.format("Todo Task [id=%s, taskValue=%s, isDone=%b]", id, taskValue, isDone);
    }
}
