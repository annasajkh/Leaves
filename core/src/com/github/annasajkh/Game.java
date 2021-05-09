package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Game extends ApplicationAdapter
{

	ShapeRenderer shapeRenderer;
	float x, y;

	public void drawPoint()
	{
		float px = MathUtils.map(-2.1820f, 2.6558f, 0, Gdx.graphics.getWidth(), x);
		float py = MathUtils.map(0, 9.9983f, Gdx.graphics.getHeight(), 0, y);
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.point(px, py, 0);
	}

	void nextPoint()
	{
		float nextX, nextY;
		float r = MathUtils.random();

		if(r < 0.01f)
		{
			nextX = 0;
			nextY = 0.16f * y;
		} 
		else if(r < 0.86f)
		{
			nextX = 0.85f * x + 0.04f * y;
			nextY = -0.04f * x + 0.85f * y + 1.6f;
		} 
		else if(r < 0.93f)
		{
			nextX = 0.20f * x - 0.26f * y;
			nextY = 0.23f * x + 0.22f * y + 1.6f;
		} 
		else
		{
			nextX = -0.15f * x + 0.28f * y;
			nextY = 0.26f * x + 0.24f * y + 0.44f;
		}

		x = nextX;
		y = nextY;
	}

	@Override
	public void create()
	{
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		shapeRenderer.begin(ShapeType.Point);
		for(int i = 0; i < 150_000; i++)
		{
			drawPoint();
			nextPoint();
		}
		shapeRenderer.end();
	}

	@Override
	public void dispose()
	{
		shapeRenderer.dispose();
	}
}
