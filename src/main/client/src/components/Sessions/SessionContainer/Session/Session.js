import React from 'react';

import { Button } from '@material-ui/core';
import useStyles from './styles';
import { useDispatch, useSelector } from "react-redux";
import { showHallPopup } from "../../../../actions/hallPopup";
import { getCurrentSession } from '../../../../actions/currentSession';

const Session = ({ session }) => {
  const { id, time, price, hall } = session;
  const classes = useStyles();
  const visiblePopup = useSelector(state => state.hallPopup.visible);
  const dispatch = useDispatch();

  const handleOnClick = (id) => {
    dispatch(getCurrentSession(id));

    dispatch(showHallPopup());
  }

  return (
    <Button className={classes.sessionButton} variant="text" onClick={() => handleOnClick(id)}>
      <div className={classes.buttonContent}>
        <h2 style={{ fontSize: "90%", margin: "0 2px"}}>{time}</h2>
        <p style={{ fontSize: "80%", margin: "0" }}>from {price}₽</p>
      </div>
    </Button>
  )
}

export default Session;