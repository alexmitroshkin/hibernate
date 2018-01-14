package model_lesson10;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex on 13.01.2018.
 */
@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {

    private static final long serialVersionUID = -3815174292031027477L;

    @Column(name="title")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="parent_product_category", referencedColumnName="id")
    private ProductCategory parentProductCategory;
    @OneToMany(mappedBy = "productCategory",fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Product> products;

    public ProductCategory() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "title='" + title + '\'' +
                ", parentProductCategory=" + (parentProductCategory == null ? "null" : parentProductCategory.toString()) +
//                ", products=" + (!products.isEmpty() ? products.toString() : "null") +
                '}';
    }
}
