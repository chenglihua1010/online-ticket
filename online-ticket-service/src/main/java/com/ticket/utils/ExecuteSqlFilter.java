package com.ticket.utils;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.ResultSetProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.ticket.entity.DaoExecuteLog;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangwu on 2020/8/10.
 */
public class ExecuteSqlFilter extends FilterEventAdapter {
        private SQLUtils.FormatOption statementSqlFormatOption = new SQLUtils.FormatOption(false, true);
        private static final Logger logger = LoggerFactory.getLogger(FilterEventAdapter.class);
        protected void statementLog(String message) {
                try {
                        String sql = StringUtils.trim(message);
                        System.out.println("过滤的sql为"+sql);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }


        @Override
        public ResultSetProxy preparedStatement_executeQuery(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
                if(true){
                        long startTimeStamp = System.currentTimeMillis();
                        try {
                                ResultSetProxy resultSetProxy = super.preparedStatement_executeQuery(chain, statement);
                                return resultSetProxy;
                        } catch (SQLException e) {
                                DaoExecuteLog dalEntity = createErrorDaoExecuteLog(startTimeStamp,statement,e);
                                logger.info("报错啦 string=[{}]", JSONUtils.toJSONString(dalEntity));
                                throw e;
                        } finally {
                        }
                }else {
                        return super.preparedStatement_executeQuery(chain,statement);
                }
        }

        private DaoExecuteLog createErrorDaoExecuteLog(long reqTime,PreparedStatementProxy statement,Exception e){
                long resTime = System.currentTimeMillis();
                DaoExecuteLog dalEntity = assembleDalEntity(statement);
                dalEntity.setReqTime(reqTime);
                dalEntity.setResTime(resTime);
                dalEntity.setCostMilliSeconds(resTime - reqTime);
                dalEntity.setSucceed(0);
                dalEntity.setExceptionMsg(e.getMessage());
                dalEntity.setExceptionStackTrace(newStList(e.getStackTrace()));
                return dalEntity;
        }

        @Override
        public boolean preparedStatement_execute(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
                if(true) {
                        long startTimeStamp = System.currentTimeMillis();
                        try {
                                boolean resultSetProxy = super.preparedStatement_execute(chain, statement);
                                return resultSetProxy;
                        } catch (Exception e) {
                                DaoExecuteLog dalEntity = createErrorDaoExecuteLog(startTimeStamp,statement,e);
                                logger.info("报错啦 string=[{}]", JSONObject.toJSONString(dalEntity));
                                 throw new IllegalArgumentException("报错了呀");
                        } finally {
                        }
                }else{
                        return super.preparedStatement_execute(chain, statement);
                }
        }


        @Override
        public int preparedStatement_executeUpdate(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
                if(true) {
                        long startTimeStamp = System.currentTimeMillis();
                        try {
                                int resultSetProxy = super.preparedStatement_executeUpdate(chain, statement);
                                return resultSetProxy;
                        } catch (SQLException e) {
                                DaoExecuteLog dalEntity = createErrorDaoExecuteLog(startTimeStamp,statement,e);
                                logger.info("报错啦 string=[{}]", JSONUtils.toJSONString(dalEntity));
                                throw e;
                        } finally {
                        }
                }else{
                        return super.preparedStatement_executeUpdate(chain, statement);
                }
        }


        //报错之后会执行的方法
        //@Override
        //protected void statement_executeErrorAfter(StatementProxy statement, String sql, Throwable error) {
        //        if(true) {
        //
        //                long startTimeStamp = System.currentTimeMillis();
        //                try {
        //                        DaoExecuteLog dalEntity = createErrorDaoExecuteLog(startTimeStamp, (PreparedStatementProxy) statement, new Exception(error));
        //                        logger.info("报错啦 string=[{}]", JSONUtils.toJSONString(dalEntity));
        //                } catch (Exception e) {
        //                        logger.info("报错啦 string=[{}]", JSONUtils.toJSONString("xixi"));
        //                } finally {
        //                }
        //        }else{
        //                 super.statement_executeErrorAfter(statement,sql,error);
        //        }
        //}


        private DaoExecuteLog assembleDalEntity(PreparedStatementProxy statement) {
                DaoExecuteLog de = new DaoExecuteLog();
                if(!ObjectUtils.isEmpty(ContextUtils.getContext().get())){
                        de=(DaoExecuteLog)ContextUtils.getContext().get().get("daoExecuteLog");
                }
                String sqlText = statement.getRawObject().toString();
                de.setSqlText(sqlText.substring(sqlText.indexOf(":") + 1));
                de.setCreateTime(new Date());
                return de;
        }


        private String newStList(StackTraceElement[] stackTrace) {
                List<String> list = new ArrayList<>(stackTrace.length);
                for (StackTraceElement st : stackTrace) {
                        list.add(st.toString());
                }
                return list.toString();
        }

        @Override
        protected void statementExecuteUpdateAfter(StatementProxy statement, String sql, int updateCount) {
                logExecutableSql(statement, sql);
        }

        @Override
        protected void statementExecuteAfter(StatementProxy statement, String sql, boolean firstResult) {
                logExecutableSql(statement, sql);
        }

        @Override
        protected void statementExecuteQueryAfter(StatementProxy statement, String sql, ResultSetProxy resultSet) {
                logExecutableSql(statement, sql);
        }

        @Override
        protected void statementExecuteBatchAfter(StatementProxy statement, int[] result) {
                if (statement instanceof PreparedStatementProxy) {
                        String sql = ((PreparedStatementProxy) statement).getSql();
                        logBatchExecutableSql(statement, sql);
                }
                List<String> sqls = statement.getBatchSqlList();
                if (sqls != null) {
                        for (String sql : sqls) {
                                logExecutableSql(statement, sql);
                        }
                }
        }

        private static final String BATCH_PSTMT_ARGS = "batch-pstmt-args";

        @Override
        public void preparedStatement_addBatch(FilterChain chain, PreparedStatementProxy statement) throws SQLException {
                List<Object> parameters = formatParameters(statement);
                List<List<Object>> args = (List<List<Object>>) statement.getAttribute(BATCH_PSTMT_ARGS);
                if (args == null) {
                        args = new ArrayList<>();
                        statement.putAttribute(BATCH_PSTMT_ARGS, args);
                }
                args.add(parameters);
                super.preparedStatement_addBatch(chain, statement);
        }

        private void logBatchExecutableSql(StatementProxy statement, String sql) {
                List<List<Object>> args = (List<List<Object>>) statement.getAttribute(BATCH_PSTMT_ARGS);
                if (args != null && args.size() > 0) {
                        for (List<Object> parameters : args) {
                                String formattedSql = formattedSql(statement, sql, parameters);
                                statementLog(formattedSql);
                        }
                        args.clear();
                }
        }

        private void logExecutableSql(StatementProxy statement, String sql) {
                int parametersSize = statement.getParametersSize();
                if (parametersSize == 0) {
                        statementLog(sql);
                        return;
                }
                List<Object> parameters = formatParameters(statement);
                String formattedSql = formattedSql(statement, sql, parameters);
                statementLog(formattedSql);
        }

        private String formattedSql(StatementProxy statement, String sql, List<Object> parameters) {
                String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
                String formattedSql = SQLUtils.format(sql, dbType, parameters, this.statementSqlFormatOption);
                return formattedSql;
        }

        private List<Object> formatParameters(StatementProxy statement) {
                int parametersSize = statement.getParametersSize();
                List<Object> parameters = new ArrayList<Object>(parametersSize);
                for (int i = 0; i < parametersSize; ++i) {
                        JdbcParameter jdbcParam = statement.getParameter(i);
                        parameters.add(jdbcParam != null ? jdbcParam.getValue() : null);
                }
                return parameters;
        }
}


