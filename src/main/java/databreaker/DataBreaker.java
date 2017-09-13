package databreaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataBreaker {
    List<String> brokenRecords;

    public Integer deleted = 0;
    public Integer duplicates = 0;

    public List<String> run(List<String> records) {
        brokenRecords = new ArrayList<>();
        this.swapLines(records);
        records.forEach(r -> breakRecord(r));
        return brokenRecords;
    }

    private void breakRecord(String s) {
        if (remove()) {
            return;
        }

        AttributesBreaker attributesBreaker = new AttributesBreaker();
        s = attributesBreaker.run(s);

        duplicate(s);
        brokenRecords.add(s);
    }

    private boolean remove() {
        if (shouldBeBroken()) {
            System.out.println("Record was removed!");
            deleted++;
            return true;
        } else {
            return false;
        }
    }

    private boolean duplicate(String record) {
        if (shouldBeBroken()) {
            String duplicated = new String(record);
            brokenRecords.add(duplicated);
            duplicates++;
            System.out.println("Record was duplicated");
            return true;
        } else {
            return false;
        }
    }

    private boolean shouldBeBroken() {
        Double random = Math.random();
        if (random < 0.005) {
            return true;
        } else {
            return false;
        }
    }

    public void swapLines(List<String> records) {
        final float PERCENT_OF_RECORDS_TO_SWAP = 0.005f;

        long howManyLinesToSwap = Math.round(PERCENT_OF_RECORDS_TO_SWAP * records.size());
        for (int i = 1; i <= howManyLinesToSwap; i++) {
            Integer random = ThreadLocalRandom.current().nextInt(0, records.size() - 1);
            Collections.swap(records, random, random + 1);
            System.out.println("2 records were swapped");
        }
    }
}
