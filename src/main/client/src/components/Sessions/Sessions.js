import React, { useEffect } from 'react';
import SessionContainer from './SessionContainer/SessionContainer';
import useStyles from './styles';
import { useSelector, useDispatch } from 'react-redux';
import { getSessions } from '../../actions/sessions';

import data from './data';

const Sessions = ({ filmId }) => {
  const classes = useStyles();
  const dispatch = useDispatch();
  let sessions;

  const sessionsData = useSelector(state => state.sessions);

  // useEffect(() => {
  //   dispatch(getSessions(filmId));
  //
  //   sessions = Object.entries(sessionsData.reduce((dates, s) => {
  //     dates[s.date] = [...dates[s.date] || [], s];
  //     return dates;
  //   }, {}));
  // }, [dispatch]);

  // change data to sessionsData
  sessions = Object.entries(data.reduce((dates, s) => {
        dates[s.date] = [...dates[s.date] || [], s];
        return dates;
      }, {}));

  return (
    <div className={classes.buttonContainer}>
      {sessions.map((date, index) => {
          return <SessionContainer date={date[0]} sessionsOnDate={date[1]} key={index} />
        })}
    </div>
  )
}

export default Sessions;