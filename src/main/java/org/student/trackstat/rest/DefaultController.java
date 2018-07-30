package org.student.trackstat.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.student.trackstat.model.Track;
import org.student.trackstat.service.ManageService;

@RestController
@RequestMapping("/api")
@Log
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DefaultController {

  private final ManageService manageService;
  private ObjectMapper mapper = new ObjectMapper();

  @PostMapping("/tracks")
  public HttpStatus addTrack(@RequestBody Map<String, List<Track>> body) {
    HttpStatus httpStatus;
    try {
      List<Track> tracks = body.get("tracks");
      for (Track track : tracks) {
        track.getCars().forEach(c -> {
          c.setTrack(track);
        });
        manageService.save(track);
      }
      httpStatus = HttpStatus.OK;
    } catch (Exception e) {
      log.severe(e.toString());
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return httpStatus;
  }

  @GetMapping("/tracks")
  public ResponseEntity<List<Track>> getAllTracks() {
    List<Track> answer = null;
    HttpStatus httpStatus;
    try {
      answer = manageService.getAllTracks();
      httpStatus = HttpStatus.OK;
    } catch (Exception e) {
      log.severe(e.toString());
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    return new ResponseEntity<>(answer, httpStatus);
  }
}
