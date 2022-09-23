CREATE TABLE `ssb`.`entry_table`( 
    `id` BIGINT NOT NULL AUTO_INCREMENT
    , `name` VARCHAR (100) NULL
    , `nationality` VARCHAR (50) NULL
    , `gender` VARCHAR (50) NULL
    , `date_Of_Year` VARCHAR (100) NULL
    , `date_Of_Month` VARCHAR (100) NULL
    , `date_Of_Day` VARCHAR (100) NULL
    , `merriage` VARCHAR (100) NULL
    , `email` VARCHAR (100) NULL
    , `mobile_No1` VARCHAR (100) NULL
    , `mobile_No2` VARCHAR (100) NULL
    , `mobile_No3` VARCHAR (100) NULL
    , `post_NO` VARCHAR (100) NULL
    , `address1` VARCHAR (100) NULL
    , `address2` VARCHAR (100) NULL
    , `living_Situation` VARCHAR (100) NULL
    , `housing_Loan` VARCHAR (100) NULL
    , `driving_License_Label` VARCHAR (100) NULL
    , `driving_License` VARCHAR (100) NULL
    , `user_Id` VARCHAR (100) NULL
    , `pwd` VARCHAR (100) NULL
    , `re_Pwd` VARCHAR (100) NULL
    , `update_date` DATETIME NOT NULL
    , `create_date` DATETIME NOT NULL
    , `delete_date` DATETIME NULL
    , PRIMARY KEY (`id`)
); 


