import React from 'react';
import './styles.css';
import Seat from '../Seat/Seat';

const Row = ({ row }) => {
  return (
    <div className="row">
      {row.map((seat, key) => {
        return (
          <Seat seat={seat} id={key} />
        )
      })}
    </div>
  );
};

export default Row;