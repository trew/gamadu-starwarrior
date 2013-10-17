package com.gamadu.starwarrior.systems;

import java.util.Random;

import org.newdawn.slick.GameContainer;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.gamadu.starwarrior.EntityFactory;
import com.gamadu.starwarrior.components.Transform;
import com.gamadu.starwarrior.components.Weapon;

public class EnemySpawnSystem extends IntervalEntitySystem {

	private ComponentMapper<Weapon> weaponMapper;
	private long now;
	private ComponentMapper<Transform> transformMapper;
	private GameContainer container;
	private Random r;

	public EnemySpawnSystem(int interval, GameContainer container) {
		super(Aspect.getEmpty(), interval);
		this.container = container;
	}

	@Override
	public void initialize() {
		weaponMapper = world.getMapper(Weapon.class);
		transformMapper = world.getMapper(Transform.class);
		r = new Random();
	}
	
	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		EntityFactory.createEnemyShip(world, r.nextInt(container.getWidth()), -50, 0, 0.05f).addToWorld();
	}
	
}
