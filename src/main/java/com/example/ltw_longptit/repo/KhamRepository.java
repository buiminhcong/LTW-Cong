package com.example.ltw_longptit.repo;

import com.example.ltw_longptit.model.BenhNhan;
import com.example.ltw_longptit.model.Kham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KhamRepository extends JpaRepository<Kham, Integer> {

    @Query(value = "select * from kham where datein like %:keyword% and status = 'have'",nativeQuery = true)
    public List<Kham> getAllKhamByThang(@Param("keyword") String keyword);

    @Query(value = "select distinct(id_bn) from kham where datein like %:keyword% and id_bs = :id  and status = 'have'",nativeQuery = true)
    public List<Integer> getAllKhamByBacSy(@Param("keyword") String keyword, @Param("id") String id);

    @Query(value = "select * from kham where datein like %:keyword% and id_bn = :id",nativeQuery = true)
    public List<Kham> getAllKhamByBenhNhan(@Param("keyword") String keyword ,@Param("id") String id);

    @Query(value = "select * from kham where id_bs = :id_bs and id_bn = :id_bn limit 1",nativeQuery = true)
    public Kham getKham(@Param("id_bn") String id_bn, @Param("id_bs") String id_bs);

    


}
