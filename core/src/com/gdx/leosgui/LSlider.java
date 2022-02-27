package com.gdx.leosgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LSlider {

	boolean valueText = true;
	
	int x, y, width, height;
	int sliderX, sliderY, sliderWidth, sliderHeight;
	int leftSide, rightSide, top, bottom;
	
	int value;
	float mouseValue;
	
	Color color, fontColor;
	
	ShapeType shapetype;
	
	BitmapFont font;
	int DEFAULT_FONT_SIZE = 1;
	
	public LSlider(int x, int y, int width, int height, Color color, ShapeType shapetype) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.leftSide = x;
		this.rightSide = x + width;
		this.top = y + height; //query?
		this.bottom = y; //query?
		
		this.sliderX = x;
		this.sliderY = y;
		this.sliderWidth = 10;
		this.sliderHeight = height;
		
		this.color = color;
		
		this.shapetype = shapetype;
		
		this.font = new BitmapFont();
		this.font.getData().setScale(DEFAULT_FONT_SIZE);
		this.font.setColor(Color.BLACK);
	}
	
	public void draw(ShapeRenderer sr, Batch batch) {
		// Mouse pos?
		boolean M1 = Gdx.input.isButtonPressed(Buttons.LEFT);
		float mouseX = Gdx.input.getX();
		float mouseY = 720 - Gdx.input.getY();
		
		if((mouseX >= leftSide & mouseX <= rightSide) & (mouseY <= top & mouseY >= bottom) & M1) {
			mouseValue = mouseX - this.leftSide;
			sliderX = (int) (mouseValue - (sliderWidth/2) + this.leftSide);
			sliderY = y;
			sliderHeight = height;
			
			}
		
		sr.begin(this.shapetype);
		sr.setColor(this.color);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.BLACK);
		sr.rect(sliderX, sliderY, sliderWidth, sliderHeight);
		sr.end();
		
		if(valueText) {
			GlyphLayout layout = new GlyphLayout(font, String.valueOf(value));
			float fontX = rightSide + 7;
			float fontY = y + (height + layout.height) / 2;
			
			batch.begin();
			font.draw(batch, layout, fontX, fontY);
			batch.end();
		}
		
		value = (int) (((mouseValue) / width) * 100);
		
	}
	
	public void enableValueText() {
		this.valueText = true;
	}
	
	public void disableValueText() {
		this.valueText = false;
	}
	
	public int getValue() {
		return value;
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
