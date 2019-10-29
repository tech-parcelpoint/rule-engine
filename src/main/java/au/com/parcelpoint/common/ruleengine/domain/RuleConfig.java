package au.com.parcelpoint.common.ruleengine.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/**
 * The {@code RuleConfig} class represents 1 rule. Its fields are as follows:
 * 1) A surrogate key field: "id"
 * 2) A field to categories rules: "ruleModule". Only rules in a particular ruleModule are executed in one execution cycle of the rule engine.
 * 3) A field containing the SQL for the rule: "ruleSql".
 * 4) A human readable description for the rule decision: "ruleDescription"
 * 5) A field that determines if the rule requires action or not: "ruleActionFlag"
 * 6) A key field to uniquely identify the rule: "ruleKey"
 * 7) A field that determines the order in which the rules are executed within a module: "sortOrder"
 */

@Entity
@Table(name = "rule_config")
@ToString
public class RuleConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @Getter
    private Long id;

    @Column(name = "rule_module")
    @Getter
    private String ruleModule;

    @Column(name = "rule_sql")
    @Getter
    private String ruleSql;

    @Column(name = "rule_description")
    @Getter
    private String ruleDescription;

    @Column(name = "rule_action_flag")
    @Getter
    private Boolean ruleActionFlag;

    @Column(name = "rule_key")
    @Getter
    private String ruleKey;

    @Column(name = "sort_order")
    private Long sortOrder;

}
