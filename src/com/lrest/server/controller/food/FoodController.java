package com.lrest.server.controller.food;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lrest.server.controller.BaseController;
import com.lrest.server.dao.food.FoodDao;
import com.lrest.server.services.DB;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;

import static com.lrest.server.utils.UtilBase.getJsonAsInt;
import static com.lrest.server.utils.UtilBase.getJsonAsString;

/**
 * Created by Administrator on 2017/7/18.
 */
@Path("/food")
public class FoodController extends BaseController {

    @Inject
    private FoodDao foodDao;

    /***
     * @param query
    {
        "page":"1",
        "pagenum":"10",
        "foodKindId":"1",
        "foodType":"1",
        "foodId":"1",
        "foodName":"1"
    }
     * @Description: 方法描述,必填  <br/>
     * @return: com.google.gson.JsonObject
     * @throw:
     * @author: @韩武洽 @Wyshown
     * @createTime: 2018/3/7 上午11:26
     * @Version: V1.0.0
     * @UpateLog :		Modifier		ModifyTime		Reason/Contents
     *             ---------------------------------------------------------
     *
    */
    @POST
    @Path("/findAllFoodByQuery")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject findAllFoodByQuery(String query) throws Exception {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {

            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            this.page = getJsonAsInt(this.jsonObject, "page");
            this.pagenum = getJsonAsInt(this.jsonObject, "pagenum");

            Integer foodKindId = getJsonAsInt(this.jsonObject, "foodKindId");
            String foodType = getJsonAsString(this.jsonObject, "foodType");
            String foodKindName = getJsonAsString(this.jsonObject, "foodKindName");
            Integer foodId = getJsonAsInt(this.jsonObject, "foodId");
            String foodName = getJsonAsString(this.jsonObject, "foodName");
            String orderName = getJsonAsString(this.jsonObject, "orderName");
            String orderSort = getJsonAsString(this.jsonObject, "orderSort");

            this.jsonArray = this.foodDao.findAllFoodByQuery(
                    create,this.page,this.pagenum,foodKindId,foodType,foodKindName,foodId,foodName,orderName,orderSort);
            this.count = this.foodDao.findAllFoodByQueryCount(create,foodKindId,foodType,foodKindName,foodId,foodName).get("cnt").getAsInt();
            return success(this.jsonArray,this.count);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }


    @POST
    @Path("/findFoodById")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject findFoodById(String query) throws Exception {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {

            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            Integer foodId = getJsonAsInt(this.jsonObject, "foodId");

            this.jsonObject = this.foodDao.findAllFoodByQuery(
                    create,-1,-1,-1,null,null,foodId,null,null,null).get(0).getAsJsonObject();
            return success(this.jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    @POST
    @Path("/saveFood")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject saveFood(String query) throws Exception {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {

            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            this.jsonObject = this.foodDao.getJsonByBean(this.jsonObject);
            this.foodDao.save(conn,this.jsonObject);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }

    @POST
    @Path("/updateFood")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject updateFood(String query) throws Exception {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {

            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            this.jsonObject = this.foodDao.getJsonByBean(this.jsonObject);
            this.foodDao.update(conn,this.jsonObject);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }



}
