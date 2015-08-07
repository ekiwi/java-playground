import java.util.ArrayList;

public class Main {

	static abstract class Event {
	}

	static class MouseEvent extends Event {
		public int x;
		public int y;
		public MouseEvent(int x, int y) { this.x = x; this.y = y; }
	}

	static class KeyboardEvent extends Event {
		public char key;
		public KeyboardEvent(char key) { this.key = key; }
	}

	static interface EventHandler {
		public void handle(Event e);
	}

	static class MyEventHandler implements EventHandler {
		public void handle(Event e) {
			System.out.println("MyEventHandler::handle Event");
		}

		public void handle(KeyboardEvent e) {
			System.out.println("MyEventHandler::handle KeyboardEvent(" + e.key + ")");
		}

		public void handle(MouseEvent e) {
			System.out.println("MyEventHandler::handle MouseEvent(" + e.x + ", " + e.y + ")");
		}
	}


	static interface SpecificEventHandler {
		public void handle(KeyboardEvent e);
		public void handle(MouseEvent e);
	}
// the following does not compile!

//	static class GenericEventHandler implements SpecificEventHandler {
//		public void handle(Event e) {
//			System.out.println("GenericEventHandler::handle Event");
//		}
//	}

	public static void main(String[] args)
	{
		System.out.println("Polymorphic Method Overloading");

		{
		System.out.println("1. --------------------------");
		System.out.println("We have a simple MyEventHandler instance.");
		System.out.println("Overloaded Methods: yes");
		System.out.println("Polymorphism: yes");
		System.out.println("Virtual Method Calls: no");
		MyEventHandler handler = new MyEventHandler();
		System.out.println("MouseEvent");
		handler.handle(new MouseEvent(100,200));
		System.out.println("KeyboardEvent");
		handler.handle(new KeyboardEvent('a'));
		Event alsoAMouseEvent = new MouseEvent(100,200);
		System.out.println("MouseEvent casted to Event");
		handler.handle(alsoAMouseEvent);
		}

		{
		System.out.println("1. --------------------------");
		System.out.println("We have a MyEventHandler instance that was upcasted to EventHandler.");
		System.out.println("Overloaded Methods: yes");
		System.out.println("Polymorphism: yes");
		System.out.println("Virtual Method Calls: yes");
		EventHandler handler = new MyEventHandler();
		System.out.println("MouseEvent");
		handler.handle(new MouseEvent(100,200));
		System.out.println("KeyboardEvent");
		handler.handle(new KeyboardEvent('a'));
		Event alsoAMouseEvent = new MouseEvent(100,200);
		System.out.println("MouseEvent casted to Event");
		handler.handle(alsoAMouseEvent);
		}

	}
}
