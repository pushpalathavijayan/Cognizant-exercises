import React from 'react';

const IndianPlayers = () => {
  const T20players = ['Kohli', 'Rohit', 'Pant', 'Pandya'];
  const RanjiTrophy = ['Pujara', 'Rahane', 'Saha', 'Unadkat'];

  // Merge arrays
  const allPlayers = [...T20players, ...RanjiTrophy];

  // Destructure into odd/even players
  const oddPlayers = allPlayers.filter((_, index) => index % 2 !== 0);
  const evenPlayers = allPlayers.filter((_, index) => index % 2 === 0);

  return (
    <div>
      <h2>All Merged Players</h2>
      <ul>
        {allPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        {evenPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>

      <h2>Odd Team Players</h2>
      <ul>
        {oddPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
