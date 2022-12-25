CREATE TABLE department(
    id INT PRIMARY KEY ,
    dname VARCHAR(20) NOT NULL,
    company_id INT,
    CONSTRAINT fk_company_id FOREIGN KEY(company_id) REFERENCES company(id)
);