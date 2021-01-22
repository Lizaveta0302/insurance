CREATE TABLE vehicles
(
    id        serial  NOT NULL,
    number    integer,
    model     varchar NOT NULL,
    policy_id integer,
    driver_id integer,
    PRIMARY KEY (id),
    CONSTRAINT "FK_policies" FOREIGN KEY (policy_id)
        REFERENCES policies (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    CONSTRAINT "FK_drivers" FOREIGN KEY (driver_id)
        REFERENCES drivers (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
)