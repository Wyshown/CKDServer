package com.lrest.server.controller.food;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lrest.server.controller.BaseController;
import com.lrest.server.dao.food.FoodKindDao;
import org.jooq.util.derby.sys.Sys;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.lrest.server.utils.UtilBase.getJsonAsInt;
import static com.lrest.server.utils.UtilBase.getJsonAsString;

/**
 * Created by Administrator on 2017/7/18.
 */
@Path("/foodKind")
public class FoodKindController extends BaseController {

    @Inject
    private FoodKindDao foodKindDao;

    /**
     @Describe:
     @Param:
     {
        "page":"1",
        "pagenum":"10",
        "foodType":"group",
        "foodKindName":"蔬菜"
     }
     @Return: 根据食物大类名称和食物大类类别 找到食物大类
     @Author: @韩武洽 @Wyshown
     @Date: 2017/7/22 16:14
    */
    @POST
    @Path("/findAllFoodKindByFoodTypeAndName")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JsonObject findAllFoodKindByFoodTypeAndName(String query) throws Exception {
        try {
            this.jsonObject = new JsonParser().parse(query).getAsJsonObject();
            this.page = getJsonAsInt(this.jsonObject, "page");
            this.pagenum = getJsonAsInt(this.jsonObject, "pagenum");
            String foodType = getJsonAsString(this.jsonObject, "foodType");
            String foodKindName = getJsonAsString(this.jsonObject, "foodKindName");

            long a1 = System.currentTimeMillis();
            this.jsonArray = this.foodKindDao.findAllFoodKindByFoodTypeAndName(
                    this.page,this.pagenum,foodType,foodKindName);

            System.out.print("输出转化111111111的时间: ");
            long a2 = System.currentTimeMillis();
            System.out.println(a1 - a2);


            this.count = this.foodKindDao.findAllFoodKindByFoodTypeAndName(
                    -1,-1,foodType,foodKindName).size();
            long a3 = System.currentTimeMillis();
            System.out.print("输出转化1111111122222221的时间: ");
            System.out.println(a2 - a3);
            return  success(this.jsonArray,this.count);
        } catch (Exception e) {
            e.printStackTrace();
            return error();
        }
    }
}
