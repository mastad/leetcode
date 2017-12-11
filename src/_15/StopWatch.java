package _15;

/**
 * Created by reiserx on 2017/12/10.
 * 计时器
 */
public class StopWatch {

    private final long start;

    StopWatch() {
        start = System.currentTimeMillis();
    }

    public void elapsedTime() {
        long now = System.currentTimeMillis();
        System.out.println((now - start) / 1000.00 + "s");
    }
}
