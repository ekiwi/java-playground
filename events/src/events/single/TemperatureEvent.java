package events.single;

public class TemperatureEvent extends Event {
	public float temperture;
	public TemperatureEvent(float temperature) {
		this.temperture = temperature;
	}
}
