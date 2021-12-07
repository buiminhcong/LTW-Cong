package com.example.ltw_longptit.repo;

import com.example.ltw_longptit.model.ThuocSuDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ThuocSuDungRepository extends JpaRepository<ThuocSuDung, Integer> {


    @Query(value="SELECT * FROM thuoc_su_dung WHERE id_donthuoc=:id ;", nativeQuery = true)
    public List<ThuocSuDung> statisticMedicineUsedbyPrescriptionId(@Param("id") String id);



}
