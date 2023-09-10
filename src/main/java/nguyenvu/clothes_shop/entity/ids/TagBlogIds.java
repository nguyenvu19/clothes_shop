package nguyenvu.clothes_shop.entity.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagBlogIds implements Serializable {
    @Column(name = "tag_id")
    private int tagId;

    @Column(name = "blog_id")
    private int blogId;

}
