package org.student.trackstat.service;

import java.util.List;
import org.student.trackstat.model.Car;
import org.student.trackstat.model.Track;

/**
 * Service which is responsible for passing model objects to database entities and back.
 */
public interface ManageService {

  Car save(Car car);
  Track save(Track track);
  List<Track> getAllTracks();
}
