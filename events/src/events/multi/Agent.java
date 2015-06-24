package events.multi;

public class Agent {
	private String name;
	private Node node;
	private TemperatureMonitor temperatureMonitor = new TemperatureMonitor();
	private TimeoutMonitor timeoutMonitor = new TimeoutMonitor();
	
	public Agent(String name, Node node) {
		this.name = name;
		this.node = node;
		this.node.registerTemperature(this.temperatureMonitor);
		this.node.registerTimeout(this.timeoutMonitor, 1000);
		this.node.registerTimeout(this.timeoutMonitor, 2000);
	}
	
	private class TemperatureMonitor implements TemperatureEventHandler {
		@Override
		public void onNewTemperaturValue(float temperature) {
			System.out.println(Agent.this.name + ": Temperature is now " + temperature + " degrees.");
		}
		
	}
	
	private class TimeoutMonitor implements TimeoutEventHandler {
		@Override
		public void onTimeout(int deltaTimeMs) {
			System.out.println(Agent.this.name + ": Timeout called after " + deltaTimeMs + " ms.");
		}
		
	}

}
