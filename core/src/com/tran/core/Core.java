package com.tran.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Core extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	
	
	private VecEntity entity;
	private ProjectionVisual proj;
	
	@Override
	public void create () {
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.zoom = 2f;
		camera.translate(-Gdx.graphics.getWidth() / 2, -Gdx.graphics.getHeight() / 2);
		
		batch = new SpriteBatch();
		
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
		
		
		
		proj = new ProjectionVisual(500, 300, -400, 200);
		entity = new VecEntity(300, 200);
		
	}

	@Override
	public void render () {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		shapeRenderer.setProjectionMatrix(camera.combined);
		
		
		
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		
		batch.begin();
		
		batch.end();
		
		
		
		shapeRenderer.begin();
		
		
		
		//draws axis
		shapeRenderer.setColor(0.25f, 0.30f, 0.30f, 0.15f);
		shapeRenderer.line(0, 5000, 0, -5000);
		shapeRenderer.setColor(0.30f, 0.25f, 0.30f, 0.15f);
		shapeRenderer.line(-5000, 0, 5000, 0);
		
		
		
		
		//proj.render(shapeRenderer);
		entity.render(shapeRenderer);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
