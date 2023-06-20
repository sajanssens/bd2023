package org.example.post.manytoone.uni;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.ConstraintMode.CONSTRAINT;

@Entity
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class PostComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "")
    private long id;

    private String title;

    @ManyToOne(cascade = PERSIST)
    // Optionally add a cascading delete to the table definition (only when creating new table, not on exisiting table):
    @JoinColumn(name = "postId", foreignKey = @ForeignKey(value = CONSTRAINT, foreignKeyDefinition = "FOREIGN KEY (postId) REFERENCES parent(id) ON DELETE CASCADE"))
    private Post post;
}
