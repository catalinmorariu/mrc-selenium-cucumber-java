package net.metrosystems.mrc.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class TestingStatus {
    private static final int LIMIT_OF_EXCEPTIONS_TO_STORE = 100;
    private volatile State state = State.NOT_STARTED;
    private volatile AtomicBoolean shouldBeInterrupted = new AtomicBoolean(false);
    private AtomicLong startedAt = new AtomicLong(-1);
    private AtomicLong finishedAt = new AtomicLong(-1);
    private volatile Set<String> setOfExceptionStackTraces = new HashSet<>();
    public enum State {
        NOT_STARTED,
        INTERRUPTED,
        IN_PROGRESS,
        DONE;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        if (state == State.IN_PROGRESS) {
            startedAt.set(System.currentTimeMillis());
        } else if (state == State.DONE) {
            finishedAt.set(System.currentTimeMillis());
        }
        this.state = state;
    }

    public void addException(Exception e) {
        if (setOfExceptionStackTraces.size() > LIMIT_OF_EXCEPTIONS_TO_STORE) {
            return;
        }
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        setOfExceptionStackTraces.add(sw.toString());
    }
}
