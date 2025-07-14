-- Cursor: GenerateMonthlyStatements
DECLARE
  CURSOR trans_cursor IS
    SELECT a.CustomerID, t.TransactionID, t.Amount, t.TransactionDate
    FROM Transactions t JOIN Accounts a ON t.AccountID = a.AccountID
    WHERE TO_CHAR(t.TransactionDate, 'MMYYYY') = TO_CHAR(SYSDATE, 'MMYYYY');
BEGIN
  FOR t IN trans_cursor LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ' || t.CustomerID || ' - Transaction ' || t.TransactionID ||
                         ' Amount: ' || t.Amount || ' Date: ' || TO_CHAR(t.TransactionDate, 'DD-MON'));
  END LOOP;
END;
/

-- Cursor: ApplyAnnualFee
DECLARE
  CURSOR fee_cursor IS SELECT AccountID FROM Accounts;
BEGIN
  FOR a IN fee_cursor LOOP
    UPDATE Accounts SET Balance = Balance - 100 WHERE AccountID = a.AccountID;
  END LOOP;
  COMMIT;
END;
/

-- Cursor: UpdateLoanInterestRates
DECLARE
  CURSOR loan_cursor IS SELECT LoanID, InterestRate FROM Loans;
BEGIN
  FOR l IN loan_cursor LOOP
    UPDATE Loans SET InterestRate = l.InterestRate + 0.5 WHERE LoanID = l.LoanID;
  END LOOP;
  COMMIT;
END;
/