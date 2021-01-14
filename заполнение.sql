--------------------------objtype----------------------------------------------------------
INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (1, 'Logger'); 		  --1

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (2, 'Entrance');  		  --2

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (3, 'E-key');     		  --3

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)  
VALUES (4, 'Type');	   		  --4

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (5, 'Role_To_Entance');  --5

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (6, 'Role'); 	   		  --6

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (7, 'Building'); 		  --7

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (8, 'Adress');    		  --8

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (9, 'User_To_Adress');   --9

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (10, 'User');  			  --10

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (11, 'Contact');  		  --11

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (12, 'Contact_Type');  	  --12

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (13, 'AD');  			  --13

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (14, 'Utility');  		  --14

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (15, 'Category');  		  --15

INSERT INTO objtype(OBJECT_TYPE_ID,CODE)
VALUES (16, 'Services');  		  --16

---------------------------------Attrtype Logger-------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (1, 1, 2, 'entrance_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (2, 1, 3, 'ekey_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (3, 1, 'date');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (4, 1, 'time');

--------------------------------Attrtype Entrance------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (5, 2, 4, 'type_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (6, 2, 'is_active');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (7, 2, 7, 'building_id');

--------------------------------Attrtype E_key---------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (8, 3, 'key');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (9, 3, 'is_active');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (10, 3, 10, 'user_id');

--------------------------------Attrtype Type---------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (11, 4, 'value');

--------------------------------Attrtype Role_To_Entance----------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (12, 5, 2, 'entrance_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (13, 5, 6, 'role_id');

--------------------------------Attrtype Role---------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (14, 6, 'role');

--------------------------------Attrtype Building-----------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (15, 7, 'number');

--------------------------------Attrtype Adress-------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (16, 8, 7, 'building_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (17, 8, 'flat');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (48, 8, 10,'user_id');

insert into ATTRTYPE(attr_id, object_type_id, object_type_id_ref, code, name)
VALUES (49, 8, null, 'apartment_number', null);

--------------------------------Attrtype User_To_Adress-----------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (19, 9, 10, 'user_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (20, 9, 8, 'adress_id');
--------------------------------Attrtype User---------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (21, 10, 'email');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (22, 10, 'password');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (23, 10, 'first_name');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (24, 10, 'last_name');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (25, 10, 'patronymic');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (26, 10, 'is_active');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (27, 10, 'recive_utility_notif');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (28, 10, 6, 'role_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (55, 10, 'activationCode');

--------------------------------Attrtype Contact------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (29, 11, 'value');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (30, 11, 12, 'contact_type_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (31, 11, 10, 'user_id');

--------------------------------Attrtype Contact_Type-------------------------------------

--------------------------------Attrtype AD-----------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (32, 13, 'text');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (33, 13, 'date');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (34, 13, 'title');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (35, 13, 15, 'category_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (36, 13, 'createdBy');

--------------------------------Attrtype Utility------------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (37, 14, 'bank_book');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (38, 14, 'month_and_year');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (39, 14, 'current_month_read');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (47, 14, 'last_month_read');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (40, 14, 'ammount_to_pay');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (41, 14, 'status');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (42, 14, 'photo_url');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (43, 14, 16, 'service_id');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE)
VALUES (18, 14, 8, 'adress_id');
--------------------------------Attrtype Category-----------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (44, 15, 'important');

--------------------------------Attrtype Services-----------------------------------------
INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (45, 16, 'title');

INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, CODE)
VALUES (46, 16, 'tariff');

--------------------------------Objects---------------------------------------------------
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 1);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID, name)
VALUES (OBJECTS_SEQ.NEXTVAL, 2, 'name');            --Entrance
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 3);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 4);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 5);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 6);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID, description)
VALUES (OBJECTS_SEQ.NEXTVAL, 7, 'description');		--Building
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 8);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 9);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 10);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 11);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID, name)
VALUES (OBJECTS_SEQ.NEXTVAL, 12, 'name'); 			--Contact_Type
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 13);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 14);
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID, name)
VALUES (OBJECTS_SEQ.NEXTVAL, 15, 'name'); 			--Category
INSERT INTO objects(OBJECT_ID, OBJECT_TYPE_ID)
VALUES (OBJECTS_SEQ.NEXTVAL, 16);

--------------------------------Attributes---------------------------------------------------

INSERT INTO attributes(attr_id, object_id, value)
VALUES (3, 1, '30.11.2020');						--Logger date
INSERT INTO attributes(attr_id, object_id, value)
VALUES (4, 1, '04:06');								--Logger time

