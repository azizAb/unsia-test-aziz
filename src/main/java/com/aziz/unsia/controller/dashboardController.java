package com.aziz.unsia.controller;

import com.aziz.unsia.entity.DataDashboard;
import com.aziz.unsia.entity.KegiatanRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class dashboardController {

  private final KegiatanRepo kegiatanRepo;
  private final EntityManager entityManager;

  @GetMapping
  @Transactional
  public ResponseEntity<?> getDashboard() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();

    String rawData = mapper.writeValueAsString(kegiatanRepo.getDashboardData());
    String[] stringArray = rawData.replaceAll("\\[|\\]", "").split(",");

    List<Long> arrayList = Arrays.stream(stringArray)
        .map(Long::parseLong)
        .collect(Collectors.toCollection(ArrayList::new));

    DataDashboard dataDashboard = new DataDashboard();
    dataDashboard.setJmlKegiatan(arrayList.get(0));
    dataDashboard.setJmlProgram(arrayList.get(1));
    dataDashboard.setJmlSekolah(arrayList.get(2));

    return ResponseEntity.ok(dataDashboard);
  }

}
