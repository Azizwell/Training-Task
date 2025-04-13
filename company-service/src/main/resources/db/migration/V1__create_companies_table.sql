CREATE TABLE IF NOT EXISTS companies
(
    id     BIGSERIAL PRIMARY KEY,
    name   VARCHAR(255)   NOT NULL,
    budget DOUBLE PRECISION NOT NULL
);
CREATE TABLE IF NOT EXISTS employee
(
    id         BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    CONSTRAINT fk_company
        FOREIGN KEY (company_id)
            REFERENCES companies (id)
            ON DELETE CASCADE
);

