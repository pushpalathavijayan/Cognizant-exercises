
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
  RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob)/12);
END;
/

-- CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_loan_amt NUMBER, p_rate NUMBER, p_years NUMBER) RETURN NUMBER IS
  v_monthly_rate NUMBER := p_rate / 12 / 100;
  v_months NUMBER := p_years * 12;
BEGIN
  RETURN (p_loan_amt * v_monthly_rate) / (1 - POWER(1 + v_monthly_rate, -v_months));
END;
/

-- HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_accountid NUMBER, p_amt NUMBER) RETURN BOOLEAN IS
  v_bal NUMBER;
BEGIN
  SELECT Balance INTO v_bal FROM Accounts WHERE AccountID = p_accountid;
  RETURN v_bal >= p_amt;
END;
/