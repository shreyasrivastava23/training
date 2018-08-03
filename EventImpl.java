
public class EventImpl implements Event {

	public void doSomething() {
		System.out.println("First event implementation");
	}

	public static class InnerEventImpl implements Event {
		public void doSomething() {
			System.out.println("Second event implementation");
		}
	}

	public void doingSomething() {
		class InnerMostImpl implements Event {

			@Override
			public void doSomething() {

				System.out.println("Third event implementation");
			}

		}
		;
		new InnerMostImpl().doSomething();
	}

	public void doingSomethingAgain() {
		Event e = new Event() {
			public void doSomething() {

				System.out.println("fourth event implementation");
			}
		};
		e.doSomething();
	}

	public void doingSomethingOneLastTime() {
		Event e = () -> System.out.println("fifth event implementation");
		e.doSomething();
	}

	public static void main(String args[]) {
		EventImpl impl = new EventImpl();
		impl.doSomething();

		// InnerEventImpl innerImpl=impl.new InnerEventImpl();

		InnerEventImpl innerImpl = new EventImpl.InnerEventImpl();
		innerImpl.doSomething();

		impl.doingSomething();
		impl.doingSomethingAgain();
		impl.doingSomethingOneLastTime();

	}

}
