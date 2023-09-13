package nguyenvu.clothes_shop.entity.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
