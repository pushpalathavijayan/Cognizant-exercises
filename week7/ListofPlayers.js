import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 88 },
    { name: 'Rohit Sharma', score: 72 },
    { name: 'KL Rahul', score: 65 },
    { name: 'Shubman Gill', score: 45 },
    { name: 'Hardik Pandya', score: 77 },
    { name: 'Rishabh Pant', score: 60 },
    { name: 'Ravindra Jadeja', score: 40 },
    { name: 'Bumrah', score: 85 },
    { name: 'Siraj', score: 55 },
    { name: 'Ashwin', score: 90 },
    { name: 'Iyer', score: 35 }
  ];

  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
