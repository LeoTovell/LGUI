package com.gdx.leosgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class LButton {
	
	int DEFAULT_FONT_SIZE = 1;
	String text;
	int x, y, width, height;
	Color color;
	ShapeType shapetype;
	BitmapFont font;
	Color fontColor;
	
	
	public LButton(String text, int x, int y, int width, int height, Color color, ShapeType shapetype) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.shapetype = shapetype;

		this.font = new BitmapFont();
		this.font.getData().setScale(DEFAULT_FONT_SIZE);
		this.font.setColor(Color.BLACK);	
	}
	
	public void draw(ShapeRenderer sr, Batch batch) {
		// Draw button box
		sr.begin(this.shapetype);
		sr.setColor(this.color);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
		
		// Draw button text
		batch.begin();
		this.font.draw(batch, text, x + width/2 - font.getData().spaceXadvance*3, y+height-font.getData().xHeight*2);
		batch.end();
	}
	
	public void setFont(String filepath, Color color) {
		try {
			System.out.println("Start");
			
			this.fontColor = color;
								
		}
		catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	public void setColor(Color color) {
		this.color = color;		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;		
	}
	
}
