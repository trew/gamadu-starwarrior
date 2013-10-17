package com.gamadu.starwarrior.spatials;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.gamadu.starwarrior.components.Expires;
import com.gamadu.starwarrior.components.Transform;

public class Explosion extends Spatial {
	private Transform transform;
	private Expires expires;
	private float initialLifeTime;
	private Color color;
	private int radius;

	public Explosion(World world, Entity owner, int radius) {
		super(world, owner);
		this.radius = radius; 
	}

	@Override
	public void initalize() {
		ComponentMapper<Transform> transformMapper = world.getMapper(Transform.class);
		transform = transformMapper.get(owner);
		
		ComponentMapper<Expires> expiresMapper = world.getMapper(Expires.class);
		expires = expiresMapper.get(owner);
		initialLifeTime = expires.getLifeTime();
		
		color = new Color(Color.yellow);
	}

	@Override
	public void render(Graphics g) {
		
		color.a = expires.getLifeTime()/initialLifeTime;
		
		g.setColor(color);
		g.setAntiAlias(true);
		g.fillOval(transform.getX() - radius, transform.getY() - radius, radius*2, radius*2);
	}

}
