CREATE TABLE drivers
(
    id         serial  NOT NULL,
    first_name varchar NOT NULL,
    last_name  varchar NOT NULL,
    age        integer NOT NULL,
    policy_id  integer,
    PRIMARY KEY (id),
    CONSTRAINT "FK_policies" FOREIGN KEY (policy_id)
        REFERENCES policies (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
)