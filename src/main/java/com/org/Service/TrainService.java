package com.org.Service;

import com.org.DTO.TrainDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TrainService {
    public List<TrainDto> getAllTrains();
    public TrainDto addTrain(TrainDto trainDto);
    public TrainDto deleteTain(int id);
    public TrainDto updateTrain(int id, TrainDto trainDto);

    public List<String> findByStation(String source,String Destination);
}
