class Shape{
    String calculateArea(){
        return "0";
    }
}

class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius = radius;
    }

    String calculateArea(){ return "Area of Circle with radius "+radius+": "+radius * radius * Math.PI; }
}

class Rectangle extends Shape{
    double width;
    double height;
    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    String calculateArea(){
        return "Area of Rectangle with width "+width+" and height"+height+": "+width * height;
    }
}

class Triangle extends Shape{
    double base;
    double height;
    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    String calculateArea(){
        return "Area of Triangle with base "+base+" and height "+height+": "+base*height/2;
    }
}
class ShapeCalculator{
    public static  void main(String[] args){
        System.out.println("Shape Calculator \n");
        Shape[] shapes = {new Circle(5),new Rectangle(4,6),new Triangle(3,8)};
        for (Shape s : shapes){
            System.out.println(s.calculateArea());
        }
    }
}