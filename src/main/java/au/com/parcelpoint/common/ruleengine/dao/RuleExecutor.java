package au.com.parcelpoint.common.ruleengine.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code RuleExecutor} class is a DAO layer class that is used for executing the rule.
 * It calls the execute_rule_engine stored procedure with ruleModule, entityId and returns with the id of the "hit" rule.
 *
 */

@Repository
@Transactional
@Slf4j
public class RuleExecutor {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RuleExecutor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }


    public Long executeRuleUsingProc(String ruleModule, String entityId){
        log.info("Executing rules for module {} and entity {}", ruleModule, entityId);
        SimpleJdbcCall storedProcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("execute_rule_engine");

        storedProcCall.addDeclaredParameter(new SqlParameter("p_rule_module", Types.VARCHAR));
        storedProcCall.addDeclaredParameter(new SqlParameter("p_entity_id", Types.VARCHAR));
        storedProcCall.addDeclaredParameter(new SqlOutParameter("p_rule_id", Types.BIGINT));


        Map<String, String> callParams = new HashMap<>();
        callParams.put("p_rule_module", ruleModule);
        callParams.put("p_entity_id", entityId);
        Map<String, Object> outputMap = storedProcCall.execute(callParams);


        return (Long)outputMap.get("p_rule_id");

    }

}
