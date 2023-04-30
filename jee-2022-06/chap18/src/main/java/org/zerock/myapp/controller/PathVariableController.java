package org.zerock.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@RestController
public class PathVariableController {

	@PostMapping(
			path="/product/{category}/{productionId}",
			produces="application/json"
			)
	@GetMapping(
			path="/product/{category}/{productionId}",
			produces="application/json"
			)
	public String[] getPathVariables(
			@PathVariable("category") String category, 
			@PathVariable("productionId") Integer productionId
			) {
		log.trace("getPathVariables({}, {}) invoked.", category, productionId);
		
		return new String[] {"category: " + category, "Prodcution ID: " + productionId};
	} //getPathVariables
} //end class
