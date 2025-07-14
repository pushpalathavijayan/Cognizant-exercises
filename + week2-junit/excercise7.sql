-- Package: CustomerManagement
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers VALUES (p_id, p_name, p_dob, p_balance, SYSDATE, 'F');
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name WHERE CustomerID = p_id;
  END;

  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
    v_bal NUMBER;
  BEGIN
    SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = p_id;
    RETURN v_bal;
  END;
END;
/

-- Package: EmployeeManagement
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2);
  PROCEDURE UpdateDetails(p_id NUMBER, p_pos VARCHAR2);
  FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_pos VARCHAR2, p_salary NUMBER, p_dept VARCHAR2) IS
  BEGIN
    INSERT INTO Employees VALUES (p_id, p_name, p_pos, p_salary, p_dept, SYSDATE);
  END;

  PROCEDURE UpdateDetails(p_id NUMBER, p_pos VARCHAR2) IS
  BEGIN
    UPDATE Employees SET Position = p_pos WHERE EmployeeID = p_id;
  END;

  FUNCTION AnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_sal NUMBER;
  BEGIN
    SELECT Salary INTO v_sal FROM Employees WHERE EmployeeID = p_id;
    RETURN v_sal * 12;
  END;
END;
/

-- Package: AccountOperations
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_custid NUMBER, p_type VARCHAR2, p_bal NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION TotalCustomerBalance(p_custid NUMBER) RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_custid NUMBER, p_type VARCHAR2, p_bal NUMBER) IS
  BEGIN
    INSERT INTO Accounts VALUES (p_id, p_custid, p_type, p_bal, SYSDATE);
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;
  END;

  FUNCTION TotalCustomerBalance(p_custid NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_custid;
    RETURN NVL(v_total, 0);
  END;
END;
/
