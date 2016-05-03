package es.uniovi.asw.VoteCounting.recuento.impl;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.VoteCounting.recuento.CountSystem;

@Component("BeanCountingExecutor")
@Scope("singleton")
public class CountingExecutor {

	private final static long TIME = 5 * 1000;

	private Map<CountSystem, Timer> timers = new ConcurrentHashMap<>();

	public void register(CountSystem countSystem) {
		if (!timers.containsKey(countSystem)) {
			Timer timer = new Timer();
			timer.schedule(new CountTask(countSystem), 1, TIME);
		}
	}

	public void unregister(CountSystem countSystem) {
		Timer timer = timers.get(countSystem);

		if (timer != null) {
			timer.cancel();
		}
	}
	
	public void stopAll() {
		for (Timer timer : timers.values()) {
			timer.cancel();
		}
	}

	private class CountTask extends TimerTask {
		private CountSystem countSystem;

		public CountTask(CountSystem countSystem) {
			this.countSystem = countSystem;
		}

		public void run() {
			countSystem.calcular();
		}
	}

}
