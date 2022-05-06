CREATE TABLE company_locale
(
    company_id INT NOT NULL REFERENCES company1(id),
    lang CHAR(2) NOT NULL ,
    description VARCHAR(128) NOT NULL ,
    PRIMARY KEY (company_id, lang)
);

drop table company_locale;