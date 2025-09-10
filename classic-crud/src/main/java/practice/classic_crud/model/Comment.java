package practice.classic_crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties({"comments", "author"})
    private Post post;


    @ManyToOne()
    @JoinColumn(name = "author_id")
    @JsonIgnoreProperties({"comments", "author", "posts"})
    private User author;

    public Comment() {}
}