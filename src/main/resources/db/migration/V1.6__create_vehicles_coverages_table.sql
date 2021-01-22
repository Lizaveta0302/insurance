CREATE TABLE vehicles_coverages
(
    vehicle_id  integer NOT NULL,
    coverage_id integer NOT NULL,
    PRIMARY KEY (vehicle_id, coverage_id),
    CONSTRAINT "FK_vehicles" FOREIGN KEY (vehicle_id)
        REFERENCES vehicles (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "FK_coverages" FOREIGN KEY (coverage_id)
        REFERENCES coverages (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);