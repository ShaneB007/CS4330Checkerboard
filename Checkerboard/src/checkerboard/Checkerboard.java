/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author bisho
 */
public class Checkerboard {
    
    private int numRows;
    private int numCols;
    
    private double anchorWidth;
    private double anchorHeight;
    
    private double rectWidth;
    private double rectHeight;
    
    private Color color1;
    private Color color2;
    
    private AnchorPane anchorPane = null;
    
    public Checkerboard(int numRows, int numCols, double anchorWidth, double anchorHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.anchorWidth = anchorWidth;
        this.anchorHeight = anchorHeight;
        color1 = Color.RED;
        color2 = Color.BLACK;
        
        rectWidth = anchorWidth/numCols;
        rectHeight = anchorHeight/numRows;
    }
    
    public Checkerboard(int numRows, int numCols, double anchorWidth, double anchorHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, anchorWidth, anchorHeight);
        this.color1 = lightColor;
        this.color2 = darkColor;
    }
    
    /* Builds board UI and returns AnchorPane as root object */
    public void build() {
        anchorPane = new AnchorPane();
        
        Color tempColor = color1;
        
        for ( int row = 0; row < numRows; row++ )
        {
            for( int col = 0; col < numCols; col++ )
            {
                if( (row % 2 == 1) && (col % 2 == 1) )
                {
                    tempColor = color1;
                }else if ( (row % 2 == 1) )
                {
                    tempColor = color2;
                }else if ( (row % 2 == 0) && (col % 2 == 0) )
                {
                    tempColor = color1;
                }else
                {
                    tempColor = color2;
                }
                
                Rectangle rect = new Rectangle(rectWidth, rectHeight, tempColor);
                rect.setX(rectWidth * col);
                rect.setY(rectHeight * row);
                
                anchorPane.getChildren().add(rect);
            }
        }
    }
    
    /* Returns the AnchorPane made by build() or null if one hasn't been built yet */
    public AnchorPane getBoard() {
        if(anchorPane == null) {
            return null;
        }
        return anchorPane;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return anchorWidth;
    }
    
    public double getHeight() {
        return anchorHeight;
    }
    
    public Color getLightColor() {
        return color1;
    }
    
    public Color getDarkColor() {
        return color2;
    }
    
    public double getRectangleWidth() {
        return rectWidth;
    }
    
    public double getRectangleHeight() {
        return rectHeight;
    }
}
