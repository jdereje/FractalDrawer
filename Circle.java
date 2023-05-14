// Written by Jonathan Dereje, derej009

//constructor method
import java.awt.*;
public class Circle {
    private double xPos;
    private double yPos;
    private double radius;
    private Color c;
    private static final double PI = 3.14;
    private Object getRadius;

    public Circle(double r, double y, double radius){
        this.radius = r;
    }
    // Initalizing radius, color, xPos, and yPos
    public Circle(double radius, double x, double y, Color c, Canvas can, int level){
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;
        this.c = c;
    }
    // Setter Methods
    public void setRadius(double r) {
        radius = r;
    }
    public void setColor(Color c){
        this.c = c;
    }
    // Getter Methods

    public double getCircumference() {
        return 2 * PI * radius;
    }
    public double getDiameter() {
        return 2 * radius;
    }
    public double getArea() {
        return PI * radius * radius;
    }
    public Color getColor(){
        return c;
    }

    public Object getXPos() {
        return xPos;
    }

    public Object getYPos() {
        return yPos;
    }
    public double getRadius() {
        return radius;
    }
    }






