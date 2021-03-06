package com.example.ratingservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
class ScoreUpdatesListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScoreUpdatesListener.class);
    private final RatingRepository ratingRepository;

    public ScoreUpdatesListener(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @RabbitListener(queues = "score-updates")
    void handleScoreUpdate(ScoreUpdate scoreUpdate) {
        LOGGER.info("Received score update: {}", scoreUpdate);
        ratingRepository.saveRating(scoreUpdate.movieId(), scoreUpdate.score());
    }

    static record ScoreUpdate(@JsonProperty("movieId") Long movieId, @JsonProperty("score") Integer score){}
}