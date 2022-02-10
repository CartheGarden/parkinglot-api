package com.carthegarden.parkinglotapi.domain;

import com.carthegarden.parkinglotapi.dto.RecordDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicInsert
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private ParkingSpace parkingSpace;

    @Temporal(TemporalType.TIMESTAMP)
    private Date entranceTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date exitTime;

    @CreationTimestamp
    private Date recordTime;

    private Integer charge;

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public Integer getCharge() {
        return charge;
    }

    public static class Builder {

        private Member member;
        private ParkingSpace parkingSpace;
        private Integer charge;
        private Date entranceTime;
        private Date exitTime;

        public Builder(RecordDTO.Record record) {
            this.member = record.getMember();
            this.parkingSpace = record.getParkingSpace();
            this.charge = record.getCharge();
            this.entranceTime = record.getEntranceTime();
            this.exitTime = record.getExitTime();
        }

        public Record build() {
            Record record = new Record();
            record.member = member;
            record.parkingSpace = parkingSpace;
            record.charge = charge;
            record.entranceTime = entranceTime;
            record.exitTime = exitTime;

            return record;
        }
    }
}
