USE highlight ;

# CREATE TABLE users (
#                     id BIGINT NOT NULL AUTO_INCREMENT,
#                     username VARCHAR(100) NOT NULL,
#                     password VARCHAR(255) NOT NULL,
#                     email VARCHAR(255) NOT NULL,
#                     create_time DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
#                     PRIMARY KEY (id),
#                     UNIQUE KEY (username)
# );
# INSERT INTO group_collection (create_time, description, group_name, open, strict, size)
# VALUES (CURRENT_TIMESTAMP ,'this is test this is test', 'We do', true, false, 10);
#
# INSERT INTO group_collection (create_time, description, group_name, open, strict, size) VALUES (CURRENT_TIMESTAMP ,'all about cats', 'muris', true, true, 10);

# INSERT INTO users (create_time, email, password, role, username)
# VALUES (current_timestamp(),'admin1@gmail.com','need to be encrypted by BCryptEncoder - better I will do it through DbInitializer','ADMIN','admin1.name')

# INSERT INTO users (username, password, email,  role)
# VALUES ('admin','$2a$12$I0f8HXsBiaPwmfB2xV8p8e1fzFWDhxs/BR51RWnAceL7MbGb86dqK', 'admin@admin.lv',
#         'ADMIN')
