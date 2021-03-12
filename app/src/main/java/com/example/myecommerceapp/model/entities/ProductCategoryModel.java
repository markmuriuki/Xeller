/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

/**
 *
 */
package com.example.myecommerceapp.model.entities;


public class ProductCategoryModel {

    private String categoryName;
    private String categoryDescription;
    private String categoryDiscount;
    private String categoryImageUrl;
    /**
     * @param productCategoryName
     * @param productCategoryDescription
     * @param productCategoryDiscount
     * @param productCategoryUrl
     */
    public ProductCategoryModel(String productCategoryName, String productCategoryDescription,
                                String productCategoryDiscount, String productCategoryUrl) {
        super();
        this.categoryName = productCategoryName;
        this.categoryDescription = productCategoryDescription;
        this.categoryDiscount = productCategoryDiscount;
        this.categoryImageUrl = productCategoryUrl;
    }

    /**
     * @return the idproductcategory
     */
    public String getProductCategoryName() {
        return categoryName;
    }

    /**
     * @return the productDescription
     */
    public String getProductCategoryDescription() {
        return categoryDescription;
    }

    /**
     * @return the productDiscount
     */
    public String getProductCategoryDiscount() {
        return categoryDiscount;
    }

    /**
     * @return the productUrl
     */
    public String getProductCategoryImageUrl() {
        return categoryImageUrl;
    }

}
