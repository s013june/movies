package com.siyun.movies.controller;

import com.siyun.movies.service.ReviewService;
import com.siyun.movies.model.Review;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    private final ReviewService service;

    @Autowired
    private ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping()
    @Operation(summary = "Example Operation", description = "This is an example operation.",
        extensions = {
            @Extension(name = "parameters", properties = {
                @ExtensionProperty(name = "reviewBody", value = "sample_value"),
                @ExtensionProperty(name = "imdbId", value = "42")
            })
    })
    public ResponseEntity<Review> createReview(@RequestParam String reviewBody, @RequestParam String imdbId) {
        return new ResponseEntity<>(
            service.createReview(reviewBody, imdbId), HttpStatus.OK);
    }
}
