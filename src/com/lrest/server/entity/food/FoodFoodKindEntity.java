package com.lrest.server.entity.food;

import javax.persistence.*;

/**
 * @version V1.0.0
 * @projectName: CKDServer
 * @title: FoodFoodKindEntity
 * @package com.lrest.server.entity.food
 * @description: ${TODO}
 * @author: 韩武洽 @Wyshown
 * @date: 2018/3/7 上午10:32
 */
@Entity
@Table(name = "food_food_kind", schema = "test", catalog = "")
public class FoodFoodKindEntity {
    private int id;
    private String foodKindName;
    private String imageUrl;
    private String description;
    private String foodType;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOOD_KIND_NAME", nullable = true, length = 50)
    public String getFoodKindName() {
        return foodKindName;
    }

    public void setFoodKindName(String foodKindName) {
        this.foodKindName = foodKindName;
    }

    @Basic
    @Column(name = "IMAGE_URL", nullable = true, length = 255)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "FOOD_TYPE", nullable = true, length = 20)
    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodFoodKindEntity that = (FoodFoodKindEntity) o;

        if (id != that.id) return false;
        if (foodKindName != null ? !foodKindName.equals(that.foodKindName) : that.foodKindName != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (foodType != null ? !foodType.equals(that.foodType) : that.foodType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foodKindName != null ? foodKindName.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (foodType != null ? foodType.hashCode() : 0);
        return result;
    }
}
