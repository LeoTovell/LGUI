package com.gdx.leosgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class LButton {
	
	int DEFAULT_FONT_SIZE = 1;
	String text, defaultText, hoverText, clickedText;
	int x, y, width, height;
	int leftSide, rightSide, top, bottom;
	
	ShapeType shapetype;
	BitmapFont font;
	Color color, fontColor, colorHover, defaultColor, clickedColor;
	
	
	public LButton(String text, int x, int y, int width, int height, Color color, ShapeType shapetype) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.defaultColor = color;
		this.shapetype = shapetype;
		this.colorHover = Color.GRAY;
		this.clickedColor = Color.BROWN;
		
		this.leftSide = x;
		this.rightSide = x + width;
		this.top = y + height; //query?
		this.bottom = y; //query?

		this.font = new BitmapFont();
		this.font.getData().setScale(DEFAULT_FONT_SIZE);
		this.font.setColor(Color.BLACK);	
	}
	
	public void draw(ShapeRenderer sr, Batch batch) {
		// Mouse pos?
		boolean clicked = false;
		boolean hover = false;
		boolean M1 = Gdx.input.isButtonPressed(Buttons.LEFT);
		float mouseX = Gdx.input.getX();
		float mouseY = 720 - Gdx.input.getY();
		
		if((mouseX >= leftSide & mouseX <= rightSide) & (mouseY <= top & mouseY >= bottom)) {
			if(M1) {
				clicked = true;
			}
			else {
				hover = true;
			}
		}
		
		// Execute
		
		if(clicked) {
			this.color = this.clickedColor;
			this.text = this.clickedText;
		}
		else if(hover) {
			this.color = this.colorHover;
			this.text = this.hoverText;
		}
		else {
			this.color = this.defaultColor;
			this.text = this.defaultText;
		}
		
		// Draw button box
		sr.begin(this.shapetype);
		sr.setColor(this.color);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
		
		// Draw button text
		
		GlyphLayout layout = new GlyphLayout(font, text);
		float fontX = x + (width - layout.width) / 2;
		float fontY = y + (height + layout.height) / 2;
		
		batch.begin();
		font.draw(batch, layout, fontX, fontY);
		batch.end();
	}
	
	public void setFont(String filepath, Color color) {
		try {
			this.fontColor = color;
								
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	public void setColor(Color color) {
		this.color = color;		
	}
	
	public void setHoverColor(Color color) {
		this.colorHover = color;
	}
	
	public void setDefaultText(String text){
		this.defaultText = text;
	}
	
	public void setHoverText(String text){
		this.hoverText = text;
	}
	
	public void setClickedText(String text){
		this.clickedText = text;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;		
	}
	
}
