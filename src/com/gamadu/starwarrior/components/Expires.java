package com.gamadu.starwarrior.components;

import com.artemis.Component;

public class Expires extends Component {
	private float lifeTime;
	
	public Expires(float lifeTime) {
		this.lifeTime = lifeTime;
	}
	
	public float getLifeTime() {
		return lifeTime;
	}
	
	public void setLifeTime(float lifeTime) {
		this.lifeTime = lifeTime;
	}
	
	public void reduceLifeTime(float lifeTime) {
		this.lifeTime -= lifeTime;
	}
	
	public boolean isExpired() {
		return lifeTime <= 0;
	}

	

}
