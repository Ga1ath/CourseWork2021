import React, { useState } from 'react';
import './styles.css'

const Seat = ({ seat }) => {

  let { name, isBought } = seat;

  const [isSelected, setIsSelected] = useState(false);

  const handleOnClick = () => {
    if (!isBought) {
      setIsSelected(!isSelected);
    }
  }

  return (
    <div
      onClick={handleOnClick}
      className={`${isBought ? 'seat bought' : 'seat'} ${isSelected ? 'selected' : ''}`}>
      {console.log(`${isBought ? 'seat bought' : 'seat'} ${isSelected ? 'selected' : ''}`)}
      {name}
    </div>
  )
};

export default Seat;