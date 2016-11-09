package com.tran.core;

import com.badlogic.gdx.math.Vector2;

public class ProjectionVisual {
	
	
	
	private Vector2 one, two, projection;
	public ProjectionVisual(float x1, float y1, float x2, float y2){
		
		one = new Vector2(x1, y1);
		two = new Vector2(x2, y2);
		
		
		float projTop = one.x * two.x + one.y * two.y;
		
		float projBottom = one.x * one.x + one.y * one.y;
		//projBottom = projBottom < 0 ? projBottom * -1 : projBottom;
		
		projection = new Vector2(projTop);
		
	}
	
	public void project(){
		
	}

}
