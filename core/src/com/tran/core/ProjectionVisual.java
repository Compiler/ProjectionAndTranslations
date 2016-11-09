package com.tran.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class ProjectionVisual {

	private Vector2 one, two, projection;
	private boolean start;

	/**
	 * Projects vec2(x1, y1) onto vec2(x2, y2)
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public ProjectionVisual(float x1, float y1, float x2, float y2) {

		one = new Vector2(x1, y1);
		two = new Vector2(x2, y2);

		float projTop = one.x * two.x + one.y * two.y;

		float projBottom = two.x * two.x + two.y * two.y;
		// projBottom = projBottom < 0 ? projBottom * -1 : projBottom;

		float division = projTop / projBottom;

		projection = new Vector2(division * one.x, division * one.y);
		//projection.x = -280;
		//projection.y = -140;
		
	}

	float speed = 0.0f;

	public void project() {
			speed += 1 * Gdx.graphics.getDeltaTime();
			if(one.x >= projection.x + 5 || one.x <= projection.x - 5) {
				if(one.x < projection.x) {
					one.x += speed;
				} else
					one.x -= speed;
			}
			if(one.y >= projection.y + 5 || one.y <= projection.y - 5) {
				if(one.y < projection.y) {
					one.y += speed;
				} else
					one.y -= speed;
			}
	}

	public void render(ShapeRenderer render) {
		if(Gdx.input.isKeyJustPressed(Keys.SPACE))
			start = true;
		if(start)
			project();
		
		System.out.println(one.x + ", " + one.y);
		render.setColor(1f, 0.f, 0.0f, 10.5f);
		render.line(0, 0, two.x, 0);
		render.setColor(.0f, 1.0f, 0.f, 0.2f);
		render.line(two.x, 0, two.x, two.y);
		
		render.setColor(1.0f, 1.0f, 0.0f, 0.2f);
		render.line(0, 0, two.x, two.y);
		
		render.setColor(1f, 0.0f, 0.0f, 10.5f);
		render.line(0, 0, one.x, 0);
		render.setColor(.0f, 1.0f, 0.0f, 0.2f);
		render.line(one.x, 0, one.x, one.y);
		
		render.setColor(1.0f, 1.0f, 1.0f, 0.2f);
		render.line(0, 0, one.x, one.y);


	}

}
