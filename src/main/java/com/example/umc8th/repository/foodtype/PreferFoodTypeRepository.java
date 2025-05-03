package com.example.umc8th.repository.foodtype;

import com.example.umc8th.domain.foodType.PreferFoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PreferFoodTypeRepository extends JpaRepository<PreferFoodType, Long> {

    @Modifying
    @Query("DELETE FROM PreferFoodType p WHERE p.member.id = :memberId")
    void deleteAllByMemberId(@Param("memberId") Long memberId);
}
