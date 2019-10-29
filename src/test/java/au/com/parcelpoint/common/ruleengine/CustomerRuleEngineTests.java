package au.com.parcelpoint.common.ruleengine;

import au.com.parcelpoint.common.ruleengine.domain.RuleConfig;
import au.com.parcelpoint.common.ruleengine.service.RuleEngineService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuleEngineApplication.class)
public class CustomerRuleEngineTests {

    @Autowired
    private RuleEngineService ruleEngineService;


    @Test
    public void testPremiumRule() {
        RuleConfig ruleConfig =  ruleEngineService.fireRulesForModuleAndEntity("Customer", "1");
        Assert.assertEquals("Incorrect rule match", ruleConfig.getRuleDescription(), "Premium Email for Premium Orders");
    }



}
