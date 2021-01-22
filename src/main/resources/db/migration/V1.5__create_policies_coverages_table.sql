CREATE TABLE policies_coverages
(
    policy_id   integer NOT NULL,
    coverage_id integer NOT NULL,
    PRIMARY KEY (policy_id, coverage_id),
    CONSTRAINT "FK_policies" FOREIGN KEY (policy_id)
        REFERENCES policies (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "FK_coverages" FOREIGN KEY (coverage_id)
        REFERENCES coverages (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);