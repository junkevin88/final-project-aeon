package com.aeon.finpro.service.impl;

import com.aeon.finpro.dto.TrainingModel;
import com.aeon.finpro.entity.Training;
import com.aeon.finpro.repository.TrainingRepo;
import com.aeon.finpro.service.TrainingService;
import com.aeon.finpro.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    private Response response;

    @Override
    public ResponseEntity<Map> insertTraining(TrainingModel trainingModel) {
        try {
            if (trainingModel.getFacilitator() == null) {
                return new ResponseEntity<Map>(response.clientError("Facilitator is required"), HttpStatus.BAD_REQUEST);
            }
            if (trainingModel.getTopic() == null) {
                return new ResponseEntity<Map>(response.clientError("Topic is required"), HttpStatus.BAD_REQUEST);
            }

            Training training = new Training();
            training.setFacilitator(trainingModel.getFacilitator());
            training.setTopic(trainingModel.getTopic());
            trainingRepo.save(training);

            return new ResponseEntity<Map>(response.resSuccess(training, "Success insert training", 201), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map> updateTraining(TrainingModel trainingModel) {
        try {
            if (trainingModel.getFacilitator() == null) {
                return new ResponseEntity<Map>(response.clientError("Facilitator is required"), HttpStatus.BAD_REQUEST);
            }
            if (trainingModel.getTopic() == null) {
                return new ResponseEntity<Map>(response.clientError("Topic is required"), HttpStatus.BAD_REQUEST);
            }
            if (trainingModel.getId() == null) {
                return new ResponseEntity<Map>(response.clientError("ID is required"), HttpStatus.BAD_REQUEST);
            }

            Training training = trainingRepo.getReferenceById(trainingModel.getId());
            if(training == null){
                return new ResponseEntity<Map>(response.clientError("Training not found"), HttpStatus.BAD_REQUEST);
            }
            training.setFacilitator(trainingModel.getFacilitator());
            training.setTopic(trainingModel.getTopic());
            trainingRepo.save(training);

            return new ResponseEntity<Map>(response.resSuccess(training, "Success update training", 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map> getTrainingById(UUID id) {
        try {
            Optional<Training> training = trainingRepo.findById(id);
            if (training == null) {
                return new ResponseEntity<Map>(response.clientError("Training not found"), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Map>(response.resSuccess(training, "Succes get employee", 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }    }
}
