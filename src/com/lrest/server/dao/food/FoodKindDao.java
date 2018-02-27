package com.lrest.server.dao.food;

import com.google.gson.JsonArray;
import com.lrest.server.dao.BaseDao;
import com.lrest.server.entity.food.FoodFoodKindEntity;
import com.lrest.server.services.Config;
import com.lrest.server.services.DB;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.lrest.server.utils.DBUtils.dataChangeJsonArray;

public class FoodKindDao extends BaseDao<FoodFoodKindEntity> {


    /**
     @Describe:
     @Return:  根据食物大类名称和食物大类类别 找到食物大类
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/22 15:57
    */
    public JsonArray findAllFoodKindByFoodTypeAndName(
            Integer page,Integer pagenum, String foodType,String foodKindName) {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");
                sql.append(" foodKind.ID AS id, \n");
                sql.append(" foodKind.FOOD_KIND_NAME AS foodKindName, \n");
                sql.append(" CASE \n");
                sql.append(" WHEN foodKind.IMAGE_URL IS NULL THEN NULL \n");
                sql.append(" ELSE CONCAT('" + Config.OSS + "',REPLACE(foodKind.IMAGE_URL,\"type\",\"small\")) \n");
                sql.append(" END AS imageUrl, \n");
                sql.append(" foodKind.DESCRIPTION AS description, \n");
                sql.append(" foodKind.FOOD_TYPE AS foodKind \n");

                sql.append(" FROM  food_food_kind AS foodKind \n");
                sql.append(" WHERE 1 = 1 \n");
                if (null != foodType) {
                    sql.append(" AND foodKind.FOOD_TYPE = '" +  foodType + "' \n");
                }
                if (null != foodKindName && !foodKindName.equals("")) {
                    sql.append(" AND foodKind.FOOD_KIND_NAME LIKE '%" + foodKindName + "%' \n");
                }
                sql.append(" ORDER BY foodKind.FOOD_KIND_NAME \n");
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


    public JsonArray findAllFoodKindType() {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");
                sql.append(" foodKind.ID AS id, \n");
                sql.append(" foodKind.FOOD_TYPE AS foodKind \n");
                sql.append(" FROM  food_food_kind AS foodKind \n");
                sql.append(" WHERE 1 = 1 \n");
                sql.append(" GROUP BY foodKind.FOOD_TYPE \n");
                sql.append(" ORDER BY foodKind.id \n");
                Result<Record> record = create.fetch(sql.toString());
                this.jsonArray = dataChangeJsonArray(record);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.jsonArray;
    }
}
