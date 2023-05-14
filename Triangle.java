// Written by Jonathan Dereje, derej009 

import java.awt.*;

public class Triangle {
    // constructor method
    private double xPos;
    private double yPos;
    private double Width;
    private double Height;
    private Color c;
    // Initalize the xPos, yPos, Width, and Height
    public Triangle(double xPos,double yPos, double Width, double Height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.Width = Width;
        this.Height = Height;
    }
    // create the other methods.. calculating the perimeter and area
    public double calculatePerimeter(){
        return 2 * (this.Width + this.Height);
    }
    public double calculateArea(){
        double area = this.Width * this.Height;
        return area / 2;
    }
    // Setter Methods
    public void setColor(Color c) {
        this.c = c;
    }
    public void setPos(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public void setHeight(double Height){
        this.Height = Height;
    }
    public void setWidth(double Width){
        this.Width = Width;
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

   // public void setColor(Color c) {
  //  }
}


