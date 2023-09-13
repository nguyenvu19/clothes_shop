package nguyenvu.clothes_shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nguyenvu.clothes_shop.entity.ids.CategoryTagIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "category_tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTag {

    @EmbeddedId
    private CategoryTagIds ids;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false,updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "tag_id", insertable = false,updatable = false)
    private TagEntity tag;
}
