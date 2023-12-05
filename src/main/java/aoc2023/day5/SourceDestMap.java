package aoc2023.day5;

import java.util.ArrayList;
import java.util.List;

public class SourceDestMap {

    public final String from;
    public final String to;
    public List<SourceDestEntry> entries = new ArrayList<>();


    public SourceDestMap(String definition) {
        String mapping = definition.split(" ")[0];
        String[] fromTo = mapping.split("-to-");
        from = fromTo[0];
        to = fromTo[1];
    }

    public void addLine(String line) {
        this.entries.add(new SourceDestEntry(line));
    }

    public long execute(Long value) {
        for (SourceDestEntry destEntry : this.entries) {
            if (destEntry.appliesTo(value)) {
                return destEntry.apply(value);
            }
        }
        return value;
    }
}
