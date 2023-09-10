package nguyenvu.clothes_shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<CategoryTag> categoryTags;

    @OneToMany(mappedBy = "tag")
    @JsonIgnore
    private Set<TagBlogEntity> tagBlogs;

}
