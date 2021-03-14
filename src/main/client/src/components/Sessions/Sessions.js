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

  useEffect(() => {
    dispatch(getSessions(filmId));
  }, [dispatch]);

  const sessionsData = useSelector(state => state.filmInfo);

  // change data to sessionsData
  sessions = Object.entries(sessionsData.sessions.reduce((dates, s) => {
        dates[s.date] = [...dates[s.date] || [], s];
        return dates;
      }, {}));

  return (
    <div className={classes.sessionsContainer}>
      <div className={classes.filmInfo}>
        <div className={classes.title}>
          <p>{sessionsData.filmName}</p>
        </div>
        <Grid container>
          <Grid item xs={12} sm={4}>
            <img src={sessionsData.logo} className={classes.logo} />
          </Grid>
          <Grid item xs={12} sm={8} className={classes.info}>
            <p>Length: <span>{sessionsData.length}</span></p>
            <p>Director: <span>{sessionsData.director}</span></p>
            <p>Main Actors: <span>{sessionsData.mainRoles}</span></p>
            <div className={classes.plot}>
              <p><span>{sessionsData.plot}</span></p>
            </div>
          </Grid>
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