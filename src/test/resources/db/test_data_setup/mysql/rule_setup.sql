INSERT INTO rule_config (rule_module, rule_sql, rule_description, rule_action_flag, rule_key, sort_order)
VALUES
	('Email', 'select count(o.id) from system_order o where order_type = \'PREMIUM\' and o.id = ', 'Premium Email for Premium Orders', 1, 'email.premium', 10),
	('Email', 'select count(o.id) from system_order o join customer c on o.customer_id = c.id where order_type = \'STANDARD\' and c.age >= 50 and o.id = ', 'Standard Email with offers For Standard Orders of Senior Citizens', 1, 'email.standard.seniors', 20),
	('Email', 'select count(o.id) from system_order o join customer c on o.customer_id = c.id where order_type = \'STANDARD\' and c.age < 50 and o.id = ', 'Standard Email with offers For Standard Orders all others', 1, 'email.standard', 30);