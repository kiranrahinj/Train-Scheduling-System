package com.org.Service.impl;

import java.util.*;
import com.org.Entity.Train;
import com.org.DTO.TrainDto;
import com.org.Exception.TrainScedulingException;
import com.org.Exception.TrainSchedulingUtilsException;
import com.org.Repository.TrainRepository;
import com.org.Service.TrainService;
import com.org.Util.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainServiceImp implements TrainService {
    private final TrainRepository trainRepository;
    @Override
    public final List<TrainDto> getAllTrains() {
        List<Train> train = trainRepository.findAll();
        List<TrainDto> resp = new ArrayList<>();
        for (var k : train) {
            resp.add(TrainDto.builder().name(k.getName()).number(k.getNumber()).stations(k.getStations()).build());
        }
        return resp;
    }

    @Override
    public final TrainDto addTrain(TrainDto trainDto) {
        Optional<Train> checkTrain=trainRepository.findById(trainDto.getNumber());
        if(checkTrain.isPresent()){
            TrainSchedulingUtilsException.propogateBadRequestException("Given train number is already present", ResponseCode.BAD_REQUEST);
        }
        Train train=Train.builder().name(trainDto.getName()).number(trainDto.getNumber()).stations(trainDto.getStations()).build();
        trainRepository.save(train);
        return trainDto;
    }

    @Override
    public TrainDto deleteTain(int id) {
        Optional<Train> checkTrain=trainRepository.findById(id);
        if(checkTrain.isEmpty()){
            TrainSchedulingUtilsException.propogateBadRequestException("Given train is not present", ResponseCode.BAD_REQUEST);
        }
        trainRepository.deleteById(id);
        return null;
    }

    @Override
    public TrainDto updateTrain(int id, TrainDto trainDto) {
        Optional<Train> checkTrain=trainRepository.findById(id);
        if(checkTrain.isEmpty()){
            TrainSchedulingUtilsException.propogateBadRequestException("Given train is not present", ResponseCode.BAD_REQUEST);
        }
        Train t=checkTrain.get();
        t.setName(trainDto.getName());
        t.setStations(trainDto.getStations());
        trainRepository.save(t);
        return trainDto;
    }

    @Override
    public List<String> findByStation(String source, String Destination) {
        if(source.trim().length()==0 || Destination.trim().length()==0 ){
            TrainSchedulingUtilsException.propogateBadRequestException("Please Give valid details", ResponseCode.BAD_REQUEST);
        }
        return trainRepository.findByStation(source,Destination);
    }

}
