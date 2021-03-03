import React, { useEffect } from 'react';
import SessionContainer from './SessionContainer/SessionContainer';
import useStyles from './styles';
import { useSelector, useDispatch } from 'react-redux';
import { getSessions } from '../../actions/sessions';

import data from './data';
import Grid from '@material-ui/core/Grid';

const Sessions = ({ filmId }) => {
  const classes = useStyles();
  const dispatch = useDispatch();
  let sessions;

  const sessionsData = useSelector(state => state.filmInfo);

  // useEffect(() => {
  //   dispatch(getSessions(filmId));
  //
  //   sessions = Object.entries(sessionsData.reduce((dates, s) => {
  //     dates[s.date] = [...dates[s.date] || [], s];
  //     return dates;
  //   }, {}));
  // }, [dispatch]);

  // change data to sessionsData
  sessions = Object.entries(sessionsData.sessions.reduce((dates, s) => {
        dates[s.date] = [...dates[s.date] || [], s];
        return dates;
      }, {}));

  return (
    <div className={classes.sessionsContainer}>
      <div className={classes.filmInfo}>
        <Grid item xs={3}>
          <img src={sessionsData.logo} className={classes.logo} />
        </Grid>
      </div>
      <div className={classes.buttonContainer}>
        {sessions.map((date, index) => {
          return <SessionContainer date={date[0]} sessionsOnDate={date[1]} key={index} />
        })}
      </div>
    </div>
  )
}

export default Sessions;