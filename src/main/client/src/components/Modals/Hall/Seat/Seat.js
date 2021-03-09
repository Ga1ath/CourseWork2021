import React from 'react';

const Seat = ({ name, isBought }) => {

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
      {name}
    </div>
  )
};

export default Seat;