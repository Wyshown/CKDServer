package com.lrest.server.entity.food;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * All rights Reserved, Designed By www.yingfeng365.com
 *
 * @version V1.0.0
 * @projectName: CKDServer
 * @title: FoodFoodEntity
 * @package com.lrest.server.entity.food
 * @description: ${TODO}
 * @author: 韩武洽 @Wyshown
 * @date: 2018/5/23 下午9:03
 * @copyright: 2018 www.yingfeng365.com
 * 注意：本内容仅限于 江苏灜沣信息科技有限公司，禁止外泄以及用于其他的商业
 */
@Entity
@Table(name = "food_food", schema = "test", catalog = "")
public class FoodFoodEntity {
    private int id;
    private Integer foodKindId;
    private String foodCode;
    private String foodCnName;
    private String foodEnName;
    private String foodAlias;
    private String thumbImageUrl;
    private String isLiquid;
    private Integer healthLight;
    private String healthLightGradeRemark;
    private Integer weight;
    private BigDecimal calory;
    private Integer caloryStateRemark;
    private BigDecimal fat;
    private Integer fatStateRemark;
    private BigDecimal protein;
    private BigDecimal fiberDietary;
    private BigDecimal carbohydrate;
    private BigDecimal vitaminA;
    private BigDecimal thiamine;
    private BigDecimal lactoflavin;
    private BigDecimal vitaminC;
    private BigDecimal vitaminE;
    private BigDecimal niacin;
    private BigDecimal natrium;
    private BigDecimal calcium;
    private BigDecimal iron;
    private BigDecimal kalium;
    private BigDecimal iodine;
    private BigDecimal zinc;
    private BigDecimal selenium;
    private BigDecimal magnesium;
    private BigDecimal copper;
    private BigDecimal manganese;
    private BigDecimal cholesterol;
    private Integer gl;
    private Integer glStateRemark;
    private Integer gi;
    private Integer giStateRemark;
    private Integer uremiaSateGrade;
    private String uremiaSateGradeRemark;
    private Integer dnSateGrade;
    private String dnSateGradeRemark;
    private Integer igaSateGrade;
    private String igaSateGradeRemark;
    private Integer maSateGrade;
    private String maSateGradeRemark;
    private String createTime;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOOD_KIND_ID", nullable = true)
    public Integer getFoodKindId() {
        return foodKindId;
    }

    public void setFoodKindId(Integer foodKindId) {
        this.foodKindId = foodKindId;
    }

    @Basic
    @Column(name = "FOOD_CODE", nullable = true, length = 100)
    public String getFoodCode() {
        return foodCode;
    }

    public void setFoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    @Basic
    @Column(name = "FOOD_CN_NAME", nullable = true, length = 50)
    public String getFoodCnName() {
        return foodCnName;
    }

    public void setFoodCnName(String foodCnName) {
        this.foodCnName = foodCnName;
    }

    @Basic
    @Column(name = "FOOD_EN_NAME", nullable = true, length = 50)
    public String getFoodEnName() {
        return foodEnName;
    }

    public void setFoodEnName(String foodEnName) {
        this.foodEnName = foodEnName;
    }

    @Basic
    @Column(name = "FOOD_ALIAS", nullable = true, length = 50)
    public String getFoodAlias() {
        return foodAlias;
    }

    public void setFoodAlias(String foodAlias) {
        this.foodAlias = foodAlias;
    }

    @Basic
    @Column(name = "THUMB_IMAGE_URL", nullable = true, length = 200)
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @Basic
    @Column(name = "IS_LIQUID", nullable = true, length = 18)
    public String getIsLiquid() {
        return isLiquid;
    }

    public void setIsLiquid(String isLiquid) {
        this.isLiquid = isLiquid;
    }

    @Basic
    @Column(name = "HEALTH_LIGHT", nullable = true)
    public Integer getHealthLight() {
        return healthLight;
    }

    public void setHealthLight(Integer healthLight) {
        this.healthLight = healthLight;
    }

    @Basic
    @Column(name = "HEALTH_LIGHT_GRADE_REMARK", nullable = true, length = 32)
    public String getHealthLightGradeRemark() {
        return healthLightGradeRemark;
    }

    public void setHealthLightGradeRemark(String healthLightGradeRemark) {
        this.healthLightGradeRemark = healthLightGradeRemark;
    }

