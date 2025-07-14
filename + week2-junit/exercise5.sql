-- UpdateCustomerLastModified Trigger
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

-- LogTransaction Trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog(LogMessage)
  VALUES('Transaction ' || :NEW.TransactionID || ' recorded on ' || TO_CHAR(:NEW.TransactionDate, 'DD-MON-YYYY'));
END;
/

-- CheckTransactionRules Trigger
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  v_balance NUMBER;
BEGIN
  IF :NEW.TransactionType = 'Withdrawal' THEN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
    IF :NEW.Amount > v_balance THEN
      RAISE_APPLICATION_ERROR(-20011, 'Withdrawal exceeds balance');
    END IF;
  ELSIF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20012, 'Deposit must be positive');
  END IF;
END;
/
