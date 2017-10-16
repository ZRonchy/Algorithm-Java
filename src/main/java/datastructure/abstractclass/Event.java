package datastructure.abstractclass;

import java.util.Vector;

public abstract class Event {
	protected int numLanes;
	@SuppressWarnings("rawtypes")
	protected Vector swimmers;
	
	public abstract Seeding getSeeding();
	public abstract boolean isPrelim();
	public abstract Seeding isFinal();
	public abstract Seeding isTimedFinal();
	
}
