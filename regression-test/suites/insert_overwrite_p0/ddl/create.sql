CREATE TABLE large_wide_table (
    `stat_date` datetime NULL COMMENT '',
    `user_id` varchar(50) NULL COMMENT '',
    `is_white_user` int(11) NULL COMMENT '',
    `white_user_name` text NULL COMMENT '',
    `gender` int(11) NULL COMMENT '',
    `gender_desc` text NULL COMMENT '',
    `user_tel` text NULL COMMENT '',
    `user_status` int(11) NULL COMMENT '',
    `user_status_desc` text NULL COMMENT '',
    `register_source` int(11) NULL COMMENT '',
    `register_source_desc` text NULL COMMENT '',
    `is_register` int(11) NULL COMMENT '',
    `is_register_desc` text NULL COMMENT '',
    `is_new_user` int(11) NULL COMMENT '',
    `is_new_user_desc` text NULL COMMENT '',
    `is_staff` int(11) NULL COMMENT '',
    `is_staff_desc` text NULL COMMENT '',
    `is_official` int(11) NULL COMMENT '',
    `is_official_desc` text NULL COMMENT '',
    `user_platform_array` text NULL COMMENT '',
    `user_platform_info` text NULL COMMENT '',
    `delete_user_array` text NULL COMMENT '',
    `delete_user_info` text NULL COMMENT '',
    `is_delete_user` int(11) NULL COMMENT '',
    `is_delete_user_desc` text NULL COMMENT '',
    `new_user_id` text NULL COMMENT '',
    `region_code` text NULL COMMENT '',
    `region_country` text NULL COMMENT '',
    `region_province` text NULL COMMENT '',
    `region_city` text NULL COMMENT '',
    `region_district` text NULL COMMENT '',
    `region_parent` text NULL COMMENT '',
    `home_region` text NULL COMMENT '',
    `home_addr` text NULL COMMENT '',
    `home_country` text NULL COMMENT '',
    `home_province` text NULL COMMENT '',
    `home_city` text NULL COMMENT '',
    `home_district` text NULL COMMENT '',
    `home_parent` text NULL COMMENT '',
    `company_region` text NULL COMMENT '',
    `company_addr` text NULL COMMENT '',
    `company_country` text NULL COMMENT '',
    `company_province` text NULL COMMENT '',
    `company_city` text NULL COMMENT '',
    `company_district` text NULL COMMENT '',
    `company_parent` text NULL COMMENT '',
    `nick` text NULL COMMENT '',
    `avatar` text NULL COMMENT '',
    `birthday` text NULL COMMENT '',
    `occupation` int(11) NULL COMMENT '',
    `occupation_desc` text NULL COMMENT '',
    `hobby_id_array` text NULL COMMENT '',
    `hobby_name_array` text NULL COMMENT '',
    `hobby_info` text NULL COMMENT '',
    `intro` text NULL COMMENT '',
    `account_create_time` text NULL COMMENT '',
    `account_update_time` text NULL COMMENT '',
    `account_register_time` text NULL COMMENT '',
    `passportc_create_time` text NULL COMMENT '',
    `passportc_update_time` text NULL COMMENT '',
    `user_register_date` text NULL COMMENT '',
    `user_register_hour` text NULL COMMENT '',
    `user_create_date` text NULL COMMENT '',
    `user_create_hour` text NULL COMMENT '',
    `register_last_page_name` varchar(255) NULL COMMENT '',
    `register_last_page_name_desc` varchar(255) NULL COMMENT '',
    `pv_0d_cnt` int(11) NULL COMMENT '',
    `event_0d_cnt` int(11) NULL COMMENT '',
    `is_0d_open_page` int(11) NULL COMMENT '',
    `is_0d_open_page_desc` text NULL COMMENT '',
    `is_0d_active` int(11) NULL COMMENT '',
    `is_0d_active_desc` text NULL COMMENT '',
    `is_1d_active` int(11) NULL COMMENT '',
    `is_1d_active_desc` text NULL COMMENT '',
    `is_2d_active` int(11) NULL COMMENT '',
    `is_2d_active_desc` text NULL COMMENT '',
    `is_3d_active` int(11) NULL COMMENT '',
    `is_3d_active_desc` text NULL COMMENT '',
    `is_4d_active` int(11) NULL COMMENT '',
    `is_4d_active_desc` text NULL COMMENT '',
    `is_5d_active` int(11) NULL COMMENT '',
    `is_5d_active_desc` text NULL COMMENT '',
    `is_6d_active` int(11) NULL COMMENT '',
    `is_6d_active_desc` text NULL COMMENT '',
    `is_7d_active` int(11) NULL COMMENT '',
    `is_7d_active_desc` text NULL COMMENT '',
    `is_15d_active` int(11) NULL COMMENT '',
    `is_15d_active_desc` text NULL COMMENT '',
    `is_30d_active` int(11) NULL COMMENT '',
    `is_30d_active_desc` text NULL COMMENT '',
    `is_7d_within_active` int(11) NULL COMMENT '',
    `is_7d_within_active_desc` text NULL COMMENT '',
    `is_15d_within_active` int(11) NULL COMMENT '',
    `is_15d_within_active_desc` text NULL COMMENT '',
    `is_30d_within_active` int(11) NULL COMMENT '',
    `is_30d_within_active_desc` text NULL COMMENT '',
    `is_7d_n0d_within_active` int(11) NULL COMMENT '',
    `is_7d_n0d_within_active_desc` text NULL COMMENT '',
    `is_15d_n0d_within_active` int(11) NULL COMMENT '',
    `is_15d_n0d_within_active_desc` text NULL COMMENT '',
    `is_30d_n0d_within_active` int(11) NULL COMMENT '',
    `is_30d_n0d_within_active_desc` text NULL COMMENT '',
    `is_7d_continue_active` int(11) NULL COMMENT '',
    `is_7d_continue_active_desc` text NULL COMMENT '',
    `is_15d_continue_active` int(11) NULL COMMENT '',
    `is_15d_continue_active_desc` text NULL COMMENT '',
    `is_30d_continue_active` int(11) NULL COMMENT '',
    `is_30d_continue_active_desc` text NULL COMMENT '',
    `is_1d_retention` int(11) NULL COMMENT '',
    `is_1d_retention_desc` text NULL COMMENT '',
    `is_2d_retention` int(11) NULL COMMENT '',
    `is_2d_retention_desc` text NULL COMMENT '',
    `is_3d_retention` int(11) NULL COMMENT '',
    `is_3d_retention_desc` text NULL COMMENT '',
    `is_4d_retention` int(11) NULL COMMENT '',
    `is_4d_retention_desc` text NULL COMMENT '',
    `is_5d_retention` int(11) NULL COMMENT '',
    `is_5d_retention_desc` text NULL COMMENT '',
    `is_6d_retention` int(11) NULL COMMENT '',
    `is_6d_retention_desc` text NULL COMMENT '',
    `is_7d_retention` int(11) NULL COMMENT '',
    `is_7d_retention_desc` text NULL COMMENT '',
    `is_15d_retention` int(11) NULL COMMENT '',
    `is_15d_retention_desc` text NULL COMMENT '',
    `is_30d_retention` int(11) NULL COMMENT '',
    `is_30d_retention_desc` text NULL COMMENT '',
    `is_7d_within_retention` int(11) NULL COMMENT '',
    `is_7d_within_retention_desc` text NULL COMMENT '',
    `is_15d_within_retention` int(11) NULL COMMENT '',
    `is_15d_within_retention_desc` text NULL COMMENT '',
    `is_30d_within_retention` int(11) NULL COMMENT '',
    `is_30d_within_retention_desc` text NULL COMMENT '',
    `is_0d_attend` int(11) NULL COMMENT '',
    `is_0d_attend_desc` text NULL COMMENT '',
    `is_1d_attend` int(11) NULL COMMENT '',
    `is_1d_attend_desc` text NULL COMMENT '',
    `is_2d_attend` int(11) NULL COMMENT '',
    `is_2d_attend_desc` text NULL COMMENT '',
    `is_3d_attend` int(11) NULL COMMENT '',
    `is_3d_attend_desc` text NULL COMMENT '',
    `is_4d_attend` int(11) NULL COMMENT '',
    `is_4d_attend_desc` text NULL COMMENT '',
    `is_5d_attend` int(11) NULL COMMENT '',
    `is_5d_attend_desc` text NULL COMMENT '',
    `is_6d_attend` int(11) NULL COMMENT '',
    `is_6d_attend_desc` text NULL COMMENT '',
    `is_7d_attend` int(11) NULL COMMENT '',
    `is_7d_attend_desc` text NULL COMMENT '',
    `is_15d_attend` int(11) NULL COMMENT '',
    `is_15d_attend_desc` text NULL COMMENT '',
    `is_30d_attend` int(11) NULL COMMENT '',
    `is_30d_attend_desc` text NULL COMMENT '',
    `is_7d_within_attend` int(11) NULL COMMENT '',
    `is_7d_within_attend_desc` text NULL COMMENT '',
    `is_15d_within_attend` int(11) NULL COMMENT '',
    `is_15d_within_attend_desc` text NULL COMMENT '',
    `is_30d_within_attend` int(11) NULL COMMENT '',
    `is_30d_within_attend_desc` text NULL COMMENT '',
    `is_7d_n0d_within_attend` int(11) NULL COMMENT '',
    `is_7d_n0d_within_attend_desc` text NULL COMMENT '',
    `is_15d_n0d_within_attend` int(11) NULL COMMENT '',
    `is_15d_n0d_within_attend_desc` text NULL COMMENT '',
    `is_30d_n0d_within_attend` int(11) NULL COMMENT '',
    `is_30d_n0d_within_attend_desc` text NULL COMMENT '',
    `is_7d_continue_attend` int(11) NULL COMMENT '',
    `is_7d_continue_attend_desc` text NULL COMMENT '',
    `is_15d_continue_attend` int(11) NULL COMMENT '',
    `is_15d_continue_attend_desc` text NULL COMMENT '',
    `is_30d_continue_attend` int(11) NULL COMMENT '',
    `is_30d_continue_attend_desc` text NULL COMMENT '',
    `client_type` text NULL COMMENT '',
    `client_type_desc` text NULL COMMENT '',
    `inviter_user_id` text NULL COMMENT '',
    `biz_id` text NULL COMMENT '',
    `biz_id_desc` text NULL COMMENT '',
    `register_type` text NULL COMMENT '',
    `register_type_desc` text NULL COMMENT '',
    `device_info` text NULL COMMENT '',
    `scene` text NULL COMMENT '',
    `event_source` text NULL COMMENT '',
    `event_source_desc` text NULL COMMENT '',
    `event_source_level_1_desc` text NULL COMMENT '',
    `event_source_level_2_desc` text NULL COMMENT ''
) ENGINE=OLAP
DUPLICATE KEY(`stat_date`, `user_id`)
COMMENT 'OLAP'
DISTRIBUTED BY HASH(`stat_date`) BUCKETS 10
PROPERTIES (
    "replication_allocation" = "tag.location.default: 1",
    "in_memory" = "false",
    "storage_format" = "V2",
    "disable_auto_compaction" = "false"
);
