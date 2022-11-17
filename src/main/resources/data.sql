USE highlight ;
INSERT INTO group_collection (create_time, description, group_name, open, strict, size)
VALUES (current_timestamp() ,'this is test this is test', 'We do', true, false, 10);

INSERT INTO group_collection (create_time, description, group_name, open, strict, size) VALUES (current_timestamp() ,'all about cats', 'muris', true, true, 10);

# INSERT INTO users (create_time, email, password, role, username)
# VALUES (current_timestamp(),'admin1@gmail.com','need to be encrypted by BCryptEncoder - better I will do it through DbInitializer','ADMIN','admin1.name')
