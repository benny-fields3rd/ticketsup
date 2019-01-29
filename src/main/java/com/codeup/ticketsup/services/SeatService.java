package com.codeup.ticketsup.services;

import com.codeup.ticketsup.interfaces.SeatsRepository;
import com.codeup.ticketsup.models.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatsRepository seatRepo;


    public SeatService( SeatsRepository seatRepo){
        this.seatRepo = seatRepo;
    }
    public Seat create(Seat seat){
        return seatRepo.save(seat);
    }

    public List<Seat> allSeats(){
        return (List<Seat>) seatRepo.findAll();
    }

    public Seat singleSeat(int id){
        return seatRepo.findOne(id);
    }

    public Seat saveSeat(Seat seat){
        return seatRepo.save(seat);
    }

    public void deleteSeat(Seat seat){
        seatRepo.delete(seat);
    }

}
