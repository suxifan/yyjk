/*
Navicat PGSQL Data Transfer

Source Server         : 运营决策
Source Server Version : 90224
Source Host           : localhost:5432
Source Database       : datacenter_yb
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90224
File Encoding         : 65001

Date: 2020-09-22 11:08:57
*/


-- ----------------------------
-- Sequence structure for analysis_arrive_volume_day_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_arrive_volume_day_id_seq";
CREATE SEQUENCE "public"."analysis_arrive_volume_day_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 833543
 CACHE 1;
SELECT setval('"public"."analysis_arrive_volume_day_id_seq"', 833543, true);

-- ----------------------------
-- Sequence structure for analysis_length_time_day_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_length_time_day_id_seq";
CREATE SEQUENCE "public"."analysis_length_time_day_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for analysis_length_time_month_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_length_time_month_id_seq";
CREATE SEQUENCE "public"."analysis_length_time_month_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for analysis_passenger_month_trend_trend_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_passenger_month_trend_trend_uuid_seq";
CREATE SEQUENCE "public"."analysis_passenger_month_trend_trend_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 106
 CACHE 1;
SELECT setval('"public"."analysis_passenger_month_trend_trend_uuid_seq"', 106, true);

-- ----------------------------
-- Sequence structure for analysis_prf_capacity_volume_day_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_prf_capacity_volume_day_id_seq";
CREATE SEQUENCE "public"."analysis_prf_capacity_volume_day_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 28902
 CACHE 1;
SELECT setval('"public"."analysis_prf_capacity_volume_day_id_seq"', 28902, true);

-- ----------------------------
-- Sequence structure for analysis_prf_fullload_day_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_prf_fullload_day_id_seq";
CREATE SEQUENCE "public"."analysis_prf_fullload_day_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 157468
 CACHE 1;
SELECT setval('"public"."analysis_prf_fullload_day_id_seq"', 157468, true);

-- ----------------------------
-- Sequence structure for analysis_prf_peak_month_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_prf_peak_month_id_seq";
CREATE SEQUENCE "public"."analysis_prf_peak_month_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 34512
 CACHE 1;
SELECT setval('"public"."analysis_prf_peak_month_id_seq"', 34512, true);

-- ----------------------------
-- Sequence structure for analysis_prf_section_month_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_prf_section_month_id_seq";
CREATE SEQUENCE "public"."analysis_prf_section_month_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 394200
 CACHE 1;
SELECT setval('"public"."analysis_prf_section_month_id_seq"', 394200, true);

-- ----------------------------
-- Sequence structure for analysis_prf_sta_on_off_day_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."analysis_prf_sta_on_off_day_id_seq";
CREATE SEQUENCE "public"."analysis_prf_sta_on_off_day_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 112052
 CACHE 1;
SELECT setval('"public"."analysis_prf_sta_on_off_day_id_seq"', 112052, true);

-- ----------------------------
-- Sequence structure for base_access_log_log_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_access_log_log_uuid_seq";
CREATE SEQUENCE "public"."base_access_log_log_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 20368
 CACHE 1;
SELECT setval('"public"."base_access_log_log_uuid_seq"', 20368, true);

-- ----------------------------
-- Sequence structure for base_access_page_log_log_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_access_page_log_log_uuid_seq";
CREATE SEQUENCE "public"."base_access_page_log_log_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 3239
 CACHE 1;
SELECT setval('"public"."base_access_page_log_log_uuid_seq"', 3239, true);

-- ----------------------------
-- Sequence structure for base_bus_video_info_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_bus_video_info_uuid_seq";
CREATE SEQUENCE "public"."base_bus_video_info_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 55
 CACHE 1;
SELECT setval('"public"."base_bus_video_info_uuid_seq"', 55, true);

-- ----------------------------
-- Sequence structure for base_data_resource_info_data_resource_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_data_resource_info_data_resource_uuid_seq";
CREATE SEQUENCE "public"."base_data_resource_info_data_resource_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for base_excel_import_log_xls_log_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_excel_import_log_xls_log_uuid_seq";
CREATE SEQUENCE "public"."base_excel_import_log_xls_log_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 285
 CACHE 1;
SELECT setval('"public"."base_excel_import_log_xls_log_uuid_seq"', 285, true);

-- ----------------------------
-- Sequence structure for base_log_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_log_info_id_seq";
CREATE SEQUENCE "public"."base_log_info_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 301
 CACHE 1;
SELECT setval('"public"."base_log_info_id_seq"', 301, true);

-- ----------------------------
-- Sequence structure for base_login_log_log_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_login_log_log_uuid_seq";
CREATE SEQUENCE "public"."base_login_log_log_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1817
 CACHE 1;
SELECT setval('"public"."base_login_log_log_uuid_seq"', 1817, true);

-- ----------------------------
-- Sequence structure for base_resource_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_resource_info_id_seq";
CREATE SEQUENCE "public"."base_resource_info_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 70
 CACHE 1;
SELECT setval('"public"."base_resource_info_id_seq"', 70, true);

-- ----------------------------
-- Sequence structure for base_role_dataresource_role_data_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_role_dataresource_role_data_id_seq";
CREATE SEQUENCE "public"."base_role_dataresource_role_data_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 393
 CACHE 1;
SELECT setval('"public"."base_role_dataresource_role_data_id_seq"', 393, true);

-- ----------------------------
-- Sequence structure for base_role_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_role_info_id_seq";
CREATE SEQUENCE "public"."base_role_info_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 42
 CACHE 1;
SELECT setval('"public"."base_role_info_id_seq"', 42, true);

-- ----------------------------
-- Sequence structure for base_role_lineresource_role_data_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_role_lineresource_role_data_id_seq";
CREATE SEQUENCE "public"."base_role_lineresource_role_data_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1299
 CACHE 1;
SELECT setval('"public"."base_role_lineresource_role_data_id_seq"', 1299, true);

-- ----------------------------
-- Sequence structure for base_role_resource_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_role_resource_id_seq";
CREATE SEQUENCE "public"."base_role_resource_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 3764
 CACHE 1;
SELECT setval('"public"."base_role_resource_id_seq"', 3764, true);

-- ----------------------------
-- Sequence structure for base_sort_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_sort_id_seq";
CREATE SEQUENCE "public"."base_sort_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 51
 CACHE 1;
SELECT setval('"public"."base_sort_id_seq"', 51, true);

-- ----------------------------
-- Sequence structure for base_sys_param_info_sys_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_sys_param_info_sys_uuid_seq";
CREATE SEQUENCE "public"."base_sys_param_info_sys_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 36
 CACHE 1;
SELECT setval('"public"."base_sys_param_info_sys_uuid_seq"', 36, true);

-- ----------------------------
-- Sequence structure for base_user_info_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_user_info_id_seq";
CREATE SEQUENCE "public"."base_user_info_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 23
 CACHE 1;
SELECT setval('"public"."base_user_info_id_seq"', 23, true);

-- ----------------------------
-- Sequence structure for base_user_role_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_user_role_id_seq";
CREATE SEQUENCE "public"."base_user_role_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 55
 CACHE 1;
SELECT setval('"public"."base_user_role_id_seq"', 55, true);

-- ----------------------------
-- Sequence structure for base_video_param_info_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."base_video_param_info_uuid_seq";
CREATE SEQUENCE "public"."base_video_param_info_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 6
 CACHE 1;
SELECT setval('"public"."base_video_param_info_uuid_seq"', 6, true);

-- ----------------------------
-- Sequence structure for dw_dim_other_device_dev_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dw_dim_other_device_dev_uuid_seq";
CREATE SEQUENCE "public"."dw_dim_other_device_dev_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2041
 CACHE 1;
SELECT setval('"public"."dw_dim_other_device_dev_uuid_seq"', 2041, true);

-- ----------------------------
-- Sequence structure for dw_dim_other_device_id_bus_dev_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dw_dim_other_device_id_bus_dev_uuid_seq";
CREATE SEQUENCE "public"."dw_dim_other_device_id_bus_dev_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 16
 CACHE 1;
SELECT setval('"public"."dw_dim_other_device_id_bus_dev_uuid_seq"', 16, true);

-- ----------------------------
-- Sequence structure for dw_dim_sys_datadict_type_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dw_dim_sys_datadict_type_uuid_seq";
CREATE SEQUENCE "public"."dw_dim_sys_datadict_type_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval('"public"."dw_dim_sys_datadict_type_uuid_seq"', 2, true);

-- ----------------------------
-- Sequence structure for dw_dim_sys_datadict_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."dw_dim_sys_datadict_uuid_seq";
CREATE SEQUENCE "public"."dw_dim_sys_datadict_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for mid_bus_warn_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."mid_bus_warn_id_seq";
CREATE SEQUENCE "public"."mid_bus_warn_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9
 CACHE 1;
SELECT setval('"public"."mid_bus_warn_id_seq"', 9, true);

-- ----------------------------
-- Sequence structure for mid_passenger_flow_result_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."mid_passenger_flow_result_id_seq";
CREATE SEQUENCE "public"."mid_passenger_flow_result_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 524240
 CACHE 1;
SELECT setval('"public"."mid_passenger_flow_result_id_seq"', 524240, true);

-- ----------------------------
-- Sequence structure for mid_pl_t_warn_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."mid_pl_t_warn_id_seq";
CREATE SEQUENCE "public"."mid_pl_t_warn_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Sequence structure for net_data_line_geo_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_data_line_geo_uuid_seq";
CREATE SEQUENCE "public"."net_data_line_geo_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 5920
 CACHE 1;
SELECT setval('"public"."net_data_line_geo_uuid_seq"', 5920, true);

-- ----------------------------
-- Sequence structure for net_dea_base_xml_config_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_dea_base_xml_config_uuid_seq";
CREATE SEQUENCE "public"."net_dea_base_xml_config_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 7215
 CACHE 1;
SELECT setval('"public"."net_dea_base_xml_config_uuid_seq"', 7215, true);

-- ----------------------------
-- Sequence structure for net_index_dea_linescore_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_dea_linescore_uuid_seq";
CREATE SEQUENCE "public"."net_index_dea_linescore_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 28
 CACHE 1;
SELECT setval('"public"."net_index_dea_linescore_uuid_seq"', 28, true);

-- ----------------------------
-- Sequence structure for net_index_dea_transfordata_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_dea_transfordata_uuid_seq";
CREATE SEQUENCE "public"."net_index_dea_transfordata_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 28
 CACHE 1;
SELECT setval('"public"."net_index_dea_transfordata_uuid_seq"', 28, true);

-- ----------------------------
-- Sequence structure for net_index_level_entropy_result_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_level_entropy_result_uuid_seq";
CREATE SEQUENCE "public"."net_index_level_entropy_result_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 14
 CACHE 1;
SELECT setval('"public"."net_index_level_entropy_result_uuid_seq"', 14, true);

-- ----------------------------
-- Sequence structure for net_index_pf_base_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_base_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_base_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 141349
 CACHE 1;
SELECT setval('"public"."net_index_pf_base_uuid_seq"', 141349, true);

-- ----------------------------
-- Sequence structure for net_index_pf_line_day_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_line_day_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_line_day_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 63
 CACHE 1;
SELECT setval('"public"."net_index_pf_line_day_uuid_seq"', 63, true);

-- ----------------------------
-- Sequence structure for net_index_pf_od_aavg_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_od_aavg_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_od_aavg_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 4018
 CACHE 1;
SELECT setval('"public"."net_index_pf_od_aavg_uuid_seq"', 4018, true);

-- ----------------------------
-- Sequence structure for net_index_pf_od_day_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_od_day_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_od_day_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9097
 CACHE 1;
SELECT setval('"public"."net_index_pf_od_day_uuid_seq"', 9097, true);

-- ----------------------------
-- Sequence structure for net_index_pf_od_dsum_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_od_dsum_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_od_dsum_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 8835
 CACHE 1;
SELECT setval('"public"."net_index_pf_od_dsum_uuid_seq"', 8835, true);

-- ----------------------------
-- Sequence structure for net_index_pf_od_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_od_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_od_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 102234
 CACHE 1;
SELECT setval('"public"."net_index_pf_od_uuid_seq"', 102234, true);

-- ----------------------------
-- Sequence structure for net_index_pf_station_day_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_pf_station_day_uuid_seq";
CREATE SEQUENCE "public"."net_index_pf_station_day_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1651
 CACHE 1;
SELECT setval('"public"."net_index_pf_station_day_uuid_seq"', 1651, true);

-- ----------------------------
-- Sequence structure for net_index_repeat_arrow_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_repeat_arrow_uuid_seq";
CREATE SEQUENCE "public"."net_index_repeat_arrow_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 27
 CACHE 1;
SELECT setval('"public"."net_index_repeat_arrow_uuid_seq"', 27, true);

-- ----------------------------
-- Sequence structure for net_index_repeat_company_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_repeat_company_uuid_seq";
CREATE SEQUENCE "public"."net_index_repeat_company_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 3
 CACHE 1;
SELECT setval('"public"."net_index_repeat_company_uuid_seq"', 3, true);

-- ----------------------------
-- Sequence structure for net_index_repeat_linenum_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_repeat_linenum_uuid_seq";
CREATE SEQUENCE "public"."net_index_repeat_linenum_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 14
 CACHE 1;
SELECT setval('"public"."net_index_repeat_linenum_uuid_seq"', 14, true);

-- ----------------------------
-- Sequence structure for net_index_repeat_sc_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_repeat_sc_uuid_seq";
CREATE SEQUENCE "public"."net_index_repeat_sc_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1084
 CACHE 1;
SELECT setval('"public"."net_index_repeat_sc_uuid_seq"', 1084, true);

-- ----------------------------
-- Sequence structure for net_index_statis_arrow_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_statis_arrow_uuid_seq";
CREATE SEQUENCE "public"."net_index_statis_arrow_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 27
 CACHE 1;
SELECT setval('"public"."net_index_statis_arrow_uuid_seq"', 27, true);

-- ----------------------------
-- Sequence structure for net_index_statis_linenum_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_index_statis_linenum_uuid_seq";
CREATE SEQUENCE "public"."net_index_statis_linenum_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 28
 CACHE 1;
SELECT setval('"public"."net_index_statis_linenum_uuid_seq"', 28, true);

-- ----------------------------
-- Sequence structure for net_xml_config_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."net_xml_config_uuid_seq";
CREATE SEQUENCE "public"."net_xml_config_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 9541
 CACHE 1;
SELECT setval('"public"."net_xml_config_uuid_seq"', 9541, true);

-- ----------------------------
-- Sequence structure for temp_bus_warn_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."temp_bus_warn_id_seq";
CREATE SEQUENCE "public"."temp_bus_warn_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 237
 CACHE 1;
SELECT setval('"public"."temp_bus_warn_id_seq"', 237, true);

-- ----------------------------
-- Sequence structure for temp_ic_card_data_uuid_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."temp_ic_card_data_uuid_seq";
CREATE SEQUENCE "public"."temp_ic_card_data_uuid_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;

