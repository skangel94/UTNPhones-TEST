package edu.utn.utnphones.controller;

import edu.utn.utnphones.domain.Call;

import edu.utn.utnphones.exception.ResourcesNotExistException;
import edu.utn.utnphones.projections.CallsByLineCant;
import edu.utn.utnphones.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class CallController {
    private CallService callService;

    @Autowired
    public CallController(CallService callService) {
        this.callService = callService;
    }

    public List<Call> getAllCalls(){
        return callService.getAll();
    }

    public Call addCall(Call call){
        return callService.add(call);
    }

    public Call getById(int id) throws ResourcesNotExistException {
        return callService.getById(id);
    }

    public List<CallsByLineCant> getCallsByLineCants(int userid){
        return callService.getCallsByLineCants(userid);
    }
}
