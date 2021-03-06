package org.student.trackstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.student.trackstat.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
