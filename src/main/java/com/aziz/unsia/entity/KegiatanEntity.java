package com.aziz.unsia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "DashboardData", procedureName = "data_dashboard")
@Table(name = "kegiatan_kampus")
public class KegiatanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String namaLengkap;
  private String alamat;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date tanggalLahir;
  private String email;
  private String noHp;
  private String namaInstansi;
  private String jabatan;
  private String namaInstagram;
  private String namaFacebook;

}
