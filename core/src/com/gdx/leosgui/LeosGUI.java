package com.gdx.leosgui;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

public class LeosGUI extends ApplicationAdapter {
	
	SpriteBatch batch;
	ShapeRenderer sr;
	LButton button;
	ArrayList<LButton> buttonList = new ArrayList<>();
	ArrayList<LSlider> sliderList = new ArrayList<>();
	ArrayList<LToggleSwitch> toggleList = new ArrayList<>();
	ArrayList<LExpandableMenu> menuList = new ArrayList<>();
	
	public static void myFunction(String text) {
		System.out.println(text);
	}
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();	
		sr = new ShapeRenderer();
		
		LButton button = new LButton("Button 1", 100, 100, 200, 50, Color.RED, ShapeType.Filled);
		buttonList.add(button);
		
		button = new LButton("Button 2",400, 400, 300, 50, Color.PURPLE, ShapeType.Filled);
		button.setHoverColor(Color.CHARTREUSE);
		button.setClickedColor(Color.VIOLET);
		buttonList.add(button);
		
		LSlider slider = new LSlider(300, 500, 200, 20, Color.BLUE, ShapeType.Filled);
		sliderList.add(slider);
		
		LToggleSwitch toggle = new LToggleSwitch(200,300,75,Color.BLACK);
		toggleList.add(toggle);
		
		toggle = new LToggleSwitch(200, 300, 75, Color.WHITE);
		LExpandableMenu menu = new LExpandableMenu(0,0,100,300,Color.BLACK);
		ArrayList<Object> menuElements = new ArrayList<>();
		
		menu.addElement(toggle, 5);
		menuList.add(menu);
		
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.WHITE);
		
		for(LButton button: buttonList) {
			button.draw(sr, batch);
			if(button.isClicked()) {
				//myFunction(button.defaultText);
			}
		}
		for(LSlider slider: sliderList) {
			slider.draw(sr, batch);
			if(slider.getValue() % 10 == 0) {
				//System.out.println(slider.getValue());
			}
		}
		for(LToggleSwitch toggle: toggleList) {
			toggle.draw(sr, batch);
				//System.out.println("Toggle is set to %s".formatted(toggle.getStatus()));
			
		}
		for(LExpandableMenu menu: menuList) {
			menu.draw(sr, batch);
		}
		
	}
	
}
