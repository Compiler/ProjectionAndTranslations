package com.tran.core;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class VecEntity {
	
	
	
	private Vector2 pos;
	
	public VecEntity(float x, float y){
		
		pos = new Vector2(x,y);
		
	}
	
	
	
	
	
	
	public void render(ShapeRenderer render){
		
		render.setColor(0.0f, 1.0f, 0.0f, 1.0f);
		render.line(Vector2.Zero.x, Vector2.Zero.y, pos.x, 0.0f);
		
		render.setColor(1.0f, 0.0f, 0.0f, 1.0f);
		render.line(Vector2.Zero.x, Vector2.Zero.y, 0.0f, pos.y);
		
		render.setColor(0.0f, 1.0f, 1.0f, 1.0f);
		render.line(Vector2.Zero, pos);
		
	}

}
