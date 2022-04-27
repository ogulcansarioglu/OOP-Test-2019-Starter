package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
import processing.core.PApplet;

public class resistor {

    int value, ones, tens, hundreds;

    UI ui;
    Colour hc;
    Colour tc;
    Colour oc;

    

    public resistor(UI ui, int resistance) {
        this.ui = ui;
        this.value = resistance;
        int hundreds = (resistance / 100);
        int tens = (resistance - (hundreds * 100)) / 10;
        int ones = resistance - ((hundreds * 100)  + (tens * 10));
        hc = ui.findColor(hundreds);
        tc = ui.findColor(tens);
        oc = ui.findColor(ones);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getTens() {
        return tens;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public void Render(float x, float y) 
    {
        ui.pushMatrix();
        ui.translate(x, y);
        ui.stroke(0);
        ui.line(-100, 0, -50, 0);
        ui.line(-50, 0, -50, -50);
        ui.line(-50, -50, 50, -50);
        
        ui.line(50, -50, 50, 0);
        ui.line(50, 0, 100, 0);
        ui.line(50, 0, 50, 50);
        ui.line(50, 50, -50, 50);
        ui.line(-50, 50, -50, 0);

        // Draw the color bars
        ui.noStroke();
        ui.fill(hc.r, hc.g, hc.b);
        ui.rect(-40, -49, 10, 99);
        
        ui.fill(tc.r, tc.g, tc.b);
        ui.rect(-20, -49, 10, 99);
        
        ui.fill(oc.r, oc.g, oc.b);
        ui.rect(0, -49, 10, 99);
        ui.fill(0);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.textSize(30);
        ui.text(value, 200, 0);
        ui.popMatrix();
    }
    
    
}