    @Basic
    @Column(name = "WEIGHT", nullable = true)
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "CALORY", nullable = true, precision = 1)
    public BigDecimal getCalory() {
        return calory;
    }

    public void setCalory(BigDecimal calory) {
        this.calory = calory;
    }

    @Basic
    @Column(name = "CALORY_STATE_REMARK", nullable = true)
    public Integer getCaloryStateRemark() {
        return caloryStateRemark;
    }

    public void setCaloryStateRemark(Integer caloryStateRemark) {
        this.caloryStateRemark = caloryStateRemark;
    }

    @Basic
    @Column(name = "FAT", nullable = true, precision = 1)
    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    @Basic
    @Column(name = "FAT_STATE_REMARK", nullable = true)
    public Integer getFatStateRemark() {
        return fatStateRemark;
    }

    public void setFatStateRemark(Integer fatStateRemark) {
        this.fatStateRemark = fatStateRemark;
    }

    @Basic
    @Column(name = "PROTEIN", nullable = true, precision = 1)
    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    @Basic
    @Column(name = "FIBER_DIETARY", nullable = true, precision = 1)
    public BigDecimal getFiberDietary() {
        return fiberDietary;
    }

    public void setFiberDietary(BigDecimal fiberDietary) {
        this.fiberDietary = fiberDietary;
    }

    @Basic
    @Column(name = "CARBOHYDRATE", nullable = true, precision = 1)
    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(BigDecimal carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Basic
    @Column(name = "VITAMIN_A", nullable = true, precision = 1)
    public BigDecimal getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(BigDecimal vitaminA) {
        this.vitaminA = vitaminA;
    }

    @Basic
    @Column(name = "THIAMINE", nullable = true, precision = 1)
    public BigDecimal getThiamine() {
        return thiamine;
    }

    public void setThiamine(BigDecimal thiamine) {
        this.thiamine = thiamine;
    }

    @Basic
    @Column(name = "LACTOFLAVIN", nullable = true, precision = 1)
    public BigDecimal getLactoflavin() {
        return lactoflavin;
    }

    public void setLactoflavin(BigDecimal lactoflavin) {
        this.lactoflavin = lactoflavin;
    }

    @Basic
    @Column(name = "VITAMIN_C", nullable = true, precision = 1)
    public BigDecimal getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(BigDecimal vitaminC) {
        this.vitaminC = vitaminC;
    }

    @Basic
    @Column(name = "VITAMIN_E", nullable = true, precision = 1)
    public BigDecimal getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(BigDecimal vitaminE) {
        this.vitaminE = vitaminE;
    }

    @Basic
    @Column(name = "NIACIN", nullable = true, precision = 1)
    public BigDecimal getNiacin() {
        return niacin;
    }

    public void setNiacin(BigDecimal niacin) {
        this.niacin = niacin;
    }

    @Basic
    @Column(name = "NATRIUM", nullable = true, precision = 1)
    public BigDecimal getNatrium() {
        return natrium;
    }

    public void setNatrium(BigDecimal natrium) {
        this.natrium = natrium;
    }

    @Basic
    @Column(name = "CALCIUM", nullable = true, precision = 1)
    public BigDecimal getCalcium() {
        return calcium;
    }

    public void setCalcium(BigDecimal calcium) {
        this.calcium = calcium;
    }

    @Basic
    @Column(name = "IRON", nullable = true, precision = 1)
    public BigDecimal getIron() {
        return iron;
    }

    public void setIron(BigDecimal iron) {
        this.iron = iron;
    }

    @Basic
    @Column(name = "KALIUM", nullable = true, precision = 1)
    public BigDecimal getKalium() {
        return kalium;
    }

    public void setKalium(BigDecimal kalium) {
        this.kalium = kalium;
    }

    @Basic
    @Column(name = "IODINE", nullable = true, precision = 1)
    public BigDecimal getIodine() {
        return iodine;
    }

    public void setIodine(BigDecimal iodine) {
        this.iodine = iodine;
    }

    @Basic
    @Column(name = "ZINC", nullable = true, precision = 1)
    public BigDecimal getZinc() {
        return zinc;
    }

    public void setZinc(BigDecimal zinc) {
        this.zinc = zinc;
    }

    @Basic
    @Column(name = "SELENIUM", nullable = true, precision = 1)
    public BigDecimal getSelenium() {
        return selenium;
    }

    public void setSelenium(BigDecimal selenium) {
        this.selenium = selenium;
    }

    @Basic
    @Column(name = "MAGNESIUM", nullable = true, precision = 1)
    public BigDecimal getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(BigDecimal magnesium) {
        this.magnesium = magnesium;
    }

    @Basic
    @Column(name = "COPPER", nullable = true, precision = 1)
    public BigDecimal getCopper() {
        return copper;
    }

    public void setCopper(BigDecimal copper) {
        this.copper = copper;
    }

    @Basic
    @Column(name = "MANGANESE", nullable = true, precision = 1)
    public BigDecimal getManganese() {
        return manganese;
    }

    public void setManganese(BigDecimal manganese) {
        this.manganese = manganese;
    }

    @Basic
    @Column(name = "CHOLESTEROL", nullable = true, precision = 1)
    public BigDecimal getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(BigDecimal cholesterol) {
        this.cholesterol = cholesterol;
    }

    @Basic
    @Column(name = "GL", nullable = true, precision = 0)
    public Integer getGl() {
        return gl;
    }

    public void setGl(Integer gl) {
        this.gl = gl;
    }

    @Basic
    @Column(name = "GL_STATE_REMARK", nullable = true)
    public Integer getGlStateRemark() {
        return glStateRemark;
    }

    public void setGlStateRemark(Integer glStateRemark) {
        this.glStateRemark = glStateRemark;
    }

    @Basic
    @Column(name = "GI", nullable = true, precision = 0)
    public Integer getGi() {
        return gi;
    }

    public void setGi(Integer gi) {
        this.gi = gi;
    }

    @Basic
    @Column(name = "GI_STATE_REMARK", nullable = true)
    public Integer getGiStateRemark() {
        return giStateRemark;
    }

    public void setGiStateRemark(Integer giStateRemark) {
        this.giStateRemark = giStateRemark;
    }

    @Basic
    @Column(name = "UREMIA_SATE_GRADE", nullable = true)
    public Integer getUremiaSateGrade() {
        return uremiaSateGrade;
    }

    public void setUremiaSateGrade(Integer uremiaSateGrade) {
        this.uremiaSateGrade = uremiaSateGrade;
    }

    @Basic
    @Column(name = "UREMIA_SATE_GRADE_REMARK", nullable = true, length = 255)
    public String getUremiaSateGradeRemark() {
        return uremiaSateGradeRemark;
    }

    public void setUremiaSateGradeRemark(String uremiaSateGradeRemark) {
        this.uremiaSateGradeRemark = uremiaSateGradeRemark;
    }

    @Basic
    @Column(name = "DN_SATE_GRADE", nullable = true)
    public Integer getDnSateGrade() {
        return dnSateGrade;
    }

    public void setDnSateGrade(Integer dnSateGrade) {
        this.dnSateGrade = dnSateGrade;
    }

    @Basic
    @Column(name = "DN_SATE_GRADE_REMARK", nullable = true, length = 255)
    public String getDnSateGradeRemark() {
        return dnSateGradeRemark;
    }

    public void setDnSateGradeRemark(String dnSateGradeRemark) {
        this.dnSateGradeRemark = dnSateGradeRemark;
    }

    @Basic
    @Column(name = "IGA_SATE_GRADE", nullable = true)
    public Integer getIgaSateGrade() {
        return igaSateGrade;
    }

    public void setIgaSateGrade(Integer igaSateGrade) {
        this.igaSateGrade = igaSateGrade;
    }

    @Basic
    @Column(name = "IGA_SATE_GRADE_REMARK", nullable = true, length = 255)
    public String getIgaSateGradeRemark() {
        return igaSateGradeRemark;
    }

    public void setIgaSateGradeRemark(String igaSateGradeRemark) {
        this.igaSateGradeRemark = igaSateGradeRemark;
    }

    @Basic
    @Column(name = "MA_SATE_GRADE", nullable = true)
    public Integer getMaSateGrade() {
        return maSateGrade;
    }

    public void setMaSateGrade(Integer maSateGrade) {
        this.maSateGrade = maSateGrade;
    }

    @Basic
    @Column(name = "MA_SATE_GRADE_REMARK", nullable = true, length = 255)
    public String getMaSateGradeRemark() {
        return maSateGradeRemark;
    }

    public void setMaSateGradeRemark(String maSateGradeRemark) {
        this.maSateGradeRemark = maSateGradeRemark;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = true, length = 32)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodFoodEntity that = (FoodFoodEntity) o;

        if (id != that.id) return false;
        if (foodKindId != null ? !foodKindId.equals(that.foodKindId) : that.foodKindId != null) return false;
        if (foodCode != null ? !foodCode.equals(that.foodCode) : that.foodCode != null) return false;
        if (foodCnName != null ? !foodCnName.equals(that.foodCnName) : that.foodCnName != null) return false;
        if (foodEnName != null ? !foodEnName.equals(that.foodEnName) : that.foodEnName != null) return false;
        if (foodAlias != null ? !foodAlias.equals(that.foodAlias) : that.foodAlias != null) return false;
        if (thumbImageUrl != null ? !thumbImageUrl.equals(that.thumbImageUrl) : that.thumbImageUrl != null)
            return false;
        if (isLiquid != null ? !isLiquid.equals(that.isLiquid) : that.isLiquid != null) return false;
        if (healthLight != null ? !healthLight.equals(that.healthLight) : that.healthLight != null) return false;
        if (healthLightGradeRemark != null ? !healthLightGradeRemark.equals(that.healthLightGradeRemark) : that.healthLightGradeRemark != null)
            return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (calory != null ? !calory.equals(that.calory) : that.calory != null) return false;
        if (caloryStateRemark != null ? !caloryStateRemark.equals(that.caloryStateRemark) : that.caloryStateRemark != null)
            return false;
        if (fat != null ? !fat.equals(that.fat) : that.fat != null) return false;
        if (fatStateRemark != null ? !fatStateRemark.equals(that.fatStateRemark) : that.fatStateRemark != null)
            return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (fiberDietary != null ? !fiberDietary.equals(that.fiberDietary) : that.fiberDietary != null) return false;
        if (carbohydrate != null ? !carbohydrate.equals(that.carbohydrate) : that.carbohydrate != null) return false;
        if (vitaminA != null ? !vitaminA.equals(that.vitaminA) : that.vitaminA != null) return false;
        if (thiamine != null ? !thiamine.equals(that.thiamine) : that.thiamine != null) return false;
        if (lactoflavin != null ? !lactoflavin.equals(that.lactoflavin) : that.lactoflavin != null) return false;
        if (vitaminC != null ? !vitaminC.equals(that.vitaminC) : that.vitaminC != null) return false;
        if (vitaminE != null ? !vitaminE.equals(that.vitaminE) : that.vitaminE != null) return false;
        if (niacin != null ? !niacin.equals(that.niacin) : that.niacin != null) return false;
        if (natrium != null ? !natrium.equals(that.natrium) : that.natrium != null) return false;
        if (calcium != null ? !calcium.equals(that.calcium) : that.calcium != null) return false;
        if (iron != null ? !iron.equals(that.iron) : that.iron != null) return false;
        if (kalium != null ? !kalium.equals(that.kalium) : that.kalium != null) return false;
        if (iodine != null ? !iodine.equals(that.iodine) : that.iodine != null) return false;
        if (zinc != null ? !zinc.equals(that.zinc) : that.zinc != null) return false;
        if (selenium != null ? !selenium.equals(that.selenium) : that.selenium != null) return false;
        if (magnesium != null ? !magnesium.equals(that.magnesium) : that.magnesium != null) return false;
        if (copper != null ? !copper.equals(that.copper) : that.copper != null) return false;
        if (manganese != null ? !manganese.equals(that.manganese) : that.manganese != null) return false;
        if (cholesterol != null ? !cholesterol.equals(that.cholesterol) : that.cholesterol != null) return false;
        if (gl != null ? !gl.equals(that.gl) : that.gl != null) return false;
        if (glStateRemark != null ? !glStateRemark.equals(that.glStateRemark) : that.glStateRemark != null)
            return false;
        if (gi != null ? !gi.equals(that.gi) : that.gi != null) return false;
        if (giStateRemark != null ? !giStateRemark.equals(that.giStateRemark) : that.giStateRemark != null)
            return false;
        if (uremiaSateGrade != null ? !uremiaSateGrade.equals(that.uremiaSateGrade) : that.uremiaSateGrade != null)
            return false;
        if (uremiaSateGradeRemark != null ? !uremiaSateGradeRemark.equals(that.uremiaSateGradeRemark) : that.uremiaSateGradeRemark != null)
            return false;
        if (dnSateGrade != null ? !dnSateGrade.equals(that.dnSateGrade) : that.dnSateGrade != null) return false;
        if (dnSateGradeRemark != null ? !dnSateGradeRemark.equals(that.dnSateGradeRemark) : that.dnSateGradeRemark != null)
            return false;
        if (igaSateGrade != null ? !igaSateGrade.equals(that.igaSateGrade) : that.igaSateGrade != null) return false;
        if (igaSateGradeRemark != null ? !igaSateGradeRemark.equals(that.igaSateGradeRemark) : that.igaSateGradeRemark != null)
            return false;
        if (maSateGrade != null ? !maSateGrade.equals(that.maSateGrade) : that.maSateGrade != null) return false;
        if (maSateGradeRemark != null ? !maSateGradeRemark.equals(that.maSateGradeRemark) : that.maSateGradeRemark != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foodKindId != null ? foodKindId.hashCode() : 0);
        result = 31 * result + (foodCode != null ? foodCode.hashCode() : 0);
        result = 31 * result + (foodCnName != null ? foodCnName.hashCode() : 0);
        result = 31 * result + (foodEnName != null ? foodEnName.hashCode() : 0);
        result = 31 * result + (foodAlias != null ? foodAlias.hashCode() : 0);
        result = 31 * result + (thumbImageUrl != null ? thumbImageUrl.hashCode() : 0);
        result = 31 * result + (isLiquid != null ? isLiquid.hashCode() : 0);
        result = 31 * result + (healthLight != null ? healthLight.hashCode() : 0);
        result = 31 * result + (healthLightGradeRemark != null ? healthLightGradeRemark.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (calory != null ? calory.hashCode() : 0);
        result = 31 * result + (caloryStateRemark != null ? caloryStateRemark.hashCode() : 0);
        result = 31 * result + (fat != null ? fat.hashCode() : 0);
        result = 31 * result + (fatStateRemark != null ? fatStateRemark.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (fiberDietary != null ? fiberDietary.hashCode() : 0);
        result = 31 * result + (carbohydrate != null ? carbohydrate.hashCode() : 0);
        result = 31 * result + (vitaminA != null ? vitaminA.hashCode() : 0);
        result = 31 * result + (thiamine != null ? thiamine.hashCode() : 0);
        result = 31 * result + (lactoflavin != null ? lactoflavin.hashCode() : 0);
        result = 31 * result + (vitaminC != null ? vitaminC.hashCode() : 0);
        result = 31 * result + (vitaminE != null ? vitaminE.hashCode() : 0);
        result = 31 * result + (niacin != null ? niacin.hashCode() : 0);
        result = 31 * result + (natrium != null ? natrium.hashCode() : 0);
        result = 31 * result + (calcium != null ? calcium.hashCode() : 0);
        result = 31 * result + (iron != null ? iron.hashCode() : 0);
        result = 31 * result + (kalium != null ? kalium.hashCode() : 0);
        result = 31 * result + (iodine != null ? iodine.hashCode() : 0);
        result = 31 * result + (zinc != null ? zinc.hashCode() : 0);
        result = 31 * result + (selenium != null ? selenium.hashCode() : 0);
        result = 31 * result + (magnesium != null ? magnesium.hashCode() : 0);
        result = 31 * result + (copper != null ? copper.hashCode() : 0);
        result = 31 * result + (manganese != null ? manganese.hashCode() : 0);
        result = 31 * result + (cholesterol != null ? cholesterol.hashCode() : 0);
        result = 31 * result + (gl != null ? gl.hashCode() : 0);
        result = 31 * result + (glStateRemark != null ? glStateRemark.hashCode() : 0);
        result = 31 * result + (gi != null ? gi.hashCode() : 0);
        result = 31 * result + (giStateRemark != null ? giStateRemark.hashCode() : 0);
        result = 31 * result + (uremiaSateGrade != null ? uremiaSateGrade.hashCode() : 0);
        result = 31 * result + (uremiaSateGradeRemark != null ? uremiaSateGradeRemark.hashCode() : 0);
        result = 31 * result + (dnSateGrade != null ? dnSateGrade.hashCode() : 0);
        result = 31 * result + (dnSateGradeRemark != null ? dnSateGradeRemark.hashCode() : 0);
        result = 31 * result + (igaSateGrade != null ? igaSateGrade.hashCode() : 0);
        result = 31 * result + (igaSateGradeRemark != null ? igaSateGradeRemark.hashCode() : 0);
        result = 31 * result + (maSateGrade != null ? maSateGrade.hashCode() : 0);
        result = 31 * result + (maSateGradeRemark != null ? maSateGradeRemark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
