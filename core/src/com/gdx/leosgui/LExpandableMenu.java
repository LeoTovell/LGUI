package com.gdx.leosgui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LExpandableMenu {
	
	int x, y, width, height;
	int leftSide, rightSide, top, bottom;
	int tabX, tabY, tabWidth, tabHeight;
	int tabLeftSide, tabRightSide, tabTop, tabBottom;
	Color backgroundColor, tabColor;
	
	boolean moving = false;

	public LExpandableMenu(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.leftSide = x;
		this.rightSide = x + width;
		this.top = y + height;
		this.bottom = y;

		this.tabHeight = height/10;
		this.tabX = x + width;
		this.tabY = y + height - tabHeight;
		this.tabWidth = width/5;
		this.tabLeftSide = tabX;
		this.tabRightSide = tabX + tabWidth;
		this.tabTop = tabY;
		this.tabBottom = tabY + tabHeight;
		
		this.backgroundColor = color;
		this.tabColor = color;
	}
	
	public void draw(ShapeRenderer sr, Batch batch) {
		
		if(!moving) {//Check tab clicked?
			float mouseX = Gdx.input.getX();
			float mouseY = 720 - Gdx.input.getY();
			boolean M1 = Gdx.input.isButtonPressed(Buttons.LEFT);
						
			if((mouseX >= tabLeftSide & mouseX <= tabRightSide) & (mouseY >= tabTop & mouseY <= tabBottom)) {
				if(M1) {
					tabColor = backgroundColor;
					moving = true;
				}
				else {
					tabColor = Color.GRAY;
				}
			}
			else {
				tabColor = backgroundColor;
			}
		}
				
		sr.begin(ShapeType.Filled);
		sr.setColor(backgroundColor);
		sr.rect(x, y, width, height);
		sr.end();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(tabColor);
		sr.rect(tabX, tabY, tabWidth, tabHeight);
		sr.end();
		
	}
	
}
