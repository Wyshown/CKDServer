package com.lrest.server.dao.user;

import com.google.gson.JsonObject;
import com.lrest.server.dao.BaseDao;
import com.lrest.server.entity.user.TUserEntity;
import com.lrest.server.services.DB;
import com.tencent.common.MD5;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static com.lrest.server.utils.DBUtils.dataChangeJsonObject;
import static com.lrest.server.utils.UtilBase.getJsonAsString;

public class UserDao extends BaseDao<TUserEntity> {

    Integer resultINo = 0;

    public JsonObject doLogin(String loginName, String loginPwd) {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {

                StringBuffer sql = new StringBuffer();
                sql.append(" SELECT \n");
                sql.append(" u.id AS userId, \n");
                sql.append(" u.ROLE_NUM AS roleNum, \n");
                sql.append(" u.LOGIN_NAME AS loginName, \n");
                sql.append(" u.USER_NAME AS userName,HH \n");
                sql.append(" u.NICK_NAME AS nickName, \n");
                sql.append(" u.SEX AS sex, \n");
                sql.append(" u.CELLPHONE AS cellphone\n");

                sql.append(" FROM t_user AS u \n");
                sql.append(" WHERE u.LOGIN_NAME = '" + loginName + "' \n");
                sql.append(" AND u.LOGIN_PWD = '" + MD5.MD5Encode(loginPwd) + "' \n");
                sql.append(" LIMIT 1 \n");
                this.jsonObject = dataChangeJsonObject(create.fetchOne(sql.toString()));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.jsonObject;
    }




    public Integer doLogUp(String userId, String oldLoginPwd, String newLoginPwd) {
        try (Connection conn = DB.getConn();
             DSLContext create = DSL.using(conn, SQLDialect.MYSQL)) {
            create.transaction(configuration -> {

                this.jsonObject = this.findJonObjByPropery("id",userId);

                String loginPwd = getJsonAsString(this.jsonObject,"login_pwd");

                if (loginPwd.equals(MD5.MD5Encode(oldLoginPwd))) {
                    StringBuffer sql = new StringBuffer();
                    sql.append(" UPDATE t_user SET LOGIN_PWD = '" + MD5.MD5Encode(newLoginPwd) + "' WHERE ID = '" + userId + "' \n");
                    create.execute(sql.toString());
                    resultINo = 2;
                } else {
                    resultINo = 1;
                }
            });
        } catch (Exception e) {
            resultINo = 0;
            e.printStackTrace();
        }
        return resultINo;
    }
}
