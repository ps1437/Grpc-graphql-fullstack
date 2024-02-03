package com.syshco.grpc.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Movies")
public class MovieDTO {
    @Id
    private int movieId;
    private int rating;
    private int releaseYear;
    private String title;
    private String genre;
    private String director;
    private String description;

}