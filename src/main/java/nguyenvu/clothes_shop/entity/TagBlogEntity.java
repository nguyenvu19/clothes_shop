package nguyenvu.clothes_shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenvu.clothes_shop.entity.ids.TagBlogIds;

@Entity(name = "tag_blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagBlogEntity {
    @EmbeddedId
    @JsonIgnore
    private TagBlogIds ids;

    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false,updatable = false)
    private TagEntity tag;

    @ManyToOne
    @JoinColumn(name = "blog_id", insertable = false,updatable = false)
    @JsonIgnore
    private BlogEntity blog;

}
