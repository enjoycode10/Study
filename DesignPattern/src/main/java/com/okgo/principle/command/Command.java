package com.okgo.principle.command;


//��������ӿ�
public interface Command {

    //ִ�ж���(����)
    public void execute();

    //��������(����)
    public void undo();
}
