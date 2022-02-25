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
	ArrayList<LButton> elementList = new ArrayList<>();
	ArrayList<LSlider> sliderList = new ArrayList<>();
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		
		LButton button = new LButton("Button 1", 100, 100, 200, 50, Color.RED, ShapeType.Filled);
		elementList.add(button);
		button = new LButton("Button 2",400, 400, 300, 50, Color.PURPLE, ShapeType.Filled);
		button.setHoverColor(Color.CHARTREUSE);
		button.setClickedColor(Color.VIOLET);
		elementList.add(button);
		LSlider slider = new LSlider(300, 500, 200, 20, Color.BLUE, ShapeType.Filled);
		sliderList.add(slider);
		
		
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.WHITE);
		
		for(LButton button: elementList) {
			button.draw(sr, batch);
		}
		for(LSlider slider: sliderList) {
			slider.draw(sr, batch);
		}
		

	}
	
}
