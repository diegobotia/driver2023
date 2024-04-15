package com.udea.driver2023.controller;

import com.udea.driver2023.exception.InvalidRating;
import com.udea.driver2023.exception.ModelNotFoundException;
import com.udea.driver2023.model.Flight;
import com.udea.driver2023.service.FlightService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
@Api(value = "Flight Management System", description = "Operations to Flights")
public class FlightController {
    @Autowired
    FlightService flightService;

@ApiOperation(value = "Add Flight")
    @PostMapping("/save")
    public long save(
            @ApiParam(value = "Flight Object Store in DB table", required = true)
            @RequestBody Flight flight)  throws InvalidRating {
           if(flight.getRating() > 5)
               throw new InvalidRating("Id should be less than or equal 5");


        flightService.save(flight);
        return flight.getIdFlight();
    }

    @ApiOperation(value = "View a list of available flights", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights(){return flightService.list();}


    @ApiOperation(value = "Get Flight by ID")
    @GetMapping("/list/{id}")
    public Flight listFlightById( @ApiParam(value = "Flight ID from flight object will retrive", required = true) @PathVariable("id") int id){
        Optional<Flight> flight= flightService.listId(id);
        if(flight.isPresent()){
            return flight.get();
        }

        throw new ModelNotFoundException("ID de Flight invalido");
    }

    @ApiOperation(value = "Get Top Flights")
    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights(){
        List<Flight> list=flightService.viewBestFlight();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }


    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable long id){
        return flightService.delete(id);
    }

}
