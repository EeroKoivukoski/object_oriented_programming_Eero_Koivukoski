import java.awt.*;

class Shape2{
    Color color;
    Shape2(Color c){
        this.color = c;
    }
    String calculateArea(){
        return "0";
    }
}

class Circle2 extends Shape2{
    double radius;
    Circle2(double radius){
        super(Color.BLUE);
        this.radius = radius;
    }

    String calculateArea(){ return "Area of Circle with radius "+radius+": "+radius * radius * Math.PI; }
}

class Rectangle2 extends Shape2{
    double width;
    double height;
    Rectangle2(double width, double height){
        super(Color.RED);
        this.width = width;
        this.height = height;
    }
    String calculateArea(){
        return "Area of Rectangle with width "+width+" and height"+height+": "+width * height;
    }
}

class Triangle2 extends Shape2{
    double base;
    double height;
    Triangle2(double base, double height){
        super(Color.GREEN);
        this.base = base;
        this.height = height;
    }
    String calculateArea(){
        return "Area of Triangle with base "+base+" and height "+height+": "+base*height/2;
    }
}

class ShapeCalculator2{
    public static  void main(String[] args){
        System.out.println("Shape Calculator \n");
        Shape2[] shapes = {new Circle2(5),new Rectangle2(4,6),new Triangle2(3,8)};
        for (Shape2 s : shapes){
            System.out.println(s.calculateArea());
        }
    }
}
