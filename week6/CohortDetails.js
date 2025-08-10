import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const titleStyle = {
    color: cohort.status.toLowerCase() === 'ongoing' ? 'green' : 'blue',
    fontWeight: 'bold',
    fontSize: '16px'
  };

  return (
    <div className={styles.box}>
      <p style={titleStyle}>{cohort.title}</p>
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        <dt>Current Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Coach</dt>
        <dd>{cohort.coach}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
