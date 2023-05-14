//Written by Jonathan Dereje (derej009)
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.awt.*;
import java.util.*;
public class FractalDrawer {
    private static String type;
    private double totalArea=0; //create the area variable, so area can be added on of the different shapes
    public FractalDrawer() {}
    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas can = new Canvas(800, 800);
        while(true){
            // set the canvas size, and check if input == to each of the shapes
            if (type.equals("circle")){
                drawCircleFractal(500 , 300, 200, Color.BLACK, can, 7);
                return totalArea;
            } else if(type.equals("triangle")) {
                drawTriangleFractal(400, 200, 100, 200,Color.RED, can, 7);
            }else if(type.equals("rectangle")){
                drawRectangleFractal(150, 200, 50, 50, Color.GREEN, can, 7);
                return totalArea;
            }
            else{
                return totalArea;
            }
            // returning the Area for each shape, and returning nothing
            // if the input doesnt == any of the choices
        }
    }
    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle myTriangle = new Triangle(x, y, width, height);
        myTriangle.setColor(c);
        // Base Case of Triangle Fractal
        if(level == 0) {
            can.drawShape(myTriangle);
            this.totalArea = myTriangle.calculateArea();
        } else {
            double w_new = 0.5*myTriangle.getWidth();
            double h_new = 0.5*myTriangle.getHeight();
            Triangle myTriangle1 = new Triangle(myTriangle.getXPos() - 0.5*myTriangle.getWidth(), myTriangle.getYPos(), w_new, h_new);
            Triangle myTriangle2 = new Triangle(myTriangle.getXPos() + myTriangle.getWidth(), myTriangle.getYPos(), w_new, h_new);
            Triangle myTriangle3 = new Triangle(myTriangle.getXPos()+ 0.5*w_new, myTriangle.getYPos()-myTriangle.getHeight(), w_new, h_new);
            // Creating 3 Triangles, to cover all 3 of the points
            myTriangle1.setColor(Color.BLUE);
            myTriangle2.setColor(Color.YELLOW);
            myTriangle3.setColor(Color.RED);
            can.drawShape(myTriangle1);
            can.drawShape(myTriangle2);
            can.drawShape(myTriangle3);
            // Setting the color and drawing shapes
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos()- 0.5*myTriangle.getWidth(),myTriangle.getYPos(), Color.RED, can, level-1);
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos() +myTriangle.getWidth(), myTriangle.getYPos(), Color.GREEN, can, level-1);
            drawTriangleFractal(w_new, h_new, myTriangle.getXPos()+ 0.5*w_new, myTriangle.getYPos()-myTriangle.getHeight(), Color.BLACK, can, level-1);
            this.totalArea += myTriangle1.calculateArea();
            this.totalArea += myTriangle2.calculateArea();
            this.totalArea += myTriangle3.calculateArea();
            // Calculate the area for the given triangles
        }
    }
    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle myCircle = new Circle(x, y, radius);
        myCircle.setColor(c);
        // Base Case of Circle Fractal
        if(level == 0){
            can.drawShape(myCircle);
            this.totalArea = myCircle.getArea();
        } else{
            // Computing the calcuations needed to place the circles in the
            // correct place
            double R = myCircle.getRadius();
            double r = R*Math.sqrt(6)/(2+Math.sqrt(6));
            double b = r/Math.sqrt(6);
            double a = b*Math.sqrt(6);
            Circle myCircle1 = new Circle(myCircle.getDiameter() - a, myCircle.getCircumference() + b, r);
            Circle myCircle2 = new Circle(myCircle.getDiameter() + a, myCircle.getCircumference() + b, r);
            Circle myCircle3 = new Circle(myCircle.getDiameter() -a, myCircle.getCircumference() - b, r);
            // Creating 3 circles, so it can fully surround the circle
            // at all of the points
            myCircle1.setColor(Color.PINK);
            myCircle2.setColor(Color.RED);
            myCircle3.setColor(Color.BLACK);
            can.drawShape(myCircle1);
            can.drawShape(myCircle2);
            can.drawShape(myCircle3);
            // Setting the color, and drawing the shapes
            drawCircleFractal(r, myCircle.getDiameter() - a, myCircle.getCircumference() + b, Color.YELLOW, can, level-1);
            drawCircleFractal(r, myCircle.getDiameter() + a, myCircle.getCircumference() + b, Color.BLUE, can, level-1);
            drawCircleFractal(r, myCircle.getDiameter(), myCircle.getCircumference() - b, Color.GREEN, can, level-1);
            this.totalArea += myCircle1.getArea();
            this.totalArea += myCircle2.getArea();
            this.totalArea += myCircle3.getArea();
            //Get the area for all circles
        }
    }

    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle myRectangle = new Rectangle(x, y, width, height);
        myRectangle.setColor(c);
        // Base Case of Rectangle Function
        if(level == 0){
            this.totalArea = myRectangle.calculateArea();
        } else{
            double w_new = 0.5*myRectangle.getWidth();
            double h_new = 0.5*myRectangle.getHeight();
            double posX1 = myRectangle.getXPos() - w_new;
            double posX2 = myRectangle.getXPos() - w_new;
            double posX3 = myRectangle.getXPos() + myRectangle.getWidth();
            double posX4 = myRectangle.getXPos() + myRectangle.getWidth();
            double posY1 = myRectangle.getYPos() - h_new;
            double posY2 = myRectangle.getYPos() + myRectangle.getHeight();
            double posY3 = myRectangle.getYPos() - h_new;
            double posY4 = myRectangle.getYPos() + myRectangle.getHeight();
            // Creating 4 Rectangles since there is 4 sides
            Rectangle myRectangle1 = new Rectangle(posX1, posY1, w_new, h_new);
            Rectangle myRectangle2 = new Rectangle(posX2, posY2, w_new, h_new);
            Rectangle myRectangle3 = new Rectangle(posX3, posY3, w_new, h_new);
            Rectangle myRectangle4 = new Rectangle(posX4, posY4, w_new, h_new);
            myRectangle1.setColor(Color.BLUE);
            myRectangle2.setColor(Color.YELLOW);
            myRectangle3.setColor(Color.GREEN);
            myRectangle4.setColor(Color.BLACK);
            can.drawShape(myRectangle1);
            can.drawShape(myRectangle2);
            can.drawShape(myRectangle3);
            can.drawShape(myRectangle4);
            //Set the color and draw the shape
            drawRectangleFractal(w_new, h_new, posX1, posY1, Color.BLACK, can, level-1);
            drawRectangleFractal(w_new, h_new, posX2, posY2, Color.BLUE, can, level-1);
            drawRectangleFractal(w_new, h_new, posX3, posY3, Color.RED, can, level-1);
            drawRectangleFractal(w_new, h_new, posX4, posY4, Color.YELLOW, can, level-1);
            this.totalArea += myRectangle1.calculateArea();
            this.totalArea += myRectangle2.calculateArea();
            this.totalArea += myRectangle3.calculateArea();
            this.totalArea += myRectangle4.calculateArea();
            // Calculate the Area needed
        }

    }
    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal
    // should print area of fractal as well
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please input your choice from circle, rectangle and triangle: ");
        String type = myScanner.nextLine();
        FractalDrawer fractalDrawer = new FractalDrawer();
        double result = fractalDrawer.drawFractal(type);
        System.out.println("For this shape, the total area is: " + result);
        myScanner.close();
    }
}