INSERT INTO attributes(attr_id, object_id, value)
VALUES (6, 2, 'true');								--Entrance is_active

INSERT INTO attributes(attr_id, object_id, value)
VALUES (8, 3, 'quet#1534');							--E_key key
INSERT INTO attributes(attr_id, object_id, value)
VALUES (9, 3, 'true');								--E_key is_active

INSERT INTO attributes(attr_id, object_id, value)
VALUES (11, 4, 'value');							--Type value

INSERT INTO attributes(attr_id, object_id, value)
VALUES (14, 6, 'user');								--Role role

INSERT INTO attributes(attr_id, object_id, value)
VALUES (15, 7, '#7');								--Building number

INSERT INTO attributes(attr_id, object_id, value)
VALUES (17, 8, '44');								--Adress flat

INSERT INTO attributes(attr_id, object_id, value)
VALUES (21, 10, 'sobaka@sobaka.ua');			    --User email
INSERT INTO attributes(attr_id, object_id, value)
VALUES (22, 10, 'parol_ti_korol99');			    --User password
INSERT INTO attributes(attr_id, object_id, value)
VALUES (23, 10, 'Max');			    				--User first_name
INSERT INTO attributes(attr_id, object_id, value)
VALUES (24, 10, 'Romashenko');			    		--User last_name
INSERT INTO attributes(attr_id, object_id, value)
VALUES (25, 10, 'Aleksandrovich');			    	--User patronymic
INSERT INTO attributes(attr_id, object_id, value)
VALUES (26, 10, 'true');			    			--User is_active
INSERT INTO attributes(attr_id, object_id, value)
VALUES (27, 10, 'utility_notifications');			--User recive_utility_notif

INSERT INTO attributes(attr_id, object_id, value)
VALUES (29, 11, '99');			    				--Contact value

INSERT INTO attributes(attr_id, object_id, value)
VALUES (32, 13, 'text');			    			--AD text
INSERT INTO attributes(attr_id, object_id, value)
VALUES (33, 13, '20.12.2020');			    	    --AD date
INSERT INTO attributes(attr_id, object_id, value)
VALUES (34, 13, 'title');			    			--AD title
INSERT INTO attributes(attr_id, object_id, value)
VALUES (36, 13, 'Maxim');			    			--AD createdBy

INSERT INTO attributes(attr_id, object_id, value)
VALUES (37, 14, 'bank_book');			    		 --Utility bank_book
INSERT INTO attributes(attr_id, object_id, value)
VALUES (38, 14, '12.2020');			    		 	 --Utility month_and_year
INSERT INTO attributes(attr_id, object_id, value)
VALUES (39, 14, 'current_month_read');			     --Utility current_month_read
INSERT INTO attributes(attr_id, object_id, value)
VALUES (40, 14, 'ammount_to_pay');			         --Utility ammount_to_pay
INSERT INTO attributes(attr_id, object_id, value)
VALUES (41, 14, 'good?');			    		 	 --Utility status
INSERT INTO attributes(attr_id, object_id, value)
VALUES (42, 14, 'somePhote.url');			         --Utility photo_url

INSERT INTO attributes(attr_id, object_id, value)
VALUES (44, 15, 'false');			    		 	 --Category important

INSERT INTO attributes(attr_id, object_id, value)
VALUES (45, 16, 'title');			    			 --Services title
INSERT INTO attributes(attr_id, object_id, value)
VALUES (46, 16, 'tariff');			    			 --Services tariff

--------------------------------Objreference---------------------------------------------------
			------------Logger---------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (1, 1, 2);			--entrance_id 
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (2, 1, 3);			--ekey_id 

			------------Entrance-------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (5, 2, 4);			--type_id 
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (7, 2, 7);			--building_id 

			------------E_key----------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (10, 3, 10);			--user_id 

			------------Role_To_Entance------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (12, 5, 2);			--entrance_id 			
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (13, 5, 6);			--role_id 

			------------Adress---------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (16, 8, 7);			--building_id
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (18, 8, 14);			--role_id  

			------------User_To_Adress-------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (19, 9, 10);	 		--user_id
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (20, 9, 8);			--adress_id

			------------User---------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (28, 10, 6);	 		--role_id

			------------Contact------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (30, 11, 12);	 	--contact_type_id
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (31, 11, 10);	 	--user_id

			------------AD-----------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (35, 13, 15);	 	--category_id

			------------Utility------------
INSERT INTO objreference(attr_id, object_id, reference)
VALUES (43, 14, 16);	 	--service_id			
