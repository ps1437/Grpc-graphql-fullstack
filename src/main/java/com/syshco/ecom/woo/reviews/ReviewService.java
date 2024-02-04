package com.syshco.ecom.woo.reviews;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public ReviewEntity getReviewById(UUID reviewId) {
        Optional<ReviewEntity> optionalReview = reviewRepository.findById(reviewId);
        return optionalReview.orElse(null);
    }

    public ReviewEntity createReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    public ReviewEntity updateReview(UUID reviewId, ReviewEntity updatedReview) {
        if (reviewRepository.existsById(reviewId)) {
            updatedReview.setReviewId(reviewId);
            return reviewRepository.save(updatedReview);
        }
        return null;
    }

    public boolean deleteReview(UUID reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
