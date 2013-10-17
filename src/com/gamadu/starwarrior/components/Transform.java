package com.gamadu.starwarrior.components;

import com.artemis.Component;

public class Transform extends Component {
	private float x;
	private float y;
	private float rotation;

	public Transform() {
	}

	public Transform(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Transform(float x, float y, float rotation) {
		this(x, y);
		this.rotation = rotation;
	}

	public void addX(float x) {
		this.x += x;
	}

	public void addY(float y) {
		this.y += y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void addRotation(float angle) {
		rotation = (rotation + angle) % 360;
	}

	public float getRotationAsRadians() {
		return (float) Math.toRadians(rotation);
	}
	
	public float getDistanceTo(Transform t) {
		final float x_d = t.getX() - this.x;
		final float y_d = t.getY() - this.y;
		return (float)Math.sqrt(x_d * x_d + y_d * y_d);
	}

}
