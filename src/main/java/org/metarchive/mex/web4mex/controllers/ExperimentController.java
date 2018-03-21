package org.metarchive.mex.web4mex.controllers;

import org.metarchive.mex.web4mex.objects.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.net.URI;

import org.metarchive.mex.web4mex.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.metarchive.mex.core.MEXEnum;

@RestController
public class ExperimentController {

	@Autowired
	ExperimentService experimentService;

	
	@PostMapping(value = { "/{token}/experimentId" })
	public void setExperimentId(@RequestBody String experimentId, @PathVariable String token) {
		experimentService.getCacheByUser(token).setExperimentId(experimentId);
	}	
	
	@PostMapping(value = { "/{token}/experimentTitle" })
	public void setExperimentTitle(@RequestBody String experimentTitle, @PathVariable String token) {
		experimentService.getCacheByUser(token).setExperimentTitle(experimentTitle);
	}		
	
	@PostMapping(value = { "/{token}/experimentDate" })
	public void setExperimentDate(@RequestBody String experimentDate, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDate(DateFormat.getDateInstance().parse(experimentDate));
	}		
	
	@PostMapping(value = { "/{token}/experimentDescription" })
	public void setExperimentDescription(@RequestBody String experimentDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDescription(experimentDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentDataNormalizationDescription" })
	public void setExperimentDataNormalizationDescription(@RequestBody String experimentDataNormalizationDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDataNormalizationDescription(experimentDataNormalizationDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentNoiseRemovalDescription" })
	public void setExperimentNoiseRemovalDescription(@RequestBody String experimentNoiseRemovalDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentNoiseRemovalDescription(experimentNoiseRemovalDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentAttributeSelectionDescription" })
	public void setExperimentAttributeSelectionDescription(@RequestBody String experimentAttributeSelectionDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentAttributeSelectionDescription(experimentAttributeSelectionDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentOutlierDetectionDescription" })
	public void setExperimentOutlierDetectionDescription(@RequestBody String experimentOutlierDetectionDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentOutlierDetectionDescription(experimentOutlierDetectionDescription);
	}

	@PostMapping(value = { "/{token}/experimentAlgorithm" })
	public void setExperimentAlgorithm(@RequestBody Algorithm experimentAlgorithm, @PathVariable String token) throws Exception {
        String algorithmID = experimentAlgorithm.getAlgorithmID();
        String algorithmName = experimentAlgorithm.getAlgorithmName();
        URI uri = new URI(experimentAlgorithm.getURL());
        MEXEnum.EnumAlgorithmsClasses algorithmClass = MEXEnum.EnumAlgorithmsClasses.valueOf(experimentAlgorithm.getAlgorithmClass());
        String idExecution = experimentAlgorithm.getIdExecution();
        experimentService.getCacheByUser(token).Configuration().addAlgorithm(algorithmID, algorithmName, algorithmClass, uri,  idExecution);
	}


}
