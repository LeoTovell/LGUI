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
	
	public static void print(String text) {
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
		button.onclick(print("hey"));
		buttonList.add(button);
		LSlider slider = new LSlider(300, 500, 200, 20, Color.BLUE, ShapeType.Filled);
		sliderList.add(slider);
		LToggleSwitch toggle = new LToggleSwitch(200,300,75,Color.BLACK);
		toggleList.add(toggle);
		
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.WHITE);
		
		for(LButton button: buttonList) {
			button.draw(sr, batch);
		}
		for(LSlider slider: sliderList) {
			slider.draw(sr, batch);
		}
		for(LToggleSwitch toggle: toggleList) {
			toggle.draw(sr, batch);
		}
		
	}
	
}
