package com.syshco.grpc.movie;

import com.syshco.grpc.gen.Empty;
import com.syshco.grpc.gen.Movie;
import com.syshco.grpc.gen.MovieResponse;
import com.syshco.grpc.gen.MovieServiceGrpc;
import com.syshco.grpc.starter.GrpcService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@GrpcService
@RequiredArgsConstructor
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    private final MovieRepository movieRepository;

    @Override
    public void getMovies(Empty request, StreamObserver<MovieResponse> responseObserver) {

        List<MovieDTO> movies = movieRepository.findAll();
        List<Movie> movieResponse = toMovie(movies)
                .collect(Collectors.toList());
        responseObserver.onNext(MovieResponse.newBuilder().addAllMovies(movieResponse).build());
        responseObserver.onCompleted();

    }

    private static Stream<Movie> toMovie(List<MovieDTO> movies) {
        return movies.stream()
                .map(movie -> Movie.newBuilder()
                        .setTitle(movie.getTitle())
                        .setMovieId(movie.getMovieId())
                        .setYear(movie.getReleaseYear())
                        .setRating(movie.getRating())
                        .setDescription(movie.getDescription())
                        .setDirector(movie.getDirector())
                        .build());
    }
}
