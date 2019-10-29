package au.com.parcelpoint.common.ruleengine.service;

import au.com.parcelpoint.common.ruleengine.dao.RuleExecutor;
import au.com.parcelpoint.common.ruleengine.domain.RuleConfig;
import au.com.parcelpoint.common.ruleengine.repository.RuleConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RuleEngineService {


    private RuleConfigRepository ruleConfigRepository;

    private RuleExecutor ruleExecutorRepository;

    @Autowired
    RuleEngineService(RuleConfigRepository ruleConfigRepository, RuleExecutor ruleExecutorRepository){
        this.ruleConfigRepository = ruleConfigRepository;
        this.ruleExecutorRepository = ruleExecutorRepository;
    }


    public RuleConfig fireRulesForModuleAndEntity(String ruleModule, String entityId){
        log.info("Fetching rules for module {}", ruleModule);
        Long ruleId = ruleExecutorRepository.executeRuleUsingProc(ruleModule, entityId);

        return ruleConfigRepository.findById(ruleId).get();
    }
}
