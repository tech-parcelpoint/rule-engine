CREATE SEQUENCE seq_rule_config START WITH 1 INCREMENT BY 1;

CREATE TABLE rule_config(
	id NUMBER(5) NOT NULL PRIMARY KEY,
	rule_module varchar2(100) NOT NULL,
	rule_sql varchar2(2000) NOT NULL,
	rule_description varchar2(1000) NOT NULL,
	rule_action_flag NUMBER(1) DEFAULT 1,
	rule_key varchar2(100) NOT NULL,
	sort_order NUMBER(5) NOT NULL
);

INSERT INTO rule_config (id, rule_module, rule_sql, rule_description, rule_action_flag, rule_key, sort_order)
VALUES
	 (0, "No Module", "select 1", "No Matching rule found", 0, "no_action", 0);

UPDATE rule_config
   SET id = 0
 WHERE rule_module = "No Module";
