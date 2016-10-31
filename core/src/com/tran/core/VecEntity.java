package com.tran.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;

public class VecEntity {

	private Vector2 pos;
	private float[][] mat2 = { { -1.0f, 0.0f }, { 0.0f, -2.0f } };

	public VecEntity(float x, float y) {

		pos = new Vector2(x, y);

	}

	boolean go;
	float newX = 0;
	float newY = 0;
	float speed = 0;

	public void render(ShapeRenderer render) {
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			go = true;
			newX = mat2[0][0] * pos.x + mat2[1][0] * pos.y;
			newY = mat2[0][1] * pos.x + mat2[1][1] * pos.y;
		}

		if(go) {
			speed += 10 * Gdx.graphics.getDeltaTime();
			if(pos.x >= newX + 5 || pos.x <= newX - 5) {
				if(pos.x < newX) {
					pos.x += speed;
				} else
					pos.x -= speed;
			} else {

			}
			if(pos.y >= newY + 5 || pos.y <= newY - 5) {
				if(pos.y < newY) {
					pos.y += speed;
				} else
					pos.y -= speed;
			} else {

			}
		}

		render.setColor(0.0f, 1.0f, 0.0f, 1.0f);
		render.line(Vector2.Zero.x, Vector2.Zero.y, pos.x, 0.0f);

		render.setColor(1.0f, 0.0f, 0.0f, 1.0f);
		render.line(pos.x, Vector2.Zero.y, pos.x, pos.y);

		render.setColor(0.0f, 1.0f, 1.0f, 1.0f);
		render.line(Vector2.Zero, pos);

	}

}
