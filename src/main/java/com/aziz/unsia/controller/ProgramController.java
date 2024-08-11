package com.aziz.unsia.controller;

import com.aziz.unsia.entity.ProgramEntity;
import com.aziz.unsia.entity.ProgramRepo;
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
@RequestMapping("/program")
@RequiredArgsConstructor
public class ProgramController {

  private final ProgramRepo programRepo;

  @GetMapping
  public ResponseEntity<?> getProgram(@RequestParam(defaultValue = "0") int pageNumber){
    var listPerPage = 10;
    Pageable pagingProgram = PageRequest.of(pageNumber, listPerPage, Sort.by("id").descending());
    var listProgram = programRepo.findAll(pagingProgram);
    return ResponseEntity.ok(listProgram);
  }

  @PostMapping
  public ResponseEntity<?> tambahProgram(@RequestBody ProgramEntity program){
    programRepo.save(program);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editProgram(@PathVariable long id, @RequestBody ProgramEntity program){
    program.setId(id);
    try {
      if(!programRepo.findById(id).isPresent()){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      programRepo.save(program);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return ResponseEntity.ok(program);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteProgram(@PathVariable long id){
    if(!programRepo.findById(id).isPresent()){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    programRepo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
