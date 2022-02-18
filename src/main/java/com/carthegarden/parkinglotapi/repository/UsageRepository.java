package com.carthegarden.parkinglotapi.repository;

import com.carthegarden.parkinglotapi.domain.Member;
import com.carthegarden.parkinglotapi.domain.ParkingSpace;
import com.carthegarden.parkinglotapi.domain.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Long> {
    Optional<Usage> findByParkingSpace(ParkingSpace parkingSpace);

    //List<Long> findByMember(Member member);

//    Optional<UsageProjection> findByMember(Member member);
    // List<UsageProjection> findBy(UsageProjection type);
//
    @Query(value="SELECT parking_space_id FROM Usage", nativeQuery = true)
    List<Long> findAllParkingSpaceId();
}
