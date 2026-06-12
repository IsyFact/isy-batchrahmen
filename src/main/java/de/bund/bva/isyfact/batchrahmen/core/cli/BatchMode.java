package de.bund.bva.isyfact.batchrahmen.core.cli;

import java.util.Arrays;

public final class BatchMode {

    private BatchMode() {
    }

    public static boolean isBatch(String[] args) {
        if (args == null) {
            return false;
        }

        return Arrays.stream(args)
                .anyMatch("-batch"::equalsIgnoreCase);
    }
}
