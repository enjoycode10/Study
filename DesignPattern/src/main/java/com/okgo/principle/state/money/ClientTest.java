package com.okgo.principle.state.money;

/**
 * 客户端测试
 **/
public class ClientTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 创建 context 对象
        Context context = new Context();
        // 初始化状态为 PublishState
        context.setState(new PublishState());
        System.out.println(context.getCurrentState());

        // publish --> not pay
        context.acceptOrderEvent(context);
        // not pay --> paid
        context.payOrderEvent(context);
        // 失败检测时，会抛出异常
        try {
            context.checkFailEvent(context);
            System.out.println("流程正常...");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

}
