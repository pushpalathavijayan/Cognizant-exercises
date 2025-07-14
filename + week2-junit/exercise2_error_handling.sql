CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_from NUMBER, p_to NUMBER, p_amount NUMBER) IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from;
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    INSERT INTO AuditLog(LogMessage) VALUES('Transfer failed: ' || SQLERRM);
END;
/

-- UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary(p_empid NUMBER, p_percent NUMBER) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_percent / 100)
  WHERE EmployeeID = p_empid;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee not found');
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    INSERT INTO AuditLog(LogMessage) VALUES('Salary update failed: ' || SQLERRM);
END;
/

-- AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE, 'F');
  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    INSERT INTO AuditLog(LogMessage) VALUES('Customer already exists with ID: ' || p_id);
  WHEN OTHERS THEN
    INSERT INTO AuditLog(LogMessage) VALUES('Insert failed: ' || SQLERRM);
END;
/
