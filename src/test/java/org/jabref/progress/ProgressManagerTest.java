package org.jabref.progress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgressManagerTest {

    @Test
    public void testSetAndGetProgress() {
        ProgressManager manager = new ProgressManager();
        manager.setProgress("article1", 50);
        assertEquals(50, manager.getProgress("article1"));
    }

    @Test
    public void testDefaultProgressIsZero() {
        ProgressManager manager = new ProgressManager();
        assertEquals(0, manager.getProgress("unknown"));
    }

    @Test
    public void testResetProgress() {
        ProgressManager manager = new ProgressManager();
        manager.setProgress("article2", 80);
        manager.resetProgress("article2");
        assertEquals(0, manager.getProgress("article2"));
    }

    @Test
    public void testInvalidProgressThrowsException() {
        ProgressManager manager = new ProgressManager();
        assertThrows(IllegalArgumentException.class, () -> {
            manager.setProgress("article3", 120);
        });
    }
}

