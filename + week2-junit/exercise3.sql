-- ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';
  COMMIT;
END;
/

-- UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_dept VARCHAR2, p_bonus_percent NUMBER) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_dept;
  COMMIT;
END;
/

-- TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER, p_to NUMBER, p_amt NUMBER) IS
  v_bal NUMBER;
BEGIN
  SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_from;
  IF v_bal < p_amt THEN
    RAISE_APPLICATION_ERROR(-20010, 'Insufficient balance');
  END IF;

  UPDATE Accounts SET Balance = Balance - p_amt WHERE AccountID = p_from;
  UPDATE Accounts SET Balance = Balance + p_amt WHERE AccountID = p_to;
  COMMIT;
END;
/