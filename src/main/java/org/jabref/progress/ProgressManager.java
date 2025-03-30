package org.jabref.progress;

import java.util.HashMap;
import java.util.Map;

public class ProgressManager {
    private final Map<String, Integer> progressMap = new HashMap<>();

    public void setProgress(String entryId, int progressPercent) {
        if (progressPercent < 0 || progressPercent > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100.");
        }
        progressMap.put(entryId, progressPercent);
    }

    public int getProgress(String entryId) {
        return progressMap.getOrDefault(entryId, 0);
    }

    public void resetProgress(String entryId) {
        progressMap.put(entryId, 0);
    }
}
