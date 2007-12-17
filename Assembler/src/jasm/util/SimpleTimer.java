package jasm.util;

import java.util.HashMap;
import java.util.Map;

public final class SimpleTimer {
  private final Map<String, Long> _flatTimes = new HashMap<String, Long>();

  private String _current;
  private long _start;

  public void start(final String id) {
    _current = id;
    _start = System.currentTimeMillis();
  }

  public void stop() {
    final long time = System.currentTimeMillis() - _start;
    final Long flatTime = _flatTimes.get(_current);
    if (flatTime == null) {
      _flatTimes.put(_current, time);
    } else {
      _flatTimes.put(_current, flatTime);
    }
  }

  /**
   * Gets an iterator over the collected flat times.
   *
   * @return an iterator over the collected flat times
   */
  public Iterable<Map.Entry<String, Long>> flatTimes() {
    return _flatTimes.entrySet();
  }

  /**
   * Resets all the data gathered by the timer.
   *
   * @throws IllegalStateException if there is an execution currently being timed
   */
  public void reset() {
    _flatTimes.clear();
  }
}

