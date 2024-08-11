package com.aziz.unsia.controller;

import com.aziz.unsia.entity.KegiatanEntity;
import com.aziz.unsia.entity.KegiatanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kegiatan")
@RequiredArgsConstructor
public class KegiatanController {

  private final KegiatanRepo kegiatanRepo;

  @GetMapping
  public ResponseEntity<?> getKegiatan(@RequestParam(defaultValue = "0") int pageNumber){
    var listPerPage = 10;
    Pageable pagingKegiatan = PageRequest.of(pageNumber, listPerPage, Sort.by("id").descending());
    var listKegiatan = kegiatanRepo.findAll(pagingKegiatan);
    return ResponseEntity.ok(listKegiatan);
  }

  @PostMapping
  public ResponseEntity<?> tambahKegiatan(@RequestBody KegiatanEntity kegiatan){
    kegiatanRepo.save(kegiatan);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("{id}")
  public ResponseEntity<?> editKegiatan(@PathVariable long id, @RequestBody KegiatanEntity kegiatan){
    kegiatan.setId(id);
    try {
      if(!kegiatanRepo.findById(id).isPresent()){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      kegiatanRepo.save(kegiatan);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return ResponseEntity.ok(kegiatan);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteKegiatan(@PathVariable long id){
    if(!kegiatanRepo.findById(id).isPresent()){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    kegiatanRepo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