-- ----------------------------
-- Table structure for analysis_arrive_volume_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_arrive_volume_day";
CREATE TABLE "public"."analysis_arrive_volume_day" (
"arrive_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_arrive_volume_day_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"bus_plate_number" varchar(50) COLLATE "default",
"upload_time_date" varchar(10) COLLATE "default",
"upload_time_in" timestamp(6),
"upload_time_out" timestamp(6),
"upload_time_hour" int2,
"bus_class" int2
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_arrive_volume_day" IS '车辆到站时刻表';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."arrive_uuid" IS '主键id';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."org_uuid" IS '机构id';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."sta_uuid" IS '站id';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."sta_name" IS '站名';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."upload_time_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."upload_time_in" IS '进站时间';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."upload_time_out" IS '出站时间';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_arrive_volume_day"."bus_class" IS '班次';

-- ----------------------------
-- Table structure for analysis_arrive_volume_day_10
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_arrive_volume_day_10";
CREATE TABLE "public"."analysis_arrive_volume_day_10" (
"arrive_uuid" varchar(64) COLLATE "default" NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"bus_plate_number" varchar(50) COLLATE "default",
"upload_time_date" varchar(10) COLLATE "default",
"upload_time_in" timestamp(6),
"upload_time_out" timestamp(6),
"upload_time_hour" int2,
"bus_class" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for analysis_arrive_volume_day_11
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_arrive_volume_day_11";
CREATE TABLE "public"."analysis_arrive_volume_day_11" (
"arrive_uuid" varchar(64) COLLATE "default" NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"bus_plate_number" varchar(50) COLLATE "default",
"upload_time_date" varchar(10) COLLATE "default",
"upload_time_in" timestamp(6),
"upload_time_out" timestamp(6),
"upload_time_hour" int2,
"bus_class" int2
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for analysis_investment_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_investment_day";
CREATE TABLE "public"."analysis_investment_day" (
"invest_uuid" varchar(50) COLLATE "default" NOT NULL,
"dispatch_date" varchar(10) COLLATE "default",
"bus_month" varchar(10) COLLATE "default",
"bus_quarter" varchar(10) COLLATE "default",
"bus_year" varchar(10) COLLATE "default",
"org_uuid" varchar(32) COLLATE "default",
"org_name" varchar(32) COLLATE "default",
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"line_isloop" varchar(32) COLLATE "default",
"act_trip" varchar(32) COLLATE "default",
"avgepassdrv" varchar(32) COLLATE "default",
"avgepassruntime" varchar(53) COLLATE "default",
"avgemeigletrip" varchar(53) COLLATE "default",
"avgemeigledrv" varchar(53) COLLATE "default",
"avgemeigleruntime" varchar(53) COLLATE "default",
"runtime" varchar(10) COLLATE "default",
"drvnum" varchar(53) COLLATE "default",
"get_onnumber" varchar(32) COLLATE "default",
"operation_mileage" varchar(32) COLLATE "default",
"avgepass_trip" varchar(32) COLLATE "default",
"invest_type" varchar(2) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."analysis_investment_day"."invest_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_investment_day"."dispatch_date" IS '行车日期';
COMMENT ON COLUMN "public"."analysis_investment_day"."bus_month" IS '公交月';
COMMENT ON COLUMN "public"."analysis_investment_day"."bus_quarter" IS '季度';
COMMENT ON COLUMN "public"."analysis_investment_day"."bus_year" IS '年';
COMMENT ON COLUMN "public"."analysis_investment_day"."org_uuid" IS '机构UUID';
COMMENT ON COLUMN "public"."analysis_investment_day"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_investment_day"."line_uuid" IS '计划运营线路ID';
COMMENT ON COLUMN "public"."analysis_investment_day"."line_name" IS '计划运营线路名称';
COMMENT ON COLUMN "public"."analysis_investment_day"."line_isloop" IS '计划线路类型:环线；非环线';

-- ----------------------------
-- Table structure for analysis_length_time_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_length_time_day";
CREATE TABLE "public"."analysis_length_time_day" (
"day_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_length_time_day_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"upload_time_day" varchar(10) COLLATE "default",
"upload_time_hour" int4,
"sta_length_time" numeric(10,2)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_length_time_day" IS '线路站间运行时间分析（月报）';
COMMENT ON COLUMN "public"."analysis_length_time_day"."day_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_length_time_day"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."analysis_length_time_day"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_length_time_day"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_length_time_day"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_length_time_day"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_length_time_day"."sta_uuid" IS '线路站点ID';
COMMENT ON COLUMN "public"."analysis_length_time_day"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."analysis_length_time_day"."sta_name" IS '线路站点名称';
COMMENT ON COLUMN "public"."analysis_length_time_day"."upload_time_day" IS '月份';
COMMENT ON COLUMN "public"."analysis_length_time_day"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_length_time_day"."sta_length_time" IS '时长（秒）';

-- ----------------------------
-- Table structure for analysis_length_time_month
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_length_time_month";
CREATE TABLE "public"."analysis_length_time_month" (
"length_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_length_time_month_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"upload_time_month" varchar(10) COLLATE "default",
"upload_time_hour" int4,
"sta_length_time" numeric(10,2)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_length_time_month" IS '线路站间运行时间分析（月报）';
COMMENT ON COLUMN "public"."analysis_length_time_month"."length_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_length_time_month"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."analysis_length_time_month"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_length_time_month"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_length_time_month"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_length_time_month"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_length_time_month"."sta_uuid" IS '线路站点ID';
COMMENT ON COLUMN "public"."analysis_length_time_month"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."analysis_length_time_month"."sta_name" IS '线路站点名称';
COMMENT ON COLUMN "public"."analysis_length_time_month"."upload_time_month" IS '月份';
COMMENT ON COLUMN "public"."analysis_length_time_month"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_length_time_month"."sta_length_time" IS '时长（秒）';

-- ----------------------------
-- Table structure for analysis_network_line_od_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_network_line_od_data";
CREATE TABLE "public"."analysis_network_line_od_data" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"org_uuid" varchar(32) COLLATE "default",
"org_name" varchar(32) COLLATE "default",
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"line_type" varchar(10) COLLATE "default",
"up_line_sta_uuid" varchar(32) COLLATE "default",
"up_sta_seq" varchar(32) COLLATE "default",
"up_sta_name" varchar(32) COLLATE "default",
"up_sta_lng" varchar(32) COLLATE "default",
"up_sta_lat" varchar(32) COLLATE "default",
"down_line_sta_uuid" varchar(32) COLLATE "default",
"down_sta_seq" varchar(32) COLLATE "default",
"down_sta_name" varchar(32) COLLATE "default",
"down_sta_lng" varchar(32) COLLATE "default",
"down_sta_lat" varchar(32) COLLATE "default",
"pay_number" int4,
"upload_date" date,
"pay_time_interval" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_network_line_od_data" IS '线路OD表';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."org_uuid" IS '机构UUID';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."line_type" IS '线路方向';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."up_line_sta_uuid" IS '上车线路站点ID';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."up_sta_seq" IS '上车站序';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."up_sta_name" IS '上车站点名称';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."up_sta_lng" IS '上车站点经度';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."up_sta_lat" IS '上车站点纬度';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."down_line_sta_uuid" IS '下车线路站点ID';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."down_sta_seq" IS '下车站序';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."down_sta_name" IS '下车站点名称';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."down_sta_lng" IS '下车站点经度';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."down_sta_lat" IS '下车站点纬度';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."pay_number" IS '刷卡人次';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."upload_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_network_line_od_data"."pay_time_interval" IS '刷卡时间段（以上车刷卡时间为准）';

-- ----------------------------
-- Table structure for analysis_network_sta_od_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_network_sta_od_data";
CREATE TABLE "public"."analysis_network_sta_od_data" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"up_sta_uuid" varchar(32) COLLATE "default",
"up_sta_name" varchar(32) COLLATE "default",
"up_sta_lng" varchar(32) COLLATE "default",
"up_sta_lat" varchar(32) COLLATE "default",
"down_sta_uuid" varchar(32) COLLATE "default",
"down_sta_name" varchar(32) COLLATE "default",
"down_sta_lng" varchar(32) COLLATE "default",
"down_sta_lat" varchar(32) COLLATE "default",
"pay_number" int4,
"linear_distance" numeric(32,2),
"drive_distance" numeric(32,2),
"is_transfer" char(32) COLLATE "default",
"consume_time" numeric(32,2),
"upload_date" date,
"pay_time_interval" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_network_sta_od_data" IS '站点OD表';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."up_sta_uuid" IS '上车站点ID';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."up_sta_name" IS '上车站点名称';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."up_sta_lng" IS '上车站点经度';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."up_sta_lat" IS '上车站点纬度';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."down_sta_uuid" IS '下车站点ID';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."down_sta_name" IS '下车站点名称';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."down_sta_lng" IS '下车站点经度';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."down_sta_lat" IS '下车站点纬度';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."pay_number" IS '刷卡人次';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."linear_distance" IS '直线距离';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."drive_distance" IS '驾车距离';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."is_transfer" IS '是否需要换乘';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."consume_time" IS '耗费时间';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."upload_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_network_sta_od_data"."pay_time_interval" IS '刷卡时间段（以上车刷卡时间为准）';

-- ----------------------------
-- Table structure for analysis_network_sta_od_month_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_network_sta_od_month_data";
CREATE TABLE "public"."analysis_network_sta_od_month_data" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"up_sta_uuid" varchar(32) COLLATE "default",
"up_sta_name" varchar(32) COLLATE "default",
"down_sta_uuid" varchar(32) COLLATE "default",
"down_sta_name" varchar(32) COLLATE "default",
"pay_number" int4,
"linear_distance" numeric(32,2),
"drive_distance" numeric(32,2),
"is_transfer" char(32) COLLATE "default",
"consume_time" numeric(32,2),
"od_month" varchar COLLATE "default",
"pay_time_interval" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_network_sta_od_month_data" IS '站点OD表';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."up_sta_uuid" IS '上车站点ID';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."up_sta_name" IS '上车站点名称';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."down_sta_uuid" IS '下车站点ID';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."down_sta_name" IS '下车站点名称';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."pay_number" IS '刷卡人次';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."linear_distance" IS '直线距离';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."drive_distance" IS '驾车距离';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."is_transfer" IS '是否需要换乘';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."consume_time" IS '耗费时间';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."od_month" IS '日期';
COMMENT ON COLUMN "public"."analysis_network_sta_od_month_data"."pay_time_interval" IS '刷卡时间段（以上车刷卡时间为准）';

-- ----------------------------
-- Table structure for analysis_passenger_month_trend
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_passenger_month_trend";
CREATE TABLE "public"."analysis_passenger_month_trend" (
"trend_uuid" varchar(32) COLLATE "default" DEFAULT nextval('analysis_passenger_month_trend_trend_uuid_seq'::regclass) NOT NULL,
"org_uuid" varchar(32) COLLATE "default",
"upload_time_month" varchar(20) COLLATE "default",
"upload_time_date" date,
"person_count" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for analysis_prf_capacity_volume_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_prf_capacity_volume_day";
CREATE TABLE "public"."analysis_prf_capacity_volume_day" (
"capacity_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_prf_capacity_volume_day_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"upload_time_date" date,
"upload_time_quarter" varchar(10) COLLATE "default",
"pfr_get_on_number" int4,
"pfr_get_off_number" int4,
"prf_get_person_count" int4,
"bus_load_number" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_prf_capacity_volume_day" IS '线路客流运力运量分析（日报）';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."capacity_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."upload_time_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."upload_time_quarter" IS '时间区间';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."pfr_get_on_number" IS '上车人数';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."pfr_get_off_number" IS '下车人数';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."prf_get_person_count" IS '车内人数';
COMMENT ON COLUMN "public"."analysis_prf_capacity_volume_day"."bus_load_number" IS '车辆核载人数';

-- ----------------------------
-- Table structure for analysis_prf_fullload_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_prf_fullload_day";
CREATE TABLE "public"."analysis_prf_fullload_day" (
"fullload_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_prf_fullload_day_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(32) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"upload_time_date" date,
"upload_time_hour" int4,
"pfr_get_on_number" int4,
"pfr_get_off_number" int4,
"prf_get_person_count" int4,
"bus_load_number" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_prf_fullload_day" IS '区间满载率查询(日报)';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."fullload_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."org_uuid" IS '机构uuid';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."org_name" IS '机构名';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."line_uuid" IS '线路uuid';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."line_name" IS '线路名';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."line_type" IS '线路类型（1：上行；2下行）';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."sta_uuid" IS '线路站点uuid';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."sta_name" IS '线路站点名';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."upload_time_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."upload_time_hour" IS '时间';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."pfr_get_on_number" IS '上车人数';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."pfr_get_off_number" IS '下车人数';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."prf_get_person_count" IS '车内人数';
COMMENT ON COLUMN "public"."analysis_prf_fullload_day"."bus_load_number" IS '车辆核载人数';

-- ----------------------------
-- Table structure for analysis_prf_peak_month
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_prf_peak_month";
CREATE TABLE "public"."analysis_prf_peak_month" (
"peak_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_prf_peak_month_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"upload_time_month" varchar(10) COLLATE "default",
"upload_time_week" varchar(10) COLLATE "default",
"upload_time_hour" int4,
"pfr_get_on_number" int4,
"pfr_get_off_number" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."peak_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."upload_time_month" IS '月份';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."upload_time_week" IS '周数';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."pfr_get_on_number" IS '上车人数';
COMMENT ON COLUMN "public"."analysis_prf_peak_month"."pfr_get_off_number" IS '下车人数';

-- ----------------------------
-- Table structure for analysis_prf_section_month
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_prf_section_month";
CREATE TABLE "public"."analysis_prf_section_month" (
"section_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_prf_section_month_id_seq'::regclass) NOT NULL,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"line_type" varchar(1) COLLATE "default",
"line_sta_uuid" varchar(64) COLLATE "default",
"sta_seq" varchar(32) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"upload_time_month" varchar(10) COLLATE "default",
"upload_time_hour" int4,
"pfr_get_on_number" int4,
"pfr_get_off_number" int4,
"prf_get_person_count" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_prf_section_month" IS '线路客流高峰断面分析(月报)';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."section_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."line_type" IS '线路类型';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."line_sta_uuid" IS '线路站点ID';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."sta_name" IS '线路站点名称';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."upload_time_month" IS '月份';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."pfr_get_on_number" IS '平均上车人数';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."pfr_get_off_number" IS '平均下车人数';
COMMENT ON COLUMN "public"."analysis_prf_section_month"."prf_get_person_count" IS '车内人数';

-- ----------------------------
-- Table structure for analysis_prf_sta_on_off_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."analysis_prf_sta_on_off_day";
CREATE TABLE "public"."analysis_prf_sta_on_off_day" (
"sta_on_off_uuid" varchar(64) COLLATE "default" DEFAULT nextval('analysis_prf_sta_on_off_day_id_seq'::regclass) NOT NULL,
"sta_uuid" varchar(64) COLLATE "default",
"sta_name" varchar(50) COLLATE "default",
"upload_time_date" date,
"upload_time_hour" int2,
"pfr_get_on_number" int4,
"pfr_get_off_number" int4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."analysis_prf_sta_on_off_day" IS '线路站点登降量查询(日报）';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."sta_on_off_uuid" IS '主键';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."sta_uuid" IS '线路站点uuid';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."sta_name" IS '线路站点名';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."upload_time_date" IS '日期';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."upload_time_hour" IS '小时';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."pfr_get_on_number" IS '上车人数';
COMMENT ON COLUMN "public"."analysis_prf_sta_on_off_day"."pfr_get_off_number" IS '下车人数';

-- ----------------------------
-- Table structure for base_access_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_access_log";
CREATE TABLE "public"."base_access_log" (
"log_uuid" int8 DEFAULT nextval('base_access_log_log_uuid_seq'::regclass) NOT NULL,
"org_uuid" varchar(32) COLLATE "default",
"user_uuid" varchar(32) COLLATE "default",
"role_uuid" varchar(32) COLLATE "default",
"access_model_name" varchar(50) COLLATE "default",
"access_page_name" varchar(50) COLLATE "default",
"access_ip" varchar(20) COLLATE "default",
"access_time" timestamp(6) DEFAULT now(),
"access_duration" int8,
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_access_log"."log_uuid" IS '主键uuid';
COMMENT ON COLUMN "public"."base_access_log"."org_uuid" IS '机构uuid';
COMMENT ON COLUMN "public"."base_access_log"."role_uuid" IS '角色uuid';
COMMENT ON COLUMN "public"."base_access_log"."access_model_name" IS '访问模块名称';
COMMENT ON COLUMN "public"."base_access_log"."access_page_name" IS '访问页面名称';
COMMENT ON COLUMN "public"."base_access_log"."access_ip" IS '访问IP地址';
COMMENT ON COLUMN "public"."base_access_log"."access_time" IS '访问时间';
COMMENT ON COLUMN "public"."base_access_log"."access_duration" IS '访问时长（毫秒）';
COMMENT ON COLUMN "public"."base_access_log"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_access_page_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_access_page_log";
CREATE TABLE "public"."base_access_page_log" (
"log_uuid" int8 DEFAULT nextval('base_access_page_log_log_uuid_seq'::regclass) NOT NULL,
"org_uuid" varchar(32) COLLATE "default",
"user_uuid" varchar(32) COLLATE "default",
"role_uuid" varchar(32) COLLATE "default",
"access_model_name" varchar(50) COLLATE "default",
"access_page_name" varchar(50) COLLATE "default",
"access_ip" varchar(20) COLLATE "default",
"access_time" timestamp(6) DEFAULT now(),
"access_duration" int8,
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_access_page_log"."log_uuid" IS '主键uuid';
COMMENT ON COLUMN "public"."base_access_page_log"."org_uuid" IS '机构uuid';
COMMENT ON COLUMN "public"."base_access_page_log"."role_uuid" IS '角色uuid';
COMMENT ON COLUMN "public"."base_access_page_log"."access_model_name" IS '访问模块名称';
COMMENT ON COLUMN "public"."base_access_page_log"."access_page_name" IS '访问页面名称';
COMMENT ON COLUMN "public"."base_access_page_log"."access_ip" IS '访问IP地址';
COMMENT ON COLUMN "public"."base_access_page_log"."access_time" IS '访问时间';
COMMENT ON COLUMN "public"."base_access_page_log"."access_duration" IS '访问时长（毫秒）';
COMMENT ON COLUMN "public"."base_access_page_log"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_api_taketime_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_api_taketime_info";
CREATE TABLE "public"."base_api_taketime_info" (
"api_id" varchar(64) COLLATE "default" NOT NULL,
"api_ip" varchar(50) COLLATE "default",
"api_url" varchar(255) COLLATE "default",
"api_method" varchar(255) COLLATE "default",
"api_take_time" int8,
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_api_taketime_info"."api_ip" IS 'IP地址';
COMMENT ON COLUMN "public"."base_api_taketime_info"."api_url" IS '接口url';
COMMENT ON COLUMN "public"."base_api_taketime_info"."api_take_time" IS 'API耗时（毫秒）';
COMMENT ON COLUMN "public"."base_api_taketime_info"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_bus_video_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_bus_video_info";
CREATE TABLE "public"."base_bus_video_info" (
"uuid" varchar(32) COLLATE "default" DEFAULT nextval('base_bus_video_info_uuid_seq'::regclass) NOT NULL,
"bus_uuid" varchar(32) COLLATE "default",
"video1" varchar(50) COLLATE "default",
"video2" varchar(50) COLLATE "default",
"video3" varchar(50) COLLATE "default",
"video4" varchar(50) COLLATE "default",
"video5" varchar(50) COLLATE "default",
"video6" varchar(50) COLLATE "default",
"video7" varchar(50) COLLATE "default",
"video8" varchar(50) COLLATE "default",
"video9" varchar(50) COLLATE "default",
"video10" varchar(50) COLLATE "default",
"video11" varchar(50) COLLATE "default",
"video12" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for base_data_resource_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_data_resource_info";
CREATE TABLE "public"."base_data_resource_info" (
"data_resource_id" varchar(64) COLLATE "default" DEFAULT nextval('base_data_resource_info_data_resource_uuid_seq'::regclass) NOT NULL,
"data_resource_name" varchar(50) COLLATE "default",
"data_resource_parent_id" varchar(64) COLLATE "default",
"data_resource_type" varchar(10) COLLATE "default",
"data_resource_title" varchar(50) COLLATE "default",
"data_resource_sort" int2,
"data_resource_isvalid" char(1) COLLATE "default",
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now(),
"update_user" varchar(50) COLLATE "default",
"update_time" timestamp(6) DEFAULT now(),
"describes" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_id" IS '数据资源id';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_name" IS '数据资源名称';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_parent_id" IS '父id';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_type" IS '数据资源类型';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_title" IS '数据资源名称';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_sort" IS '排序号';
COMMENT ON COLUMN "public"."base_data_resource_info"."data_resource_isvalid" IS '是否有效1：有效；0：无效';
COMMENT ON COLUMN "public"."base_data_resource_info"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_data_resource_info"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_data_resource_info"."update_user" IS '修改者';
COMMENT ON COLUMN "public"."base_data_resource_info"."update_time" IS '修改时间';
COMMENT ON COLUMN "public"."base_data_resource_info"."describes" IS '描述';

-- ----------------------------
-- Table structure for base_excel_import_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_excel_import_log";
CREATE TABLE "public"."base_excel_import_log" (
"xls_log_model" varchar(20) COLLATE "default" NOT NULL,
"xls_filename" varchar(255) COLLATE "default",
"xls_err_code" varchar(6) COLLATE "default",
"xls_err_msg" varchar(255) COLLATE "default",
"xls_log_date" date NOT NULL,
"xls_log_create_time" timestamp(6),
"xls_log_create_user" varchar(20) COLLATE "default",
"xls_log_update_time" timestamp(6),
"xls_log_uuid" varchar(32) COLLATE "default" DEFAULT nextval('base_excel_import_log_xls_log_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."base_excel_import_log" IS 'excel导入日志表';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_log_model" IS '日志所属模块';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_filename" IS 'excel文件名';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_err_code" IS '错误码';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_err_msg" IS '错误信息';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_log_date" IS '创建日期';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_log_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_log_create_user" IS '创建人';
COMMENT ON COLUMN "public"."base_excel_import_log"."xls_log_update_time" IS '更新时间';

-- ----------------------------
-- Table structure for base_log_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_log_info";
CREATE TABLE "public"."base_log_info" (
"log_id" varchar(64) COLLATE "default" DEFAULT nextval('base_log_info_id_seq'::regclass) NOT NULL,
"user_id" varchar(64) COLLATE "default" NOT NULL,
"user_name" varchar(64) COLLATE "default" NOT NULL,
"ip_address" varchar(50) COLLATE "default",
"user_agent" varchar(300) COLLATE "default",
"model_name" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_log_info"."log_id" IS '登录日志id';
COMMENT ON COLUMN "public"."base_log_info"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."base_log_info"."user_name" IS '用户名';
COMMENT ON COLUMN "public"."base_log_info"."ip_address" IS '登录ip';
COMMENT ON COLUMN "public"."base_log_info"."user_agent" IS '登录设备';
COMMENT ON COLUMN "public"."base_log_info"."model_name" IS '模块名';
COMMENT ON COLUMN "public"."base_log_info"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_login_log
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_login_log";
CREATE TABLE "public"."base_login_log" (
"log_uuid" int8 DEFAULT nextval('base_login_log_log_uuid_seq'::regclass) NOT NULL,
"org_uuid" varchar(32) COLLATE "default",
"user_uuid" varchar(32) COLLATE "default",
"role_uuid" varchar(32) COLLATE "default",
"access_ip" varchar(20) COLLATE "default",
"access_channel" varchar(350) COLLATE "default",
"access_time" timestamp(6),
"access_model" varchar(1) COLLATE "default",
"create_time" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_login_log"."log_uuid" IS '主键uuid';
COMMENT ON COLUMN "public"."base_login_log"."org_uuid" IS '用户机构uuid';
COMMENT ON COLUMN "public"."base_login_log"."user_uuid" IS '登录用户uuid';
COMMENT ON COLUMN "public"."base_login_log"."role_uuid" IS '用户角色uuids,多个用逗号分开';
COMMENT ON COLUMN "public"."base_login_log"."access_ip" IS '访问IP地址';
COMMENT ON COLUMN "public"."base_login_log"."access_channel" IS '访问渠道';
COMMENT ON COLUMN "public"."base_login_log"."access_time" IS '登录时间';
COMMENT ON COLUMN "public"."base_login_log"."access_model" IS '访问模块1：登录；2：登出';
COMMENT ON COLUMN "public"."base_login_log"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_resource_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_resource_info";
CREATE TABLE "public"."base_resource_info" (
"resource_id" varchar(64) COLLATE "default" DEFAULT nextval('base_resource_info_id_seq'::regclass) NOT NULL,
"resource_name" varchar(50) COLLATE "default",
"resource_parent_id" varchar(64) COLLATE "default",
"resource_type" varchar(1) COLLATE "default",
"resource_title" varchar(50) COLLATE "default",
"resource_url" varchar(100) COLLATE "default",
"resource_sort" int2,
"resource_image" varchar(50) COLLATE "default",
"resource_component" varchar(100) COLLATE "default",
"enabled" varchar(1) COLLATE "default",
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now(),
"update_user" varchar(50) COLLATE "default",
"update_time" timestamp(6) DEFAULT now(),
"describes" varchar(200) COLLATE "default",
"resource_level" varchar(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_resource_info"."resource_id" IS '主键id';
COMMENT ON COLUMN "public"."base_resource_info"."resource_name" IS '对应的是模块name;只有菜单级别有';
COMMENT ON COLUMN "public"."base_resource_info"."resource_parent_id" IS '父级菜单';
COMMENT ON COLUMN "public"."base_resource_info"."resource_type" IS '1.根节点2.父节点3.子节点';
COMMENT ON COLUMN "public"."base_resource_info"."resource_title" IS 'title资源标题(对应按钮级别的name和菜单级别的title)';
COMMENT ON COLUMN "public"."base_resource_info"."resource_url" IS '资源链接(对应菜单级别的path和按钮级别的click)';
COMMENT ON COLUMN "public"."base_resource_info"."resource_sort" IS '排序字段';
COMMENT ON COLUMN "public"."base_resource_info"."resource_image" IS 'icon';
COMMENT ON COLUMN "public"."base_resource_info"."resource_component" IS '组件';
COMMENT ON COLUMN "public"."base_resource_info"."enabled" IS '是否启用(0：停用；1：启用)';
COMMENT ON COLUMN "public"."base_resource_info"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_resource_info"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_resource_info"."update_user" IS '更新者';
COMMENT ON COLUMN "public"."base_resource_info"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."base_resource_info"."describes" IS '描述';
COMMENT ON COLUMN "public"."base_resource_info"."resource_level" IS '1.模块 ，2.页面';

-- ----------------------------
-- Table structure for base_resource_info_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_resource_info_copy";
CREATE TABLE "public"."base_resource_info_copy" (
"resource_id" varchar(64) COLLATE "default" DEFAULT nextval('base_resource_info_id_seq'::regclass) NOT NULL,
"resource_name" varchar(50) COLLATE "default",
"resource_parent_id" varchar(64) COLLATE "default",
"resource_type" varchar(1) COLLATE "default",
"resource_title" varchar(50) COLLATE "default",
"resource_url" varchar(100) COLLATE "default",
"resource_sort" int2,
"resource_image" varchar(50) COLLATE "default",
"resource_component" varchar(100) COLLATE "default",
"enabled" varchar(1) COLLATE "default",
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now(),
"update_user" varchar(50) COLLATE "default",
"update_time" timestamp(6) DEFAULT now(),
"describes" varchar(200) COLLATE "default",
"resource_level" varchar(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_id" IS '主键id';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_name" IS '对应的是模块name;只有菜单级别有';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_parent_id" IS '父级菜单';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_type" IS '1.根节点2.父节点3.子节点';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_title" IS 'title资源标题(对应按钮级别的name和菜单级别的title)';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_url" IS '资源链接(对应菜单级别的path和按钮级别的click)';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_sort" IS '排序字段';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_image" IS 'icon';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_component" IS '组件';
COMMENT ON COLUMN "public"."base_resource_info_copy"."enabled" IS '是否启用(0：停用；1：启用)';
COMMENT ON COLUMN "public"."base_resource_info_copy"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_resource_info_copy"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_resource_info_copy"."update_user" IS '更新者';
COMMENT ON COLUMN "public"."base_resource_info_copy"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."base_resource_info_copy"."describes" IS '描述';
COMMENT ON COLUMN "public"."base_resource_info_copy"."resource_level" IS '1.模块 ，2.页面';

-- ----------------------------
-- Table structure for base_role_dataresource
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_role_dataresource";
CREATE TABLE "public"."base_role_dataresource" (
"role_data_id" varchar(64) COLLATE "default" DEFAULT nextval('base_role_dataresource_role_data_id_seq'::regclass) NOT NULL,
"role_id" varchar(64) COLLATE "default" NOT NULL,
"data_resource_id" varchar(64) COLLATE "default" NOT NULL,
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_role_dataresource"."role_data_id" IS '主键';
COMMENT ON COLUMN "public"."base_role_dataresource"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."base_role_dataresource"."data_resource_id" IS '数据权限id';
COMMENT ON COLUMN "public"."base_role_dataresource"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_role_dataresource"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_role_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_role_info";
CREATE TABLE "public"."base_role_info" (
"role_id" varchar(64) COLLATE "default" DEFAULT nextval('base_role_info_id_seq'::regclass) NOT NULL,
"role_name" varchar(50) COLLATE "default",
"role_parent_id" varchar(64) COLLATE "default",
"role_sort" int2 DEFAULT nextval('base_sort_id_seq'::regclass),
"enabled" varchar(1) COLLATE "default",
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now(),
"update_user" varchar(50) COLLATE "default",
"update_time" timestamp(6) DEFAULT now(),
"describes" varchar(200) COLLATE "default",
"role_type" char(1) COLLATE "default" DEFAULT 0,
"recheck_type" char(1) COLLATE "default" DEFAULT 0
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_role_info"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."base_role_info"."role_name" IS '角色名称';
COMMENT ON COLUMN "public"."base_role_info"."role_parent_id" IS '角色父级id';
COMMENT ON COLUMN "public"."base_role_info"."role_sort" IS '排序字段';
COMMENT ON COLUMN "public"."base_role_info"."enabled" IS '是否启用(0：停用；1：启用)';
COMMENT ON COLUMN "public"."base_role_info"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_role_info"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_role_info"."update_user" IS '更新者';
COMMENT ON COLUMN "public"."base_role_info"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."base_role_info"."describes" IS '描述';
COMMENT ON COLUMN "public"."base_role_info"."role_type" IS '角色类型 0：普通角色； 1：审核角色  (请勿修改); -1: 可审核可修改';
COMMENT ON COLUMN "public"."base_role_info"."recheck_type" IS '角色类型 0：普通角色； 1: 可审核可修改角色';

-- ----------------------------
-- Table structure for base_role_lineresource
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_role_lineresource";
CREATE TABLE "public"."base_role_lineresource" (
"role_line_id" varchar(64) COLLATE "default" DEFAULT nextval('base_role_lineresource_role_data_id_seq'::regclass) NOT NULL,
"role_id" varchar(64) COLLATE "default" NOT NULL,
"line_resource_id" varchar(64) COLLATE "default" NOT NULL,
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_role_lineresource"."role_line_id" IS '主键';
COMMENT ON COLUMN "public"."base_role_lineresource"."role_id" IS '角色id';
COMMENT ON COLUMN "public"."base_role_lineresource"."line_resource_id" IS '数据权限id';
COMMENT ON COLUMN "public"."base_role_lineresource"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_role_lineresource"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_role_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_role_resource";
CREATE TABLE "public"."base_role_resource" (
"role_resource_id" varchar(64) COLLATE "default" DEFAULT nextval('base_role_resource_id_seq'::regclass) NOT NULL,
"role_id" varchar(64) COLLATE "default" NOT NULL,
"resource_id" varchar(64) COLLATE "default" NOT NULL,
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_role_resource"."role_resource_id" IS '角色资源id';
COMMENT ON COLUMN "public"."base_role_resource"."role_id" IS '角色编号';
COMMENT ON COLUMN "public"."base_role_resource"."resource_id" IS '资源编号';
COMMENT ON COLUMN "public"."base_role_resource"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_role_resource"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_sys_alarm_handle_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_sys_alarm_handle_result";
CREATE TABLE "public"."base_sys_alarm_handle_result" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"handle_context" varchar(300) COLLATE "default",
"handle_status" varchar(1) COLLATE "default",
"crate_time" timestamp(6) DEFAULT now(),
"handle_isvalid" char(1) COLLATE "default",
"remark" varchar(255) COLLATE "default",
"handle_type" varchar(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_sys_alarm_handle_result"."handle_context" IS '处理内容';
COMMENT ON COLUMN "public"."base_sys_alarm_handle_result"."handle_status" IS '处理状态  1：已处理；  2：误报';
COMMENT ON COLUMN "public"."base_sys_alarm_handle_result"."crate_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_sys_alarm_handle_result"."handle_isvalid" IS '1：启用；0：禁用';
COMMENT ON COLUMN "public"."base_sys_alarm_handle_result"."handle_type" IS '处理类型：1，处理；2：审核';

-- ----------------------------
-- Table structure for base_sys_param_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_sys_param_info";
CREATE TABLE "public"."base_sys_param_info" (
"sys_uuid" int4 DEFAULT nextval('base_sys_param_info_sys_uuid_seq'::regclass) NOT NULL,
"param_name" varchar(50) COLLATE "default",
"param_value" varchar(3000) COLLATE "default",
"param_isvalid" char(1) COLLATE "default",
"crate_time" timestamp(6) DEFAULT now(),
"remark" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_sys_param_info"."remark" IS '备注';

-- ----------------------------
-- Table structure for base_user_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_user_info";
CREATE TABLE "public"."base_user_info" (
"user_id" varchar(64) COLLATE "default" DEFAULT nextval('base_user_info_id_seq'::regclass) NOT NULL,
"user_account" varchar(50) COLLATE "default" NOT NULL,
"user_password" varchar(100) COLLATE "default" NOT NULL,
"user_gender" varchar(1) COLLATE "default",
"user_real_name" varchar(50) COLLATE "default",
"enabled" varchar(1) COLLATE "default",
"user_telephone" varchar(20) COLLATE "default",
"user_mobile" varchar(20) COLLATE "default",
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now(),
"update_user" varchar(50) COLLATE "default",
"update_time" timestamp(6) DEFAULT now(),
"describes" varchar(200) COLLATE "default",
"user_org_uuid" varchar(64) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_user_info"."user_id" IS '用户id';
COMMENT ON COLUMN "public"."base_user_info"."user_account" IS '用户名';
COMMENT ON COLUMN "public"."base_user_info"."user_password" IS '密码';
COMMENT ON COLUMN "public"."base_user_info"."user_gender" IS '性别 1.男 2 女';
COMMENT ON COLUMN "public"."base_user_info"."user_real_name" IS '姓名';
COMMENT ON COLUMN "public"."base_user_info"."enabled" IS '是否启用(0：停用；1：启用)';
COMMENT ON COLUMN "public"."base_user_info"."user_telephone" IS '联系电话';
COMMENT ON COLUMN "public"."base_user_info"."user_mobile" IS '移动电话';
COMMENT ON COLUMN "public"."base_user_info"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_user_info"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."base_user_info"."update_user" IS '更新者';
COMMENT ON COLUMN "public"."base_user_info"."update_time" IS '更新时间';
COMMENT ON COLUMN "public"."base_user_info"."describes" IS '描述';

-- ----------------------------
-- Table structure for base_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_user_role";
CREATE TABLE "public"."base_user_role" (
"user_role_id" varchar(64) COLLATE "default" DEFAULT nextval('base_user_role_id_seq'::regclass) NOT NULL,
"user_id" varchar(64) COLLATE "default" NOT NULL,
"role_id" varchar(64) COLLATE "default" NOT NULL,
"create_user" varchar(50) COLLATE "default",
"create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_user_role"."user_role_id" IS '用户角色主键';
COMMENT ON COLUMN "public"."base_user_role"."user_id" IS '用户编号';
COMMENT ON COLUMN "public"."base_user_role"."role_id" IS '角色编号';
COMMENT ON COLUMN "public"."base_user_role"."create_user" IS '创建者';
COMMENT ON COLUMN "public"."base_user_role"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for base_video_param_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."base_video_param_info";
CREATE TABLE "public"."base_video_param_info" (
"video_uuid" int4 DEFAULT nextval('base_video_param_info_uuid_seq'::regclass) NOT NULL,
"video_name" varchar(50) COLLATE "default",
"video_value" varchar(10) COLLATE "default",
"video_group_number" int2,
"video_isvalid" char(1) COLLATE "default",
"video_create_time" timestamp(6) DEFAULT now()
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."base_video_param_info"."video_uuid" IS '车辆视频位置uuid';
COMMENT ON COLUMN "public"."base_video_param_info"."video_name" IS '车辆视频位置名称';
COMMENT ON COLUMN "public"."base_video_param_info"."video_value" IS '车辆视频位置取值';
COMMENT ON COLUMN "public"."base_video_param_info"."video_group_number" IS '车辆视频位置分组';
COMMENT ON COLUMN "public"."base_video_param_info"."video_isvalid" IS '是否有效，1：有效，0：无效';

-- ----------------------------
-- Table structure for dw_dim_bd_osm_region
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bd_osm_region";
CREATE TABLE "public"."dw_dim_bd_osm_region" (
"bd_region_district_id" varchar(40) COLLATE "default" NOT NULL,
"osm_region_district_id" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bd_osm_region" IS '行政区划映射表';

-- ----------------------------
-- Table structure for dw_dim_bd_region
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bd_region";
CREATE TABLE "public"."dw_dim_bd_region" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"district_id" int4,
"province" varchar(20) COLLATE "default",
"city" varchar(20) COLLATE "default",
"city_geocode" int4,
"district" varchar(20) COLLATE "default",
"district_geocode" int4,
"lon" numeric,
"lat" numeric,
"s_atime" timestamp(6),
"s_mtime" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bd_region" IS '行政区划';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."uuid" IS '主键编号';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."district_id" IS '城市代码';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."province" IS '省市名称';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."city" IS '城市名称';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."city_geocode" IS '区域编号';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."district" IS '区划名称';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."district_geocode" IS '区划区域编号';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."lon" IS '经度';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."lat" IS '维度';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bd_region"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_bd_weather
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bd_weather";
CREATE TABLE "public"."dw_dim_bd_weather" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"country" varchar(40) COLLATE "default",
"province" varchar(20) COLLATE "default",
"city" varchar(20) COLLATE "default",
"name" varchar(20) COLLATE "default",
"id" varchar(20) COLLATE "default",
"text" varchar(20) COLLATE "default",
"temp" int2,
"feels_like" int2,
"rh" int2,
"wind_class" varchar(20) COLLATE "default",
"wind_dir" varchar(20) COLLATE "default",
"uptime" varchar(20) COLLATE "default",
"s_atime" timestamp(6),
"s_mtime" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bd_weather" IS '百度天气信息';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."country" IS '国家名称';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."province" IS '省市名称';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."city" IS '城市名称';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."name" IS '区县名称';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."id" IS '区县ID';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."text" IS '天气现象';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."temp" IS '温度（C）,异常值999999';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."feels_like" IS '体感温度，异常值999999';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."rh" IS '相对湿度（%），异常值999999';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."wind_class" IS '风力等级';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."wind_dir" IS '风力描述';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."uptime" IS '数据更新时间';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bd_weather"."s_mtime" IS '更新时间';

-- ----------------------------
-- Table structure for dw_dim_bd_weather_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bd_weather_type";
CREATE TABLE "public"."dw_dim_bd_weather_type" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"name" varchar(40) COLLATE "default",
"name_en_day" varchar(40) COLLATE "default",
"name_en_night" varchar(40) COLLATE "default",
"type" int2,
"s_atime" varchar(40) COLLATE "default",
"s_mtime" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bd_weather_type" IS '百度天气分类信息，根据百度提供的天气现象进行分类使用';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."uuid" IS '编码';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."name" IS '现象';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."name_en_day" IS '白天英文';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."name_en_night" IS '夜间英文';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."type" IS '天气分类';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."s_atime" IS '新建时间';
COMMENT ON COLUMN "public"."dw_dim_bd_weather_type"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_bus
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus";
CREATE TABLE "public"."dw_dim_bus" (
"bus_uuid" varchar(32) COLLATE "default" NOT NULL,
"bus_dev_uuid" varchar(32) COLLATE "default",
"bus_plate_number" varchar(32) COLLATE "default",
"bus_self_code" varchar(32) COLLATE "default",
"bus_fuel_type" varchar(32) COLLATE "default",
"bus_isvalid" char(1) COLLATE "default",
"bus_org_uuid" varchar(32) COLLATE "default",
"bus_line_uuid" varchar(32) COLLATE "default",
"bus_load_number" int4,
"bus_create_time" timestamp(6),
"bus_drop_flag" char(1) COLLATE "default",
"bus_state" numeric(4),
"bus_product_use" varchar(40) COLLATE "default",
"bus_first_operation_time" varchar(40) COLLATE "default",
"bus_brand" varchar(40) COLLATE "default",
"bus_model" varchar(40) COLLATE "default",
"bus_purchase_time" varchar(40) COLLATE "default",
"bus_scrapped_year" varchar(40) COLLATE "default",
"bus_length" varchar(40) COLLATE "default",
"bus_air_conditioner" varchar(40) COLLATE "default",
"bus_tyre_count" varchar(40) COLLATE "default",
"bus_safety_hammer" varchar(40) COLLATE "default",
"bus_fireextinguisher" varchar(40) COLLATE "default",
"bus_fireextinguish_bomb" varchar(40) COLLATE "default",
"bus_year_check_date" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus" IS '车辆信息表';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_dev_uuid" IS '设备编号';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_self_code" IS '车辆自编号';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_fuel_type" IS '燃料类型';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_isvalid" IS '启用标记1：启用0：禁用';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_org_uuid" IS '所属机构';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_line_uuid" IS '所属线路';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_load_number" IS '荷载人数';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_drop_flag" IS '删除标示 0 正常 1 删除';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_state" IS '车辆状态';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_product_use" IS '生成车辆用途';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_first_operation_time" IS '首次投入运营时间';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_brand" IS '车辆品牌';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_model" IS '车辆型号';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_purchase_time" IS '购车时间';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_scrapped_year" IS '拟报废年度';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_length" IS '车辆长度';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_air_conditioner" IS '空调车';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_tyre_count" IS '轮胎数量';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_safety_hammer" IS '安全锤配置';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_fireextinguisher" IS '灭火器配置';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_fireextinguish_bomb" IS '灭火弹配置';
COMMENT ON COLUMN "public"."dw_dim_bus"."bus_year_check_date" IS '年检时间';

-- ----------------------------
-- Table structure for dw_dim_bus_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_copy";
CREATE TABLE "public"."dw_dim_bus_copy" (
"bus_uuid" varchar(32) COLLATE "default" NOT NULL,
"bus_dev_uuid" varchar(32) COLLATE "default",
"bus_plate_number" varchar(32) COLLATE "default",
"bus_self_code" varchar(32) COLLATE "default",
"bus_fuel_type" varchar(32) COLLATE "default",
"bus_isvalid" char(1) COLLATE "default",
"bus_org_uuid" varchar(32) COLLATE "default",
"bus_line_uuid" varchar(32) COLLATE "default",
"bus_load_number" int4,
"bus_create_time" timestamp(6),
"bus_drop_flag" char(1) COLLATE "default",
"bus_state" numeric(4),
"bus_product_use" varchar(40) COLLATE "default",
"bus_first_operation_time" varchar(40) COLLATE "default",
"bus_brand" varchar(40) COLLATE "default",
"bus_model" varchar(40) COLLATE "default",
"bus_purchase_time" varchar(40) COLLATE "default",
"bus_scrapped_year" varchar(40) COLLATE "default",
"bus_length" varchar(40) COLLATE "default",
"bus_air_conditioner" varchar(40) COLLATE "default",
"bus_tyre_count" varchar(40) COLLATE "default",
"bus_safety_hammer" varchar(40) COLLATE "default",
"bus_fireextinguisher" varchar(40) COLLATE "default",
"bus_fireextinguish_bomb" varchar(40) COLLATE "default",
"bus_year_check_date" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_copy" IS '车辆信息表';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_dev_uuid" IS '设备编号';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_self_code" IS '车辆自编号';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_fuel_type" IS '燃料类型';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_isvalid" IS '启用标记1：启用0：禁用';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_org_uuid" IS '所属机构';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_line_uuid" IS '所属线路';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_load_number" IS '荷载人数';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_drop_flag" IS '删除标示 0 正常 1 删除';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_state" IS '车辆状态';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_product_use" IS '生成车辆用途';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_first_operation_time" IS '首次投入运营时间';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_brand" IS '车辆品牌';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_model" IS '车辆型号';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_purchase_time" IS '购车时间';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_scrapped_year" IS '拟报废年度';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_length" IS '车辆长度';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_air_conditioner" IS '空调车';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_tyre_count" IS '轮胎数量';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_safety_hammer" IS '安全锤配置';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_fireextinguisher" IS '灭火器配置';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_fireextinguish_bomb" IS '灭火弹配置';
COMMENT ON COLUMN "public"."dw_dim_bus_copy"."bus_year_check_date" IS '年检时间';

-- ----------------------------
-- Table structure for dw_dim_bus_driver
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_driver";
CREATE TABLE "public"."dw_dim_bus_driver" (
"drv_uuid" varchar(32) COLLATE "default" NOT NULL,
"drv_org_uuid" varchar(32) COLLATE "default",
"drv_line_uuid" varchar(32) COLLATE "default",
"drv_name" varchar(30) COLLATE "default",
"drv_sex" varchar(1) COLLATE "default",
"drv_birthday" timestamp(6),
"drv_employee_id" varchar(30) COLLATE "default",
"drv_per_id" varchar(20) COLLATE "default",
"drv_ic_card" varchar(50) COLLATE "default",
"drv_isvalid" char(1) COLLATE "default",
"drv_create_time" timestamp(6),
"drv_drop_flag" char(1) COLLATE "default",
"drv_type" varchar(20) COLLATE "default",
"unit_name_erp" varchar(200) COLLATE "default",
"dept_name_erp" varchar(200) COLLATE "default",
"post_class_erp" varchar(40) COLLATE "default",
"post_type_name_erp" varchar(1000) COLLATE "default",
"post_erp" varchar(1000) COLLATE "default",
"post_time_erp" varchar(1000) COLLATE "default",
"job_type_erp" varchar(4) COLLATE "default",
"worker_level_erp" varchar(4) COLLATE "default",
"work_nature_erp" varchar(4) COLLATE "default",
"driver_license_erp" varchar(4) COLLATE "default",
"work_time_erp" varchar(40) COLLATE "default",
"unit_work_time_erp" varchar(40) COLLATE "default",
"post_type_erp" varchar(1000) COLLATE "default",
"post_uuid_erp" varchar(1000) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_org_uuid" IS '所属机构';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_line_uuid" IS '所属线路';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_name" IS '姓名';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_sex" IS '性别';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_birthday" IS '出生日期';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_employee_id" IS '员工编号';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_per_id" IS '身份证号';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_ic_card" IS 'IC卡编号';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_isvalid" IS '删除标识1启用，2禁用';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_drop_flag" IS '删除标示  0 正常 1 删除'';';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."drv_type" IS '人员类型';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."unit_name_erp" IS '单位';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."dept_name_erp" IS '部门';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_class_erp" IS '职级';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_type_name_erp" IS '岗位类型';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_erp" IS '岗位';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_time_erp" IS '到岗时间';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."job_type_erp" IS '工作类型（实习、临时、正式）';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."worker_level_erp" IS '工人职称（字典）';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."work_nature_erp" IS '工作性质';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."driver_license_erp" IS '驾驶执照（字典）';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."work_time_erp" IS '参加工作时间';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."unit_work_time_erp" IS '本单位工作时间';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_type_erp" IS '岗位类型编码';
COMMENT ON COLUMN "public"."dw_dim_bus_driver"."post_uuid_erp" IS '岗位字典UUID';

-- ----------------------------
-- Table structure for dw_dim_bus_line
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_line";
CREATE TABLE "public"."dw_dim_bus_line" (
"line_uuid" varchar(32) COLLATE "default" NOT NULL,
"line_org_uuid" varchar(32) COLLATE "default",
"line_name" varchar(30) COLLATE "default",
"line_isvalid" char(1) COLLATE "default",
"line_isloop" int4,
"line_bf_type" int4,
"line_drop_flag" char(1) COLLATE "default",
"line_up_first_date" varchar(10) COLLATE "default",
"line_up_last_date" varchar(10) COLLATE "default",
"line_create_time" timestamp(6),
"line_up_plan" varchar(50) COLLATE "default",
"line_down_plan" varchar(50) COLLATE "default",
"line_up_station_count" int2 DEFAULT 0,
"line_down_station_count" int2 DEFAULT 0,
"line_type" varchar(1) COLLATE "default" DEFAULT 0,
"line_down_first_date" varchar(10) COLLATE "default",
"line_down_last_date" varchar(10) COLLATE "default",
"par_line_uuid" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_line" IS '线路表';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_org_uuid" IS '所属机构';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_isvalid" IS '删除标记
1：启用
0：禁用';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_isloop" IS '是否环线车；0：否；1：是';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_bf_type" IS '发车类型（0单向 ，1双向，2环线）';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_drop_flag" IS '删除标示 0：否；1：是';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_up_first_date" IS '上行首班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_up_last_date" IS '上行末班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_create_time" IS '修改时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_up_plan" IS '上行计划';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_down_plan" IS '下行计划';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_up_station_count" IS '线路上行站点的数量，默认为0';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_down_station_count" IS '线路下行站点的数量，默认为0';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_type" IS ' 线路类型：0：父线路；2：子线路';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_down_first_date" IS '下行首班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."line_down_last_date" IS '下行末班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line"."par_line_uuid" IS '父线路uuid';

-- ----------------------------
-- Table structure for dw_dim_bus_line_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_line_copy";
CREATE TABLE "public"."dw_dim_bus_line_copy" (
"line_uuid" varchar(32) COLLATE "default" NOT NULL,
"line_org_uuid" varchar(32) COLLATE "default",
"line_name" varchar(30) COLLATE "default",
"line_isvalid" char(1) COLLATE "default",
"line_isloop" int4,
"line_bf_type" int4,
"line_drop_flag" char(1) COLLATE "default",
"line_up_first_date" varchar(10) COLLATE "default",
"line_up_last_date" varchar(10) COLLATE "default",
"line_create_time" timestamp(6),
"line_up_plan" varchar(50) COLLATE "default",
"line_down_plan" varchar(50) COLLATE "default",
"line_up_station_count" int2 DEFAULT 0,
"line_down_station_count" int2 DEFAULT 0,
"line_type" varchar(1) COLLATE "default" DEFAULT 0,
"line_down_first_date" varchar(10) COLLATE "default",
"line_down_last_date" varchar(10) COLLATE "default",
"par_line_uuid" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_line_copy" IS '线路表';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_org_uuid" IS '所属机构';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_isvalid" IS '删除标记
1：启用
0：禁用';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_isloop" IS '是否环线车；0：否；1：是';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_bf_type" IS '发车类型（0单向 ，1双向，2环线）';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_drop_flag" IS '删除标示 0：否；1：是';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_up_first_date" IS '上行首班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_up_last_date" IS '上行末班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_create_time" IS '修改时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_up_plan" IS '上行计划';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_down_plan" IS '下行计划';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_up_station_count" IS '线路上行站点的数量，默认为0';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_down_station_count" IS '线路下行站点的数量，默认为0';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_type" IS ' 线路类型：0：父线路；2：子线路';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_down_first_date" IS '下行首班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."line_down_last_date" IS '下行末班时间';
COMMENT ON COLUMN "public"."dw_dim_bus_line_copy"."par_line_uuid" IS '父线路uuid';

-- ----------------------------
-- Table structure for dw_dim_bus_line_device_id
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_line_device_id";
CREATE TABLE "public"."dw_dim_bus_line_device_id" (
"bld_uuid" varchar(20) COLLATE "default" NOT NULL,
"bld_line_uuid" varchar(20) COLLATE "default" NOT NULL,
"bld_line_type" varchar(20) COLLATE "default",
"bld_device_line_id" int4,
"bld_flag" int2 DEFAULT 0
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_line_device_id" IS '系统线路到设备上线路ID的对应。';
COMMENT ON COLUMN "public"."dw_dim_bus_line_device_id"."bld_line_uuid" IS '线路在设备上的ID';

-- ----------------------------
-- Table structure for dw_dim_bus_line_device_id_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_line_device_id_copy";
CREATE TABLE "public"."dw_dim_bus_line_device_id_copy" (
"bld_uuid" varchar(20) COLLATE "default" NOT NULL,
"bld_line_uuid" varchar(20) COLLATE "default" NOT NULL,
"bld_line_type" varchar(20) COLLATE "default",
"bld_device_line_id" int4,
"bld_flag" int2 DEFAULT 0
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_line_device_id_copy" IS '系统线路到设备上线路ID的对应。';
COMMENT ON COLUMN "public"."dw_dim_bus_line_device_id_copy"."bld_line_uuid" IS '线路在设备上的ID';

-- ----------------------------
-- Table structure for dw_dim_bus_station
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_station";
CREATE TABLE "public"."dw_dim_bus_station" (
"sta_uuid" varchar(32) COLLATE "default" NOT NULL,
"sta_name" varchar(50) COLLATE "default",
"sta_address" varchar(500) COLLATE "default",
"sta_isvalid" char(1) COLLATE "default",
"sta_drop_flag" char(1) COLLATE "default",
"sta_no" varchar(20) COLLATE "default",
"sta_lng" varchar(30) COLLATE "default" DEFAULT 0,
"sta_lnt" varchar(30) COLLATE "default" DEFAULT 0,
"direction_angle" varchar(20) COLLATE "default",
"sta_direction" varchar(20) COLLATE "default",
"sta_create_time" timestamp(6),
"sta_district" varchar(50) COLLATE "default",
"sta_township" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_station" IS '站点信息表';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_name" IS '站名';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_address" IS '详细地址';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_isvalid" IS '删除标记  
1：启用
0：禁用';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_drop_flag" IS '删除标示（0:未删除 1 ：删除）';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_no" IS '站点编号';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_lng" IS '站点经度';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_lnt" IS '站点纬度';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."direction_angle" IS '方向角';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_direction" IS '方向:东南西北';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_district" IS '行政区划';
COMMENT ON COLUMN "public"."dw_dim_bus_station"."sta_township" IS '街道';

-- ----------------------------
-- Table structure for dw_dim_bus_sys_org
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_sys_org";
CREATE TABLE "public"."dw_dim_bus_sys_org" (
"org_uuid" varchar(32) COLLATE "default" NOT NULL,
"org_name" varchar(32) COLLATE "default",
"org_type" int4,
"org_parent_uuid" varchar(32) COLLATE "default",
"org_enabled" char(1) COLLATE "default",
"org_sort_index" int4,
"org_create_time" timestamp(6),
"org_short_name" varchar(30) COLLATE "default",
"org_drop_flag" char(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_sys_org" IS '组织机构表';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_uuid" IS '组织机构编号';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_name" IS '组织机构名称';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_type" IS '组织机构类型0:总公司 2：分公司 3：路队4：部门';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_parent_uuid" IS '上级机构';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_enabled" IS '是否启用（1：启用0：禁用）';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_sort_index" IS '排序号';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_short_name" IS '简称';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org"."org_drop_flag" IS '逻辑删除标识符';

-- ----------------------------
-- Table structure for dw_dim_bus_sys_org_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_bus_sys_org_copy";
CREATE TABLE "public"."dw_dim_bus_sys_org_copy" (
"org_uuid" varchar(32) COLLATE "default" NOT NULL,
"org_name" varchar(32) COLLATE "default",
"org_type" int4,
"org_parent_uuid" varchar(32) COLLATE "default",
"org_enabled" char(1) COLLATE "default",
"org_sort_index" int4,
"org_create_time" timestamp(6),
"org_short_name" varchar(30) COLLATE "default",
"org_drop_flag" char(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_bus_sys_org_copy" IS '组织机构表';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_uuid" IS '组织机构编号';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_name" IS '组织机构名称';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_type" IS '组织机构类型0:总公司 2：分公司 3：路队4：部门';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_parent_uuid" IS '上级机构';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_enabled" IS '是否启用（1：启用0：禁用）';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_sort_index" IS '排序号';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_short_name" IS '简称';
COMMENT ON COLUMN "public"."dw_dim_bus_sys_org_copy"."org_drop_flag" IS '逻辑删除标识符';

-- ----------------------------
-- Table structure for dw_dim_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_device";
CREATE TABLE "public"."dw_dim_device" (
"dev_uuid" varchar(32) COLLATE "default" NOT NULL,
"dev_code" varchar(32) COLLATE "default",
"dev_version" varchar(10) COLLATE "default",
"dev_sim_num" varchar(50) COLLATE "default",
"dev_isvalid" char(1) COLLATE "default",
"dev_create_time" timestamp(6),
"dev_drop_flag" char(1) COLLATE "default",
"dev_key" varchar(20) COLLATE "default",
"dev_type" varchar(10) COLLATE "default",
"dev_ref_id" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_device" IS '设备管理';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_version" IS '版本';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_sim_num" IS '设备卡号';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_isvalid" IS '启用标记1：启用0：禁用';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_drop_flag" IS '删除标示0：未删除 1 删除';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_key" IS ' 鉴权码';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_type" IS '设备类型 F3R , FTP, F3R-FTP';
COMMENT ON COLUMN "public"."dw_dim_device"."dev_ref_id" IS '终端Id';

-- ----------------------------
-- Table structure for dw_dim_line_station
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_line_station";
CREATE TABLE "public"."dw_dim_line_station" (
"ls_uuid" varchar(32) COLLATE "default" NOT NULL,
"ls_line_uuid" varchar(32) COLLATE "default",
"ls_line_type" varchar(20) COLLATE "default",
"ls_sta_uuid" varchar(32) COLLATE "default",
"ls_sta_lng" varchar(30) COLLATE "default",
"ls_sta_lat" varchar(30) COLLATE "default",
"ls_sequence" int4,
"ls_delete_flag" char(1) COLLATE "default" DEFAULT 0,
"ls_delete_time" timestamp(6),
"ls_major" char(1) COLLATE "default" DEFAULT 0,
"ls_start_to_this_distance" varchar(20) COLLATE "default",
"ls_pre_station_distance" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_line_station" IS '线路站点关联表，包括线路类型，线路对应站点顺序';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_line_uuid" IS '线路uuid';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_line_type" IS '线路类型
1：上行
2：下行';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_sta_uuid" IS '站点uuid';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_sta_lng" IS '站点经度';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_sta_lat" IS '站点纬度';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_sequence" IS '站点序号';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_delete_flag" IS '删除标志 0--正常数据 1--删除数据';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_delete_time" IS '删除时间';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_major" IS '大站标志 0 -- 普通站点；1--大站';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_start_to_this_distance" IS '起始站点到本站的距离（米）';
COMMENT ON COLUMN "public"."dw_dim_line_station"."ls_pre_station_distance" IS '距离上一站距离，单位为米';

-- ----------------------------
-- Table structure for dw_dim_line_station_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_line_station_copy";
CREATE TABLE "public"."dw_dim_line_station_copy" (
"ls_uuid" varchar(32) COLLATE "default" NOT NULL,
"ls_line_uuid" varchar(32) COLLATE "default",
"ls_line_type" varchar(20) COLLATE "default",
"ls_sta_uuid" varchar(32) COLLATE "default",
"ls_sta_lng" varchar(30) COLLATE "default",
"ls_sta_lat" varchar(30) COLLATE "default",
"ls_sequence" int4,
"ls_delete_flag" char(1) COLLATE "default" DEFAULT 0,
"ls_delete_time" timestamp(6),
"ls_major" char(1) COLLATE "default" DEFAULT 0,
"ls_start_to_this_distance" varchar(20) COLLATE "default",
"ls_pre_station_distance" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_line_station_copy" IS '线路站点关联表，包括线路类型，线路对应站点顺序';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_line_uuid" IS '线路uuid';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_line_type" IS '线路类型
1：上行
2：下行';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_sta_uuid" IS '站点uuid';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_sta_lng" IS '站点经度';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_sta_lat" IS '站点纬度';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_sequence" IS '站点序号';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_delete_flag" IS '删除标志 0--正常数据 1--删除数据';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_delete_time" IS '删除时间';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_major" IS '大站标志 0 -- 普通站点；1--大站';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_start_to_this_distance" IS '起始站点到本站的距离（米）';
COMMENT ON COLUMN "public"."dw_dim_line_station_copy"."ls_pre_station_distance" IS '距离上一站距离，单位为米';

-- ----------------------------
-- Table structure for dw_dim_map_line
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_map_line";
CREATE TABLE "public"."dw_dim_map_line" (
"ml_uuid" varchar(32) COLLATE "default" NOT NULL,
"ml_line_uuid" varchar(32) COLLATE "default",
"ml_sta_uuid" varchar(32) COLLATE "default",
"ml_lng" varchar(30) COLLATE "default",
"ml_lat" varchar(30) COLLATE "default",
"ml_sequence" int4,
"ml_line_type" varchar(20) COLLATE "default",
"ml_distance" float8,
"ml_whichstop" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_line_uuid" IS '线路uuid';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_sta_uuid" IS '站点uuid';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_lng" IS '经度';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_lat" IS '维度';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_sequence" IS '站序';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_line_type" IS '线路类型1，上行，2，下行';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_distance" IS '从起点到该点的距离，单位为米';
COMMENT ON COLUMN "public"."dw_dim_map_line"."ml_whichstop" IS '第几站';

-- ----------------------------
-- Table structure for dw_dim_map_line_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_map_line_copy";
CREATE TABLE "public"."dw_dim_map_line_copy" (
"ml_uuid" varchar(32) COLLATE "default" NOT NULL,
"ml_line_uuid" varchar(32) COLLATE "default",
"ml_sta_uuid" varchar(32) COLLATE "default",
"ml_lng" varchar(30) COLLATE "default",
"ml_lat" varchar(30) COLLATE "default",
"ml_sequence" int4,
"ml_line_type" varchar(20) COLLATE "default",
"ml_distance" float8,
"ml_whichstop" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_line_uuid" IS '线路uuid';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_sta_uuid" IS '站点uuid';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_lng" IS '经度';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_lat" IS '维度';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_sequence" IS '站序';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_line_type" IS '线路类型1，上行，2，下行';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_distance" IS '从起点到该点的距离，单位为米';
COMMENT ON COLUMN "public"."dw_dim_map_line_copy"."ml_whichstop" IS '第几站';

-- ----------------------------
-- Table structure for dw_dim_osm_node
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_osm_node";
CREATE TABLE "public"."dw_dim_osm_node" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"link_roads" varchar(255) COLLATE "default",
"in_link_roads" varchar(255) COLLATE "default",
"out_link_roads" varchar(255) COLLATE "default",
"type_uuid" varchar(40) COLLATE "default",
"name" varchar(40) COLLATE "default",
"mark" varchar(200) COLLATE "default",
"geom" "public"."geometry",
"s_atime" timestamp(0),
"s_mtime" timestamp(0)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_osm_node"."uuid" IS '道路节点ID';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."link_roads" IS '关联道路ID';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."in_link_roads" IS '进 道路ID';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."out_link_roads" IS '出 道路ID';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."type_uuid" IS '节点类型ID';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."name" IS '节点名称';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."mark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."geom" IS '空间数据';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_osm_node"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_osm_node_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_osm_node_type";
CREATE TABLE "public"."dw_dim_osm_node_type" (
"uuid" varchar(30) COLLATE "default" NOT NULL,
"type" varchar(20) COLLATE "default",
"wait_time" float4,
"name" varchar(20) COLLATE "default",
"mark" varchar(40) COLLATE "default",
"s_atime" timestamp(0),
"s_mtime" timestamp(0)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."type" IS '原OSM中节点类型编码';
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."wait_time" IS '等待时间（单位：分钟）';
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."name" IS '节点类型名称';
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."mark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_osm_node_type"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_osm_region
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_osm_region";
CREATE TABLE "public"."dw_dim_osm_region" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"name" varchar(50) COLLATE "default",
"level" varchar(2) COLLATE "default",
"pid" varchar(40) COLLATE "default",
"area" float8,
"mark" varchar(200) COLLATE "default",
"geom" "public"."geometry",
"s_atime" timestamp(0),
"s_mtime" timestamp(0)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_osm_region"."uuid" IS '数据ID（行政区编码）';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."name" IS '行政区名称';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."level" IS '行政区划等级';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."pid" IS '所属行政区划ID';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."area" IS '面积';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."mark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."geom" IS '空间数据';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_osm_region"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_osm_road
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_osm_road";
CREATE TABLE "public"."dw_dim_osm_road" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"s_node_uuid" varchar(30) COLLATE "default",
"e_node_uuid" varchar(30) COLLATE "default",
"driving_direction" varchar(1) COLLATE "default",
"name" varchar(50) COLLATE "default",
"class_uuid" varchar(40) COLLATE "default",
"layer" varchar(2) COLLATE "default",
"max_speed" varchar(10) COLLATE "default",
"is_tunnel" varchar(1) COLLATE "default",
"length" varchar(10) COLLATE "default",
"mark" varchar(200) COLLATE "default",
"geom" "public"."geometry",
"s_atime" timestamp(0),
"s_mtime" timestamp(0)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_osm_road"."uuid" IS '道路ID';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."s_node_uuid" IS '开始节点ID';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."e_node_uuid" IS '结束节点ID';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."driving_direction" IS '行驶方向（1：双向；2：顺向；3：逆向）';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."name" IS '道路名称';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."class_uuid" IS '道路等级';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."layer" IS '所处图层';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."max_speed" IS '最高限速';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."is_tunnel" IS '是否是隧道';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."length" IS '道路长度';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."mark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."geom" IS '空间数据';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_osm_road"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_osm_road_class
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_osm_road_class";
CREATE TABLE "public"."dw_dim_osm_road_class" (
"uuid" varchar(40) COLLATE "default" NOT NULL,
"class" varchar(20) COLLATE "default",
"level" int2,
"name" varchar(20) COLLATE "default",
"speed" float8,
"mark" varchar(200) COLLATE "default",
"s_atime" timestamp(0),
"s_mtime" timestamp(0)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."uuid" IS '数据ID';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."class" IS '对应原OSM中道路类型编码';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."level" IS '自定义道路等级';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."name" IS '自定义道路名称';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."speed" IS '自定义平均速度';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."mark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."s_atime" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_osm_road_class"."s_mtime" IS '修改时间';

-- ----------------------------
-- Table structure for dw_dim_other_bus_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_other_bus_device";
CREATE TABLE "public"."dw_dim_other_bus_device" (
"bus_dev_uuid" varchar(32) COLLATE "default" DEFAULT nextval('dw_dim_other_device_id_bus_dev_uuid_seq'::regclass) NOT NULL,
"bus_uuid" varchar(32) COLLATE "default" NOT NULL,
"dev_uuid" varchar(32) COLLATE "default" NOT NULL,
"create_user" varchar(32) COLLATE "default",
"create_time" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for dw_dim_other_device
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_other_device";
CREATE TABLE "public"."dw_dim_other_device" (
"dev_uuid" varchar(32) COLLATE "default" DEFAULT nextval('dw_dim_other_device_dev_uuid_seq'::regclass) NOT NULL,
"dev_code" varchar(32) COLLATE "default",
"dev_model_num" varchar(32) COLLATE "default",
"dev_version" varchar(10) COLLATE "default",
"dev_plate_number" varchar(20) COLLATE "default",
"dev_sim_num" varchar(50) COLLATE "default",
"dev_online_status" varchar(1) COLLATE "default",
"dev_isvalid" varchar(1) COLLATE "default",
"dev_phone" varchar(12) COLLATE "default",
"dev_create_user" varchar(30) COLLATE "default",
"dev_create_time" timestamp(6),
"dev_update_user" varchar(30) COLLATE "default",
"dev_update_time" timestamp(6),
"dev_drop_flag" varchar(1) COLLATE "default" DEFAULT 0,
"dev_remark" varchar(255) COLLATE "default",
"dev_key" varchar(32) COLLATE "default",
"dev_online_time" timestamp(6),
"dev_class" varchar(32) COLLATE "default",
"dev_arm_version" varchar(255) COLLATE "default",
"dev_arm_crc" varchar(255) COLLATE "default",
"dev_dsp_version" varchar(255) COLLATE "default",
"dev_dsp_crc" varchar(255) COLLATE "default",
"dev_bus_plate_number" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_model_num" IS '型号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_version" IS '版本号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_sim_num" IS 'sim卡号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_online_status" IS '设备在线状态
0：断开
1：在线';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_isvalid" IS '1 启用 0 禁用 ';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_phone" IS '通用电话';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_drop_flag" IS '删除标示 0：未删除 1 删除';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_key" IS '鉴权码';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_online_time" IS '在线更新时间';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_class" IS '设备类别';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_arm_version" IS 'arm版本号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_arm_crc" IS 'arm秘钥';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_dsp_version" IS 'dsp版本号';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_dsp_crc" IS 'dsp秘钥';
COMMENT ON COLUMN "public"."dw_dim_other_device"."dev_bus_plate_number" IS '车牌号';

-- ----------------------------
-- Table structure for dw_dim_pl_sys_datadict
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_pl_sys_datadict";
CREATE TABLE "public"."dw_dim_pl_sys_datadict" (
"pl_uuid" varchar(20) COLLATE "default" NOT NULL,
"pl_value" varchar(50) COLLATE "default" NOT NULL,
"pl_display" varchar(50) COLLATE "default" NOT NULL,
"pl_sort" numeric(4) NOT NULL,
"pl_isvalid" char(1) COLLATE "default" DEFAULT '1'::bpchar,
"pl_warn_level" varchar(50) COLLATE "default",
"pl_remark" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_value" IS '编码值（同一编码code内，不能重复）';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_display" IS '显示值';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_sort" IS '显示顺序';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_isvalid" IS '状态（1：启用  0：禁用）';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_warn_level" IS '报警类型';
COMMENT ON COLUMN "public"."dw_dim_pl_sys_datadict"."pl_remark" IS '备注';

-- ----------------------------
-- Table structure for dw_dim_sys_datadict
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_sys_datadict";
CREATE TABLE "public"."dw_dim_sys_datadict" (
"type_code" varchar(10) COLLATE "default" DEFAULT NULL::character varying,
"type_value" varchar(50) COLLATE "default" NOT NULL,
"display" varchar(50) COLLATE "default" NOT NULL,
"sort" numeric(4) NOT NULL,
"isvalid" char(1) COLLATE "default" DEFAULT '1'::bpchar,
"remark" varchar(255) COLLATE "default",
"uuid" varchar(32) COLLATE "default" DEFAULT nextval('dw_dim_sys_datadict_uuid_seq'::regclass) NOT NULL,
"create_time" timestamp(6),
"update_time" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_sys_datadict" IS '数据字典表';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."type_code" IS '数据类型类型code，不能重复';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."type_value" IS '编码值（同一编码code内，不能重复）';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."display" IS '显示值';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."sort" IS '显示顺序';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."isvalid" IS '状态（1：启用  0：禁用）';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict"."remark" IS '备注';

-- ----------------------------
-- Table structure for dw_dim_sys_datadict_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_sys_datadict_type";
CREATE TABLE "public"."dw_dim_sys_datadict_type" (
"type_code" varchar(10) COLLATE "default" NOT NULL,
"type_name" varchar(50) COLLATE "default" NOT NULL,
"isvalid" char(1) COLLATE "default" DEFAULT '1'::bpchar,
"uuid" varchar(32) COLLATE "default" DEFAULT nextval('dw_dim_sys_datadict_type_uuid_seq'::regclass) NOT NULL,
"create_time" timestamp(6),
"update_time" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_sys_datadict_type" IS '数据字典类型表';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict_type"."type_code" IS '数据类型code';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict_type"."type_name" IS '数据字典类型名称，不能重复';
COMMENT ON COLUMN "public"."dw_dim_sys_datadict_type"."isvalid" IS '状态（1：启用  0：禁用）';

-- ----------------------------
-- Table structure for dw_dim_t_device_flow
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_dim_t_device_flow";
CREATE TABLE "public"."dw_dim_t_device_flow" (
"dev_uuid" varchar(32) COLLATE "default" NOT NULL,
"dev_code" varchar(32) COLLATE "default",
"dev_model_num" varchar(32) COLLATE "default",
"dev_version" varchar(10) COLLATE "default",
"dev_plate_number" varchar(20) COLLATE "default",
"dev_sim_num" varchar(50) COLLATE "default",
"dev_online_status" varchar(1) COLLATE "default",
"dev_status" varchar(1) COLLATE "default" DEFAULT 1,
"dev_isvalid" varchar(1) COLLATE "default",
"dev_phone" varchar(12) COLLATE "default",
"dev_ref_id" varchar(32) COLLATE "default",
"dev_status_change_time" timestamp(6),
"dev_create_user" varchar(30) COLLATE "default",
"dev_create_time" timestamp(6),
"dev_update_user" varchar(30) COLLATE "default",
"dev_update_time" timestamp(6),
"dev_drop_flag" varchar(1) COLLATE "default",
"dev_remark" varchar(255) COLLATE "default",
"dev_flag" int2,
"dev_key" varchar(20) COLLATE "default",
"dev_type" varchar(10) COLLATE "default",
"dev_manufacturer" varchar(100) COLLATE "default",
"city_code" varchar(20) COLLATE "default",
"dev_error_flag" varchar(2) COLLATE "default",
"dev_bus_plate_number" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_dim_t_device_flow" IS '设备管理';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_version" IS '版本';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_sim_num" IS '设备卡号';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_online_status" IS '设备在线状态
0：断开
1：在线';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_status" IS '设备状态
1：正常
0：维修
';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_isvalid" IS '启用标记1：启用0：禁用';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_phone" IS '电话';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_ref_id" IS '终端Id';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_status_change_time" IS '设备状态修改时间';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_create_user" IS '创建用户';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_update_user" IS '更新用户';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_update_time" IS '更新时间';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_drop_flag" IS '删除标示0：未删除 1 删除';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_remark" IS '备注';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_flag" IS '来自同步库 1 来自别的库 0 正常录入数据';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_key" IS ' 鉴权码';
COMMENT ON COLUMN "public"."dw_dim_t_device_flow"."dev_type" IS '设备类型 F3R , FTP, F3R-FTP';

-- ----------------------------
-- Table structure for dw_voiceprompt
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_voiceprompt";
CREATE TABLE "public"."dw_voiceprompt" (
"voiceprompt_uuid" varchar(32) COLLATE "default" NOT NULL,
"bus_uuid" varchar(32) COLLATE "default",
"voiceprompt_content" varchar(1000) COLLATE "default",
"send_type" varchar(50) COLLATE "default",
"create_time" timestamp(6),
"message_class" varchar(20) COLLATE "default",
"message_type" varchar(32) COLLATE "default",
"send_time" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_voiceprompt" IS '设备管理';
COMMENT ON COLUMN "public"."dw_voiceprompt"."voiceprompt_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_voiceprompt"."bus_uuid" IS '车辆id';
COMMENT ON COLUMN "public"."dw_voiceprompt"."voiceprompt_content" IS '消息内容';
COMMENT ON COLUMN "public"."dw_voiceprompt"."send_type" IS '消息类型';
COMMENT ON COLUMN "public"."dw_voiceprompt"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."dw_voiceprompt"."message_class" IS ' 鉴权码';
COMMENT ON COLUMN "public"."dw_voiceprompt"."message_type" IS '消息类型';
COMMENT ON COLUMN "public"."dw_voiceprompt"."send_time" IS '发送时间';

-- ----------------------------
-- Table structure for dw_voiceprompt_temp
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_voiceprompt_temp";
CREATE TABLE "public"."dw_voiceprompt_temp" (
"voicetemp_uuid" varchar(32) COLLATE "default" NOT NULL,
"voicetemp_message_content" varchar(1000) COLLATE "default",
"voicetemp_type_uuid" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_voiceprompt_temp" IS '设备管理';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp"."voicetemp_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp"."voicetemp_message_content" IS '消息内容';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp"."voicetemp_type_uuid" IS '消息类型';

-- ----------------------------
-- Table structure for dw_voiceprompt_temp_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."dw_voiceprompt_temp_type";
CREATE TABLE "public"."dw_voiceprompt_temp_type" (
"voicetemp_type_uuid" varchar(32) COLLATE "default" NOT NULL,
"voicetemp_content" varchar(1000) COLLATE "default",
"voicetemp_type_code" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."dw_voiceprompt_temp_type" IS '设备管理';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp_type"."voicetemp_type_uuid" IS '主键';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp_type"."voicetemp_content" IS '消息内容';
COMMENT ON COLUMN "public"."dw_voiceprompt_temp_type"."voicetemp_type_code" IS '消息类型code';

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS "public"."emp";
CREATE TABLE "public"."emp" (
"empname" text COLLATE "default",
"salary" int4,
"last_date" timestamp(6),
"last_user" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for mid_bus_warn_msg
-- ----------------------------
DROP TABLE IF EXISTS "public"."mid_bus_warn_msg";
CREATE TABLE "public"."mid_bus_warn_msg" (
"warn_sid" varchar(64) COLLATE "default" NOT NULL,
"warn_code" varchar(32) COLLATE "default",
"warn_line_group_sid" varchar(64) COLLATE "default",
"warn_line_group_name" varchar(100) COLLATE "default",
"warn_line_group_no" varchar(32) COLLATE "default",
"warn_line_sid" varchar(64) COLLATE "default",
"warn_line_name" varchar(100) COLLATE "default",
"warn_line_no" varchar(32) COLLATE "default",
"warn_bus_sid" varchar(64) COLLATE "default",
"warn_bus_number" varchar(100) COLLATE "default",
"warn_bus_selfcode" varchar(32) COLLATE "default",
"warn_driver_sid" varchar(64) COLLATE "default",
"warn_driver_name" varchar(100) COLLATE "default",
"warn_storage_time" timestamp(6),
"warn_start_time" timestamp(6),
"warn_end_time" timestamp(6),
"warn_start_lng" varchar(32) COLLATE "default",
"warn_start_lat" varchar(32) COLLATE "default",
"warn_end_lng" varchar(32) COLLATE "default",
"warn_end_lat" varchar(32) COLLATE "default",
"warn_mileage" varchar(32) COLLATE "default",
"warn_station_sid" varchar(64) COLLATE "default",
"warn_station_seq" int4,
"warn_line_type" varchar(1) COLLATE "default",
"brs_sid" varchar(32) COLLATE "default",
"warn_available" bool DEFAULT true,
"warn_id" varchar(64) COLLATE "default" DEFAULT nextval('mid_bus_warn_id_seq'::regclass) NOT NULL,
"warn_closed_flag" varchar(1) COLLATE "default" DEFAULT 0,
"warn_closed_by" varchar(20) COLLATE "default",
"warn_closed_time" timestamp(6),
"warn_closed_note" varchar(500) COLLATE "default",
"warn_gps" varchar(500) COLLATE "default",
"warn_duration" int4,
"warn_speed" int4,
"warn_name" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_sid" IS '报警SID ';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_code" IS '报警类型';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_group_sid" IS '线路SID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_group_name" IS '线路名称';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_group_no" IS '线路编号';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_sid" IS '线路轨迹SID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_name" IS '线路轨迹名称';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_no" IS '线路轨迹编号';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_bus_sid" IS '车辆SID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_bus_number" IS '车牌号';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_bus_selfcode" IS '车辆自编号';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_driver_sid" IS '司机SID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_driver_name" IS '司机名称';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_storage_time" IS '存储时间';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_start_time" IS '报警开始时间';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_end_time" IS '报警结束时间';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_start_lng" IS '报警开始坐标 经度';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_start_lat" IS '报警开始坐标 纬度';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_end_lng" IS '报警结束坐标 经度';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_end_lat" IS '报警结束坐标 纬度';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_mileage" IS '报警里程(单位：米)';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_station_sid" IS '站点SID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_station_seq" IS '站序';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_line_type" IS '方向（1：上行、2：下行）';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."brs_sid" IS 'bus_schedule_run表SID,需要管理趟次信息时候使用';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_available" IS '是否删除标识';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_closed_flag" IS '报警关闭标识（0-未关闭，1-关闭）';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_closed_by" IS '关闭报警调度员ID';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_closed_time" IS '报警关闭时间';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_closed_note" IS '报警关闭说明';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_gps" IS '超速GPS坐标 lng1,lat1;lng2,lat';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_duration" IS '报警时长';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_speed" IS '速度';
COMMENT ON COLUMN "public"."mid_bus_warn_msg"."warn_name" IS '报警类型名称';

-- ----------------------------
-- Table structure for mid_ic_card_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."mid_ic_card_data";
CREATE TABLE "public"."mid_ic_card_data" (
"uuid" varchar(32) COLLATE "default" NOT NULL,
"ic_card_uuid" varchar(32) COLLATE "default",
"upload_time" timestamp(0),
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"line_type" varchar(32) COLLATE "default",
"bus_self_code" varchar(32) COLLATE "default",
"bus_plate_number" varchar(32) COLLATE "default",
"sta_seq" int4,
"line_sta_uuid" varchar COLLATE "default",
"sta_uuid" varchar COLLATE "default",
"sta_name" varchar(32) COLLATE "default",
"sta_lng" varchar(32) COLLATE "default",
"sta_lat" varchar(32) COLLATE "default",
"trip_time" int4,
"org_uuid" varchar COLLATE "default",
"org_name" varchar(32) COLLATE "default",
"amount_after" numeric(10,2),
"amount_before" numeric(10,2),
"ic_card_type" varchar(16) COLLATE "default",
"upload_date" date
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."mid_ic_card_data" IS '补全站点后IC卡数据';
COMMENT ON COLUMN "public"."mid_ic_card_data"."uuid" IS '主键';
COMMENT ON COLUMN "public"."mid_ic_card_data"."ic_card_uuid" IS '卡号';
COMMENT ON COLUMN "public"."mid_ic_card_data"."upload_time" IS '交易时间';
COMMENT ON COLUMN "public"."mid_ic_card_data"."line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."mid_ic_card_data"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."mid_ic_card_data"."line_type" IS '线路方向';
COMMENT ON COLUMN "public"."mid_ic_card_data"."bus_self_code" IS '车辆自编号';
COMMENT ON COLUMN "public"."mid_ic_card_data"."bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."mid_ic_card_data"."sta_seq" IS '站序';
COMMENT ON COLUMN "public"."mid_ic_card_data"."line_sta_uuid" IS '线路站点ID';
COMMENT ON COLUMN "public"."mid_ic_card_data"."sta_uuid" IS '站点ID';
COMMENT ON COLUMN "public"."mid_ic_card_data"."sta_name" IS '站点名字';
COMMENT ON COLUMN "public"."mid_ic_card_data"."sta_lng" IS '站点经度';
COMMENT ON COLUMN "public"."mid_ic_card_data"."sta_lat" IS '站点纬度';
COMMENT ON COLUMN "public"."mid_ic_card_data"."trip_time" IS '趟次';
COMMENT ON COLUMN "public"."mid_ic_card_data"."org_uuid" IS '机构UUID';
COMMENT ON COLUMN "public"."mid_ic_card_data"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."mid_ic_card_data"."amount_after" IS '优惠后金额';
COMMENT ON COLUMN "public"."mid_ic_card_data"."amount_before" IS '优惠前金额';
COMMENT ON COLUMN "public"."mid_ic_card_data"."ic_card_type" IS '卡类型';
COMMENT ON COLUMN "public"."mid_ic_card_data"."upload_date" IS '日期';

-- ----------------------------
-- Table structure for mid_passenger_flow_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."mid_passenger_flow_result";
CREATE TABLE "public"."mid_passenger_flow_result" (
"id" varchar(64) COLLATE "default" DEFAULT nextval('mid_passenger_flow_result_id_seq'::regclass) NOT NULL,
"pfr_uuid" varchar(64) COLLATE "default",
"pfr_line_name" varchar(50) COLLATE "default",
"pfr_line_uuid" varchar(64) COLLATE "default",
"pfr_line_type" int4,
"pfr_station_seq" int4,
"pfr_line_station_uuid" varchar(64) COLLATE "default",
"pfr_get_on_number" int4,
"pfr_get_off_number" int4,
"pfr_upload_time" timestamp(6),
"prf_dev_code" varchar(32) COLLATE "default",
"prf_get_f_on_number" int4,
"prf_get_f_off_number" int4,
"prf_get_c_on_number" int4,
"prf_get_c_off_number" int4,
"prf_get_e_on_number" int4,
"prf_get_e_off_number" int4,
"prf_dev_datastring" varchar(500) COLLATE "default",
"prf_get_person_count" int4,
"pfr_station_uuid" varchar(64) COLLATE "default",
"pfr_station_name" varchar(50) COLLATE "default",
"sta_lng" varchar(50) COLLATE "default",
"sta_lnt" varchar(50) COLLATE "default",
"pfr_trip_time" varchar(20) COLLATE "default",
"pfr_trip_date" date,
"prf_bus_plate_number" varchar(50) COLLATE "default",
"bus_load_number" int4,
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"bus_self_code" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_uuid" IS '主键id';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_line_name" IS '线路名称';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_line_type" IS '线路类型';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_station_seq" IS '站点顺序';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_line_station_uuid" IS '站点ID';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_get_on_number" IS '总的上车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_get_off_number" IS '总的下车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_upload_time" IS '修改时间';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_f_on_number" IS '前门上车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_f_off_number" IS '前门下车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_c_on_number" IS '中门上车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_c_off_number" IS '中门下车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_e_on_number" IS '后门上车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_e_off_number" IS '后门下车人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_dev_datastring" IS '原始数据值';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_get_person_count" IS '车内人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_station_uuid" IS '站点ID';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_station_name" IS '站点名称';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."sta_lng" IS '站点经度';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."sta_lnt" IS '站点纬度';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."pfr_trip_time" IS '趟次';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."prf_bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."bus_load_number" IS '荷载人数';
COMMENT ON COLUMN "public"."mid_passenger_flow_result"."bus_self_code" IS '自编号';

-- ----------------------------
-- Table structure for mid_pl_t_warn
-- ----------------------------
DROP TABLE IF EXISTS "public"."mid_pl_t_warn";
CREATE TABLE "public"."mid_pl_t_warn" (
"dim_warn_id" varchar(32) COLLATE "default" DEFAULT nextval('mid_pl_t_warn_id_seq'::regclass) NOT NULL,
"warn_uuid" varchar(32) COLLATE "default",
"device_code" varchar(32) COLLATE "default",
"warn_type" varchar(32) COLLATE "default",
"warn_type_name" varchar(50) COLLATE "default",
"warn_time" timestamp(6),
"warn_level" varchar(10) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"lng" varchar(32) COLLATE "default",
"speed" varchar(20) COLLATE "default",
"bus_plate_number" varchar(50) COLLATE "default",
"bus_self_code" varchar(50) COLLATE "default",
"org_uuid" varchar(64) COLLATE "default",
"org_name" varchar(50) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"line_name" varchar(50) COLLATE "default",
"driver_name" varchar(50) COLLATE "default",
"driver_uuid" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."mid_pl_t_warn"."dim_warn_id" IS '主键id';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."warn_uuid" IS '告警uuid';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."device_code" IS '设备代码';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."warn_type_name" IS '报警类型中文名称';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."warn_level" IS '告警级别';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."speed" IS '速度';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."bus_plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."mid_pl_t_warn"."driver_name" IS '司机名称';

-- ----------------------------
-- Table structure for net_data_basestation
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_data_basestation";
CREATE TABLE "public"."net_data_basestation" (
"station_id" varchar(64) COLLATE "default" NOT NULL,
"station_name" varchar(32) COLLATE "default",
"lon" varchar(32) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"angle" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_data_basestation" IS '基础站位表';
COMMENT ON COLUMN "public"."net_data_basestation"."station_id" IS '站位ID';
COMMENT ON COLUMN "public"."net_data_basestation"."station_name" IS '站位名称';
COMMENT ON COLUMN "public"."net_data_basestation"."lon" IS '经度';
COMMENT ON COLUMN "public"."net_data_basestation"."lat" IS '纬度';
COMMENT ON COLUMN "public"."net_data_basestation"."angle" IS '方向角';

-- ----------------------------
-- Table structure for net_data_busline
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_data_busline";
CREATE TABLE "public"."net_data_busline" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"line_uuid" varchar(64) COLLATE "default",
"line_number" varchar(64) COLLATE "default",
"company" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"length" float4
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_data_busline" IS '基础线路';
COMMENT ON COLUMN "public"."net_data_busline"."uuid" IS '唯一ID';
COMMENT ON COLUMN "public"."net_data_busline"."line_uuid" IS '线路号的唯一ID';
COMMENT ON COLUMN "public"."net_data_busline"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_data_busline"."company" IS '所属单位';
COMMENT ON COLUMN "public"."net_data_busline"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_data_busline"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."net_data_busline"."length" IS '线路长度';

-- ----------------------------
-- Table structure for net_data_busstation
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_data_busstation";
CREATE TABLE "public"."net_data_busstation" (
"uuid" varchar(64) COLLATE "default" NOT NULL,
"pid" varchar(64) COLLATE "default",
"station_id" varchar(64) COLLATE "default",
"station_name" varchar(32) COLLATE "default",
"station_index" int4,
"predistance" varchar(32) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"lon" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_data_busstation" IS '基础站位';
COMMENT ON COLUMN "public"."net_data_busstation"."uuid" IS '唯一ID';
COMMENT ON COLUMN "public"."net_data_busstation"."pid" IS '关联线路表的uuid';
COMMENT ON COLUMN "public"."net_data_busstation"."station_id" IS '站位ID';
COMMENT ON COLUMN "public"."net_data_busstation"."station_name" IS '站位名称';
COMMENT ON COLUMN "public"."net_data_busstation"."station_index" IS '站序号';
COMMENT ON COLUMN "public"."net_data_busstation"."predistance" IS '距前一站距离';
COMMENT ON COLUMN "public"."net_data_busstation"."lat" IS '纬度';
COMMENT ON COLUMN "public"."net_data_busstation"."lon" IS '经度';

-- ----------------------------
-- Table structure for net_data_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_data_config";
CREATE TABLE "public"."net_data_config" (
"uuid" varchar(32) COLLATE "default" NOT NULL,
"config_name" varchar(32) COLLATE "default",
"config_file" text COLLATE "default",
"update_time" date
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_data_config" IS 'xml配置文件存储表结构';
COMMENT ON COLUMN "public"."net_data_config"."uuid" IS '唯一ID';
COMMENT ON COLUMN "public"."net_data_config"."config_name" IS '配置文件名称';
COMMENT ON COLUMN "public"."net_data_config"."config_file" IS '配置文件内容';
COMMENT ON COLUMN "public"."net_data_config"."update_time" IS '配置文件更新时间';

-- ----------------------------
-- Table structure for net_data_line_geo
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_data_line_geo";
CREATE TABLE "public"."net_data_line_geo" (
"line_id" varchar(64) COLLATE "default" NOT NULL,
"line_num" varchar(64) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"lon" varchar(30) COLLATE "default",
"lat" varchar(30) COLLATE "default" NOT NULL,
"node_index" int2,
"station_index" int2,
"station_name" varchar(32) COLLATE "default",
"station_id" varchar(64) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_data_line_geo_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_data_line_geo" IS '基础线路(空间路由数据)';
COMMENT ON COLUMN "public"."net_data_line_geo"."line_id" IS '线路号的唯一ID,关联线路表的lineuuid';
COMMENT ON COLUMN "public"."net_data_line_geo"."line_num" IS '线路号';
COMMENT ON COLUMN "public"."net_data_line_geo"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_data_line_geo"."lon" IS '经度';
COMMENT ON COLUMN "public"."net_data_line_geo"."lat" IS '纬度';
COMMENT ON COLUMN "public"."net_data_line_geo"."node_index" IS '节点序号';
COMMENT ON COLUMN "public"."net_data_line_geo"."station_index" IS '站序号';
COMMENT ON COLUMN "public"."net_data_line_geo"."station_name" IS '站位名称';
COMMENT ON COLUMN "public"."net_data_line_geo"."station_id" IS '唯一站位ID';

-- ----------------------------
-- Table structure for net_index_dea_linescore
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_dea_linescore";
CREATE TABLE "public"."net_index_dea_linescore" (
"line_number" varchar(16) COLLATE "default",
"sta_rational" float4,
"safe_rational" float4,
"con_rational" float4,
"rap_rational" float4,
"score" float4,
"uuid" int4 DEFAULT nextval('net_index_dea_linescore_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_dea_linescore" IS '线路评分';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."sta_rational" IS '站位设置合理性评分';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."safe_rational" IS '舒适性评分';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."con_rational" IS '便捷性评分';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."rap_rational" IS '快捷性评分';
COMMENT ON COLUMN "public"."net_index_dea_linescore"."score" IS '总评分';

-- ----------------------------
-- Table structure for net_index_dea_transfordata
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_dea_transfordata";
CREATE TABLE "public"."net_index_dea_transfordata" (
"uuid" int4 DEFAULT nextval('net_index_dea_transfordata_uuid_seq'::regclass) NOT NULL,
"line_number" varchar(30) COLLATE "default",
"ovehiclecou" int4,
"nvehiclecou" int4,
"oworktime" numeric(6,2),
"nworktime" numeric(6,2),
"opjpc" numeric(10,2),
"npjpc" numeric(10,2),
"ofzx" numeric(5,2),
"nfzx" numeric(5,2),
"ositecount" int4,
"nsitecount" int4,
"olength" numeric(10,2),
"nlength" numeric(10,2),
"oiskt" int4,
"niskt" int4,
"ospeed" numeric(8,2),
"nspeed" numeric(8,2),
"obrushcount" int4,
"nbrushcount" int4,
"oltd" int4,
"nltd" int4,
"obld" int4,
"nbld" int4,
"ojtxs" numeric(5,2),
"njtxs" numeric(5,2),
"omzl" numeric(8,4),
"nmzl" numeric(8,4),
"op_distance" numeric(10,2),
"np_distance" numeric(10,2),
"ofh" numeric(8,2),
"nfh" numeric(8,2)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_dea_transfordata" IS '线路评分基础数据表';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ovehiclecou" IS '运营车辆数（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nvehiclecou" IS '运营车辆数（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."oworktime" IS '运营时间（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nworktime" IS '运营时间（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."opjpc" IS '线长偏差（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."npjpc" IS '线长偏差（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ofzx" IS '非直线系数（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nfzx" IS '非直线系数（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ositecount" IS '站点个数（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nsitecount" IS '站点个数（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."olength" IS '线长（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nlength" IS '线长（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."oiskt" IS '是否空调车（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."niskt" IS '是否空调车（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ospeed" IS '运送速度（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nspeed" IS '运送速度（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."obrushcount" IS '刷卡量（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nbrushcount" IS '刷卡量（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."oltd" IS '连通度（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nltd" IS '连通度（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."obld" IS '便利度（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nbld" IS '便利度（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ojtxs" IS '交替系数（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."njtxs" IS '交替系数（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."omzl" IS '满载率（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nmzl" IS '满载率（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."op_distance" IS '平均站距（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."np_distance" IS '平均站距（转换后值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."ofh" IS '线路负荷（原始值）';
COMMENT ON COLUMN "public"."net_index_dea_transfordata"."nfh" IS '线路负荷（转换后值）';

-- ----------------------------
-- Table structure for net_index_level_entropy_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_level_entropy_result";
CREATE TABLE "public"."net_index_level_entropy_result" (
"line_number" varchar(16) COLLATE "default",
"level_name" varchar(16) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_level_entropy_result_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_level_entropy_result" IS '四级线网';
COMMENT ON COLUMN "public"."net_index_level_entropy_result"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_level_entropy_result"."level_name" IS '线路等级';

-- ----------------------------
-- Table structure for net_index_pf_base
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_base";
CREATE TABLE "public"."net_index_pf_base" (
"line_number" varchar(64) COLLATE "default",
"plate_number" varchar(64) COLLATE "default",
"arrow" varchar(64) COLLATE "default",
"station_index" int4,
"station_name" varchar(32) COLLATE "default",
"up_count" int4,
"down_count" int4,
"pass_count" int4,
"pass_time" date,
"p_date" varchar(32) COLLATE "default",
"p_time" varchar(32) COLLATE "default",
"full_load_num" varchar(32) COLLATE "default",
"to_next_dic" float4,
"company" varchar(16) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_pf_base_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_base" IS '客流数据（站位维度-按时间段统计）';
COMMENT ON COLUMN "public"."net_index_pf_base"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_base"."plate_number" IS '车牌号';
COMMENT ON COLUMN "public"."net_index_pf_base"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_base"."station_index" IS '站序号';
COMMENT ON COLUMN "public"."net_index_pf_base"."station_name" IS '站位名称';
COMMENT ON COLUMN "public"."net_index_pf_base"."up_count" IS '登量';
COMMENT ON COLUMN "public"."net_index_pf_base"."down_count" IS '降量';
COMMENT ON COLUMN "public"."net_index_pf_base"."pass_count" IS '通过率';
COMMENT ON COLUMN "public"."net_index_pf_base"."pass_time" IS '到站时间';
COMMENT ON COLUMN "public"."net_index_pf_base"."p_date" IS '刷卡日期';
COMMENT ON COLUMN "public"."net_index_pf_base"."p_time" IS '刷卡时间段';
COMMENT ON COLUMN "public"."net_index_pf_base"."full_load_num" IS '负载人数';
COMMENT ON COLUMN "public"."net_index_pf_base"."to_next_dic" IS '距下一站距离';
COMMENT ON COLUMN "public"."net_index_pf_base"."company" IS '所属单位';

-- ----------------------------
-- Table structure for net_index_pf_line_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_line_day";
CREATE TABLE "public"."net_index_pf_line_day" (
"line_number" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"brush_count" varchar(32) COLLATE "default",
"zzl" varchar(32) COLLATE "default",
"pjyj" varchar(32) COLLATE "default",
"p_date" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_pf_line_day_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_line_day" IS '客流数据（线路维度-按天统计）';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."brush_count" IS '刷卡总量';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."zzl" IS '周转量';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."pjyj" IS '平均运距';
COMMENT ON COLUMN "public"."net_index_pf_line_day"."p_date" IS '刷卡时间';

-- ----------------------------
-- Table structure for net_index_pf_od
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_od";
CREATE TABLE "public"."net_index_pf_od" (
"line_number" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"s_station_name" varchar(32) COLLATE "default",
"s_station_index" int4,
"e_station_name" varchar(32) COLLATE "default",
"e_station_index" int4,
"brush_count" int2,
"s_time" date,
"e_time" date,
"p_date" varchar(32) COLLATE "default",
"p_time" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_pf_od_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_od" IS '客流数据（OD维度-按时间段统计）';
COMMENT ON COLUMN "public"."net_index_pf_od"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_od"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_od"."s_station_name" IS '上车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od"."s_station_index" IS '上车站序号';
COMMENT ON COLUMN "public"."net_index_pf_od"."e_station_name" IS '下车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od"."e_station_index" IS '下车站序号';
COMMENT ON COLUMN "public"."net_index_pf_od"."brush_count" IS '刷卡量';
COMMENT ON COLUMN "public"."net_index_pf_od"."s_time" IS '上车刷卡时间';
COMMENT ON COLUMN "public"."net_index_pf_od"."e_time" IS '下车刷卡时间';
COMMENT ON COLUMN "public"."net_index_pf_od"."p_date" IS '刷卡日上期';
COMMENT ON COLUMN "public"."net_index_pf_od"."p_time" IS '刷卡时间段（以上车刷卡时间为准）';

-- ----------------------------
-- Table structure for net_index_pf_od_aavg
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_od_aavg";
CREATE TABLE "public"."net_index_pf_od_aavg" (
"line_number" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"s_station_name" varchar(32) COLLATE "default",
"s_station_index" int4,
"e_station_name" varchar(32) COLLATE "default",
"e_station_index" int4,
"brush_count" int4,
"uuid" int4 DEFAULT nextval('net_index_pf_od_aavg_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_od_aavg" IS '客流数据（OD维度-平均值）';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."s_station_name" IS '上车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."s_station_index" IS '上车站位序号';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."e_station_name" IS '下车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."e_station_index" IS '下车站位序号';
COMMENT ON COLUMN "public"."net_index_pf_od_aavg"."brush_count" IS '刷卡总量';

-- ----------------------------
-- Table structure for net_index_pf_od_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_od_day";
CREATE TABLE "public"."net_index_pf_od_day" (
"line_number" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"s_station_name" varchar(32) COLLATE "default",
"s_station_index" int4,
"e_station_name" varchar(32) COLLATE "default",
"e_station_index" int4,
"p_date" varchar(32) COLLATE "default",
"brush_count" int4,
"uuid" int4 DEFAULT nextval('net_index_pf_od_day_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_od_day" IS '客流数据（OD维度-按天统计）';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."s_station_name" IS '开始站位';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."s_station_index" IS '开始站序号';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."e_station_name" IS '结束站位';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."e_station_index" IS '结束站序号';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."p_date" IS '刷卡日期';
COMMENT ON COLUMN "public"."net_index_pf_od_day"."brush_count" IS '刷卡总量';

-- ----------------------------
-- Table structure for net_index_pf_od_dsum
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_od_dsum";
CREATE TABLE "public"."net_index_pf_od_dsum" (
"p_date" varchar(32) COLLATE "default",
"s_station_name" varchar(32) COLLATE "default",
"e_station_name" varchar(32) COLLATE "default",
"skl" int2,
"uuid" int4 DEFAULT nextval('net_index_pf_od_dsum_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_od_dsum" IS '客流数据（OD维度-按站对统计）';
COMMENT ON COLUMN "public"."net_index_pf_od_dsum"."p_date" IS '刷卡日期';
COMMENT ON COLUMN "public"."net_index_pf_od_dsum"."s_station_name" IS '上车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od_dsum"."e_station_name" IS '下车站位名称';
COMMENT ON COLUMN "public"."net_index_pf_od_dsum"."skl" IS '刷卡量';

-- ----------------------------
-- Table structure for net_index_pf_station_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_pf_station_day";
CREATE TABLE "public"."net_index_pf_station_day" (
"line_number" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"station_index" int4,
"station_name" varchar(16) COLLATE "default",
"up_count" int4,
"down_count" int4,
"pass_count" int4,
"p_date" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_pf_station_day_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_pf_station_day" IS '客流数据（站位维度-按天统计）';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."station_index" IS '站序号';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."station_name" IS '站位名称';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."up_count" IS '登量';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."down_count" IS '降量';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."pass_count" IS '通过量';
COMMENT ON COLUMN "public"."net_index_pf_station_day"."p_date" IS '刷卡日期';

-- ----------------------------
-- Table structure for net_index_repeat_arrow
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_repeat_arrow";
CREATE TABLE "public"."net_index_repeat_arrow" (
"line_number" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"arrow" varchar(32) COLLATE "default",
"sc_count" int4,
"repeat_sc_count" int4,
"repeatability" float4,
"top3" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_repeat_arrow_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_repeat_arrow" IS '重复度指标（按线路上下行统计）';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."sc_count" IS '总站对数';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."repeat_sc_count" IS '重复站对数';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."repeatability" IS '重复度';
COMMENT ON COLUMN "public"."net_index_repeat_arrow"."top3" IS '重复线路排名前三的线路';

-- ----------------------------
-- Table structure for net_index_repeat_company
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_repeat_company";
CREATE TABLE "public"."net_index_repeat_company" (
"company" varchar(32) COLLATE "default",
"sc_count" int2,
"repeat_sc_count" int2,
"repeatability" float4,
"top3" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_repeat_company_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_repeat_company" IS '重复度指标（按分公司统计）';
COMMENT ON COLUMN "public"."net_index_repeat_company"."company" IS '所属单位';
COMMENT ON COLUMN "public"."net_index_repeat_company"."sc_count" IS '总站对数';
COMMENT ON COLUMN "public"."net_index_repeat_company"."repeat_sc_count" IS '重复站对数';
COMMENT ON COLUMN "public"."net_index_repeat_company"."repeatability" IS '重复度';
COMMENT ON COLUMN "public"."net_index_repeat_company"."top3" IS '重复线路排名前三的线路';

-- ----------------------------
-- Table structure for net_index_repeat_linenum
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_repeat_linenum";
CREATE TABLE "public"."net_index_repeat_linenum" (
"line_number" varchar(32) COLLATE "default",
"sc_count" int4,
"repeat_sc_count" int4,
"repeatability" float4,
"top3" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_repeat_linenum_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_repeat_linenum" IS '重复度指标（按线路号统计）';
COMMENT ON COLUMN "public"."net_index_repeat_linenum"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_repeat_linenum"."sc_count" IS '总站对数';
COMMENT ON COLUMN "public"."net_index_repeat_linenum"."repeat_sc_count" IS '重复站对数';
COMMENT ON COLUMN "public"."net_index_repeat_linenum"."repeatability" IS '重复度';
COMMENT ON COLUMN "public"."net_index_repeat_linenum"."top3" IS '重复线路排名前三的线路';

-- ----------------------------
-- Table structure for net_index_repeat_sc
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_repeat_sc";
CREATE TABLE "public"."net_index_repeat_sc" (
"line_number" varchar(32) COLLATE "default",
"s_station" varchar(32) COLLATE "default",
"e_station" varchar(32) COLLATE "default",
"s_station_index" int4,
"e_station_index" int4,
"repeat_line" varchar(50) COLLATE "default",
"repeat_line_count" int4,
"arrow" varchar(16) COLLATE "default",
"linename" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('net_index_repeat_sc_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_repeat_sc" IS '线路站对重复明细';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."s_station" IS '上车站位';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."e_station" IS '下车站位';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."s_station_index" IS '上车站序号';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."e_station_index" IS '下车站序号';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."repeat_line" IS '重复线路';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."repeat_line_count" IS '重复线路数量';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_repeat_sc"."linename" IS '线路名称';

-- ----------------------------
-- Table structure for net_index_statis_arrow
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_statis_arrow";
CREATE TABLE "public"."net_index_statis_arrow" (
"line_number" varchar(64) COLLATE "default",
"arrow" varchar(255) COLLATE "default",
"gis_length" float4,
"length" float4,
"station_count" int4,
"site_count" int4,
"p_distance" float4,
"vehicle_cou" int4,
"ltd" float4,
"bld" float4,
"pjpc" float4,
"fzx" float4,
"speed" float4,
"uuid" int4 DEFAULT nextval('net_index_statis_arrow_uuid_seq'::regclass) NOT NULL,
"work_time" numeric
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_statis_arrow" IS '统计指标（按上下行统计）';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."arrow" IS '上下行';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."gis_length" IS 'gis长度';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."length" IS '线路长度';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."station_count" IS '站位数';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."site_count" IS '站点数';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."p_distance" IS '平均站距';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."vehicle_cou" IS '车辆数';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."ltd" IS '连通度';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."bld" IS '便利度';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."pjpc" IS '平均偏差';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."fzx" IS '非直线系数';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."speed" IS '运送速度';
COMMENT ON COLUMN "public"."net_index_statis_arrow"."work_time" IS '运营时间';

-- ----------------------------
-- Table structure for net_index_statis_linenum
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_index_statis_linenum";
CREATE TABLE "public"."net_index_statis_linenum" (
"line_number" varchar(64) COLLATE "default",
"gis_length" float4,
"length" float4,
"s_length" float4,
"site_count" int4,
"p_distance" float4,
"vehicle_cou" int2,
"ltd" float4,
"bld" float4,
"fzx" float4,
"pjpc" float4,
"speed" float4,
"uuid" int4 DEFAULT nextval('net_index_statis_linenum_uuid_seq'::regclass) NOT NULL,
"work_time" numeric
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."net_index_statis_linenum" IS '统计指标（按线路号统计）';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."line_number" IS '线路号';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."gis_length" IS 'gis长度';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."length" IS '线路长度(上下行平均值)';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."s_length" IS '线路长度(上下行之和)';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."site_count" IS '站点数';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."p_distance" IS '平均站距';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."vehicle_cou" IS '车辆数';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."ltd" IS '连通度';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."bld" IS '便利度';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."fzx" IS '平均偏差';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."pjpc" IS '非直线系数';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."speed" IS '运送速度';
COMMENT ON COLUMN "public"."net_index_statis_linenum"."work_time" IS '运营时间';

-- ----------------------------
-- Table structure for net_xml_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_xml_config";
CREATE TABLE "public"."net_xml_config" (
"uuid" varchar(32) COLLATE "default" DEFAULT nextval('net_xml_config_uuid_seq'::regclass) NOT NULL,
"code_type" varchar(32) COLLATE "default",
"code_type_name" varchar(32) COLLATE "default",
"code" varchar(32) COLLATE "default",
"code_value" varchar(32) COLLATE "default",
"code_index" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."net_xml_config"."code_type" IS '父类型';
COMMENT ON COLUMN "public"."net_xml_config"."code_type_name" IS '父类型名称';
COMMENT ON COLUMN "public"."net_xml_config"."code" IS '类型';
COMMENT ON COLUMN "public"."net_xml_config"."code_value" IS '类型名称';
COMMENT ON COLUMN "public"."net_xml_config"."code_index" IS '序号';

-- ----------------------------
-- Table structure for net_xml_dea_base_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."net_xml_dea_base_config";
CREATE TABLE "public"."net_xml_dea_base_config" (
"uuid" int4 DEFAULT nextval('net_dea_base_xml_config_uuid_seq'::regclass) NOT NULL,
"dea_table_name" varchar(32) COLLATE "default",
"p_key" varchar(32) COLLATE "default",
"col_name" varchar(32) COLLATE "default",
"o_type" varchar(32) COLLATE "default",
"n_type" varchar(32) COLLATE "default",
"min_v" varchar(32) COLLATE "default",
"max_v" varchar(32) COLLATE "default",
"opt_v" varchar(32) COLLATE "default",
"dea_index" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for spatial_ref_sys
-- ----------------------------
DROP TABLE IF EXISTS "public"."spatial_ref_sys";
CREATE TABLE "public"."spatial_ref_sys" (
"srid" int4 NOT NULL,
"auth_name" varchar(256) COLLATE "default",
"auth_srid" int4,
"srtext" varchar(2048) COLLATE "default",
"proj4text" varchar(2048) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for t_safe_device_rid_control
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_safe_device_rid_control";
CREATE TABLE "public"."t_safe_device_rid_control" (
"uuid" varchar(32) COLLATE "default" NOT NULL,
"bus_uuid" varchar(32) COLLATE "default",
"bus_self_code" varchar(32) COLLATE "default",
"bus_number" varchar(32) COLLATE "default",
"org_uuid" varchar(32) COLLATE "default",
"org_name" varchar(32) COLLATE "default",
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"bus_online_time" timestamp(6),
"bus_update_time" timestamp(6),
"bus_state" varchar(1) COLLATE "default",
"warn_time" timestamp(6),
"current_state" varchar(1) COLLATE "default",
"dev_uuid" varchar(32) COLLATE "default",
"dev_code" varchar(32) COLLATE "default",
"dev_model" varchar(32) COLLATE "default",
"dev_online_time" timestamp(6),
"dev_update_time" timestamp(6),
"dev_state" varchar(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."t_safe_device_rid_control" IS '车辆设备脱管表';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_uuid" IS '车辆ID';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_self_code" IS '车辆自编号';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_number" IS '车牌号';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."org_uuid" IS '机构ID';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."org_name" IS '机构名称';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_online_time" IS '车辆在线时间';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_update_time" IS '车辆更新时间';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."bus_state" IS '车辆状态';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."warn_time" IS '异常报警时间';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."current_state" IS '当前状态(异常0；正常1；设备和车同时在线正常，设备不在线异常；)';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_uuid" IS '设备ID';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_model" IS '设备类型';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_online_time" IS '设备在线时间';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_update_time" IS '设备更新时间';
COMMENT ON COLUMN "public"."t_safe_device_rid_control"."dev_state" IS '设备状态';

-- ----------------------------
-- Table structure for temp_bus_deployment
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_bus_deployment";
CREATE TABLE "public"."temp_bus_deployment" (
"dm_uuid" varchar(20) COLLATE "default" NOT NULL,
"dm_name" varchar(20) COLLATE "default",
"dm_org_uuid" varchar(20) COLLATE "default",
"dm_org_name" varchar(20) COLLATE "default",
"dm_line_uuid" varchar(20) COLLATE "default",
"dm_line_name" varchar(20) COLLATE "default",
"dm_start_sta_uuid" varchar(20) COLLATE "default",
"dm_end_sta_uuid" varchar(20) COLLATE "default",
"dm_start_sta_name" varchar(20) COLLATE "default",
"dm_end_sta_name" varchar(20) COLLATE "default",
"dm_start_line_type" char(1) COLLATE "default",
"dm_end_line_type" char(1) COLLATE "default",
"dm_trip" varchar(5) COLLATE "default",
"dm_run_time" int2,
"dm_run_mileage" float4,
"dm_non_mileage" float4,
"dm_drop_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"dm_create_time" timestamp(6),
"dm_update_time" timestamp(6),
"dm_non_type" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."temp_bus_deployment" IS '调车管理';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_uuid" IS '主键';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_name" IS '名称';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_org_uuid" IS '线路机构id';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_org_name" IS '线路机构名';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_line_name" IS '线路名';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_start_sta_uuid" IS '出发站点id';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_end_sta_uuid" IS '到达站点id';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_start_sta_name" IS '出发站点名';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_end_sta_name" IS '到达站点名';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_start_line_type" IS '出发站点的上下行';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_end_line_type" IS '结束站点的上下行';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_trip" IS '趟次';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_run_time" IS '运营时长';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_run_mileage" IS '运营里程';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_non_mileage" IS '非运营里程';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_drop_flag" IS '删除标示';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_create_time" IS '创建时间';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_update_time" IS '更新时间';
COMMENT ON COLUMN "public"."temp_bus_deployment"."dm_non_type" IS '非运营类型,关联数据字典D45-value';

-- ----------------------------
-- Table structure for temp_bus_over_warn_trail
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_bus_over_warn_trail";
CREATE TABLE "public"."temp_bus_over_warn_trail" (
"warn_uuid" varchar(32) COLLATE "default" NOT NULL,
"device_id" varchar(32) COLLATE "default",
"device_code" varchar(32) COLLATE "default",
"warn_type" varchar(32) COLLATE "default",
"warn_time" timestamp(6),
"create_time" timestamp(6),
"lat" varchar(32) COLLATE "default",
"lng" varchar(32) COLLATE "default",
"speed" varchar(32) COLLATE "default",
"driver_name" varchar(50) COLLATE "default",
"driver_num" varchar(50) COLLATE "default",
"warn_date" date,
"fk_warn_uuid" varchar(32) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."device_id" IS '设备号';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."device_code" IS '设备编码';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."lat" IS '维度';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."lng" IS '经度';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."speed" IS '速度';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."driver_name" IS '司机姓名';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."driver_num" IS '司机卡号';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."warn_date" IS '告警日期';
COMMENT ON COLUMN "public"."temp_bus_over_warn_trail"."fk_warn_uuid" IS '报警表外键';

-- ----------------------------
-- Table structure for temp_bus_schedule
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_bus_schedule";
CREATE TABLE "public"."temp_bus_schedule" (
"bs_uuid" varchar(32) COLLATE "default" NOT NULL,
"bs_org_uuid" varchar(32) COLLATE "default",
"bs_line_uuid" varchar(32) COLLATE "default",
"bs_schedule_time" timestamp(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."temp_bus_schedule" IS '排班表';
COMMENT ON COLUMN "public"."temp_bus_schedule"."bs_uuid" IS '排班表主键';
COMMENT ON COLUMN "public"."temp_bus_schedule"."bs_org_uuid" IS '机构id';
COMMENT ON COLUMN "public"."temp_bus_schedule"."bs_line_uuid" IS '线路id';
COMMENT ON COLUMN "public"."temp_bus_schedule"."bs_schedule_time" IS '日期';

-- ----------------------------
-- Table structure for temp_bus_schedule_day
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_bus_schedule_day";
CREATE TABLE "public"."temp_bus_schedule_day" (
"bsd_uuid" varchar(32) COLLATE "default" NOT NULL,
"bsd_bs_uuid" varchar(32) COLLATE "default",
"bsd_departure_time" varchar(32) COLLATE "default",
"bsd_shift" int4,
"bsd_type" varchar(1) COLLATE "default",
"bsd_trip_coefficient" varchar(32) COLLATE "default",
"bsd_plan_mileage" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_uuid" IS '班次类型';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_bs_uuid" IS '外键uuid';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_departure_time" IS '发车时间';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_shift" IS '班次';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_type" IS '运行模式';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_trip_coefficient" IS '趟次系数';
COMMENT ON COLUMN "public"."temp_bus_schedule_day"."bsd_plan_mileage" IS '线路趟次里程';

-- ----------------------------
-- Table structure for temp_bus_warn_msg
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_bus_warn_msg";
CREATE TABLE "public"."temp_bus_warn_msg" (
"warn_sid" varchar(64) COLLATE "default" NOT NULL,
"warn_code" varchar(32) COLLATE "default",
"warn_line_group_sid" varchar(64) COLLATE "default",
"warn_line_group_name" varchar(100) COLLATE "default",
"warn_line_group_no" varchar(32) COLLATE "default",
"warn_line_sid" varchar(64) COLLATE "default",
"warn_line_name" varchar(100) COLLATE "default",
"warn_line_no" varchar(32) COLLATE "default",
"warn_bus_sid" varchar(64) COLLATE "default",
"warn_bus_number" varchar(100) COLLATE "default",
"warn_bus_selfcode" varchar(32) COLLATE "default",
"warn_driver_sid" varchar(64) COLLATE "default",
"warn_driver_name" varchar(100) COLLATE "default",
"warn_storage_time" timestamp(6),
"warn_start_time" timestamp(6),
"warn_end_time" timestamp(6),
"warn_start_lng" varchar(32) COLLATE "default",
"warn_start_lat" varchar(32) COLLATE "default",
"warn_end_lng" varchar(32) COLLATE "default",
"warn_end_lat" varchar(32) COLLATE "default",
"warn_mileage" varchar(32) COLLATE "default",
"warn_station_sid" varchar(64) COLLATE "default",
"warn_station_seq" int4,
"warn_line_type" varchar(1) COLLATE "default",
"brs_sid" varchar(32) COLLATE "default",
"warn_available" bool DEFAULT true,
"warn_id" varchar(64) COLLATE "default" DEFAULT nextval('temp_bus_warn_id_seq'::regclass) NOT NULL,
"warn_closed_flag" varchar(1) COLLATE "default" DEFAULT 0,
"warn_closed_by" varchar(20) COLLATE "default",
"warn_closed_time" timestamp(6),
"warn_closed_note" varchar(500) COLLATE "default",
"warn_gps" varchar(500) COLLATE "default",
"warn_duration" int4,
"warn_speed" int4,
"warn_name" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_sid" IS '报警SID ';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_code" IS '报警类型';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_group_sid" IS '线路SID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_group_name" IS '线路名称';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_group_no" IS '线路编号';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_sid" IS '线路轨迹SID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_name" IS '线路轨迹名称';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_no" IS '线路轨迹编号';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_bus_sid" IS '车辆SID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_bus_number" IS '车牌号';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_bus_selfcode" IS '车辆自编号';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_driver_sid" IS '司机SID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_driver_name" IS '司机名称';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_storage_time" IS '存储时间';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_start_time" IS '报警开始时间';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_end_time" IS '报警结束时间';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_start_lng" IS '报警开始坐标 经度';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_start_lat" IS '报警开始坐标 纬度';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_end_lng" IS '报警结束坐标 经度';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_end_lat" IS '报警结束坐标 纬度';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_mileage" IS '报警里程(单位：米)';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_station_sid" IS '站点SID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_station_seq" IS '站序';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_line_type" IS '方向（1：上行、2：下行）';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."brs_sid" IS 'bus_schedule_run表SID,需要管理趟次信息时候使用';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_available" IS '是否删除标识';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_closed_flag" IS '报警关闭标识（0-未关闭，1-关闭）';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_closed_by" IS '关闭报警调度员ID';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_closed_time" IS '报警关闭时间';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_closed_note" IS '报警关闭说明';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_gps" IS '超速GPS坐标 lng1,lat1;lng2,lat';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_duration" IS '报警时长';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_speed" IS '速度';
COMMENT ON COLUMN "public"."temp_bus_warn_msg"."warn_name" IS '报警类型名称';

-- ----------------------------
-- Table structure for temp_device_send_task
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_device_send_task";
CREATE TABLE "public"."temp_device_send_task" (
"task_uuid" varchar(64) COLLATE "default" NOT NULL,
"task_name" varchar(255) COLLATE "default",
"task_create_time" timestamp(6),
"task_create_user" varchar(32) COLLATE "default",
"task_issue_num" int4,
"remark" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."temp_device_send_task" IS '下发任务表';
COMMENT ON COLUMN "public"."temp_device_send_task"."task_name" IS '任务名称';
COMMENT ON COLUMN "public"."temp_device_send_task"."task_issue_num" IS '下发设备数量';

-- ----------------------------
-- Table structure for temp_device_send_task_detail
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_device_send_task_detail";
CREATE TABLE "public"."temp_device_send_task_detail" (
"task_detail_uuid" varchar(64) COLLATE "default" NOT NULL,
"task_uuid" varchar(64) COLLATE "default",
"dev_uuid" varchar(64) COLLATE "default",
"task_status" varchar(4) COLLATE "default" DEFAULT 0,
"dev_code" varchar(32) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."temp_device_send_task_detail" IS '下发任务详情表';
COMMENT ON COLUMN "public"."temp_device_send_task_detail"."task_uuid" IS '下发任务表主键';
COMMENT ON COLUMN "public"."temp_device_send_task_detail"."dev_uuid" IS '设备id';
COMMENT ON COLUMN "public"."temp_device_send_task_detail"."task_status" IS '任务状态 1：成功  0：失败';
COMMENT ON COLUMN "public"."temp_device_send_task_detail"."dev_code" IS '设备号';

-- ----------------------------
-- Table structure for temp_ic_card_data
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_ic_card_data";
CREATE TABLE "public"."temp_ic_card_data" (
"ic_card_uuid" varchar(64) COLLATE "default" NOT NULL,
"upload_time" timestamp(0),
"line_name" varchar(32) COLLATE "default",
"line_uuid" varchar(64) COLLATE "default",
"bus_plate_number" varchar(32) COLLATE "default",
"amount_after" varchar(32) COLLATE "default",
"amount_before" varchar(32) COLLATE "default",
"ic_card_type" varchar(32) COLLATE "default",
"uuid" int4 DEFAULT nextval('temp_ic_card_data_uuid_seq'::regclass) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_ic_card_data"."ic_card_uuid" IS 'Ic卡号';
COMMENT ON COLUMN "public"."temp_ic_card_data"."upload_time" IS '交易时间';
COMMENT ON COLUMN "public"."temp_ic_card_data"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."temp_ic_card_data"."line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."temp_ic_card_data"."bus_plate_number" IS '车辆信息';
COMMENT ON COLUMN "public"."temp_ic_card_data"."amount_after" IS '优惠后金额';
COMMENT ON COLUMN "public"."temp_ic_card_data"."amount_before" IS '优惠前金额';
COMMENT ON COLUMN "public"."temp_ic_card_data"."ic_card_type" IS '卡类型';
COMMENT ON COLUMN "public"."temp_ic_card_data"."uuid" IS '主键';

-- ----------------------------
-- Table structure for temp_pl_t_warn
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_t_warn";
CREATE TABLE "public"."temp_pl_t_warn" (
"warn_uuid" varchar(32) COLLATE "default" NOT NULL,
"device_id" varchar(32) COLLATE "default",
"device_code" varchar(32) COLLATE "default",
"warn_type" varchar(32) COLLATE "default",
"warn_time" timestamp(6),
"warn_id" varchar(32) COLLATE "default",
"warn_content" varchar(255) COLLATE "default",
"create_time" timestamp(6),
"hex_location_buf" varchar(255) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"lng" varchar(32) COLLATE "default",
"speed" varchar(32) COLLATE "default",
"warn_source" varchar(4) COLLATE "default",
"driver_name" varchar(50) COLLATE "default",
"driver_num" varchar(50) COLLATE "default",
"handle_result" char(1) COLLATE "default" DEFAULT 0,
"warn_date" date,
"warn_level" varchar(4) COLLATE "default" DEFAULT 1,
"warn_end_time" timestamp(6),
"warn_end_lng" varchar(32) COLLATE "default",
"warn_end_lat" varchar(32) COLLATE "default",
"handle_suggestion" varchar(255) COLLATE "default",
"audit_status" char(1) COLLATE "default" DEFAULT 0,
"audit_time" timestamp(6),
"audit_suggestion" varchar(255) COLLATE "default",
"cc" varchar(50) COLLATE "default",
"cc_time" timestamp(6),
"handle_user" varchar(50) COLLATE "default",
"audit_user" varchar(50) COLLATE "default",
"handle_time" timestamp(6),
"warn_number" varchar(4) COLLATE "default",
"device_warn_number" varchar(4) COLLATE "default",
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"driver_iccard" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_pl_t_warn"."device_id" IS '设备号';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."device_code" IS '设备编码';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_content" IS '告警内容';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."lat" IS '维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."lng" IS '经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."speed" IS '速度';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."driver_name" IS '司机姓名';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."driver_num" IS '司机卡号';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."handle_result" IS '处理结果（0：未处理；1：已处理；2：误报 3其他  ）';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_date" IS '报警日期';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_level" IS '报警级别';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_end_time" IS '告警结束时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_end_lng" IS '告警结束经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_end_lat" IS '告警结束维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."handle_suggestion" IS '处理意见';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."audit_status" IS '审核状态 0：未审核 ；1：已处理；2：误报';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."audit_suggestion" IS '审核意见';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."cc" IS '抄送人 ';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."handle_user" IS '处理人';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."audit_user" IS '审核人';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."handle_time" IS '处理时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."warn_number" IS '每天每辆车每种报警类型的次数';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."device_warn_number" IS '该天该设备的报警次数';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."line_uuid" IS '线路UUID';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."temp_pl_t_warn"."driver_iccard" IS '司机IC卡ID';

-- ----------------------------
-- Table structure for temp_pl_t_warn_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_t_warn_copy";
CREATE TABLE "public"."temp_pl_t_warn_copy" (
"warn_uuid" varchar(32) COLLATE "default" NOT NULL,
"device_id" varchar(32) COLLATE "default",
"device_code" varchar(32) COLLATE "default",
"warn_type" varchar(32) COLLATE "default",
"warn_time" timestamp(6),
"warn_id" varchar(32) COLLATE "default",
"warn_content" varchar(255) COLLATE "default",
"create_time" timestamp(6),
"hex_location_buf" varchar(255) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"lng" varchar(32) COLLATE "default",
"speed" varchar(32) COLLATE "default",
"warn_source" varchar(4) COLLATE "default",
"driver_name" varchar(50) COLLATE "default",
"driver_num" varchar(50) COLLATE "default",
"handle_result" char(1) COLLATE "default" DEFAULT 0,
"warn_date" date,
"warn_level" varchar(4) COLLATE "default" DEFAULT 1,
"warn_end_time" timestamp(6),
"warn_end_lng" varchar(32) COLLATE "default",
"warn_end_lat" varchar(32) COLLATE "default",
"handle_suggestion" varchar(255) COLLATE "default",
"audit_status" char(1) COLLATE "default" DEFAULT 0,
"audit_time" timestamp(6),
"audit_suggestion" varchar(255) COLLATE "default",
"cc" varchar(50) COLLATE "default",
"cc_time" timestamp(6),
"handle_user" varchar(50) COLLATE "default",
"audit_user" varchar(50) COLLATE "default",
"handle_time" timestamp(6),
"warn_number" varchar(4) COLLATE "default",
"device_warn_number" varchar(4) COLLATE "default",
"line_uuid" varchar(32) COLLATE "default",
"line_name" varchar(32) COLLATE "default",
"driver_iccard" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."device_id" IS '设备号';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."device_code" IS '设备编码';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_content" IS '告警内容';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."lat" IS '维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."lng" IS '经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."speed" IS '速度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."driver_name" IS '司机姓名';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."driver_num" IS '司机卡号';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."handle_result" IS '处理结果（0：未处理；1：已处理；2：误报 3其他  ）';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_date" IS '报警日期';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_level" IS '报警级别';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_end_time" IS '告警结束时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_end_lng" IS '告警结束经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_end_lat" IS '告警结束维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."handle_suggestion" IS '处理意见';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."audit_status" IS '审核状态 0：未审核 ；1：已处理；2：误报';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."audit_suggestion" IS '审核意见';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."cc" IS '抄送人 ';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."handle_user" IS '处理人';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."audit_user" IS '审核人';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."handle_time" IS '处理时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."warn_number" IS '每天每辆车每种报警类型的次数';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."device_warn_number" IS '该天该设备的报警次数';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."line_uuid" IS '线路UUID';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."line_name" IS '线路名称';
COMMENT ON COLUMN "public"."temp_pl_t_warn_copy"."driver_iccard" IS '司机IC卡ID';

-- ----------------------------
-- Table structure for temp_pl_t_warn_media
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_t_warn_media";
CREATE TABLE "public"."temp_pl_t_warn_media" (
"media_uuid" varchar(32) COLLATE "default" NOT NULL,
"warn_uuid" varchar(32) COLLATE "default",
"media_name" varchar(64) COLLATE "default",
"media_url" varchar(255) COLLATE "default",
"media_type" int4,
"create_time" timestamp(6),
"create_user" varchar(32) COLLATE "default",
"download_url" varchar(255) COLLATE "default",
"download_time" timestamp(6),
"download_type" int4,
"media_encoding" varchar(20) COLLATE "default",
"hex_media_id" varchar(32) COLLATE "default",
"hex_localtion_buf" varchar(255) COLLATE "default",
"save_type" int2,
"save_path" varchar(255) COLLATE "default",
"index" varchar(4) COLLATE "default",
"warn_date" date
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_pl_t_warn_media"."warn_date" IS '报警日期';

-- ----------------------------
-- Table structure for temp_pl_t_warn_media_copy
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_t_warn_media_copy";
CREATE TABLE "public"."temp_pl_t_warn_media_copy" (
"media_uuid" varchar(32) COLLATE "default" NOT NULL,
"warn_uuid" varchar(32) COLLATE "default",
"media_name" varchar(64) COLLATE "default",
"media_url" varchar(255) COLLATE "default",
"media_type" int4,
"create_time" timestamp(6),
"create_user" varchar(32) COLLATE "default",
"download_url" varchar(255) COLLATE "default",
"download_time" timestamp(6),
"download_type" int4,
"media_encoding" varchar(20) COLLATE "default",
"hex_media_id" varchar(32) COLLATE "default",
"hex_localtion_buf" varchar(255) COLLATE "default",
"save_type" int2,
"save_path" varchar(255) COLLATE "default",
"index" varchar(4) COLLATE "default",
"warn_date" date
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_pl_t_warn_media_copy"."warn_date" IS '报警日期';

-- ----------------------------
-- Table structure for temp_pl_t_warn_temp
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_t_warn_temp";
CREATE TABLE "public"."temp_pl_t_warn_temp" (
"warn_uuid" varchar(32) COLLATE "default" NOT NULL,
"device_id" varchar(32) COLLATE "default",
"device_code" varchar(32) COLLATE "default",
"warn_type" varchar(32) COLLATE "default",
"warn_time" timestamp(0),
"warn_id" varchar(32) COLLATE "default",
"warn_content" varchar(255) COLLATE "default",
"create_time" timestamp(0),
"hex_location_buf" varchar(255) COLLATE "default",
"lat" varchar(32) COLLATE "default",
"lng" varchar(32) COLLATE "default",
"speed" varchar(32) COLLATE "default",
"warn_source" varchar(4) COLLATE "default",
"driver_name" varchar(50) COLLATE "default",
"driver_num" varchar(50) COLLATE "default",
"handle_result" char(1) COLLATE "default" DEFAULT 0,
"warn_date" date,
"warn_level" varchar(4) COLLATE "default" DEFAULT 1,
"warn_end_time" timestamp(0),
"warn_end_lng" varchar(32) COLLATE "default",
"warn_end_lat" varchar(32) COLLATE "default",
"handle_suggestion" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."device_id" IS '设备号';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."device_code" IS '设备编码';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_type" IS '告警类型';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_time" IS '告警时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_content" IS '告警内容';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."lat" IS '维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."lng" IS '经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."speed" IS '速度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."driver_name" IS '司机姓名';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."driver_num" IS '司机卡号';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."handle_result" IS '处理结果（0：未处理；1：已处理；2：误报）';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_date" IS '报警日期';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_level" IS '报警级别';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_end_time" IS '告警结束时间';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_end_lng" IS '告警结束经度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."warn_end_lat" IS '告警结束维度';
COMMENT ON COLUMN "public"."temp_pl_t_warn_temp"."handle_suggestion" IS '处理意见';

-- ----------------------------
-- Table structure for temp_pl_take_photo_set
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_pl_take_photo_set";
CREATE TABLE "public"."temp_pl_take_photo_set" (
"take_photo_uuid" varchar(64) COLLATE "default" NOT NULL,
"device_id" varchar(64) COLLATE "default",
"device_code" varchar(64) COLLATE "default",
"start_date" date,
"end_date" date,
"start_time" varchar(32) COLLATE "default",
"end_time" varchar(32) COLLATE "default",
"duration" varchar(255) COLLATE "default",
"timing_class" varchar(4) COLLATE "default",
"timing_remark" varchar(255) COLLATE "default",
"cron" varchar(255) COLLATE "default",
"isvalid" char(1) COLLATE "default",
"remark" varchar(255) COLLATE "default",
"create_user" varchar(255) COLLATE "default",
"create_time" timestamptz(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."temp_pl_take_photo_set" IS '设备抓拍明细';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."take_photo_uuid" IS '主键uuid';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."device_id" IS '设备id';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."device_code" IS '设备号';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."start_date" IS '开始日期';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."end_date" IS '结束日期';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."start_time" IS '开始时间';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."end_time" IS '结束时间';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."duration" IS '采集间隔';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."timing_class" IS '采集类型 （1每天 ,2每周,3每月）';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."timing_remark" IS '采集内容';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."cron" IS 'cron表达式';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."isvalid" IS '启用标记1：启用0：禁用';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."remark" IS '备注';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."create_user" IS '创建人';
COMMENT ON COLUMN "public"."temp_pl_take_photo_set"."create_time" IS '创建时间';

-- ----------------------------
-- Table structure for temp_t_passenger_flow_result
-- ----------------------------
DROP TABLE IF EXISTS "public"."temp_t_passenger_flow_result";
CREATE TABLE "public"."temp_t_passenger_flow_result" (
"pfr_uuid" varchar(64) COLLATE "default" NOT NULL,
"pfr_line_name" varchar(50) COLLATE "default",
"pfr_line_uuid" varchar(64) COLLATE "default",
"pfr_line_type" varchar(2) COLLATE "default",
"pfr_station_seq" varchar(64) COLLATE "default",
"pfr_line_station_uuid" varchar(64) COLLATE "default",
"pfr_get_on_number" int4,
"pfr_get_off_number" int4,
"pfr_upload_time" timestamp(6),
"prf_dev_code" varchar(32) COLLATE "default",
"prf_get_f_on_number" int4,
"prf_get_f_off_number" int4,
"prf_get_c_on_number" int4,
"prf_get_c_off_number" int4,
"prf_get_e_on_number" int4,
"prf_get_e_off_number" int4,
"prf_dev_datastring" varchar(500) COLLATE "default",
"prf_get_person_count" int4,
"pfr_station_uuid" varchar(20) COLLATE "default",
"pfr_trip_time" varchar(10) COLLATE "default",
"pfr_trip_date" timestamp(6),
"pfr_open_door_time" varchar(20) COLLATE "default",
"pfr_close_door_time" varchar(20) COLLATE "default",
"prf_dev_uuid" varchar(32) COLLATE "default",
"pfr_current_long" varchar(64) COLLATE "default",
"pfr_current_lat" varchar(64) COLLATE "default",
"pfr_before_long" varchar(64) COLLATE "default",
"pfr_before_lat" varchar(64) COLLATE "default",
"pfr_normal" int4,
"pfr_quality" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_uuid" IS '主键id';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_line_name" IS '线路名称';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_line_uuid" IS '线路ID';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_line_type" IS '线路类型';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_station_seq" IS '站点顺序';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_line_station_uuid" IS '线路站点ID';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_get_on_number" IS '总的上车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_get_off_number" IS '总的下车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_upload_time" IS '修改时间';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_dev_code" IS '设备编号';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_f_on_number" IS '前门上车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_f_off_number" IS '前门下车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_c_on_number" IS '中门上车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_c_off_number" IS '中门下车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_e_on_number" IS '后门上车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_e_off_number" IS '后门下车人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_dev_datastring" IS '原始数据值';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_get_person_count" IS '车内人数';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_station_uuid" IS '站点ID';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_trip_time" IS '趟次';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_trip_date" IS '日期';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_open_door_time" IS '开门时间';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."pfr_close_door_time" IS '关门时间';
COMMENT ON COLUMN "public"."temp_t_passenger_flow_result"."prf_dev_uuid" IS '设备uuid';

-- ----------------------------
-- View structure for dw_dim_map_line_v
-- ----------------------------
CREATE OR REPLACE VIEW "public"."dw_dim_map_line_v" AS 
SELECT ml.ml_uuid, ml.ml_line_uuid, ml.ml_sta_uuid, ml.ml_lng, ml.ml_lat, ml.ml_sequence, ml.ml_line_type, ml.ml_distance, ml.ml_whichstop, s.sta_address AS ml_sta_address FROM (dw_dim_map_line ml LEFT JOIN dw_dim_bus_station s ON (((ml.ml_sta_uuid)::text = (s.sta_uuid)::text))) ORDER BY ml.ml_sta_uuid DESC;

-- ----------------------------
-- View structure for dw_dim_osm_region_v
-- ----------------------------
CREATE OR REPLACE VIEW "public"."dw_dim_osm_region_v" AS 
SELECT t1.uuid, t1.name, t1.level, t1.pid, t1.area, t1.mark, st_asgeojson(t1.geom) AS geometry, t2.bd_region_district_id AS bd_id FROM (dw_dim_osm_region t1 LEFT JOIN dw_dim_bd_osm_region t2 ON (((t1.uuid)::text = (t2.osm_region_district_id)::text)));

-- ----------------------------
-- View structure for geography_columns
-- ----------------------------
CREATE OR REPLACE VIEW "public"."geography_columns" AS 
SELECT current_database() AS f_table_catalog, n.nspname AS f_table_schema, c.relname AS f_table_name, a.attname AS f_geography_column, postgis_typmod_dims(a.atttypmod) AS coord_dimension, postgis_typmod_srid(a.atttypmod) AS srid, postgis_typmod_type(a.atttypmod) AS type FROM pg_class c, pg_attribute a, pg_type t, pg_namespace n WHERE (((((((t.typname = 'geography'::name) AND (a.attisdropped = false)) AND (a.atttypid = t.oid)) AND (a.attrelid = c.oid)) AND (c.relnamespace = n.oid)) AND (NOT pg_is_other_temp_schema(c.relnamespace))) AND has_table_privilege(c.oid, 'SELECT'::text));

-- ----------------------------
-- View structure for geometry_columns
-- ----------------------------
CREATE OR REPLACE VIEW "public"."geometry_columns" AS 
SELECT (current_database())::character varying(256) AS f_table_catalog, (n.nspname)::character varying(256) AS f_table_schema, (c.relname)::character varying(256) AS f_table_name, (a.attname)::character varying(256) AS f_geometry_column, COALESCE(postgis_typmod_dims(a.atttypmod), postgis_constraint_dims((n.nspname)::text, (c.relname)::text, (a.attname)::text), 2) AS coord_dimension, COALESCE(NULLIF(postgis_typmod_srid(a.atttypmod), 0), postgis_constraint_srid((n.nspname)::text, (c.relname)::text, (a.attname)::text), 0) AS srid, (replace(replace(COALESCE(NULLIF(upper(postgis_typmod_type(a.atttypmod)), 'GEOMETRY'::text), (postgis_constraint_type((n.nspname)::text, (c.relname)::text, (a.attname)::text))::text, 'GEOMETRY'::text), 'ZM'::text, ''::text), 'Z'::text, ''::text))::character varying(30) AS type FROM pg_class c, pg_attribute a, pg_type t, pg_namespace n WHERE (((((((((t.typname = 'geometry'::name) AND (a.attisdropped = false)) AND (a.atttypid = t.oid)) AND (a.attrelid = c.oid)) AND (c.relnamespace = n.oid)) AND ((((c.relkind = 'r'::"char") OR (c.relkind = 'v'::"char")) OR (c.relkind = 'm'::"char")) OR (c.relkind = 'f'::"char"))) AND (NOT pg_is_other_temp_schema(c.relnamespace))) AND (NOT ((n.nspname = 'public'::name) AND (c.relname = 'raster_columns'::name)))) AND has_table_privilege(c.oid, 'SELECT'::text));

-- ----------------------------
-- View structure for raster_columns
-- ----------------------------
CREATE OR REPLACE VIEW "public"."raster_columns" AS 
SELECT current_database() AS r_table_catalog, n.nspname AS r_table_schema, c.relname AS r_table_name, a.attname AS r_raster_column, COALESCE(_raster_constraint_info_srid(n.nspname, c.relname, a.attname), (SELECT st_srid('010100000000000000000000000000000000000000'::geometry) AS st_srid)) AS srid, _raster_constraint_info_scale(n.nspname, c.relname, a.attname, 'x'::bpchar) AS scale_x, _raster_constraint_info_scale(n.nspname, c.relname, a.attname, 'y'::bpchar) AS scale_y, _raster_constraint_info_blocksize(n.nspname, c.relname, a.attname, 'width'::text) AS blocksize_x, _raster_constraint_info_blocksize(n.nspname, c.relname, a.attname, 'height'::text) AS blocksize_y, COALESCE(_raster_constraint_info_alignment(n.nspname, c.relname, a.attname), false) AS same_alignment, COALESCE(_raster_constraint_info_regular_blocking(n.nspname, c.relname, a.attname), false) AS regular_blocking, _raster_constraint_info_num_bands(n.nspname, c.relname, a.attname) AS num_bands, _raster_constraint_info_pixel_types(n.nspname, c.relname, a.attname) AS pixel_types, _raster_constraint_info_nodata_values(n.nspname, c.relname, a.attname) AS nodata_values, _raster_constraint_info_out_db(n.nspname, c.relname, a.attname) AS out_db, _raster_constraint_info_extent(n.nspname, c.relname, a.attname) AS extent FROM pg_class c, pg_attribute a, pg_type t, pg_namespace n WHERE (((((((t.typname = 'raster'::name) AND (a.attisdropped = false)) AND (a.atttypid = t.oid)) AND (a.attrelid = c.oid)) AND (c.relnamespace = n.oid)) AND ((c.relkind = 'r'::"char") OR (c.relkind = 'v'::"char"))) AND (NOT pg_is_other_temp_schema(c.relnamespace)));

-- ----------------------------
-- View structure for raster_overviews
-- ----------------------------
CREATE OR REPLACE VIEW "public"."raster_overviews" AS 
SELECT current_database() AS o_table_catalog, n.nspname AS o_table_schema, c.relname AS o_table_name, a.attname AS o_raster_column, current_database() AS r_table_catalog, (split_part(split_part(s.consrc, '''::name'::text, 1), ''''::text, 2))::name AS r_table_schema, (split_part(split_part(s.consrc, '''::name'::text, 2), ''''::text, 2))::name AS r_table_name, (split_part(split_part(s.consrc, '''::name'::text, 3), ''''::text, 2))::name AS r_raster_column, (btrim(split_part(s.consrc, ','::text, 2)))::integer AS overview_factor FROM pg_class c, pg_attribute a, pg_type t, pg_namespace n, pg_constraint s WHERE ((((((((((t.typname = 'raster'::name) AND (a.attisdropped = false)) AND (a.atttypid = t.oid)) AND (a.attrelid = c.oid)) AND (c.relnamespace = n.oid)) AND ((c.relkind = 'r'::"char") OR (c.relkind = 'v'::"char"))) AND (s.connamespace = n.oid)) AND (s.conrelid = c.oid)) AND (s.consrc ~~ '%_overview_constraint(%'::text)) AND (NOT pg_is_other_temp_schema(c.relnamespace)));

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."analysis_passenger_month_trend_trend_uuid_seq" OWNED BY "analysis_passenger_month_trend"."trend_uuid";
ALTER SEQUENCE "public"."base_access_log_log_uuid_seq" OWNED BY "base_access_log"."log_uuid";
ALTER SEQUENCE "public"."base_excel_import_log_xls_log_uuid_seq" OWNED BY "base_excel_import_log"."xls_log_uuid";
ALTER SEQUENCE "public"."base_login_log_log_uuid_seq" OWNED BY "base_login_log"."log_uuid";
ALTER SEQUENCE "public"."base_role_dataresource_role_data_id_seq" OWNED BY "base_role_dataresource"."role_data_id";
ALTER SEQUENCE "public"."base_sys_param_info_sys_uuid_seq" OWNED BY "base_sys_param_info"."sys_uuid";
ALTER SEQUENCE "public"."dw_dim_sys_datadict_type_uuid_seq" OWNED BY "dw_dim_sys_datadict_type"."uuid";
ALTER SEQUENCE "public"."net_data_line_geo_uuid_seq" OWNED BY "net_data_line_geo"."uuid";
ALTER SEQUENCE "public"."net_dea_base_xml_config_uuid_seq" OWNED BY "net_xml_dea_base_config"."uuid";
ALTER SEQUENCE "public"."net_index_dea_linescore_uuid_seq" OWNED BY "net_index_dea_linescore"."uuid";
ALTER SEQUENCE "public"."net_index_dea_transfordata_uuid_seq" OWNED BY "net_index_dea_transfordata"."uuid";
ALTER SEQUENCE "public"."net_index_level_entropy_result_uuid_seq" OWNED BY "net_index_level_entropy_result"."uuid";
ALTER SEQUENCE "public"."net_index_pf_base_uuid_seq" OWNED BY "net_index_pf_base"."uuid";
ALTER SEQUENCE "public"."net_index_pf_line_day_uuid_seq" OWNED BY "net_index_pf_line_day"."uuid";
ALTER SEQUENCE "public"."net_index_pf_od_aavg_uuid_seq" OWNED BY "net_index_pf_od_aavg"."uuid";
ALTER SEQUENCE "public"."net_index_pf_od_day_uuid_seq" OWNED BY "net_index_pf_od_day"."uuid";
ALTER SEQUENCE "public"."net_index_pf_od_dsum_uuid_seq" OWNED BY "net_index_pf_od_dsum"."uuid";
ALTER SEQUENCE "public"."net_index_pf_od_uuid_seq" OWNED BY "net_index_pf_od"."uuid";
ALTER SEQUENCE "public"."net_index_pf_station_day_uuid_seq" OWNED BY "net_index_pf_station_day"."uuid";
ALTER SEQUENCE "public"."net_index_repeat_arrow_uuid_seq" OWNED BY "net_index_repeat_arrow"."uuid";
ALTER SEQUENCE "public"."net_index_repeat_company_uuid_seq" OWNED BY "net_index_repeat_company"."uuid";
ALTER SEQUENCE "public"."net_index_repeat_linenum_uuid_seq" OWNED BY "net_index_repeat_linenum"."uuid";
ALTER SEQUENCE "public"."net_index_repeat_sc_uuid_seq" OWNED BY "net_index_repeat_sc"."uuid";
ALTER SEQUENCE "public"."net_index_statis_arrow_uuid_seq" OWNED BY "net_index_statis_arrow"."uuid";
ALTER SEQUENCE "public"."net_index_statis_linenum_uuid_seq" OWNED BY "net_index_statis_linenum"."uuid";
ALTER SEQUENCE "public"."net_xml_config_uuid_seq" OWNED BY "net_xml_config"."uuid";

-- ----------------------------
-- Indexes structure for table analysis_arrive_volume_day
-- ----------------------------
CREATE INDEX "index_upload_time_date" ON "public"."analysis_arrive_volume_day" USING btree ("upload_time_date");

-- ----------------------------
-- Primary Key structure for table analysis_arrive_volume_day
-- ----------------------------
ALTER TABLE "public"."analysis_arrive_volume_day" ADD PRIMARY KEY ("arrive_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_arrive_volume_day_10
-- ----------------------------
ALTER TABLE "public"."analysis_arrive_volume_day_10" ADD PRIMARY KEY ("arrive_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_arrive_volume_day_11
-- ----------------------------
ALTER TABLE "public"."analysis_arrive_volume_day_11" ADD PRIMARY KEY ("arrive_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_length_time_day
-- ----------------------------
ALTER TABLE "public"."analysis_length_time_day" ADD PRIMARY KEY ("day_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_length_time_month
-- ----------------------------
ALTER TABLE "public"."analysis_length_time_month" ADD PRIMARY KEY ("length_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_network_line_od_data
-- ----------------------------
ALTER TABLE "public"."analysis_network_line_od_data" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table analysis_network_sta_od_data
-- ----------------------------
ALTER TABLE "public"."analysis_network_sta_od_data" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table analysis_network_sta_od_month_data
-- ----------------------------
ALTER TABLE "public"."analysis_network_sta_od_month_data" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table analysis_passenger_month_trend
-- ----------------------------
ALTER TABLE "public"."analysis_passenger_month_trend" ADD PRIMARY KEY ("trend_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_prf_capacity_volume_day
-- ----------------------------
ALTER TABLE "public"."analysis_prf_capacity_volume_day" ADD PRIMARY KEY ("capacity_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_prf_fullload_day
-- ----------------------------
ALTER TABLE "public"."analysis_prf_fullload_day" ADD PRIMARY KEY ("fullload_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_prf_peak_month
-- ----------------------------
ALTER TABLE "public"."analysis_prf_peak_month" ADD PRIMARY KEY ("peak_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_prf_section_month
-- ----------------------------
ALTER TABLE "public"."analysis_prf_section_month" ADD PRIMARY KEY ("section_uuid");

-- ----------------------------
-- Primary Key structure for table analysis_prf_sta_on_off_day
-- ----------------------------
ALTER TABLE "public"."analysis_prf_sta_on_off_day" ADD PRIMARY KEY ("sta_on_off_uuid");

-- ----------------------------
-- Primary Key structure for table base_access_log
-- ----------------------------
ALTER TABLE "public"."base_access_log" ADD PRIMARY KEY ("log_uuid");

-- ----------------------------
-- Primary Key structure for table base_access_page_log
-- ----------------------------
ALTER TABLE "public"."base_access_page_log" ADD PRIMARY KEY ("log_uuid");

-- ----------------------------
-- Primary Key structure for table base_api_taketime_info
-- ----------------------------
ALTER TABLE "public"."base_api_taketime_info" ADD PRIMARY KEY ("api_id");

-- ----------------------------
-- Indexes structure for table base_bus_video_info
-- ----------------------------
CREATE INDEX "index_bus_uuid" ON "public"."base_bus_video_info" USING btree ("bus_uuid");
CREATE INDEX "index_video_uuid" ON "public"."base_bus_video_info" USING btree ("video1");

-- ----------------------------
-- Primary Key structure for table base_bus_video_info
-- ----------------------------
ALTER TABLE "public"."base_bus_video_info" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table base_data_resource_info
-- ----------------------------
ALTER TABLE "public"."base_data_resource_info" ADD PRIMARY KEY ("data_resource_id");

-- ----------------------------
-- Primary Key structure for table base_excel_import_log
-- ----------------------------
ALTER TABLE "public"."base_excel_import_log" ADD PRIMARY KEY ("xls_log_uuid");

-- ----------------------------
-- Primary Key structure for table base_log_info
-- ----------------------------
ALTER TABLE "public"."base_log_info" ADD PRIMARY KEY ("log_id");

-- ----------------------------
-- Primary Key structure for table base_login_log
-- ----------------------------
ALTER TABLE "public"."base_login_log" ADD PRIMARY KEY ("log_uuid");

-- ----------------------------
-- Primary Key structure for table base_resource_info
-- ----------------------------
ALTER TABLE "public"."base_resource_info" ADD PRIMARY KEY ("resource_id");

-- ----------------------------
-- Primary Key structure for table base_resource_info_copy
-- ----------------------------
ALTER TABLE "public"."base_resource_info_copy" ADD PRIMARY KEY ("resource_id");

-- ----------------------------
-- Primary Key structure for table base_role_dataresource
-- ----------------------------
ALTER TABLE "public"."base_role_dataresource" ADD PRIMARY KEY ("role_data_id");

-- ----------------------------
-- Primary Key structure for table base_role_info
-- ----------------------------
ALTER TABLE "public"."base_role_info" ADD PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table base_role_lineresource
-- ----------------------------
ALTER TABLE "public"."base_role_lineresource" ADD PRIMARY KEY ("role_line_id");

-- ----------------------------
-- Primary Key structure for table base_role_resource
-- ----------------------------
ALTER TABLE "public"."base_role_resource" ADD PRIMARY KEY ("role_resource_id");

-- ----------------------------
-- Primary Key structure for table base_sys_alarm_handle_result
-- ----------------------------
ALTER TABLE "public"."base_sys_alarm_handle_result" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table base_sys_param_info
-- ----------------------------
ALTER TABLE "public"."base_sys_param_info" ADD PRIMARY KEY ("sys_uuid");

-- ----------------------------
-- Primary Key structure for table base_user_info
-- ----------------------------
ALTER TABLE "public"."base_user_info" ADD PRIMARY KEY ("user_id");

-- ----------------------------
-- Primary Key structure for table base_user_role
-- ----------------------------
ALTER TABLE "public"."base_user_role" ADD PRIMARY KEY ("user_role_id");

-- ----------------------------
-- Primary Key structure for table base_video_param_info
-- ----------------------------
ALTER TABLE "public"."base_video_param_info" ADD PRIMARY KEY ("video_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bd_osm_region
-- ----------------------------
ALTER TABLE "public"."dw_dim_bd_osm_region" ADD PRIMARY KEY ("bd_region_district_id");

-- ----------------------------
-- Primary Key structure for table dw_dim_bd_region
-- ----------------------------
ALTER TABLE "public"."dw_dim_bd_region" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bd_weather
-- ----------------------------
ALTER TABLE "public"."dw_dim_bd_weather" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bd_weather_type
-- ----------------------------
ALTER TABLE "public"."dw_dim_bd_weather_type" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus" ADD PRIMARY KEY ("bus_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_copy
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_copy" ADD PRIMARY KEY ("bus_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_driver
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_driver" ADD PRIMARY KEY ("drv_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_line
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_line" ADD PRIMARY KEY ("line_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_line_copy
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_line_copy" ADD PRIMARY KEY ("line_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_line_device_id
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_line_device_id" ADD PRIMARY KEY ("bld_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_line_device_id_copy
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_line_device_id_copy" ADD PRIMARY KEY ("bld_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_station
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_station" ADD PRIMARY KEY ("sta_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_sys_org
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_sys_org" ADD PRIMARY KEY ("org_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_bus_sys_org_copy
-- ----------------------------
ALTER TABLE "public"."dw_dim_bus_sys_org_copy" ADD PRIMARY KEY ("org_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_device
-- ----------------------------
ALTER TABLE "public"."dw_dim_device" ADD PRIMARY KEY ("dev_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_osm_node
-- ----------------------------
ALTER TABLE "public"."dw_dim_osm_node" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_osm_node_type
-- ----------------------------
ALTER TABLE "public"."dw_dim_osm_node_type" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_osm_region
-- ----------------------------
ALTER TABLE "public"."dw_dim_osm_region" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_osm_road
-- ----------------------------
ALTER TABLE "public"."dw_dim_osm_road" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_other_bus_device
-- ----------------------------
ALTER TABLE "public"."dw_dim_other_bus_device" ADD PRIMARY KEY ("bus_dev_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_other_device
-- ----------------------------
ALTER TABLE "public"."dw_dim_other_device" ADD PRIMARY KEY ("dev_uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_pl_sys_datadict
-- ----------------------------
ALTER TABLE "public"."dw_dim_pl_sys_datadict" ADD PRIMARY KEY ("pl_uuid");

-- ----------------------------
-- Indexes structure for table dw_dim_sys_datadict
-- ----------------------------
CREATE INDEX "index_type_code" ON "public"."dw_dim_sys_datadict" USING btree ("type_code");

-- ----------------------------
-- Primary Key structure for table dw_dim_sys_datadict
-- ----------------------------
ALTER TABLE "public"."dw_dim_sys_datadict" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_dim_sys_datadict_type
-- ----------------------------
ALTER TABLE "public"."dw_dim_sys_datadict_type" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table dw_voiceprompt
-- ----------------------------
ALTER TABLE "public"."dw_voiceprompt" ADD PRIMARY KEY ("voiceprompt_uuid");

-- ----------------------------
-- Primary Key structure for table dw_voiceprompt_temp
-- ----------------------------
ALTER TABLE "public"."dw_voiceprompt_temp" ADD PRIMARY KEY ("voicetemp_uuid");

-- ----------------------------
-- Primary Key structure for table dw_voiceprompt_temp_type
-- ----------------------------
ALTER TABLE "public"."dw_voiceprompt_temp_type" ADD PRIMARY KEY ("voicetemp_type_uuid");

-- ----------------------------
-- Primary Key structure for table mid_bus_warn_msg
-- ----------------------------
ALTER TABLE "public"."mid_bus_warn_msg" ADD PRIMARY KEY ("warn_id");

-- ----------------------------
-- Primary Key structure for table mid_ic_card_data
-- ----------------------------
ALTER TABLE "public"."mid_ic_card_data" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table mid_passenger_flow_result
-- ----------------------------
ALTER TABLE "public"."mid_passenger_flow_result" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table mid_pl_t_warn
-- ----------------------------
ALTER TABLE "public"."mid_pl_t_warn" ADD PRIMARY KEY ("dim_warn_id");

-- ----------------------------
-- Primary Key structure for table net_data_basestation
-- ----------------------------
ALTER TABLE "public"."net_data_basestation" ADD PRIMARY KEY ("station_id");

-- ----------------------------
-- Primary Key structure for table net_data_busline
-- ----------------------------
ALTER TABLE "public"."net_data_busline" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_data_config
-- ----------------------------
ALTER TABLE "public"."net_data_config" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_data_line_geo
-- ----------------------------
ALTER TABLE "public"."net_data_line_geo" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_dea_linescore
-- ----------------------------
ALTER TABLE "public"."net_index_dea_linescore" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_dea_transfordata
-- ----------------------------
ALTER TABLE "public"."net_index_dea_transfordata" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_level_entropy_result
-- ----------------------------
ALTER TABLE "public"."net_index_level_entropy_result" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_base
-- ----------------------------
ALTER TABLE "public"."net_index_pf_base" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_line_day
-- ----------------------------
ALTER TABLE "public"."net_index_pf_line_day" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_od
-- ----------------------------
ALTER TABLE "public"."net_index_pf_od" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_od_aavg
-- ----------------------------
ALTER TABLE "public"."net_index_pf_od_aavg" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_od_day
-- ----------------------------
ALTER TABLE "public"."net_index_pf_od_day" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_od_dsum
-- ----------------------------
ALTER TABLE "public"."net_index_pf_od_dsum" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_pf_station_day
-- ----------------------------
ALTER TABLE "public"."net_index_pf_station_day" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_repeat_arrow
-- ----------------------------
ALTER TABLE "public"."net_index_repeat_arrow" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_repeat_company
-- ----------------------------
ALTER TABLE "public"."net_index_repeat_company" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_repeat_linenum
-- ----------------------------
ALTER TABLE "public"."net_index_repeat_linenum" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_repeat_sc
-- ----------------------------
ALTER TABLE "public"."net_index_repeat_sc" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_statis_arrow
-- ----------------------------
ALTER TABLE "public"."net_index_statis_arrow" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_index_statis_linenum
-- ----------------------------
ALTER TABLE "public"."net_index_statis_linenum" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_xml_config
-- ----------------------------
ALTER TABLE "public"."net_xml_config" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table net_xml_dea_base_config
-- ----------------------------
ALTER TABLE "public"."net_xml_dea_base_config" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Checks structure for table spatial_ref_sys
-- ----------------------------
ALTER TABLE "public"."spatial_ref_sys" ADD CHECK (((srid > 0) AND (srid <= 998999)));

-- ----------------------------
-- Primary Key structure for table spatial_ref_sys
-- ----------------------------
ALTER TABLE "public"."spatial_ref_sys" ADD PRIMARY KEY ("srid");

-- ----------------------------
-- Primary Key structure for table t_safe_device_rid_control
-- ----------------------------
ALTER TABLE "public"."t_safe_device_rid_control" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Primary Key structure for table temp_bus_deployment
-- ----------------------------
ALTER TABLE "public"."temp_bus_deployment" ADD PRIMARY KEY ("dm_uuid");

-- ----------------------------
-- Indexes structure for table temp_bus_over_warn_trail
-- ----------------------------
CREATE INDEX "index_warn_device_id_copy1" ON "public"."temp_bus_over_warn_trail" USING btree ("device_id");
CREATE INDEX "index_warn_warn_time_copy1" ON "public"."temp_bus_over_warn_trail" USING btree ("warn_time");

-- ----------------------------
-- Primary Key structure for table temp_bus_over_warn_trail
-- ----------------------------
ALTER TABLE "public"."temp_bus_over_warn_trail" ADD PRIMARY KEY ("warn_uuid");

-- ----------------------------
-- Primary Key structure for table temp_bus_schedule
-- ----------------------------
ALTER TABLE "public"."temp_bus_schedule" ADD PRIMARY KEY ("bs_uuid");

-- ----------------------------
-- Primary Key structure for table temp_bus_schedule_day
-- ----------------------------
ALTER TABLE "public"."temp_bus_schedule_day" ADD PRIMARY KEY ("bsd_uuid");

-- ----------------------------
-- Primary Key structure for table temp_bus_warn_msg
-- ----------------------------
ALTER TABLE "public"."temp_bus_warn_msg" ADD PRIMARY KEY ("warn_id");

-- ----------------------------
-- Primary Key structure for table temp_device_send_task
-- ----------------------------
ALTER TABLE "public"."temp_device_send_task" ADD PRIMARY KEY ("task_uuid");

-- ----------------------------
-- Primary Key structure for table temp_device_send_task_detail
-- ----------------------------
ALTER TABLE "public"."temp_device_send_task_detail" ADD PRIMARY KEY ("task_detail_uuid");

-- ----------------------------
-- Primary Key structure for table temp_ic_card_data
-- ----------------------------
ALTER TABLE "public"."temp_ic_card_data" ADD PRIMARY KEY ("uuid");

-- ----------------------------
-- Triggers structure for table temp_pl_t_warn
-- ----------------------------
CREATE TRIGGER "warn_handle" AFTER INSERT ON "public"."temp_pl_t_warn"
FOR EACH ROW
EXECUTE PROCEDURE "warn_handle_triger"();

-- ----------------------------
-- Triggers structure for table temp_pl_t_warn_copy
-- ----------------------------
CREATE TRIGGER "warn_handle" AFTER INSERT ON "public"."temp_pl_t_warn_copy"
FOR EACH ROW
EXECUTE PROCEDURE "warn_handle_triger"();

-- ----------------------------
-- Indexes structure for table temp_pl_t_warn_media
-- ----------------------------
CREATE INDEX "index_warn_uuid" ON "public"."temp_pl_t_warn_media" USING btree ("warn_uuid");
CREATE INDEX "index_create_time" ON "public"."temp_pl_t_warn_media" USING btree ("create_time");

-- ----------------------------
-- Primary Key structure for table temp_pl_t_warn_media
-- ----------------------------
ALTER TABLE "public"."temp_pl_t_warn_media" ADD PRIMARY KEY ("media_uuid");

-- ----------------------------
-- Indexes structure for table temp_pl_t_warn_media_copy
-- ----------------------------
CREATE INDEX "index_warn_uuid_copy" ON "public"."temp_pl_t_warn_media_copy" USING btree ("warn_uuid");
CREATE INDEX "index_create_time_copy" ON "public"."temp_pl_t_warn_media_copy" USING btree ("create_time");

-- ----------------------------
-- Primary Key structure for table temp_pl_t_warn_media_copy
-- ----------------------------
ALTER TABLE "public"."temp_pl_t_warn_media_copy" ADD PRIMARY KEY ("media_uuid");

-- ----------------------------
-- Indexes structure for table temp_pl_t_warn_temp
-- ----------------------------
CREATE INDEX "index_warn_device_id" ON "public"."temp_pl_t_warn_temp" USING btree ("device_id");
CREATE INDEX "index_warn_warn_time" ON "public"."temp_pl_t_warn_temp" USING btree ("warn_time");

-- ----------------------------
-- Primary Key structure for table temp_pl_t_warn_temp
-- ----------------------------
ALTER TABLE "public"."temp_pl_t_warn_temp" ADD PRIMARY KEY ("warn_uuid");

-- ----------------------------
-- Primary Key structure for table temp_pl_take_photo_set
-- ----------------------------
ALTER TABLE "public"."temp_pl_take_photo_set" ADD PRIMARY KEY ("take_photo_uuid");

-- ----------------------------
-- Primary Key structure for table temp_t_passenger_flow_result
-- ----------------------------
ALTER TABLE "public"."temp_t_passenger_flow_result" ADD PRIMARY KEY ("pfr_uuid");
