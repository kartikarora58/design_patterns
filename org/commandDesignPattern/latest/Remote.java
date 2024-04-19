package org.commandDesignPattern.latest;

import java.util.Stack;

public class Remote {
    Command command_;
    Stack<Command> undoStack;

    Remote()
    {
        undoStack = new Stack<>();
    }
    public void setCommand(Command command)
    {
        command_ = command;
    }

    public void pressButton()
    {
        undoStack.push(command_);
        command_.execute();
    }
    public void undo()
    {
        if(!undoStack.isEmpty())
        {
            undoStack.pop().undo();
        }
    }
}
