package es.uniovi.asw.recuento;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class CountingExecutor {

	private final static long TIME = 5 * 1000;

	private static Map<CountSystem, Timer> timers = new ConcurrentHashMap<>();

	public static void register(CountSystem countSystem) {
		if (!timers.containsKey(countSystem)) {
			Timer timer = new Timer();
			timer.schedule(new CountTask(countSystem), 1, TIME);
		}
	}

	public static void unregister(CountSystem countSystem) {
		Timer timer = timers.get(countSystem);

		if (timer != null) {
			timer.cancel();
		}
	}
	
	public static void stopAll() {
		for (Timer timer : timers.values()) {
			timer.cancel();
		}
	}

	private static class CountTask extends TimerTask {
		private CountSystem countSystem;

		public CountTask(CountSystem countSystem) {
			this.countSystem = countSystem;
		}

		public void run() {
			countSystem.calcular();
		}
	}

}
