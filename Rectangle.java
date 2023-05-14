// Written by Jonathan Dereje, derej009 
import java.awt.*;
public class Rectangle {
    private double xPos;
    private double yPos;
    private double Width;
    private double Height;
    private Color c;
    // constructor class
    public Rectangle(double xPos, double yPos, double Width, double Height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.Width = Width;
        this.Height = Height;
        //output the object type of the Rectangle
    }
    // Calculate the perimeter and area using correct formula
    public double calculatePerimeter(){
        return 2*(Height + Width);
    }
    public double calculateArea(){
        return Width * Height;
    }
    // Setter Methods
    public void setColor(Color c) {
        this.c = c;
    }
    public void setPos(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public void setHeight(double height){
        this.Height = height;
    }
    public void setWidth(double width){
        this.Width = width;
    }
    // Getter Methods
    public Color getColor(){
        return c;
    }
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getHeight(){
        return Height;
    }
    public double getWidth(){
        return Width;
    }
}


