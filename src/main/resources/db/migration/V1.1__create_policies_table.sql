CREATE TABLE policies
(
    id            serial               NOT NULL,
    policy_number integer              NOT NULL,
    total_amount  integer              NOT NULL,
    active        boolean default true NOT NULL,
    effectiveDate date                 NOT NULL,
    expire_date   date                 NOT NULL,
    PRIMARY KEY (id)
)