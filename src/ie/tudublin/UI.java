package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{	
	
	ArrayList<Colour> colours = new ArrayList<Colour>();
	
	ArrayList<resistor> resistors = new ArrayList<resistor>();

	public void loadColors() 
	{

		Table table = loadTable("colours.csv", "header");
		for (TableRow tr: table.rows()) {

			Colour colour = new Colour(tr);
			System.out.println(colour);
			colours.add(colour);

			
		}

	}

	public void loadResistors() {
		Table table = loadTable("resistors.csv");
		for (TableRow row: table.rows()) {

			resistors.add(new resistor(this, row.getInt(0)));
		}
	}

	private void printResistors()
	{
		for(resistor r:resistors)
		{
			int i = r.value;
			int hundreds = (i / 100);
			int tens = (i - (hundreds * 100)) / 10;
			int ones = i - ((hundreds * 100)  + (tens * 10));
			print(hundreds + ",");
			print(tens + ",");
			println(ones);			
		}
	}


	public void printColours() {

		for (Colour c: colours) {
			System.out.println(c);
		}
	}

	public Colour findColor(int num)
	{
		for(Colour c: colours)
		{
			if (c.getValue() == num)
			{
				return c;
			}			
		}
		return null;
	}
	
	
	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings()
	{
		size(500, 800);
		
		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() 
	{
		loadColors();
		printColours();
		loadResistors();
		printResistors();

	}
	
	int resistorId = 0;
	boolean lastPressed = false;
	public void draw()
	{			
		background(200);
		stroke(255);

		for(int i = 0 ; i < resistors.size() ; i ++)
		{
			float y = map(i, 0, resistors.size(), 100, height);
			resistors.get(i).Render(width / 2, y);
		}
		
	}
}
