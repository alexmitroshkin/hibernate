package model_lesson10;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by alex on 13.01.2018.
 */
@Entity
@Table(name = "product")
public class Product extends Model{

    private static final long serialVersionUID = -4934834204191042127L;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id", referencedColumnName = "id")
    private Product_Category  productCategory;


    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product_Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Product_Category productCategory) {
        this.productCategory = productCategory;
    }
}
