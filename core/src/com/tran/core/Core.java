package com.tran.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;

public class Core extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Matrix4 mat;
	ShapeRenderer shapeRenderer;
	@Override
	public void create () {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.zoom = 2f;
		camera.translate(-Gdx.graphics.getWidth() / 2, -Gdx.graphics.getHeight() / 2);
		
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		mat = new Matrix4(new float[]{
				-1f, 0.0f, 0.0f, .0f,
				.0f, -1.0f, 0.0f, .0f,
				.0f, 0.0f, 1.0f, .0f,
				.0f, 0.0f, 0.0f, 1.0f,
				
		});
		
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 100, 100);
		batch.end();
		
		
		
		//draws axis
		shapeRenderer.begin();
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.line(0, 5000, 0, -5000);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.line(-5000, 0, 5000, 0);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
