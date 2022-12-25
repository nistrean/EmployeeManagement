CREATE TABLE employee(
    idnp VARCHAR(13) PRIMARY KEY ,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(30) UNIQUE NOT NULL,
    department_id INT,
    company_id INT,
    CONSTRAINT fk_department_id FOREIGN KEY(department_id) REFERENCES department(id),
    CONSTRAINT fk_company_id FOREIGN KEY(company_id) REFERENCES company(id)
);