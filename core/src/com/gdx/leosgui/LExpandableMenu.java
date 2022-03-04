package com.gdx.leosgui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LExpandableMenu {
	
	int x, y, width, height;
	int originalWidth;
	int leftSide, rightSide, top, bottom;
	int tabX, tabY, tabWidth, tabHeight;
	int tabLeftSide, tabRightSide, tabTop, tabBottom;
	Color backgroundColor, tabColor;
	
	boolean moving = false;
	boolean expanded = true;
	
	ArrayList<Object> elementList = new ArrayList<>();

	public LExpandableMenu(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.originalWidth = width;
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
	
	public void move() {
		if(expanded) {
			if(width > 0) {
				width -= 1;
				tabX = x + width;
				tabY = y + height - tabHeight;
				tabLeftSide = tabX;
				tabRightSide = tabX + tabWidth;
				tabTop = tabY;
				tabBottom = tabY + tabHeight;
			}
			else {
				expanded = false;
				moving = false;
			}
		}
		else {
			if(width < originalWidth) {
				width += 1;
				tabX = x + width;
				tabY = y + height - tabHeight;
				tabLeftSide = tabX;
				tabRightSide = tabX + tabWidth;
				tabTop = tabY;
				tabBottom = tabY + tabHeight;
			}
			else {
				expanded = true;
				moving = false;
			}
		}
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
		
		if(moving) {
			move();
		}
				
		sr.begin(ShapeType.Filled);
		sr.setColor(backgroundColor);
		sr.rect(x, y, width, height);
		sr.end();
		
		sr.begin(ShapeType.Filled);
		sr.setColor(tabColor);
		sr.rect(tabX, tabY, tabWidth, tabHeight);
		sr.end();
		
		for(Object element: elementList) {
			if(element instanceof LToggleSwitch) {
				((LToggleSwitch) element).draw(sr, batch);
			}
		}
		
	}
	
	public void addElements(ArrayList<Object> elements) {
		for(Object element: elements) {
			if(element instanceof LToggleSwitch) {
				System.out.println("element");
			}
		}
		
	}
	
	public void addElement(Object element, int priority) {
		if(element instanceof LToggleSwitch) {
			((LToggleSwitch) element).setPriority(priority);}
		if(element instanceof LButton) {
			((LButton) element).setPriority(priority);}
		if(element instanceof LSlider) {
			((LSlider) element).setPriority(priority);}
		elementList.add(element);
		
		updateElementPosition();
	}
	
	//Sorting algorithm
	public void updateElementPosition() {
		int previousElementPriority = 0;
		int listLength = elementList.size();
		for(Object obj: elementList) {
			if(obj instanceof LToggleSwitch) {
				LToggleSwitch element = (LToggleSwitch) (obj);
				int currentElementPriority = element.getPriority();
			while(currentElementPriority > previousElementPriority) {
				
			}
			}
		}
	}
	
}
