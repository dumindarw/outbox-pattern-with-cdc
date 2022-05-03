CREATE EXTENSION IF NOT EXISTS postgis;

/*CREATE TABLE IF NOT EXISTS tbl_incident_locations(
   incd_id serial PRIMARY KEY,
   incd_name VARCHAR(255) UNIQUE NOT NULL,
   incd_location GEOMETRY(Point, 4326) NOT NULL,
   created_by VARCHAR (255) NOT NULL,
   created_on TIMESTAMP NOT NULL
);
*/
CREATE TABLE IF NOT EXISTS tbl_incident_locations(
   incd_id serial PRIMARY KEY,
   incd_name VARCHAR(255) UNIQUE NOT NULL,
   incd_location jsonb NOT NULL,
   created_by VARCHAR (255) NOT NULL,
   created_on TIMESTAMP NOT NULL
);
/*
CREATE OR REPLACE VIEW vw_incident_locations AS
SELECT incd_name,  
ST_X (ST_Transform (incd_location, 4326)) AS longitude, 
ST_Y (ST_Transform (incd_location, 4326)) AS latitude
 FROM tbl_incident_locations;

CREATE OR REPLACE VIEW vw_incident_locations_geojson AS 
SELECT incd_name,
ST_AsGeoJSON(incd_location) 
FROM tbl_incident_locations;
*/
 /*
 INSERT INTO "tbl_incident_locations" ("incd_name", "incd_location", "created_by", "created_on")
VALUES ('New Incident 01', ST_AsGeoJSON('POINT(7.4818 80.3609)')::jsonb, 'rajitha', now());

INSERT INTO "tbl_incident_locations" ("incd_name", "incd_location", "created_by", "created_on")
VALUES ('New Incident 02', ST_AsGeoJSON('POINT(7.1118 80.1109)')::jsonb, 'rajitha', now());

 */
