import React, { useState } from 'react';
import './styles.css'

const Seat = ({ seat }) => {

  let { name, isBooked } = seat;

  const [isSelected, setIsSelected] = useState(false);

  const handleOnClick = () => {
    if (!isBooked) {
      setIsSelected(!isSelected);
    }
  }

  return (
    <div
      onClick={handleOnClick}
      className={`${isBooked ? 'seat bought' : 'seat'} ${isSelected ? 'selected' : ''}`}>
      {name}
    </div>
  )
};

export default Seat;