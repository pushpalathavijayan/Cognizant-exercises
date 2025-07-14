BEGIN
  FOR cust IN (SELECT c.CustomerID, l.LoanID, l.InterestRate, TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age
               FROM Customers c JOIN Loans l ON c.CustomerID = l.CustomerID)
  LOOP
    IF cust.Age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = cust.LoanID;
    END IF;
  END LOOP;
END;
/

-- Scenario 2: Promote customers to VIP
BEGIN
  FOR cust IN (SELECT CustomerID, Balance FROM Customers)
  LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers SET IsVIP = 'T' WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;
END;
/

-- Scenario 3: Reminders for due loans
BEGIN
  FOR loan IN (
    SELECT l.LoanID, c.Name, l.EndDate
    FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || ' for ' || loan.Name ||
                         ' is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/