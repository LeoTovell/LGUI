package com.gdx.leosgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LSlider {

	boolean valueText = true;
	
	int x, y, width, height;
	int leftSide, rightSide, top, bottom;
	
	Color color, fontColor;
	
	ShapeType shapetype;
	
	public LSlider(int x, int y, int width, int height, Color color, ShapeType shapetype) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.leftSide = x;
		this.rightSide = x + width;
		this.top = y + height; //query?
		this.bottom = y; //query?
		
		this.color = color;
		
		this.shapetype = shapetype;
	}
	
	public void draw(ShapeRenderer sr, Batch batch) {
		// Mouse pos?
		boolean clicked = false;
		boolean M1 = Gdx.input.isButtonPressed(Buttons.LEFT);
		float mouseX = Gdx.input.getX();
		float mouseY = 720 - Gdx.input.getY();
		
		if((mouseX >= leftSide & mouseX <= rightSide) & (mouseY <= top & mouseY >= bottom) & M1) {
			float mouseValue = mouseX - this.leftSide;
			System.out.println(mouseValue);
			}
		
		sr.begin(this.shapetype);
		sr.setColor(this.color);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
		
	}
	
	public void enableValueText() {
		this.valueText = true;
	}
	
	public void disableValueText() {
		this.valueText = false;
	}
	
	public void valueTextPosition(String pos) {
		pos = pos.toLowerCase();
		if(pos.equals("left")) {
			// Move to left
		}
		if(pos.equals("right")) {
			//Move to right
		}
		if(pos.equals("above")) {
			//Move above
		}
		if(pos.equals("below")) {
			//Move below
		}
	}
}
