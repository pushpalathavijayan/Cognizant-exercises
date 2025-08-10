import React, { useState } from "react";

function CurrencyConvertor() {
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState(null);

  const handleSubmit = () => {
    const rate = 0.011; // 1 INR = 0.011 EUR
    if (!isNaN(rupees)) {
      setEuros((parseFloat(rupees) * rate).toFixed(2));
    }
  };

  return (
    <div style={{ marginTop: "30px" }}>
      <h2>Currency Converter</h2>
      <input
        type="number"
        placeholder="Enter amount in INR"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
        style={{ padding: "6px", marginRight: "10px" }}
      />
      <button onClick={handleSubmit}>Convert</button>
      {euros && (
        <p style={{ marginTop: "10px" }}>
          {rupees} INR = {euros} EUR
        </p>
      )}
    </div>
  );
}

export default CurrencyConvertor;

