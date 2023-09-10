package nguyenvu.clothes_shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenvu.clothes_shop.entity.ids.TagBlogIds;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "image")
    private String image;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "createdDate")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "blog")
    private Set<TagBlogEntity> tagBlogs;

    @OneToMany(mappedBy = "blog")
    private Set<CommentEntity> comments;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;


}
