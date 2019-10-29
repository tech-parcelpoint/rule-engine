package au.com.parcelpoint.common.ruleengine.repository;

import au.com.parcelpoint.common.ruleengine.domain.RuleConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The {@code RuleConfigRepository} interface is a CRUD interface for the RuleConfig class.
 */

@Repository
public interface RuleConfigRepository extends CrudRepository<RuleConfig, Long> {

        @Cacheable(value = "ruleById")
        Optional<RuleConfig> findById(Long id);
}
