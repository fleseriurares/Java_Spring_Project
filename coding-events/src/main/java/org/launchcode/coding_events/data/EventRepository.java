package org.launchcode.coding_events.data;

import org.launchcode.coding_events.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // public class MyRepository implements EventRepository()
public interface EventRepository extends CrudRepository<Event, Integer> {



}
