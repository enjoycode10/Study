package com.okgo.principle.principle.ocp.improve;

public class Ocp {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }

}

//这是一个用于绘制图形的类：使用方，使用图形如Rectangle等
class GraphicEditor {
    //这是一个用于绘制图形的类：使用方，使用图形如Rectangle等
    public void drawShape(Shape s) {
        s.draw();
    }


}

//Shape抽象类，添加抽象方法绘制draw
abstract class Shape {
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println(" 绘制圆形 ");
    }
}

class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println(" 绘制三角形 ");
    }
}

//����һ��ͼ��
class OtherGraphic extends Shape {
    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub
        System.out.println(" 绘制其他图形 ");
    }
}
