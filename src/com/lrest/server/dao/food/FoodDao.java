package com.lrest.server.dao.food;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lrest.server.dao.BaseDao;
import com.lrest.server.entity.food.FoodFoodEntity;
import com.lrest.server.services.Config;
import com.lrest.server.services.DB;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.lrest.server.utils.DBUtils.dataChangeJsonArray;
import static com.lrest.server.utils.DBUtils.dataChangeJsonObject;

/**
 * Created by Administrator on 2017/7/23.
 */
public class FoodDao extends BaseDao<FoodFoodEntity>{

    /**
     @Describe:
     @Return: 查询出所有的食物列表
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/23 16:33
    */
    public JsonArray findAllFoodByQuery(
            DSLContext create,Integer page,Integer pagenum, Integer foodKindId,String foodType,String foodKindName,
            Integer foodId,String foodName ) {
        try {
            create.transaction((Configuration configuration) -> {

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");

                sql.append(" foodKind.FOOD_TYPE AS foodType, \n");
                sql.append(" foodKind.ID AS foodKindId, \n");

                sql.append(" food.ID AS id, \n");
                sql.append(" food.FOOD_KIND_ID AS foodKindId, \n");
                sql.append(" food.FOOD_CODE AS foodCode, \n");
                sql.append(" food.FOOD_CN_NAME AS foodCnName, \n");
                sql.append(" food.FOOD_EN_NAME AS foodEnName, \n");
                sql.append(" food.FOOD_ALIAS AS foodAlias, \n");

                sql.append(" CASE \n");
                sql.append(" WHEN food.THUMB_IMAGE_URL IS NULL THEN NULL \n");
                sql.append(" ELSE CONCAT('" + Config.OSS + "',REPLACE(food.THUMB_IMAGE_URL,\"type\",\"small\")) \n");
                sql.append(" END AS thumbImageUrl, \n");

                sql.append(" food.IS_LIQUID AS isLiquid, \n");
                sql.append(" food.HEALTH_LIGHT AS healthLight, \n");
                sql.append(" food.WEIGHT AS weight, \n");
                sql.append(" food.CALORY AS calory, \n");
                sql.append(" food.FAT AS fat, \n");
                sql.append(" food.PROTEIN AS protein, \n");
                sql.append(" food.FIBER_DIETARY AS fiberDietary, \n");
                sql.append(" food.CARBOHYDRATE AS carbohydrate, \n");
                sql.append(" food.VITAMIN_A AS vitaminA, \n");
                sql.append(" food.THIAMINE AS thiamine, \n");
                sql.append(" food.LACTOFLAVIN AS lactoflavin, \n");
                sql.append(" food.VITAMIN_C AS vitaminC, \n");
                sql.append(" food.VITAMIN_E AS vitaminE, \n");
                sql.append(" food.NIACIN AS niacin, \n");
                sql.append(" food.NATRIUM AS natrium, \n");
                sql.append(" food.CALCIUM AS calcium, \n");
                sql.append(" food.IRON AS iron, \n");
                sql.append(" food.KALIUM AS kalium, \n");
                sql.append(" food.IODINE AS iodine, \n");
                sql.append(" food.ZINC AS zinc, \n");
                sql.append(" food.SELENIUM AS selenium, \n");
                sql.append(" food.MAGNESIUM AS magnesium, \n");
                sql.append(" food.COPPER AS copper, \n");
                sql.append(" food.MANGANESE AS manganese, \n");
                sql.append(" food.CHOLESTEROL AS cholesterol, \n");
                sql.append(" foodKind.FOOD_TYPE AS foodType, \n");
                sql.append(" foodKind.FOOD_KIND_NAME AS foodKindName \n");

                sql.append(" FROM food_food AS food \n");
                sql.append(" LEFT JOIN food_food_kind AS foodKind ON food.FOOD_KIND_ID = foodKind.ID \n");
                sql.append(" WHERE 1 = 1 \n");

                if (null != foodKindName && !foodKindName.equals("")) {
                    sql.append(" AND foodKind.FOOD_KIND_NAME LIKE '%" + foodKindName + "%' \n");
                }
                if (null != foodType && !foodType.equals("")) {
                    sql.append(" AND foodKind.FOOD_TYPE = '" + foodType + "' \n");
                }
                if (-1 != foodKindId) {
                    sql.append(" AND foodKind.ID = '" + foodKindId + "' \n");
                }
                if (-1 != foodId) {
                    sql.append(" AND food.ID = '" + foodId + "'\n");
                }

                if (null != foodName && !foodName.equals("")) {
                    sql.append(" AND (food.FOOD_CN_NAME LIKE '%" + foodName + "%' OR food.FOOD_EN_NAME LIKE '%" + foodName + "%' OR food.FOOD_ALIAS LIKE '%" + foodName + "%') \n");
                }
                sql.append(" ORDER BY food.FOOD_CN_NAME \n");

                if (-1 != pagenum) {
                    sql.append("LIMIT " + (page - 1) * pagenum + "," + pagenum);
                }
                long a1 = System.currentTimeMillis();
                Result<Record> record = create.fetch(sql.toString());
                long a = System.currentTimeMillis();
                System.out.print("输出需要SQL的时间: ");
                System.out.println(a1 - a);

                this.jsonArray = dataChangeJsonArray(record);
                System.out.print("输出转化的时间: ");
                System.out.println(a - System.currentTimeMillis());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.jsonArray;
    }



    /**
     @Describe:
     @Return: 查询出所有的食物列表
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/23 16:33
     */
    public JsonObject findAllFoodByQueryCount(DSLContext create,Integer foodKindId, String foodType, String foodKindName, Integer foodId, String foodName ) {
        try {
            create.transaction((Configuration configuration) -> {

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");
                sql.append(" COUNT(0) AS cnt\n \n");

                sql.append(" FROM food_food AS food \n");
                sql.append(" LEFT JOIN food_food_kind AS foodKind ON food.FOOD_KIND_ID = foodKind.ID \n");
                sql.append(" WHERE 1 = 1 \n");

                if (null != foodKindName) {
                    sql.append(" AND foodKind.FOOD_KIND_NAME LIKE '%" + foodKindName + "%' \n");
                }
                if (null != foodType) {
                    sql.append(" AND foodKind.FOOD_TYPE = '" + foodType + "' \n");
                }
                if (-1 != foodKindId) {
                    sql.append(" AND foodKind.ID = '" + foodKindId + "' \n");
                }
                if (-1 != foodId) {
                    sql.append(" AND food.ID = '" + foodId + "'\n");
                }

                if (null != foodName && !foodName.equals("")) {
                    sql.append(" AND (food.FOOD_CN_NAME LIKE '%" + foodName + "%' OR food.FOOD_EN_NAME LIKE '%" + foodName + "%' OR food.FOOD_ALIAS LIKE '%" + foodName + "%') \n");
                }
                sql.append(" ORDER BY food.FOOD_CN_NAME \n");

                long a1 = System.currentTimeMillis();
                Record record = create.fetchOne(sql.toString());
                long a = System.currentTimeMillis();
                System.out.print("输出需要SQL的时间: ");
                System.out.println(a1 - a);

                this.jsonObject = dataChangeJsonObject(record);
                System.out.print("输出转化的时间: ");
                System.out.println(a - System.currentTimeMillis());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.jsonObject;
    }

}
