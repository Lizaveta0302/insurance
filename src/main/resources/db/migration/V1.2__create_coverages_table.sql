CREATE TABLE coverages
(
    id             serial  NOT NULL,
    coverage_name  varchar NOT NULL,
    coverage_group varchar NOT NULL,
    code           integer NOT NULL,
    PRIMARY KEY (id)
)