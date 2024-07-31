package com.org.Controller;

import com.org.DTO.*;
import com.org.Exception.TrainScedulingException;
import com.org.Exception.TrainSchedulingUtilsException;
import com.org.Service.impl.*;
import com.org.Util.ResponseCode;
import com.org.Util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/train")
@RequiredArgsConstructor
public class TrainController {
    private final TrainServiceImp trainService;

    @GetMapping("/getAllTrains")
    public ResponseEntity<?>getAllTrains(){
       return new ResponseEntity<>(trainService.getAllTrains(), HttpStatus.OK);
    }

    @PostMapping("/addTrain")
    public ResponseEntity<?>addTrains(@RequestBody TrainDto train){
        try{
            return new ResponseEntity<>(ResponseUtil.getSuccessGenericApiResponse(
                    "Sucessfully recors id added","Success",ResponseCode.OK.name(),trainService.addTrain(train)), HttpStatus.OK);
        }
        catch(TrainScedulingException e){
            throw e;
        }
        catch (Exception e){
            throw new TrainScedulingException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteTrain/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable int id){
        try {
            return new ResponseEntity<>(ResponseUtil.getSuccessGenericApiResponse(
                    "Record is deleted of id "+String.valueOf(id),"Success",ResponseCode.OK.name(),trainService.deleteTain(id)),HttpStatus.OK);
        }
        catch(TrainScedulingException e){
            throw e;
        }
        catch (Exception e){
            throw new TrainScedulingException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateTrain/{id}")
    public ResponseEntity<?>updateTrain(@PathVariable int id, @RequestBody TrainDto train){
        try{
            return new ResponseEntity<>(ResponseUtil.getSuccessGenericApiResponse(
                    "Record is updated","Success",ResponseCode.OK.name(),
                    trainService.updateTrain(id,train)), HttpStatus.OK);
        }
        catch(TrainScedulingException e){
            throw e;
        }
        catch (Exception e){
            throw new TrainScedulingException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTrainByStation/{station}/{station2}")
    public ResponseEntity<?>getTrainByStation(@PathVariable("station") String station,@PathVariable("station2") String station2){
        try{
            return new ResponseEntity<>(ResponseUtil.getSuccessGenericApiResponse(
                    "Sucess","Success",ResponseCode.OK.name(),
                    trainService.findByStation(station,station2)), HttpStatus.OK);
        }
        catch(TrainScedulingException e){
            throw e;
        }
        catch (Exception e){
            throw new TrainScedulingException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }

}
