package model_lesson10;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex on 13.01.2018.
 */
@Entity
@Table(name = "product_category")
public class Product_Category extends Model {

    private static final long serialVersionUID = -3815174292031027477L;

    @Column(name="title")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="parent_product_category", referencedColumnName="id")
    private Product_Category parentProductCategory;
    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;

    public Product_Category() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product_Category getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(Product_Category parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
