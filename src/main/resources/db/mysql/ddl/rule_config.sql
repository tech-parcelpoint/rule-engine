drop table if exists rule_config;

create table rule_config(
	id bigint(20) primary key not null auto_increment,
	rule_module varchar(100) not null,
	rule_sql varchar(2000),
	rule_description varchar(1000),
	rule_action_flag tinyint(1) DEFAULT 1,
	rule_key varchar(100) null,
	sort_order bigint(20)
);

INSERT INTO rule_config (rule_module, rule_sql, rule_description, rule_action_flag, rule_key, sort_order)
VALUES
	 ('No Module', 'select 1', 'No Matching rule found', 0, 'no_action', 0);

UPDATE rule_config
   SET id = 0
 WHERE rule_module = 'No Module';
