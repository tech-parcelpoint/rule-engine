DROP PROCEDURE IF EXISTS execute_rule_engine;

DELIMITER |
CREATE PROCEDURE execute_rule_engine(IN p_rule_module VARCHAR(50), IN p_parcel_id VARCHAR(20), OUT p_rule_id INTEGER)
BEGIN
	DECLARE v_count INTEGER DEFAULT 0;
	DECLARE v_exit INTEGER DEFAULT 0;	
	DECLARE v_sql VARCHAR(2000);
	DECLARE v_rule_key VARCHAR(100);
	DECLARE v_rule_id INTEGER;

   DECLARE csr_rule_config CURSOR 
   FOR 
     SELECT rc.rule_sql, rc.rule_key, rc.id
       FROM rule_config rc
      WHERE rule_module = p_rule_module
   ORDER BY rc.sort_order asc; 

	DECLARE CONTINUE HANDLER 
    FOR NOT FOUND SET v_exit = 1;

	OPEN csr_rule_config;

	execute_rule: LOOP
		FETCH csr_rule_config INTO v_sql, v_rule_key, p_rule_id;
		
		IF v_exit = 1 THEN 
            LEAVE execute_rule;
        END IF;
		
		SET @SQL = REPLACE(v_sql, 'select p.id from parcel', 'select count(p.id) into @tmp_parcel_id from parcel');	
		
		SET @SQL = CONCAT(@SQL, "'", p_parcel_id, "'"); 		

		PREPARE v_sql FROM @SQL;

 		EXECUTE v_sql;
	
		SET v_count = @tmp_parcel_id;
		
		IF v_count > 0 
		THEN
			LEAVE execute_rule;
		ELSE	
			SET p_rule_id = 0;
		END IF;

	END LOOP execute_rule;
	
	SELECT p_rule_id;
END|
DELIMITER ;