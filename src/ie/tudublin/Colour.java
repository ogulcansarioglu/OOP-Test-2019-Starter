package ie.tudublin;

import processing.data.TableRow;

public class Colour {
    
    private String colour;
    public int r, g, b;
    private int value;

    @Override
    public String toString() {
        return "Colour [b=" + b + ", colour=" + colour + ", g=" + g + ", r=" + r + ", value=" + value + "]";
    }

    public Colour(TableRow row) 
    {
        colour = row.getString("colour");
        r = row.getInt("r");
        g= row.getInt("g");
        b = row.getInt("b");
        value = row.getInt("value");

    }

    public Colour(String colour, int r, int g, int b, int value) {
        this.colour = colour;
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getG() {
        return g;
    }
    public void setG(int g) {
        this.g = g;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
