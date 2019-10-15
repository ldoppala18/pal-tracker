package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    public InMemoryTimeEntryRepository(){};
    private Map<Long,TimeEntry> db = new HashMap<>();
    private long counter = 0;

     public TimeEntry create(TimeEntry timeEntry) {
         counter = counter + 1;

         //db=Map.of("1L",1,"2L",2);
         timeEntry.setId(counter);
         db.put(timeEntry.getId(), timeEntry);
         return timeEntry;

     }

    public TimeEntry find(long id) {
        return db.get(id);
    }

    public ArrayList<TimeEntry> list() {
        Collection<TimeEntry> values = db.values();
        return new ArrayList<>(values);
    }

    public TimeEntry update(long id, TimeEntry newEntry) {
         newEntry.setId(id);
         if (db.containsKey(id)) {
             db.put(id, newEntry);
             return newEntry;
         }
         return null;
    }

    public void delete(long id) {
        db.remove(id);
    }
}
