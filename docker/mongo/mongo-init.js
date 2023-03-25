db.createUser(
        {
            user: "template_config",
            pwd: "template_pwd_conf",
            roles: [
                {
                    role: "readWrite",
                    db: "templates"
                }
            ]
        }
);
