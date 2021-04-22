CREATE TABLE Hospital(
    hosp_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    hosp_name VARCHAR(200) NOT NULL,
    hosp_address VARCHAR(200),
    hosp_details TEXT,
    PRIMARY KEY(hosp_id)
);

-- hospital has different departments
CREATE TABLE Departments(
    dep_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    dep_name VARCHAR(200) NOT NULL,
    hosp_id INT,
    PRIMARY KEY(dep_id),
    FOREIGN KEY(hosp_id) REFERENCES Hospital(hosp_id) on DELETE CASCADE
);

-- The hospital has several employees including doctors, nurses 
CREATE TABLE Doctors(
    emp_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    emp_first_name VARCHAR(200),
    emp_last_name VARCHAR(200),
    emp_username VARCHAR(200) NOT NULL UNIQUE,
    emp_email VARCHAR(200),
    emp_password VARCHAR(200) NOT NULL,
    emp_phone VARCHAR(200),
    is_active BOOLEAN,
    dep_id INT,
    PRIMARY KEY(emp_id),
    FOREIGN KEY(dep_id) REFERENCES Departments(dep_id) ON DELETE CASCADE
);

-- There are several roles the hospital staff can do
CREATE TABLE Roles(
    role_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    role_name VARCHAR(255) NOT NULL,
    role_details TEXT,
    emp_id INT,
    time_created TIMESTAMP,
    PRIMARY KEY(role_id),
    FOREIGN KEY(emp_id) REFERENCES Doctors(emp_id) on DELETE CASCADE
);

-- Each employee has a specific schedule in their department every day
CREATE TABLE Schedule(
    schedule_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    time_start TIMESTAMP,
    time_end TIMESTAMP,
    schedule_date DATE,
    emp_dep_id INT,
    PRIMARY KEY(schedule_id),
    FOREIGN KEY(emp_dep_id) REFERENCES Doctors(emp_id) on DELETE CASCADE
);


-- A certain patient belongs to a specific hospital
CREATE TABLE Patient(
    pat_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    pat_first_name VARCHAR(200),
    pat_last_name VARCHAR(200),
    pat_email VARCHAR(200),
    pat_phone VARCHAR(50),
    case_title VARCHAR(100),
    case_details TEXT,
    time_created TIMESTAMP
);

-- patients finance
CREATE TABLE Cost(
    cost_id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    total_cost DECIMAL(10,2),
    amount_paid DECIMAL(10,2),
    time_paid TIMESTAMP,
    pat_id INT,
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id) ON DELETE CASCADE
);

-- Each patient is booked a n appointment with the department
CREATE TABLE Appointments(
    app_id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    pat_id INT,
    time_created TIMESTAMP,
    app_date DATE,
    app_start_time TIME,
    app_end_time TIME,
    app_status VARCHAR(100),
    emp_id INT,
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id) ON DELETE CASCADE,
    FOREIGN KEY(emp_id) REFERENCES Doctors(emp_id) ON DELETE CASCADE
);

-- The test reports about the patient
CREATE TABLE ClinicalTest(
    test_id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    test_results VARCHAR(255),
    test_details TEXT,
    pat_id INT,
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id) ON DELETE CASCADE
);

-- This describes the treatment reports of each patient
CREATE TABLE Treatment(
    treat_id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    treat_results VARCHAR(255),
    treat_details TEXT,
    pat_id INT,
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id) ON DELETE CASCADE
);

-- This descreibes the prescription reports for each patient
CREATE TABLE Prescription(
    pres_id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    pres_results VARCHAR(255),
    pres_details TEXT,
    pat_id INT,
    FOREIGN KEY(pat_id) REFERENCES Patient(pat_id) ON DELETE CASCADE
);

-- All the appointments status of the patient are recorded 
CREATE TABLE StatusHistory(
    hist_id INT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
    app_id INT,
    status_time TIMESTAMP,
    details TEXT, 
    FOREIGN KEY(app_id) REFERENCES Appointments(app_id) ON DELETE CASCADE
);