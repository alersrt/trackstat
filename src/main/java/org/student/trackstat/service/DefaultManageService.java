package org.student.trackstat.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.student.trackstat.model.Car;
import org.student.trackstat.model.Track;
import org.student.trackstat.repository.CarRepository;
import org.student.trackstat.repository.TrackRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DefaultManageService implements ManageService {

  private final TrackRepository trackRepository;
  private final CarRepository carRepository;

  @Transactional
  @Override
  public Car save(Car car) {
    return carRepository.saveAndFlush(car);
  }

  @Transactional
  @Override
  public Track save(Track track) {
    return trackRepository.saveAndFlush(track);
  }

  @Transactional
  @Override
  public List<Track> getAllTracks() {
    return trackRepository.findAll();
  }
}
