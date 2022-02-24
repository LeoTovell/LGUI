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
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		
		LButton button = new LButton("Hover to change colour",100, 100, 200, 50, Color.RED, ShapeType.Filled);
		button.setClickedText("Clicked");
		button.setDefaultText("Default");
		button.setHoverText("Hover");
		buttonList.add(button);
		button = new LButton("Hover to change colour",100, 100, 200, 50, Color.RED, ShapeType.Filled);
		
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.WHITE);
		
		for(LButton button: buttonList) {
			button.setFont("AmaticSC-Regular.ttf", Color.GREEN);
			button.draw(sr, batch);
		}
		

	}
	
}
